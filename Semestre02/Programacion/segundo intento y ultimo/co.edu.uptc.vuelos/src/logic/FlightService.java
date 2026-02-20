package logic;

import model.Flight;
import java.util.ArrayList;

public class FlightService {
    private ArrayList<Flight> flights;

    public FlightService() {
        flights = new ArrayList<>();
        preloadFlights();
    }

    private void preloadFlights() {
        flights.add(new Flight("AV101", "Bogota", "Medellin", "2025-01-15", 350.0, 50));
        flights.add(new Flight("LA220", "Cali", "Cartagena", "2025-02-10", 420.0, 30));
        flights.add(new Flight("VE330", "Barranquilla", "San Andrés", "2025-03-05", 500.0, 20));
    }

    public ArrayList<Flight> searchFlights(String origin, String destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) &&
                    flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    public Flight getFlightByCode(String code) {
        for (Flight flight : flights) {
            if (flight.getFlightCode().equalsIgnoreCase(code)) {
                return flight;
            }
        }
        return null;
    }
}
