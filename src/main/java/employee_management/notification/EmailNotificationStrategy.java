package employee_management.notification;

import employee_management.employee.Employee;

public class EmailNotificationStrategy implements NotificationStrategy{

    @Override
    public void send(Employee employee) {
        System.out.println("Email sent to " + employee.getName());
    }
}
