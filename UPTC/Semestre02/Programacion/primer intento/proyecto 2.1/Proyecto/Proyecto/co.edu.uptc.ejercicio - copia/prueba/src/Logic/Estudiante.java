package Logic;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario implements CompletarCurso {
    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String email, String id) {
        super(nombre, email, id);
        this.cursosInscritos = new ArrayList<>();
    }

    public List<Curso> getCursosInscritos() { return cursosInscritos; }

    @Override
    public String getTipoUsuario() { return "ESTUDIANTE"; }

    public void inscribirseCurso(Curso curso) {
        cursosInscritos.add(curso);
    }

    @Override
    public String completarCurso(Curso curso) {
        if (cursosInscritos.contains(curso)) {
            curso.setEstado(true);
            return "Curso completado: " + curso.getNombre();
        }
        return "No estás inscrito en este curso";
    }
}
