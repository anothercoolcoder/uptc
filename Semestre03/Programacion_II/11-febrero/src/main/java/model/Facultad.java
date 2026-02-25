package model;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private int id;
    private String nombre; 
    private List<Carrera> carreras = new ArrayList<>();

    public Facultad() {}

    public Facultad(int id, String nombre, List<Carrera> carreras) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
    }

    
    @Override
public String toString() { return nombre; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Carrera> getCarreras() { return carreras; }
    public void setCarreras(List<Carrera> carreras) { this.carreras = carreras; }

    public void agregarCarrera(Carrera e) {
        carreras.add(e);
    }
}