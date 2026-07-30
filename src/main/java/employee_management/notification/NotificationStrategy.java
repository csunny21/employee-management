package employee_management.notification;

import employee_management.employee.Employee;

public interface NotificationStrategy {

    void send(Employee employee);
}
