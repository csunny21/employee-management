package employee_management.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaProducer {

    private final KafkaTemplate <String,String> kafkaTemplate;

    public EmployeeKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeCreated(String employeeName) {

        System.out.println("Employee Producer Started");

        System.out.println("Sending Kafka message for " + employeeName);

        kafkaTemplate.send("employee-created", employeeName );

        System.out.println("Kafka message sent: " + employeeName);

    }

}
