package Logic;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String descripcion;
    private boolean estado;
    private List<Estudiante> estudiantesInscritos;
    private List<Leccion> lecciones;

    public Curso(String nombre, String descripcion, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.estudiantesInscritos = new ArrayList<>();
        this.lecciones = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    public List<Estudiante> getEstudiantesInscritos() { return estudiantesInscritos; }
    public List<Leccion> getLecciones() { return lecciones; }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!estudiantesInscritos.contains(estudiante)) {
            estudiantesInscritos.add(estudiante);
        }
    }

    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
    }
}
