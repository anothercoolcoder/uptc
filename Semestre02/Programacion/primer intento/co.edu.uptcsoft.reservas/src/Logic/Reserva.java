package Logic;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private String nombreCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(String nombreCliente, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombreCliente = nombreCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getDuracionDias() {
        return Period.between(fechaInicio, fechaFin).getDays();
    } // ¿por que en fechas muy grandes no representa completo?

    @Override
    public String toString() {
        return nombreCliente + " - Desde: " + fechaInicio.format(formatter) +
                " Hasta: " + fechaFin.format(formatter) + "( la duracion de su estancia en dias, es : " + getDuracionDias()+ ")" ;
    }
}