package Logic;

public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;

    public Inscripcion(Estudiante estudiante, Curso curso){
        this.estudiante = estudiante;
        this.curso = curso;
    }
    public Estudiante getEstudiante(){
        return estudiante;
    }
    public Curso getCurso(){
    return curso;
    }
}
