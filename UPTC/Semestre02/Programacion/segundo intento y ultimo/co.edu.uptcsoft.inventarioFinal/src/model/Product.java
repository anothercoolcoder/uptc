package model;

public class Product {
    public int id, amount;
    public String name, description;

    public Product(int id, int amount, String name, String description) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.description = description;
    }
}
