package employee_management.listener;

import employee_management.audit.AuditLog;
import employee_management.event.EmployeeCreatedEvent;
import employee_management.repository.AuditLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeCreatedListener {

    private final AuditLogRepository repository;

    public EmployeeCreatedListener(AuditLogRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void handleEmployeeCreated(EmployeeCreatedEvent event) {
        System.out.println("Employee Created: " + event.getEmployee().getName());

        AuditLog audit = new AuditLog();

        audit.setAction("CREATED");

        audit.setEmployeeName(
                event.getEmployee().getName()
        );

        audit.setCreatedAt(
                LocalDateTime.now()
        );

        repository.save(audit);

        System.out.println("Audit record created");

    }
}
