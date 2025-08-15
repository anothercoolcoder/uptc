package Logic;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.List;

public class InstructorDirector extends Instructor{

    private List<Curso> cusosAsignados = new ArrayList<>();

    public InstructorDirector(String nombre, String email, String id, String tipo) {
        super(nombre, email, id, tipo);
    }
    public void gestionarCurso(Curso curso){
        cusosAsignados.add(curso);
    }
}
