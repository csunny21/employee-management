package employee_management.service;

import employee_management.department.Department;
import employee_management.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    //methods
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);

    }

    public Employee findEmployeeById(Long id) {
        for (Employee employee : employees)
            if (employee.getEmployeeId().equals(id)) {
                return employee;
            }
        throw new RuntimeException("Employee not found with id " + id);
    }


    public List<Employee> getAllEmployees() {
        return employees;
    }


    public List<Employee> findByDepartment(Department department) {
       List<Employee> result = new ArrayList<>();

        for (Employee employee : employees)
            if (employee.getDepartment().equals(department)) {
                result.add(employee);
            }
        return result;
    }



    public void updateEmployee(Long id, String email) {
        Employee employee = findEmployeeById(id);
        employee.setEmail(email);
    }

    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeById(id);
        employees.remove(employee);
    }

    public int getTotalEmployees() {
        return employees.size();
    }

    public boolean existsById(Long id) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<Employee> findByName(String name) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees)
            if (employee.getName().equals(name)) {
                return result;
            }
        throw new RuntimeException("Employee not found " + name);
    }

    public int countEmployeesByDepartment(Department department) {

        int count = 0;

        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                count++;
            }
        }
        return count;
    }

}
