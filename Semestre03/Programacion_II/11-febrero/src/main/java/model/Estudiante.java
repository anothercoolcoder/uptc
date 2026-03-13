package model;

public class Estudiante {
    private int id;
    private String nombre; 
    private int edad;      
    private int codigoCarrera;

    public Estudiante(int id, String nombre, int edad, int codigoCarrera) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.codigoCarrera = codigoCarrera;
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




    public int getEdad() {
        return edad;
    }




    public void setEdad(int edad) {
        this.edad = edad;
    }




    public int getCodigoCarrera() {
        return codigoCarrera;
    }




    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }




    @Override
    public String toString() {
        return "Student [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", codigoCarrera=" + codigoCarrera + "]";
    }
    
    
}