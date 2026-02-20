package Control;

import Logic.*;
import java.util.ArrayList;
import java.util.List;

public class Control {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Instructor> instructores = new ArrayList<>();

    // Métodos para estudiantes
    public String registrarEstudiante(String nombre, String email, String id) {
        if(usuarioYaExiste(nombre, id)) {
            return "Ya existe un usuario con ese nombre o ID";
        }
        estudiantes.add(new Estudiante(nombre, email, id));
        return "Estudiante registrado exitosamente";
    }
    // En tu clase Control.java
    public List<Curso> obtenerCursosEstudiante(String estudianteId) {
        Estudiante estudiante = buscarEstudiante(estudianteId);
        if (estudiante != null) {
            return GestorCursos.obtenerCursosDeEstudiante(estudiante);
        } else {
            return new ArrayList<>(); // or handle null case as needed
        }
    }


    public Estudiante buscarEstudiante(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    // Métodos para instructores
    public String registrarInstructor(String nombre, String email, String id, String tipo) {
        // Verificar si ya existe
        for (Instructor i : instructores) {
            if (i.getNombre().equalsIgnoreCase(nombre) || i.getId().equals(id)) {
                return "El instructor ya existe (con nombre o id)";
            }
        }

        // Verificar si el ID está en estudiantes
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return "Error: El ID ya está registrado para un estudiante";
            }
        }

        Instructor instructor;
        if (tipo.equalsIgnoreCase("creador")) {
            instructor = new InstructorRector(nombre, email, id);
        } else {
            instructor = new InstructorDirector(nombre, email, id);
        }

        instructores.add(instructor);
        return "Instructor registrado exitosamente";
    }
    public Curso obtenerCursoPorNombre(String nombreCurso){
        return buscarCurso(nombreCurso);
    }
    public String agregarLeccionACurso(String nombreCurso, String tituloLeccion, String contenidoLeccion, int duracion){
        Curso curso = buscarCurso(nombreCurso);
        if (curso == null) return "Curso no encontrado";

        Leccion leccion = new Leccion(tituloLeccion, contenidoLeccion, duracion);
        curso.agregarLeccion(leccion);
        return "Leccion agregada exitosamente al curso: " + curso.getNombre();
    }



    public Instructor buscarInstructor(String id) {
        for (Instructor i : instructores) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

    public String estudiantesInscritos(String nombreCurso,String idInstructor){
        Instructor instructor = buscarInstructor(idInstructor);
        if (instructor == null || !(instructor instanceof InstructorDirector)) {
            return "Solo los instructores directores pueden modificar la descripcion";
        }
        Curso curso = buscarCurso(nombreCurso);
        if(curso == null) {
            return "El curso no se encontró";
        }
        List<Estudiante> estInscritos = curso.getEstudiantesInscritos();
        if(estInscritos.isEmpty()){
            return "Todavia no hay estudiantes inscritos en el curso: " + curso.getNombre();
            }
        StringBuilder sb = new StringBuilder("Los estudiantes que estan inscritos al curso" + curso.getNombre() + " son:");
        for (Estudiante e : estInscritos){
            sb.append(" ").append(e.getNombre())
                    .append(" Con el ID: ").append(e.getId()).append(" ");
        }
        return sb.toString();
    }

    public String modificarDescripcionCurso(String nombreCurso, String idInstructor, String nuevaDescripcion) {
        Instructor instructor = buscarInstructor(idInstructor);
        if (instructor == null || !(instructor instanceof InstructorDirector)) {
            return "Solo los instructores directores pueden modificar la descripcion";
        }
        Curso curso = buscarCurso(nombreCurso);
        if(curso == null) {
            return "El curso no se encontró";
        }
        return ((InstructorDirector)instructor).modificarDescripcionCurso(curso, nuevaDescripcion);
    }

    // Métodos para cursos
    public String crearNuevoCurso(String nombre, String descripcion, String idInstructor) {
        Instructor instructor = buscarInstructor(idInstructor);
        if (instructor == null) {
            return "Instructor no encontrado";
        }

        if ("CREADOR".equals(instructor.getTipoInstructor())) {
            Curso nuevoCurso = new Curso(nombre, descripcion);
            GestorCursos.agregarCurso(nuevoCurso);
            return "Curso creado exitosamente: " + nombre;
        } else {
            return "Solo instructores rectores pueden crear cursos";
        }
    }
    public List<Curso> obtenerCursosDisponibles() {
        return GestorCursos.getCursosDisponibles();
    }


    public String eliminarCurso(String nombreCurso, String idInstructor) {
        Instructor instructor = buscarInstructor(idInstructor);
        if (instructor == null) {
            return "Instructor no encontrado";
        }

        if (!"DIRECTOR".equals(instructor.getTipoInstructor())) {
            return "Solo instructores directores pueden eliminar cursos";
        }

        boolean cursoFueEliminado = GestorCursos.eliminarCurso(nombreCurso);
        if (cursoFueEliminado) {
            return "Curso eliminado exitosamente";
        } else {
            return "Curso no encontrado";
        }
    }

    public String inscribirEstudianteCurso(String idEstudiante, String nombreCurso) {
        Estudiante e = buscarEstudiante(idEstudiante);
        Curso c = buscarCurso(nombreCurso);
        if (e != null && c != null){
            if (e.getCursosInscritos().contains(c)){
                return "Ya estas inscrito en el curso : " + c.getNombre();
            }
        }

        if (e != null && c != null) {
            e.inscribirseCurso(c);
            c.inscribirEstudiante(e);
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

            sb.append("- ").append(c.getNombre()).append(" (");
        }
        return sb.toString(); // <-- ahora sí devuelve lo que armaste
    }


    public String listarCursosDisponibles() {
        if (GestorCursos.getCursosDisponibles().isEmpty()) {
            return "No hay cursos disponibles";
        }

        StringBuilder sb = new StringBuilder();
        for (Curso c : GestorCursos.getCursosDisponibles()) {
            sb.append("- ").append(c.getNombre())
                    .append(": ").append(c.getDescripcion())
                    .append("\n");
        }
        return sb.toString();
    }


    public Curso buscarCurso(String nombre) {
        for (Curso c : GestorCursos.getCursosDisponibles()) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }

    public boolean usuarioYaExiste(String nombre, String id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre) || estudiante.getId().equals(id))
                return true;
        }

        for (Instructor instructor : instructores) {
            if (instructor.getNombre().equalsIgnoreCase(nombre) || instructor.getId().equals(id)) {
                return true;
            }
        }
        return false;

    }
    public ArrayList<String> obtenerCursos(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Curso curso : GestorCursos.getCursosDisponibles()) {
            nombres.add(curso.getNombre());
        }
        return nombres;
    }
    public void actualizarEstadoLeccion(String estudianteId, String nombreCurso, Leccion leccionActualizada) {
        Estudiante estudiante = buscarEstudiante(estudianteId);
        if (estudiante == null) return;

        Curso curso = null;
        for (Curso c : estudiante.getCursosInscritos()) {
            if (c.getNombre().equalsIgnoreCase(nombreCurso)) {
                curso = c;
                break;
            }
        }
        if (curso == null) return;

        for (Leccion leccion : curso.getLecciones()) {
            if (leccion.getTitulo().equals(leccionActualizada.getTitulo())) {
                leccion.setCompletada(leccionActualizada.isCompletada());
                break;
            }
        }

    }


}