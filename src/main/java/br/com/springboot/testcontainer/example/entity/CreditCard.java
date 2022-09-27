package br.com.springboot.testcontainer.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "creditcard")
public class CreditCard {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    public CreditCard() {
    }

    public CreditCard(Long id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}
