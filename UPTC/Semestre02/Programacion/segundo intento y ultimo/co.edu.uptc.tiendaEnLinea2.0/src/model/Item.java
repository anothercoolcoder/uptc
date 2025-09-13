package model;

public class Item {
    protected String name;
    protected double price;
    protected int stock, id;

    public String getName() {
        return name;
    }

    public Item(String name, double price, int stock, int id) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }
}
