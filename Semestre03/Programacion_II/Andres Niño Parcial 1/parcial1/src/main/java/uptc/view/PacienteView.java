package uptc.view;

import uptc.model.PacienteModel;
import uptc.model.Estadistica;
import java.util.List;

public class PacienteView {

    public void mostrarListaPacientes(List<PacienteModel> pacientes) {
        System.out.println("\n--- LISTA DE PACIENTES ---");
        System.out.printf("%-5s %-20s %-5s %-10s %-15s %-10s\n", "ID", "Nombre", "Edad", "Género", "Enfermedad", "Ciudad");
        System.out.println("-------------------------------------------------------------------------------");
        
        for (PacienteModel p : pacientes) {
            System.out.printf("%-5d %-20s %-5d %-10s %-15s %-10s\n", 
                p.getId(), p.getNombre(), p.getEdad(), p.getGenero(), p.getEnfermedad(), p.getCiudad());
        }
    }

    public void mostrarEstadisticas(Estadistica stats) {
        System.out.println("\n--- ESTADÍSTICAS DE EDAD ---");
        System.out.printf("Edad Máxima:  %.0f años\n", (double)stats.getEdadMax());
        System.out.printf("Edad Mínima:  %.0f años\n", (double)stats.getEdadMin());
        System.out.printf("Edad Promedio: %.2f años\n", stats.getPromedioEdad());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}