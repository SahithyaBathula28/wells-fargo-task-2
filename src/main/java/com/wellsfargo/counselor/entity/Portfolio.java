package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.security.Security;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private double totalValue;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    public Portfolio(Client client, double totalValue) {
        this.client = client;
        this.totalValue = totalValue;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
