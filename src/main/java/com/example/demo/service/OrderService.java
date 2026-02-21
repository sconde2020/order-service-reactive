package com.example.demo.service;

import com.example.demo.kafka.OrderProducer;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    OrderProducer orderProducer;

    public Mono<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }

    public Mono<Order> save(Order order) {
        return orderRepository.save(order)
                .flatMap(
                    savedOrder -> {
                        orderProducer.send(savedOrder);
                        return Mono.just(savedOrder);
                    }
                );
    }

    public Mono<Void> delete(Order order) {
        return orderRepository.delete(order);
    }
}
