package com.vitoria.foodexpress_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vitoria.foodexpress_backend.entities.Restaurant;

import java.util.Optional;



public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findById(Long id);
}
