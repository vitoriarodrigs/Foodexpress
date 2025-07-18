package com.vitoria.foodexpress_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vitoria.foodexpress_backend.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
