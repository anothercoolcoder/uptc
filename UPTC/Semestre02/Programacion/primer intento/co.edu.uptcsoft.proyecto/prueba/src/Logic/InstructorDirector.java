package Logic;

import java.util.ArrayList;
import java.util.List;

public class InstructorDirector extends Instructor {
    private List<Curso> cursosGestionados = new ArrayList<>();

    public InstructorDirector(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    @Override
    public String getTipoUsuario() { return "INSTRUCTOR"; }

    @Override
    public String getTipoInstructor() { return "DIRECTOR"; }

    public void gestionarCurso(Curso curso) {
        cursosGestionados.add(curso);
    }

    public List<Curso> getCursosGestionados() { return cursosGestionados; }
}
