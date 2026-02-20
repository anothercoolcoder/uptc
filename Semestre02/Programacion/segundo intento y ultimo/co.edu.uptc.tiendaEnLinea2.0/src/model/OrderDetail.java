package model;

public class OrderDetail {
    private int quantity;
    private Item item;

    public OrderDetail( Item item,int quantity) {
        this.quantity = quantity;
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getSubtotal(){
        return item.getPrice() * quantity;
    }
    public String getQuantity(){
        return String.valueOf(quantity);
    }

    @Override
    public String toString() {
        return  "Producto: " + item.toString() + "\n" +
                "Cantidad: " +  getQuantity() + "\n";
    }
}
