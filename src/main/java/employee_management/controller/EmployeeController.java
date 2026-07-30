package employee_management.controller;

import employee_management.entity.Employee;
import employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(Long id) {
        return service.findEmployeeById(id);
    }

    @PutMapping
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);

    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        System.out.println("Employee deleted confirmed" );
        return null;
    }
}
