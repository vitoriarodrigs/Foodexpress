package com.vitoria.foodexpress_backend.repositories;

import com.vitoria.foodexpress_backend.entities.Order;
import com.vitoria.foodexpress_backend.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByFoodId(Long foodId);
}