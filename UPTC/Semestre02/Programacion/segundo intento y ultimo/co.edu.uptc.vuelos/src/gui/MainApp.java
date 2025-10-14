    package gui;

    import control.ReservationController;
    import logic.exceptions.InvalidAgeException;
    import logic.exceptions.InvalidEmailException;
    import logic.exceptions.InvalidFlightSelectionException;
    import model.Flight;
    import model.Passenger;
    import model.Reservation;

    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.UUID;

    public class MainApp {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ReservationController controller = new ReservationController();

            while (true) {
                System.out.println("\n=== SISTEMA DE RESERVA DE VUELOS ===");
                System.out.println("1. Buscar vuelos");
                System.out.println("2. Ver todas las reservas");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (option) {
                    case 1:
                        System.out.print("Ingrese ciudad de origen: ");
                        String origin = scanner.nextLine();

                        System.out.print("Ingrese ciudad de destino: ");
                        String destination = scanner.nextLine();

                        ArrayList<Flight> foundFlights = controller.searchFlights(origin, destination);

                        if (foundFlights.isEmpty()) {
                            System.out.println("No se encontraron vuelos para esa ruta.");
                            break;
                        }

                        System.out.println("\nVuelos disponibles:");
                        for (Flight flight : foundFlights) {
                            System.out.println(flight);
                        }

                        System.out.print("\nIngrese el código del vuelo a seleccionar: ");
                        String code = scanner.nextLine();
                        Flight selectedFlight = controller.selectFlight(code);

                        if (selectedFlight == null) {
                            System.out.println("Código de vuelo inválido.");
                            break;
                        }

                        try {
                            System.out.print("Ingrese nombre completo del pasajero: ");
                            String fullName = scanner.nextLine();

                            System.out.print("Ingrese documento de identidad: ");
                            String document = scanner.nextLine();

                            System.out.print("Ingrese edad: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese correo electrónico: ");
                            String email = scanner.nextLine();

                            Passenger passenger = controller.registerPassenger(fullName, document, age, email);

                            System.out.print("Ingrese número de pasajeros: ");
                            int passengerCount = scanner.nextInt();
                            scanner.nextLine();

                            String reservationCode = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
                            Reservation reservation = controller.createReservation(reservationCode, selectedFlight, passenger, passengerCount);

                            System.out.println("\n=== RESERVA CONFIRMADA ===");
                            System.out.println(reservation);

                        } catch (InvalidAgeException | InvalidEmailException | InvalidFlightSelectionException e) {
                            System.out.println("Error: " + e.getMessage());
                        }

                        break;

                    case 2:
                        ArrayList<Reservation> reservations = controller.getAllReservations();
                        if (reservations.isEmpty()) {
                            System.out.println("No hay reservas registradas.");
                        } else {
                            System.out.println("\n=== TODAS LAS RESERVAS ===");
                            for (Reservation res : reservations) {
                                System.out.println(res);
                                System.out.println("----------------------------");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema. ¡Gracias por usar el servicio!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }
            }
        }
    }
