package com.vitoria.foodexpress_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items") // Nome da tabela no banco
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Relaciona com Order
    private Order order;
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    // Campos diretos (sem classe Product)
    private String productName;     // Ex: "Hambúrguer Artesanal"
    private String productDescription; // Opcional: "Pão brioche, queijo cheddar..."
    private double unitPrice;      // Preço unitário no momento do pedido
    private int quantity;          // Quantidade (ex: 2)

    // --- Construtores ---
    public OrderItem() {
        // Construtor vazio (obrigatório para JPA)
    }

    // Construtor para facilitar a criação
    public OrderItem(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }


    // --- Método útil para calcular o total do item ---
    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}