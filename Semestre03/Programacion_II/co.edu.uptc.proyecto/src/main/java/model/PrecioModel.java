package model;

public class PrecioModel {
    public int id;
    public String nombre;
    public double precio;
    public PrecioModel(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    public PrecioModel() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Precio [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
    }
    
    

}
