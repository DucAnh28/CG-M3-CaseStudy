package com.codegym.casestudy.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private int customer_id;
    private LocalDate dateBuy;

    public Order() {
    }

    public Order(int id, int customer_id, LocalDate dateBuy) {
        this.id = id;
        this.customer_id = customer_id;
        this.dateBuy = dateBuy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", dateBuy=" + dateBuy +
                '}';
    }
}
