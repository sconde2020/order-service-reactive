package com.example.demo.kafka;

import com.example.demo.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "order-consumers")
    public void consume(Order order) {
        System.out.println("Received order: " + order);
    }
}
