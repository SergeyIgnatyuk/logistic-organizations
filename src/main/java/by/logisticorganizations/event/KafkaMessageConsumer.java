package by.logisticorganizations.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

    @KafkaListener(topics = "logistic-main-topic", groupId = "logistic-main-group")
    public void simpleListener(String message) {
        System.out.println("Received Message: " + message);
    }
}
