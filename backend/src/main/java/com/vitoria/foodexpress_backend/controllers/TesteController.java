package com.vitoria.foodexpress_backend.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
    @GetMapping("/")  // Mapeia a raiz do site ("http://localhost:8080/")
    public String home() {
        return "Olá, mundo! Página inicial funcionando!";
    }
}
