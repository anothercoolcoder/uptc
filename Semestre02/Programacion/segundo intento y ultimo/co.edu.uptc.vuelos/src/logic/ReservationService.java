package logic;

import model.Flight;
import model.Passenger;
import model.Reservation;

import java.util.ArrayList;

public class ReservationService {
    private ArrayList<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public Passenger validatePassenger(String name, String document, int age, String email)
            throws InvalidAgeException, InvalidEmailException {

        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Edad invalida tiene que estar entre 1 y 100");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Formato de correo invalido");
        }

        return new Passenger(name, document, age, email);
    }

    public Reservation createReservation(String code, Flight flight, Passenger passenger, int count)
            throws InvalidFlightSelectionException {

        if (flight == null) {
            throw new InvalidFlightSelectionException("Vuelo no encontrado o seleccion invalida");
        }

        if (flight.getAvailableSeats() < count) {
            throw new InvalidFlightSelectionException("No hay suficientes pasajeros");
        }

        flight.reduceSeats(count);
        Reservation reservation = new Reservation(code, flight, passenger, count);
        reservations.add(reservation);
        return reservation;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
