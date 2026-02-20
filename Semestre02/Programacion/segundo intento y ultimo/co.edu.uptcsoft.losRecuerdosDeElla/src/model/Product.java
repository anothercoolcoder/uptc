package model;

public class Product {
    public String name;
    public double id, price;

    public Product(String name, double id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + '\n' +
                "Identificador: " + id + "\n"+
                "Precio: " + price + "\n";
    }
}
