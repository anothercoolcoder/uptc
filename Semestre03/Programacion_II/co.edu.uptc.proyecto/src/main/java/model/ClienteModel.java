package model;

public class ClienteModel  {
    private String id; // Identificador único
    private String nombre;
    private double precioHabitacion;

    public ClienteModel() {}

    public ClienteModel(String id, String nombre, double precioHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.precioHabitacion = precioHabitacion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioHabitacion() { return precioHabitacion; }
    public void setPrecioHabitacion(double precioHabitacion) { this.precioHabitacion = precioHabitacion; }
}