package employee_management.employee;

import employee_management.department.Department;
import employee_management.notification.Notifiable;

public class Developer extends Employee implements Notifiable {

    public Developer( String name, Long employeeId, String dateOfBirth, Department department, String email, Long salary) {
        super(name, employeeId, dateOfBirth, department, email, salary);

    }

    @Override
    public void notifyEmployee() {
        System.out.println("Developer notification sent to " + getName());
    }
}
