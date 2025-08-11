package Logic;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Usuario {
    private String tipo;
    private List<Curso> cursosAsignados;  // Lista de cursos que imparte el instructor
    private List<Leccion> lecciones;      // Lista de lecciones creadas (si es necesario)

    public Instructor(String nombre, String email, String id, String tipo) {
        super(nombre, email, id);
        this.tipo = tipo;
        this.cursosAsignados = new ArrayList<>();
        this.lecciones = new ArrayList<>();
    }

    // Métodos para el tipo de instructor
    public boolean esCreador() {
        return "creador".equals(tipo);
    }

    public boolean esDirector() {
        return "director".equals(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos para gestión de cursos
    public void agregarCurso(Curso curso) {
        if (!cursosAsignados.contains(curso)) {
            cursosAsignados.add(curso);
            curso.setInstructor(this);  // Establece este instructor como responsable del curso
        }
    }

    public List<Curso> getCursosAsignados() {
        return new ArrayList<>(cursosAsignados);  // Devuelve una copia para proteger la lista original
    }

    // Métodos para gestión de lecciones (si es necesario)
    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
    }

    public List<Leccion> getLecciones() {
        return new ArrayList<>(lecciones);
    }
}