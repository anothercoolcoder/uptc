
package Logic;

import java.util.ArrayList;
import java.util.List;

public class GestorCursos {
    private static List<Curso> cursosDisponibles = new ArrayList<>();

    static {
        // Cursos predefinidos
        Curso curso1 = new Curso("Programación Básica", "Fundamentos de programación");
        curso1.agregarLeccion(new Leccion("Introducción", "Conceptos básicos", 30));

        Curso curso2 = new Curso("Matemáticas Avanzadas", "Álgebra y cálculo");
        curso2.agregarLeccion(new Leccion("Álgebra Lineal", "Vectores y matrices", 45));

        cursosDisponibles.add(curso1);
        cursosDisponibles.add(curso2);
    }
    public static List<Curso> obtenerCursosDeEstudiante(Estudiante estudiante) {
        List<Curso> cursosInscritos = new ArrayList<>();
        for (Curso curso : cursosDisponibles) {
            if (curso.getEstudiantesInscritos().contains(estudiante)) {
                cursosInscritos.add(curso);
            }
        }
        return cursosInscritos;
    }

    public static List<Curso> getCursosDisponibles() {
        return new ArrayList<>(cursosDisponibles);
    }

    public static void agregarCurso(Curso curso) {
        cursosDisponibles.add(curso);
    }
    public List<Curso> obtenerCursosDisponibles(){
        return GestorCursos.getCursosDisponibles();
    }
    public static boolean eliminarCurso(String nombre) {
        return cursosDisponibles.removeIf(curso -> curso.getNombre().equalsIgnoreCase(nombre));
    }
}
