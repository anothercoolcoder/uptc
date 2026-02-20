package Control;

import Logic.*;
import java.util.ArrayList;
import java.util.List;

public class Conversion {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Instructor> instructores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    // Métodos para estudiantes
    public String registrarEstudiante(String nombre, String email, String id) {
        estudiantes.add(new Estudiante(nombre, email, id));
        return "Estudiante registrado exitosamente";
    }

    public Estudiante buscarEstudiante(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    // Métodos para instructores
    public String registrarInstructor(String nombre, String email, String id, String tipo) {
        Instructor instructor = tipo.equalsIgnoreCase("creador")
                ? new InstructorCreador(nombre, email, id)
                : new InstructorDirector(nombre, email, id);

        instructores.add(instructor);
        return "Instructor registrado exitosamente";
    }

    public Instructor buscarInstructor(String id) {
        for (Instructor i : instructores) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

    // Métodos para cursos
    public String crearCurso(String nombre, String descripcion, String idInstructor) {
        Instructor instructor = buscarInstructor(idInstructor);
        if (instructor instanceof InstructorCreador) {
            cursos.add(new Curso(nombre, descripcion, false));
            return "Curso creado exitosamente";
        }
        return "Solo instructores creadores pueden crear cursos";
    }

    public String inscribirEstudianteCurso(String idEstudiante, String nombreCurso) {
        Estudiante e = buscarEstudiante(idEstudiante);
        Curso c = buscarCurso(nombreCurso);

        if (e != null && c != null) {
            e.inscribirseCurso(c);
            return "Inscripción exitosa al curso: " + c.getNombre();
        }
        return "Error en la inscripción";
    }

    public String listarCursosEstudiante(String idEstudiante) {
        Estudiante e = buscarEstudiante(idEstudiante);
        if (e == null) return "Estudiante no encontrado";

        if (e.getCursosInscritos().isEmpty()) return "No tienes cursos inscritos";

        StringBuilder sb = new StringBuilder();
        for (Curso c : e.getCursosInscritos()) {
            sb.append("- ").append(c.getNombre())
                    .append(" (").append(c.getEstado() ? "Completado" : "En progreso")
                    .append(")\n");
        }
        return sb.toString();
    }

    public String asignarCursoInstructor(String nombreCurso, String idInstructor) {
        Curso c = buscarCurso(nombreCurso);
        Instructor i = buscarInstructor(idInstructor);

        if (c != null && i instanceof InstructorDirector) {
            ((InstructorDirector)i).gestionarCurso(c);
            return "Curso asignado exitosamente";
        }
        return "Error al asignar curso";
    }

    private Curso buscarCurso(String nombre) {
        for (Curso c : cursos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }
}