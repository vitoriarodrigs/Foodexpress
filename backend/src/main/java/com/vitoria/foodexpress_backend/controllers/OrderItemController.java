package com.vitoria.foodexpress_backend.controllers;

import com.vitoria.foodexpress_backend.entities.OrderItem;
import com.vitoria.foodexpress_backend.services.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(
            @RequestParam Long orderId,
            @RequestParam Long foodId,
            @RequestParam int quantity) {

        OrderItem createdItem = orderItemService.createOrderItem(orderId, foodId, quantity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdItem.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem item = orderItemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getItemsByOrder(@PathVariable Long orderId) {
        List<OrderItem> items = orderItemService.findByOrder(orderId);
        return ResponseEntity.ok(items);
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<OrderItem> updateQuantity(
            @PathVariable Long id,
            @RequestParam int newQuantity) {

        OrderItem updatedItem = orderItemService.updateQuantity(id, newQuantity);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}