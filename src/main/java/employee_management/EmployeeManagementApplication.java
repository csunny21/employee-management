package employee_management;

import employee_management.department.Department;
import employee_management.employee.Employee;
import employee_management.notification.EmailNotificationStrategy;
import employee_management.notification.NotificationStrategy;
import employee_management.notification.SmsNotificationStrategy;
import employee_management.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static employee_management.department.Department.FINANCE;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);

		EmployeeService service = new EmployeeService();

		Employee emp1 = new Employee(
				"Jim",
				1001L,
				"12/12/1991",
				Department.FINANCE,
				"jim.steve@xcompany.com",
				60000L);

		NotificationStrategy welcomeEmail = new EmailNotificationStrategy();
		NotificationStrategy smsCredentials = new SmsNotificationStrategy();

		service.addEmployee(emp1);
		welcomeEmail.send(emp1);
		smsCredentials.send(emp1);


		Employee emp2 = new Employee(
				"Sammy",
				1002L,
				"12/12/1991",
				Department.SUPPORT,
				"jim.steve@xcompany.com",
				35000L);

		service.addEmployee(emp2);
		welcomeEmail.send(emp2);
		smsCredentials.send(emp2);


		//retrieving all employees
		System.out.println(service.getAllEmployees());

		//find by id
		Employee result = service.findEmployeeById(1001L);
		System.out.println(result);

		//find by department
		List<Employee> financeEmployees = service.findByDepartment(FINANCE);
		System.out.println(financeEmployees);

		//updating employee
		//service.updateEmployee(1001L, "jim.steve1@xcompany.com");
		//System.out.println(service.findEmployeeById(1001L));

		//delete employee
		//service.deleteEmployee(1001L);

		System.out.println(service.getTotalEmployees());

		System.out.println(service.existsById(1003L));

		System.out.println(service.countEmployeesByDepartment(Department.SUPPORT));

	}
}


