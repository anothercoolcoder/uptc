package Logic;

import java.util.ArrayList;
import java.util.List;

public class DataBaseEstudiantes {
    private static List<Estudiante> estudiantesRegistrados = new ArrayList<>();

    public static void registrarEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if (!existeEstudiante(estudiante.getEmail())) {
            estudiantesRegistrados.add(estudiante);
        } else {
            throw new IllegalArgumentException("Ya existe un estudiante con este email");
        }
    }

    public static List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantesRegistrados);
    }

    public static Estudiante buscarPorEmail(String email) {
        for (Estudiante estudiante : estudiantesRegistrados) {
            if (estudiante.getEmail().equalsIgnoreCase(email)) {
                return estudiante;
            }
        }
        return null;
    }

    private static boolean existeEstudiante(String email) {
        return buscarPorEmail(email) != null;
    }
}