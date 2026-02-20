package model;

public class Contenedor<T> {
    public Product product;
    public int cantidad;

    public Contenedor(Product product, int cantidad) {
        this.product = product;
        this.cantidad = cantidad;
    }
    public void setCantidad(int number){
        this.cantidad = number;
    }
    public void incrementar (int number){
        this.cantidad += number;
    }
    public void decrementar (int number){
        this.cantidad -= number;
        if (this.cantidad < 0)this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return  "Producto: "+ "\n"      + getProduct().toString()+
                "Cantidad: "    + getCantidad() + "\n";
    }
}
