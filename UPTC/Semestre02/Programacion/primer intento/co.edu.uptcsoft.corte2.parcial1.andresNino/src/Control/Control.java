package Control;

import Logic.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Control {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public String controllerDate(String name, LocalDateTime startTime, LocalDateTime finalTime){
    Car car = new Car(name,startTime,finalTime);
    return toString().valueOf(car);
    }


}
