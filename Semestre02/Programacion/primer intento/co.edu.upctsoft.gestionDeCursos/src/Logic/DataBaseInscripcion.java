package Logic;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseInscripcion {
    private static List<Inscripcion> inscripciones = new ArrayList<>();

    public static void inscribirEstudiante(Estudiante estudiante,Curso curso){
        Inscripcion nuevaInscripcion = new Inscripcion(estudiante,curso);
        inscripciones.add(nuevaInscripcion);
    }
    public static List<Curso> getCursosInscritosEstudiante(Estudiante estudiante){
        List<Curso> cursosInscritos = new ArrayList<>();
        for (Inscripcion ins : inscripciones){
            if (ins.getEstudiante().equals(estudiante)){
            }
        }
        return cursosInscritos;
    }


}
