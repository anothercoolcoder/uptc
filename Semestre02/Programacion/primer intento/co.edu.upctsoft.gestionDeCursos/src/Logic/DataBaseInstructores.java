package Logic;

import java.util.ArrayList;
import java.util.List;

public class DataBaseInstructores {
    private static List<Instructor> registradosInstructor = new ArrayList<>();

    public static void registrarInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("El instructor no puede ser nulo");
        }
        if (existeInstructor(instructor.getEmail())) {
            throw new IllegalArgumentException("Ya existe un instructor con este email");
        }
        registradosInstructor.add(instructor);
    }

    public static List<Instructor> getInstructores() {
        return new ArrayList<>(registradosInstructor);
    }

    public static boolean existeInstructor(String email) {
        for (Instructor instructor : registradosInstructor) {
            if (instructor.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public static Instructor buscarPorEmail(String email) {
        for (Instructor instructor : registradosInstructor) {
            if (instructor.getEmail().equalsIgnoreCase(email)) {
                return instructor;
            }
        }
        return null;
    }
}