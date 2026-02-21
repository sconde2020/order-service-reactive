package com.example.demo.kafka;

import com.example.demo.model.Order;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderProducer {

    KafkaTemplate<String, Order> kafkaTemplate;

    public void send(Order order) {
        kafkaTemplate.send("orders", order);
    }
}
