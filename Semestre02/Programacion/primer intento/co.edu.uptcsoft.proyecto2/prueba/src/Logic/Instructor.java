package Logic;

public abstract class Instructor extends Usuario {
    public Instructor(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    public abstract String getTipoInstructor();
}
