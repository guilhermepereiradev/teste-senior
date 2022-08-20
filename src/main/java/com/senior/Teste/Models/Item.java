package com.senior.Teste.Models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "type", nullable = false)
    private TypeItem type;

    public Item(){};

    public Item(UUID id, String description, double value, TypeItem type) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TypeItem getType() {
        return type;
    }

    public void setType(TypeItem type) {
        this.type = type;
    }
}
