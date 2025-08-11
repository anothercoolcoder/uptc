package Logic;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario implements CompletarCurso{
    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String email, String id) {
        super(nombre, email, id);
        this.cursosInscritos = new ArrayList<>();
    }

    public void inscribirseCurso(Curso curso){
        cursosInscritos.add(curso);
        curso.inscribirEstudiante(this);
    }

    public String completarCurso(Curso curso){
        curso.setEstado(true);
        return "El curso " + curso.getNombre() + "ha sido completado";
    }
}
