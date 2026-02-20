import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ejercicio41 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa una fecha en formato yyyy-MM-dd:");

            String inputFecha = scanner.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                LocalDate fecha = LocalDate.parse(inputFecha, formato);
                System.out.println("La fecha ingresada es: " + fecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, usa el formato yyyy-MM-dd.");
            }
        }
    }
}
