package com.vitoria.foodexpress_backend.controllers;

import com.vitoria.foodexpress_backend.entities.Order;
import com.vitoria.foodexpress_backend.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestParam Long userId,
            @RequestParam Long restaurantId) {

        Order createdOrder = orderService.createOrder(userId, restaurantId);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdOrder.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.findByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Order>> getOrdersByRestaurant(@PathVariable Long restaurantId) {
        List<Order> orders = orderService.findByRestaurant(restaurantId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable Order.OrderStatus status) {
        List<Order> orders = orderService.findByStatus(status);
        return ResponseEntity.ok(orders);
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam Order.OrderStatus newStatus) {

        Order updatedOrder = orderService.updateStatus(orderId, newStatus);
        return ResponseEntity.ok(updatedOrder);
    }
}