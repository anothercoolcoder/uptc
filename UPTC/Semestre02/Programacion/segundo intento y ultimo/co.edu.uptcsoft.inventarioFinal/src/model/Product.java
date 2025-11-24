package model;

public class Product {
    public int amount;
    public String name, category, id;

    public Product(String id, int amount, String name, String description) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.category = description;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  "Id: " + id + " | "  +
                "Cantidad: " + amount + " | " +
                "Nombre: " + name + " | "  +
                "Categoria: " + category;
    }
}
