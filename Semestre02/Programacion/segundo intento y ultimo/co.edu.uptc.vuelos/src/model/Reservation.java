package model;

public class Reservation {
    private String reservationCode;
    private Flight flight;
    private Passenger passenger;
    private int passengerCount;
    private double totalCost;

    public Reservation(String reservationCode, Flight flight, Passenger passenger, int passengerCount) {
        this.reservationCode = reservationCode;
        this.flight = flight;
        this.passenger = passenger;
        this.passengerCount = passengerCount;
        this.totalCost = flight.getPrice() * passengerCount;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Reservation Code: " + reservationCode +
                "\n" + flight +
                "\n" + passenger +
                "\nPassengers: " + passengerCount +
                "\nTotal Cost: $" + totalCost;
    }
}
