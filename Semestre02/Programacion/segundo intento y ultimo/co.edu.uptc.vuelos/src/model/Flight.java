package model;

public class Flight {
    private String flightCode;
    private String origin;
    private String destination;
    private String date;
    private double price;
    private int availableSeats;

    public Flight(String flightCode, String origin, String destination, String date, double price, int availableSeats) {
        this.flightCode = flightCode;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void reduceSeats(int passengers) {
        this.availableSeats -= passengers;
    }

    @Override
    public String toString() {
        return "Flight Code: " + flightCode +
                " | " + origin + " → " + destination +
                " | Date: " + date +
                " | Price: $" + price +
                " | Seats: " + availableSeats;
    }
}
