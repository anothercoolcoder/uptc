package Logic;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Curso> cursoList;
    private List<Estudiante> estudiantesRegistrados;
    private List<Instructor> instructoresRegistrados;
    public void agregarCurso(Curso curso){
        cursoList.add(curso);
    }
    public List<Curso>getCurso;

    public Sistema() {
    this.cursoList = new ArrayList<>();
    this.instructoresRegistrados = new ArrayList<>();
    this.estudiantesRegistrados = new ArrayList<>();
    }

}
