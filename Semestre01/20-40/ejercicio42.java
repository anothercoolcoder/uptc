import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ejercicio42 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                System.out.println("Ingresa la primera fecha en formato dd/MM/yyyy:");
                String inputFecha1 = scanner.nextLine();
                LocalDate fecha1 = LocalDate.parse(inputFecha1, formato);

                System.out.println("Ingresa la segunda fecha en formato dd/MM/yyyy:");
                String inputFecha2 = scanner.nextLine();
                LocalDate fecha2 = LocalDate.parse(inputFecha2, formato);

                if (fecha2.isAfter(fecha1)) {
                    System.out.println("La segunda fecha es posterior a la primera.");
                } else if (fecha2.isBefore(fecha1)) {
                    System.out.println("La segunda fecha es anterior a la primera.");
                } else {
                    System.out.println("Ambas fechas son iguales.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
            }
        }
    }
}
