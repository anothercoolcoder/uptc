package Logic;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String descripcion;
    private boolean estado;
    private List<Leccion> lecciones;
    private List<Estudiante> estudiantesInscritos;
    private Instructor instructor;  // Nuevo campo para el instructor

    public Curso(String nombre, String descripcion, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.lecciones = new ArrayList<>();
        this.estudiantesInscritos = new ArrayList<>();
    }

    // Métodos para lecciones
    public void agregarLeccion(Leccion leccion) {
        if (leccion == null) {
            throw new IllegalArgumentException("La lección no puede ser nula");
        }
        lecciones.add(leccion);
    }

    public boolean eliminarLeccion(Leccion leccion) {
        return lecciones.remove(leccion);
    }

    public List<Leccion> getLecciones() {
        return new ArrayList<>(lecciones); // Devuelve una copia para proteger la lista original
    }

    // Métodos para estudiantes
    public boolean inscribirEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if (!estudiantesInscritos.contains(estudiante)) {
            return estudiantesInscritos.add(estudiante);
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        return estudiantesInscritos.remove(estudiante);
    }

    // Métodos para el instructor
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("El instructor no puede ser nulo");
        }
        this.instructor = instructor;
    }

    // Getters y setters básicos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Métodos adicionales útiles
    public int getCantidadLecciones() {
        return lecciones.size();
    }

    public int getCantidadEstudiantes() {
        return estudiantesInscritos.size();
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", instructor=" + (instructor != null ? instructor.getNombre() : "Sin asignar") +
                ", lecciones=" + getCantidadLecciones() +
                ", estudiantesInscritos=" + getCantidadEstudiantes() +
                '}';
    }
}