package com.vitoria.foodexpress_backend.controllers;

import com.vitoria.foodexpress_backend.entities.Food;
import com.vitoria.foodexpress_backend.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // POST: Cria um Food
    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodService.create(food);
    }

    // GET: Lista todos
    @GetMapping
    public List<Food> findAll() {
        return foodService.findAll();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Food findById(@PathVariable Long id) {
        return foodService.findById(id);
    }

    // PUT: Atualiza
    @PutMapping("/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {
        return foodService.update(id, food);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}