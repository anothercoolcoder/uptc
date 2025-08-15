package Logic;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String descripcion;
    private List<Estudiante> estudiantesInscritos;
    private List<Leccion> lecciones;
    private boolean estado;
    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estudiantesInscritos = new ArrayList<>();
        this.lecciones = new ArrayList<>();
        this.estado = false;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!estudiantesInscritos.contains(estudiante)) {
            estudiantesInscritos.add(estudiante);
        }
    }
    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
    }
    public List<Leccion> getLecciones(){
        return  lecciones;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public boolean isEstado(){
        return estado;
    }
    public double calcularProgreso() {
        if (lecciones.isEmpty()) return 0;

        int completadas = 0;
        for (Leccion leccion : lecciones) {
            if (leccion.isCompletada()) {
                completadas++;
            }
        }
        return (completadas * 100.0) / lecciones.size();
    }

    // esto sirve para que no se pueda inscribir dos veces al mismo curso
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Curso curso = (Curso) obj;
        return nombre.equalsIgnoreCase(curso.nombre); // suponiendo que el nombre es único
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    public List<Estudiante> getEstudiantesInscritos(){
        return estudiantesInscritos;
    }

}
