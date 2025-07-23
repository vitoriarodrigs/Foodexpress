
package com.vitoria.foodexpress_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference // <--- ANOTAÇÃO AQUI
    private List<Food> menu = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant( String name, String address){
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }
    // Método auxiliar para adicionar um item ao menu
    public void addFood(Food food) {
        food.setRestaurant(this);
        this.menu.add(food);
    }
}