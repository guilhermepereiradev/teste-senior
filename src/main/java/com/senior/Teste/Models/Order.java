package com.senior.Teste.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "date", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Timestamp date;

    @Column(name = "percentual_discount", nullable = false)
    private Double percentualDiscount;

    @Column(name = "total_value")
    private Double totalValue;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(targetEntity=OrderItems.class,cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItems> items = new ArrayList<>();

    public Order() {}

    public Order(UUID id, Integer number, Timestamp date, Double percentualDiscount, Double totalValue, List<OrderItems> items) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.percentualDiscount = percentualDiscount;
        this.totalValue = totalValue;
        this.items = items;
    }

    public Order(UUID id, Integer number, Timestamp date, Double percentualDiscount, Double totalValue) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.percentualDiscount = percentualDiscount;
        this.totalValue = totalValue;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setPercentualDiscount(Double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setOrderItems(List<OrderItems> items) {
        this.items = items;
    }

}
