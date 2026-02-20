package Logic;

import java.util.ArrayList;
import java.util.List;

public class InstructorDirector extends Instructor {
    private List<Curso> cursosGestionados = new ArrayList<>();

    public InstructorDirector(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    @Override
    public String getTipoUsuario() {
        return "INSTRUCTOR";
    }

    @Override
    public String getTipoInstructor() {
        return "DIRECTOR";
    }

    public void gestionarCurso(Curso curso) {
        cursosGestionados.add(curso);
    }

    public List<Curso> getCursosGestionados() {
        return cursosGestionados;
    }

    public String modificarDescripcionCurso(Curso curso, String nuevaDescripcion) {
        if(cursosGestionados.contains(curso)) {
            curso.setDescripcion(nuevaDescripcion);
            return "Descripción modificada exitosamente";
        }
        return "Error: No tienes permisos para modificar este curso";
    }
}


