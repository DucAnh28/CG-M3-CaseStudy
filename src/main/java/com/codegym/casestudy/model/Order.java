package com.codegym.casestudy.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private int customerId;
    private LocalDate create;
    private LocalDate delivery;
    private String status;
    private String address;
    private String phone;

    public Order() {
    }

    public Order(int id, int customerId, LocalDate create, LocalDate delivery, String status, String address, String phone) {
        this.id = id;
        this.customerId = customerId;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreate() {
        return create;
    }

    public void setCreate(LocalDate create) {
        this.create = create;
    }

    public LocalDate getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDate delivery) {
        this.delivery = delivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", create=" + create +
                ", delivery=" + delivery +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
