package employee_management.service;

import employee_management.entity.Employee;
import employee_management.event.EmployeeCreatedEvent;
import employee_management.exception.EmployeeNotFoundException;
import employee_management.kafka.EmployeeKafkaProducer;
import employee_management.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;


import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ApplicationEventPublisher publisher;
    private final EmployeeKafkaProducer producer;

    public EmployeeService(EmployeeRepository repository,
                           ApplicationEventPublisher publisher,
                           EmployeeKafkaProducer producer) {
        this.repository = repository;
        this.publisher = publisher;
        this.producer = producer;
    }

    /* old method examples before db
       public void addEmployee(Employee employee) {
            employees.add(employee);
    }
     */

    public Employee createEmployee(Employee employee) {

        Employee savedEmployee = repository.save(employee);

        publisher.publishEvent(
                new EmployeeCreatedEvent(savedEmployee));

        System.out.println("Sending Kafka message for " + savedEmployee.getName());

        producer.sendEmployeeCreated(savedEmployee.getName());

        return savedEmployee;
    }

    public Employee findEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new EmployeeNotFoundException("Employee not found."));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found."));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return repository.save(existingEmployee);
    }


    public void deleteEmployee(Long id) {
       if(!repository.existsById(id)) {
           throw new EmployeeNotFoundException("Employee not found.");
       }
       repository.deleteById(id);
    }

}
