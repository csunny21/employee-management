package employee_management.event;

import employee_management.entity.Employee;

public class EmployeeCreatedEvent {

    private final Employee employee;

    public EmployeeCreatedEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

}
