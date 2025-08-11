import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class hola {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekInSpanish = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        System.out.println("Today is " + dayOfWeekInSpanish);
    }
}
