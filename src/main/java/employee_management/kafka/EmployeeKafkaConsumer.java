package employee_management.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaConsumer {

    @KafkaListener(topics = "employee-created",
                   groupId = "employee-group")

    public void consume(String employeeName) {
        System.out.println("Kafka received employee " + employeeName);
        System.out.println("Welcome email sent to: " + employeeName);

    }
}
