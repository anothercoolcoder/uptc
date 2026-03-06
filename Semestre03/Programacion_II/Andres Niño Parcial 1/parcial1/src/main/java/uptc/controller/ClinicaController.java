package uptc.controller;

import uptc.dao.PacienteDao;
import uptc.model.Estadistica;
import uptc.model.PacienteModel;
import uptc.view.PacienteView;
import java.util.List;
    import java.util.Map;
import java.util.stream.Collectors;

public class ClinicaController {
    private PacienteDao dao;
    private PacienteView view;

    public ClinicaController() {
        // Asumiendo que tu archivo XML está en la raíz del proyecto
        this.dao = new PacienteDao("archivos/pacientes.xml"); 
        this.view = new PacienteView();
    }



// Dentro de ClinicaController
public void mostrarConteoPorEnfermedad(List<PacienteModel> pacientes) {
    Map<String, Long> conteo = pacientes.stream()
        .collect(Collectors.groupingBy(
            PacienteModel::getEnfermedad, 
            Collectors.counting()
        ));

    System.out.println("\n--- CONTEO DE PACIENTES POR ENFERMEDAD ---");
    conteo.forEach((enfermedad, cantidad) -> 
        System.out.println(enfermedad + ": " + cantidad + " pacientes"));
}
    public void ejecutar() {
        List<PacienteModel> lista = dao.obtenerPacientes();
        
        if (lista.isEmpty()) {
            view.mostrarMensaje("No se encontraron pacientes o el archivo está vacío.");
            return;
        }

        // 1. Mostrar la tabla
        view.mostrarListaPacientes(lista);
        
        // 2. Calcular y mostrar estadísticas
        Estadistica stats = Estadistica.calcular(lista);
        view.mostrarEstadisticas(stats);
    }

}