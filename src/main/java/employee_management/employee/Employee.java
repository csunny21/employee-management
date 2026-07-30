package employee_management.employee;

import employee_management.department.Department;

public class Employee {

    //variables
    String name;
    Long employeeId;
    String dateOfBirth;
    Department department;
    String email;
    Long salary;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    //constructor
    public Employee(String name, Long employeeId, String dateOfBirth,
                    Department department, String email, Long salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }

    //to string
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
