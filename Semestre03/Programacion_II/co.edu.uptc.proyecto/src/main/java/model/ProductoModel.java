package model;

public class ProductoModel {
    int id, cantidad;
    String nombre;
    double precio_unitario, precio_total;
    
    public ProductoModel(int id, int cantidad, String nombre, double precio_unitario) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.precio_total = precio_unitario * cantidad;
    }
    
}
