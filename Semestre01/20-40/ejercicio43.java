import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ejercicio43 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa una fecha en formato dd/MM/yyyy hh:mm:ss:");

            String inputFecha = scanner.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            try {
                LocalDate fecha = LocalDate.parse(inputFecha.substring(0, 10), formato);
                LocalTime hora = LocalTime.parse(inputFecha.substring(11), formato);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy hh:mm:ss.");
            }
        }
    }
}
