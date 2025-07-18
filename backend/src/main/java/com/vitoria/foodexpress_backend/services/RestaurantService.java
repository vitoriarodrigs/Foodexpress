package com.vitoria.foodexpress_backend.services;

import com.vitoria.foodexpress_backend.entities.Restaurant;
import com.vitoria.foodexpress_backend.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant criar(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> listarTodos() {
        return restaurantRepository.findAll();
    }

    public Restaurant buscarPorId(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public Restaurant atualizar(Long id, Restaurant novosDados) {
        Restaurant existente = buscarPorId(id);
        if (existente != null) {
            existente.setName(novosDados.getName());
            existente.setAddress(novosDados.getAddress());
            return restaurantRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        restaurantRepository.deleteById(id);
    }
}
