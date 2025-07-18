package com.vitoria.foodexpress_backend.repositories;


import com.vitoria.foodexpress_backend.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    // Todos os métodos CRUD já estão herdados:
    // - save(), findById(), findAll(), delete(), etc.
}