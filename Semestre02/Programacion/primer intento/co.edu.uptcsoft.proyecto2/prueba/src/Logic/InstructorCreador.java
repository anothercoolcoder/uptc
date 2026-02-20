package Logic;

public class InstructorCreador extends Instructor {
    public InstructorCreador(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    @Override
    public String getTipoUsuario() { return "INSTRUCTOR"; }

    @Override
    public String getTipoInstructor() { return "CREADOR"; }

    public Curso crearCurso(String nombre, String descripcion) {
        return new Curso(nombre, descripcion, false);
    }
}