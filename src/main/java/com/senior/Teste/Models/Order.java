package com.senior.Teste.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "percentual_discount", nullable = false)
    private double percentualDiscount;


    @Column(name = "total_value")
    private Double totalValue;

    public Order() {}

    public Order(UUID id, Integer number, Timestamp date, double percentualDiscount, Double totalValue) {
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

    public double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setPercentualDiscount(double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
