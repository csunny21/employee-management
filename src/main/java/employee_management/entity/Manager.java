package employee_management.entity;

import employee_management.enums.Department;
import employee_management.notification.Notifiable;

public class Manager extends Employee implements Notifiable {
    public Manager( String name, Long employeeId, String dateOfBirth, Department department, String email, Long salary) {
        super(name, employeeId, dateOfBirth, department, email, salary);

    }

    @Override
    public void notifyEmployee() {
        System.out.println("Manager notification sent to " + getName());
    }
}
