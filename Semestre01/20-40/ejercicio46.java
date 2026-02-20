import java.util.Scanner;

public class ejercicio46 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Porcentajes para cada área
            double porcentajeCirugia = 0.37;
            double porcentajeLaboratorios = 0.42;
            double porcentajeUrgencias = 0.21;

            // Solicitar el presupuesto total al usuario
            System.out.println("Ingresa el presupuesto total de la clínica:");
            double presupuestoTotal = scanner.nextDouble();

            // Calcular la distribución del presupuesto
            double presupuestoCirugia = presupuestoTotal * porcentajeCirugia;
            double presupuestoLaboratorios = presupuestoTotal * porcentajeLaboratorios;
            double presupuestoUrgencias = presupuestoTotal * porcentajeUrgencias;

            // Mostrar los resultados
            System.out.printf("CIRUGÍA GENERAL: %.2f\n", presupuestoCirugia);
            System.out.printf("LABORATORIOS CLÍNICOS: %.2f\n", presupuestoLaboratorios);
            System.out.printf("URGENCIAS: %.2f\n", presupuestoUrgencias);
        }
    }
}
