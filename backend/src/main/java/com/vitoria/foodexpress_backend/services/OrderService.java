package com.vitoria.foodexpress_backend.services;

import com.vitoria.foodexpress_backend.entities.*;
import com.vitoria.foodexpress_backend.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;

    public OrderService(OrderRepository orderRepository,
                        UserService userService,
                        RestaurantService restaurantService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @Transactional
    public Order createOrder(Long userId, Long restaurantId) {
        User user = userService.findById(userId);
        Restaurant restaurant = restaurantService.findById(restaurantId);

        Order order = new Order(user, restaurant);
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<Order> findByUser(Long userId) {
        User user = userService.findById(userId);
        return orderRepository.findByUser(user);
    }

    public List<Order> findByRestaurant(Long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

    public List<Order> findByStatus(Order.OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Transactional
    public Order updateStatus(Long orderId, Order.OrderStatus newStatus) {
        Order order = findById(orderId);
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    @Transactional
    public void addItemToOrder(Long orderId, OrderItem item) {
        Order order = findById(orderId);
        order.addItem(item);
        orderRepository.save(order);
    }

    @Transactional
    public void removeItemFromOrder(Long orderId, OrderItem item) {
        Order order = findById(orderId);
        order.removeItem(item);
        orderRepository.save(order);
    }
}