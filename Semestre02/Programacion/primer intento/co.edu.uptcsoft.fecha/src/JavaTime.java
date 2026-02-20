import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
public class JavaTime {
    public static void main(String[] args) {
        try{

            Scanner sc = new Scanner(System.in);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            System.out.println("Ingrese una fecha segun este formato dd-MM-YYYY");
            LocalDate user = LocalDate.parse(sc.nextLine(),format);

            LocalDate current = LocalDate.now();

            System.out.println("Fecha ingresada                 : " + user.format(format));
            System.out.println("El dia de la semana en ingles   : " + user.getDayOfWeek()); //don't need format because it's a String
            System.out.println("El dia de la semana             : " + user.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es")));
            System.out.println("La fecha mas 7 dias             : " + user.plusDays(7).format(format));
            System.out.println("Fecha actual                    : " + current.format(format));
        } catch (Exception e) {
            System.out.println("Enter the request data.");
        }

    }
}