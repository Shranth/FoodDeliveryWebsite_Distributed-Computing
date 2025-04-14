package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private double totalAmount;
    private LocalDateTime createdAt;
    private int serverId;

    @ElementCollection
    private List<CartItem> items;

    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    public Order(String email, List<CartItem> items, double totalAmount,int serverId) {
        this.email = email;
        this.items = items;
        this.totalAmount = totalAmount;
        this.serverId = serverId;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    public int getServerId() { return serverId; }
    public void setServerId(int serverId) { this.serverId = serverId; }
}
