package Gui;

import Logic.Reserva;
import Control.SistemaReservas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InterfazReservas {
    private SistemaReservas sistema;
    private Scanner scanner;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public InterfazReservas() {
        sistema = new SistemaReservas();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false; // tengo que definir el booleano como falso, porque sino inicializo falla

        while (!salir) {
            System.out.println("\nSistema de Reservas");
            System.out.println("1. Agregar nueva reserva");
            System.out.println("2. Mostrar todas las reservas");
            System.out.println("3. Buscar reservas por fecha");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    buscarReservasPorFecha();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private void agregarReserva() {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        LocalDate fechaInicio = obtenerFecha("Fecha de inicio (dd/MM/yyyy): ");
        LocalDate fechaFin = obtenerFecha("Fecha de fin (dd/MM/yyyy): ");

        if (fechaInicio.isAfter(fechaFin)) {
            System.out.println("Error: La fecha de inicio debe ser anterior a la fecha de fin.");
            return;
        }

        Reserva nuevaReserva = new Reserva(nombre, fechaInicio, fechaFin);
        if (sistema.agregarReserva(nuevaReserva)) {
            System.out.println("Reserva agregada exitosamente.");
        } else {
            System.out.println("Error: Las fechas se solapan con otra reserva existente.");
        }
    }

    private void mostrarReservas() {
        List<Reserva> reservas = sistema.getReservas();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            System.out.println("\nListado de reservas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private void buscarReservasPorFecha() {
        LocalDate fecha = obtenerFecha("Ingrese la fecha a consultar (dd/MM/yyyy): ");
        List<Reserva> reservas = sistema.getReservasPorFecha(fecha);

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas para la fecha seleccionada.");
        } else {
            System.out.println("\nReservas para " + fecha.format(formatter) + ":");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private LocalDate obtenerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String fechaStr = scanner.nextLine();
            try {
                return LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
            }
        }
    }
}