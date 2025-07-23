package com.vitoria.foodexpress_backend.repositories;

import com.vitoria.foodexpress_backend.entities.Order;
import com.vitoria.foodexpress_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<Order> findByRestaurantId(Long restaurantId);
    List<Order> findByStatus(Order.OrderStatus status);
}