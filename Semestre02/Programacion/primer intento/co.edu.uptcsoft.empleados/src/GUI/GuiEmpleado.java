package GUI;

import java.util.Scanner;
import LOGIC.Empleado;
import LOGIC.EmpleadoTiempoCompleto;
import LOGIC.EmpleadoPorHoras;
import LOGIC.Pasante;

public class GuiEmpleado {
    public void createEmpleado() {
        Scanner sc = new Scanner(System.in);
        Empleado empleado = null;

        while (true) {
            System.out.println("Seleccione el tipo de empleado:");
            System.out.println("1. Empleado de tiempo completo");
            System.out.println("2. Empleado por horas");
            System.out.println("3. Pasante");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 4) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el ID del empleado: ");
            String id = sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el salario mensual: ");
                    double salarioMensual = sc.nextDouble();
                    sc.nextLine();
                    empleado = new EmpleadoTiempoCompleto(nombre, id, salarioMensual);
                    break;

                case 2:
                    System.out.print("Ingrese la tarifa por hora: ");
                    double tarifaPorHora = sc.nextDouble();
                    System.out.print("Ingrese las horas trabajadas: ");
                    int horasTrabajadas = sc.nextInt();
                    sc.nextLine();
                    empleado = new EmpleadoPorHoras(nombre, id, tarifaPorHora, horasTrabajadas);
                    break;

                case 3:
                    System.out.print("Ingrese el bono del pasante: ");
                    double bono = sc.nextDouble();
                    sc.nextLine();
                    empleado = new Pasante(nombre, id, bono);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            if (empleado != null) {
                System.out.println("\nEmpleado creado:");
                empleado.mostrarInformacion();
                System.out.println();
            }
        }

        sc.close();
    }
}