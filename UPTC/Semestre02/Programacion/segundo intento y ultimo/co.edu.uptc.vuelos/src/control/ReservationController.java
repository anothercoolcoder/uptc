package control;

import logic.FlightService;
import logic.ReservationService;
import logic.InvalidAgeException;
import logic.InvalidEmailException;
import logic.InvalidFlightSelectionException;
import model.Flight;
import model.Passenger;
import model.Reservation;

import java.util.ArrayList;

public class ReservationController {

    private FlightService flightService;
    private ReservationService reservationService;

    public ReservationController() {
        this.flightService = new FlightService();
        this.reservationService = new ReservationService();
    }

    public ArrayList<Flight> searchFlights(String origin, String destination) {
        return flightService.searchFlights(origin, destination);
    }

    public Flight selectFlight(String flightCode) {
        return flightService.getFlightByCode(flightCode);
    }

    public Passenger registerPassenger(String fullName, String document, int age, String email)
            throws InvalidAgeException, InvalidEmailException {
        return reservationService.validatePassenger(fullName, document, age, email);
    }

    public Reservation createReservation(String reservationCode, Flight flight, Passenger passenger, int passengerCount)
            throws InvalidFlightSelectionException {
        return reservationService.createReservation(reservationCode, flight, passenger, passengerCount);
    }

    public ArrayList<Reservation> getAllReservations() {
        return reservationService.getReservations();
    }
}
