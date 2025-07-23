package com.vitoria.foodexpress_backend.services;

import com.vitoria.foodexpress_backend.entities.*;
import com.vitoria.foodexpress_backend.repositories.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;
    private final FoodService foodService;

    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderService orderService,
                            FoodService foodService) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.foodService = foodService;
    }

    @Transactional
    public OrderItem createOrderItem(Long orderId, Long foodId, int quantity) {
        Order order = orderService.findById(orderId);
        Food food = foodService.findById(foodId);

        OrderItem item = new OrderItem(
                food.getName(),
                food.getPrice(),
                quantity
        );

        item.setOrder(order);
        item.setFood(food);

        // Remova esta linha se não tiver description:
        // item.setProductDescription(food.getDescription());

        // Ou defina como vazio/outro valor padrão:
        item.setProductDescription(""); // ou null

        return orderItemRepository.save(item);
    }

    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
    }

    public List<OrderItem> findByOrder(Long orderId) {
        Order order = orderService.findById(orderId);
        return orderItemRepository.findByOrder(order);
    }

    @Transactional
    public void deleteOrderItem(Long id) {
        OrderItem item = findById(id);
        orderItemRepository.delete(item);
    }

    @Transactional
    public OrderItem updateQuantity(Long id, int newQuantity) {
        OrderItem item = findById(id);
        item.setQuantity(newQuantity);
        return orderItemRepository.save(item);
    }
}