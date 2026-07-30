package employee_management.notification;

import employee_management.entity.Employee;

public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(Employee employee) {
        System.out.println("SMS Sent to " + employee.getName());
    }
}
