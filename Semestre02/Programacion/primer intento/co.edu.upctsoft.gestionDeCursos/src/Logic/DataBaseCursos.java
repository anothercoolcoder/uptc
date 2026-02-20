package Logic;

import java.util.ArrayList;
import java.util.List;

public class DataBaseCursos {
    private static List<Curso> cursosRegistrados = new ArrayList<>();

    public static void registrarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        if (!existeCurso(curso.getNombre())) {
            cursosRegistrados.add(curso);
        } else {
            throw new IllegalArgumentException("Ya existe un curso con este nombre");
        }
    }

    public static List<Curso> getCursos() {
        return new ArrayList<>(cursosRegistrados); // Devuelve copia para proteger la lista original
    }

    public static Curso buscarCursoPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        for (Curso curso : cursosRegistrados) {
            if (curso.getNombre().equalsIgnoreCase(nombre)) {
                return curso;
            }
        }
        return null;
    }

    private static boolean existeCurso(String nombre) {
        return buscarCursoPorNombre(nombre) != null;
    }
}