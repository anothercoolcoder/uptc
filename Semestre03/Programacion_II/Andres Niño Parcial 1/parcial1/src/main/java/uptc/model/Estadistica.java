package uptc.model;

import java.util.*;
import java.util.stream.Collectors;

public class Estadistica {
    private int edadMax;
    private int edadMin;
    private double promedioEdad;

    public Estadistica(int edadMax, int edadMin, double promedioEdad) {
        this.edadMax = edadMax;
        this.edadMin = edadMin;
        this.promedioEdad = promedioEdad;
    }

    public static Estadistica calcular(List<PacienteModel> pacientes) {
        if (pacientes == null || pacientes.isEmpty()) {
            throw new IllegalArgumentException("No hay pacientes para calcular estadísticas");
        }

        // Aquí usamos una referencia a método (method reference) para extraer la edad
        IntSummaryStatistics stats = pacientes.stream()
                .collect(Collectors.summarizingInt(PacienteModel::getEdad));

        return new Estadistica(stats.getMax(), stats.getMin(), stats.getAverage());
    }

    // Getters
    public int getEdadMax() { return edadMax; }
    public int getEdadMin() { return edadMin; }
    public double getPromedioEdad() { return promedioEdad; }
}