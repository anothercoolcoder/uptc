package Logic;

public class InstructorRector extends Instructor {
    public InstructorRector(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    @Override
    public String getTipoUsuario() { return "INSTRUCTOR"; }

    @Override
    public String getTipoInstructor() { return "CREADOR"; }
    public void editarLeccion(Leccion leccion, String nuevoTitulo, String nuevoContenido, int nuevaDuracion){
        if (leccion == null) throw new IllegalArgumentException("La leccion no puede ser nula");
        if (nuevoTitulo == null|| nuevoContenido == null || nuevaDuracion<= 0)
            throw new IllegalArgumentException("Datos invalidos para actualizar la leccion");
        leccion.setTitulo(nuevoTitulo);
        leccion.setContenido(nuevoContenido);
        leccion.setDuracion(nuevaDuracion);
    }

    public Curso crearCurso(String nombre, String descripcion) {
        return new Curso(nombre, descripcion);
    }
}