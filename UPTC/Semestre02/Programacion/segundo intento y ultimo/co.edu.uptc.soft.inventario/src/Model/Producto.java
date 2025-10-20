package Model;

public class Producto {

    private int id, cantidad;
    private String nombre, categoria;
    private boolean toxicidad;

    public Producto(int id, int cantidad, String nombre, String categoria, boolean toxicidad) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.categoria = categoria;
        this.toxicidad = toxicidad;
    }

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getToxicidad() {
        if (toxicidad) {
            return "Toxico";
        } else {
            return "No es toxico";
        }
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String reducirStock(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            return "Stock reducido";
        } else {
            return "Stock insuficiente";
        }
    }

    public String aumentarStock (int cantidad){
        if (cantidad <= 5) {
            this.cantidad += cantidad;
            return "Stock aumentado";
        } else {
            return "El stock no necesita reabastecerce";
        }
    }

    public boolean verificarStockCritico () {
        return true;
    }

}