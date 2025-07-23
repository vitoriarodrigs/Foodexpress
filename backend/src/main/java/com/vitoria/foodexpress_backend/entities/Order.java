package com.vitoria.foodexpress_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders") // Evita conflito com palavra reservada SQL
public class Order {

    // ---------- ATRIBUTOS ---------- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Armazena o enum como STRING no banco
    private OrderStatus status = OrderStatus.PREPARING; // Valor padrão

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // <--- Lado "pai" (será serializado)
    private List<OrderItem> items = new ArrayList<>();

    @CreationTimestamp // Auto-popula a data de criação
    private LocalDateTime createdAt;

    // ---------- CONSTRUTORES ---------- //
    // Construtor vazio (OBRIGATÓRIO para JPA/Hibernate)
    public Order() {
    }

    // Construtor para criar pedidos manualmente (OPCIONAL)
    public Order(User user, Restaurant restaurant) {
        this.user = user;
        this.restaurant = restaurant;
    }

    // ---------- MÉTODOS DE ACESSO (GETTERS/SETTERS) ---------- //
    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ---------- MÉTODOS UTILITÁRIOS ---------- //
    // Adiciona um item ao pedido (mantém a consistência bidirecional)
    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }

    // Remove um item do pedido
    public void removeItem(OrderItem item) {
        items.remove(item);
        item.setOrder(null);
    }

    // ---------- ENUM (Status do Pedido) ---------- //
    public enum OrderStatus {
        PREPARING,    // Em preparação
        ON_THE_WAY,   // A caminho
        DELIVERED     // Entregue
    }

    // ---------- EQUALS & HASHCODE ---------- //
    // (Opcional, mas importante para comparar objetos)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ---------- TO STRING (Para logs/debug) ---------- //
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}