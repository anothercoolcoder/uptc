package model;

public class OrderDetail {
    public int quantity;
    private final Item item;

    public OrderDetail(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
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
