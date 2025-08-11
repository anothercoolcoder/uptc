package Logic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Car {
    public LocalDateTime startDate, finalDate;
    public String placa;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Car(String placa,LocalDateTime startDate,LocalDateTime finalDate) {
        this.startDate = startDate;
        this.placa = placa;
        this.finalDate = finalDate;
    }

    public String getDuration() {
    Period period = Period.between(startDate.toLocalDate(),finalDate.toLocalDate());
    Duration duration = Duration.between(startDate,finalDate);

    long totalHours = duration.toHours() %24;
    return  period.getYears()   + " años, "    +
            period.getMonths()  + " meses, "   +
            period.getDays()    + " dias, "    +
            totalHours          + " horas ";
    }


    @Override
    public String toString() {
        return  "El carro con la placa '"  + placa + "'\nCon fecha de entrada de " + startDate.format(formatter) +
                "\nY fecha de salida : " + finalDate.format(formatter)+ "\n" + "Estuvo un total de " + getDuration();
    }
}
