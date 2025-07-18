package com.vitoria.foodexpress_backend.services;

import com.vitoria.foodexpress_backend.entities.Food;
import com.vitoria.foodexpress_backend.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // CREATE: Salva um novo food
    public Food create(Food food) {
        return foodRepository.save(food);
    }

    // READ ALL: Lista todos os foods
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    // READ BY ID: Busca por ID (lança exceção se não existir)
    public Food findById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food não encontrado com ID: " + id));
    }

    // UPDATE: Atualiza um food existente
    public Food update(Long id, Food newFoodData) {
        Food existingFood = findById(id); // Reaproveita a busca com tratamento de erro

        existingFood.setName(newFoodData.getName());
        existingFood.setPrice(newFoodData.getPrice());
        existingFood.setRestaurant(newFoodData.getRestaurant());

        return foodRepository.save(existingFood);
    }

    // DELETE: Remove um food
    public void delete(Long id) {
        Food food = findById(id); // Valida se existe antes de deletar
        foodRepository.delete(food);
    }
}