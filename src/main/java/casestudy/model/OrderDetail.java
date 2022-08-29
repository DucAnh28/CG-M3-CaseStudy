package com.codegym.casestudy.model;

public class OrderDetail {
    private int orderId;
    private int bookId;
    private int quantity;
    private double total;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int bookId, int quantity, double total) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
