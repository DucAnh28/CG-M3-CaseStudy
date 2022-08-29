package com.codegym.casestudy.model;

public class Book {
    private int id;
    private String code;
    private String name;
    private int author_id;
    private double price;
    private int category_id;
    private String image;
    private String description;

    public Book() {
    }

    public Book(int id, String code, String name, int author_id, double price, int category_id, String image, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author_id = author_id;
        this.price = price;
        this.category_id = category_id;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", author_id=" + author_id +
                ", price=" + price +
                ", category_id=" + category_id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
