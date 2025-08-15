package Control;

import Logic.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Reserva> reservas;

    public SistemaReservas() {
        this.reservas = new ArrayList<>();
    }

    public boolean agregarReserva(Reserva nuevaReserva) {
        // Verificar solapamiento de fechas
        for (Reserva reservaExistente : reservas) {
            if (nuevaReserva.getFechaFin().isAfter(reservaExistente.getFechaInicio()) &&
                    nuevaReserva.getFechaInicio().isBefore(reservaExistente.getFechaFin())) {
                return false; // Hay solapamiento
            }
        }
        reservas.add(nuevaReserva);
        return true;
    }

    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    public List<Reserva> getReservasPorFecha(LocalDate fecha) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if ((fecha.isEqual(reserva.getFechaInicio()) || fecha.isAfter(reserva.getFechaInicio())) &&
                    (fecha.isEqual(reserva.getFechaFin()) || fecha.isBefore(reserva.getFechaFin()))) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }
}