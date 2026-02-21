package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    public Mono<Order> create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/{id}")
    public Mono<Order> read(@PathVariable String id) {
        return orderService.findById(id);
    }

    @GetMapping
    public Flux<Order> readAll() {
        return orderService.findAll();
    }

    @PutMapping
    public Mono<Order> update(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Order order) {
        return orderService.findById(order.getId())
                .flatMap(orderService::delete);
    }

}
