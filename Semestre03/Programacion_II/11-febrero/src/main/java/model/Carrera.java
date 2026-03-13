package model;
import java.util.List;
import java.util.ArrayList;

public class Carrera {
    private int codigoCarrera, facultadID;
    private String nombre;
    private List<Estudiante> Estudiantes = new ArrayList<>();
    
    public Carrera() {
        this.Estudiantes = new ArrayList<>();
    }
    public int getCodigoCarrera() {
        return codigoCarrera;
    }
    public void setcodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public int getFacultadID() {
        return facultadID;
    }
    public void setFacultadID(int facultadID) {
        this.facultadID = facultadID;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Estudiante> getEstudiantes() {
        return Estudiantes;
    }
    public void setEstudiantes(List<Estudiante> estudiantes) {
        Estudiantes = estudiantes;
    }
    public Carrera(int codigoCarrera, int facultadID, String nombre, List<Estudiante> estudiantes) {
        this.codigoCarrera = codigoCarrera;
        this.facultadID = facultadID;
        this.nombre = nombre;
        Estudiantes = estudiantes;
    }
    void agregarEstudiante (Estudiante e){
        Estudiantes.add(e);
    } 
    @Override
public String toString() { return nombre; }
}
