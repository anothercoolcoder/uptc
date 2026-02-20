package Control;

import Logic.*;
import java.util.ArrayList;
import java.util.List;

public class ControlClase {
    private static List<Instructor> instructores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Estudiante> estudiantes = new ArrayList<>();

    // Métodos para Instructores
    public static void agregarInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("El instructor no puede ser nulo");
        }
        instructores.add(instructor);
    }

    public static List<Instructor> getInstructores() {
        return new ArrayList<>(instructores);
    }

    public static List<Curso> getCursosPorInstructor(Instructor instructor) {
        List<Curso> cursosInstructor = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getInstructor() != null && curso.getInstructor().equals(instructor)) {
                cursosInstructor.add(curso);
            }
        }
        return cursosInstructor;
    }

    // Métodos para Cursos
    public static void agregarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        cursos.add(curso);
    }

    public static List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    // Métodos para Estudiantes
    public static void agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        estudiantes.add(estudiante);
    }

    public static List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    // Registro en bases de datos
    public static void registrarEstudiante(Estudiante estudiante) {
        DataBaseEstudiantes.registrarEstudiante(estudiante);
    }

    public static void registrarCurso(Curso curso) {
        DataBaseCursos.registrarCurso(curso);
    }

    // Búsquedas
    public static Estudiante buscarEstudiantePorEmail(String email) {
        for (Estudiante estudiante : DataBaseEstudiantes.getEstudiantes()) {
            if (estudiante.getEmail().equals(email)) {
                return estudiante;
            }
        }
        return null;
    }

    public static List<Curso> obtenerCursosDisponibles() {
        // Combinar cursos locales y de la base de datos
        List<Curso> todosCursos = new ArrayList<>(cursos);
        todosCursos.addAll(DataBaseCursos.getCursos());
        return todosCursos;
    }

    //Inscribir estudiante a un curso
    public List<Curso> inscribirEstudiante(Estudiante estudiante){
        return DataBaseInscripcion.getCursosInscritosEstudiante(estudiante);
    }
}