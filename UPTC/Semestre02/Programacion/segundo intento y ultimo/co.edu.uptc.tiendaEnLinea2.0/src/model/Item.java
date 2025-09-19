package model;

public class Item {
    protected String name;
    protected double price;
    protected int stock, id;
    public double getPrice(){
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public Item(String name, double price, int stock, int id) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + "\n" +
                "Precio: $" + price + "\n"+
                "Cantidad: " + stock + "\n"+
                "Identificador: " + id + "\n";
    }
}
