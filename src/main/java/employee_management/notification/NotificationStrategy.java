package employee_management.notification;

import employee_management.entity.Employee;

public interface NotificationStrategy {

    void send(Employee employee);
}
