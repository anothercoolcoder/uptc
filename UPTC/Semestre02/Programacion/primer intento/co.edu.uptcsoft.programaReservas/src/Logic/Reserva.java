package Logic;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    public String nombreCliente;
    public LocalDate inicioFecha;
    public LocalDate finalFecha;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(String nombreCliente, LocalDate inicioFecha, LocalDate finalFecha) {
        this.nombreCliente = nombreCliente;
        this.inicioFecha = inicioFecha;
        this.finalFecha = finalFecha;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public 


}
