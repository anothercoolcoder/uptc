package gestion;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import dto.*;
import model.*;

public class EstadisticasEstudianteGestion {

    public EstadisticasEstudiantesDto calcular(List<Estudiante> es) {
        if (es == null || es.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes");

        }
        DoubleSummaryStatistics stats = es.stream().collect(Collectors.summarizingDouble(Estudiante::getEdad));
        int edadMax = (int) stats.getMax();
        int edadMin = (int) stats.getMin();
        double promedioEdad = stats.getAverage();
        return new EstadisticasEstudiantesDto(edadMax, edadMin, promedioEdad);
    }
}
