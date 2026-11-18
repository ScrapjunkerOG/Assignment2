
package flights;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Database {

    private static HashMap<Integer, Flight> flights = new HashMap<>();
    
    static {
        flights.put(1, new Flight(1, "2026-12-15", "08:30",
                "Helsinki", "London", 150.0));

        flights.put(2, new Flight(2, "2026-12-15", "12:00",
                "Helsinki", "Paris", 220.0));

        flights.put(3, new Flight(3, "2026-12-16", "10:15",
                "Vaasa", "Stockholm", 180.0));

        flights.put(4, new Flight(4, "2026-12-17", "14:45",
                "Tampere", "Berlin", 250.0));
    }

    public static void addFlight(Flight flight) {
        flights.put(flight.getId(), flight);
    }

    public static Flight getFlight(int id) {
        return flights.get(id);
    }

    public static List<Flight> getFlightsByDate(String date) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights.values()) {
            if (flight.getDate().equals(date)) {
                result.add(flight);
            }
        }

        return result;
    }

    public static HashMap<Integer, Flight> getFlightsByPrice(
            double min, double max) {

        HashMap<Integer, Flight> result = new HashMap<>();

        for (Flight flight : flights.values()) {
            if (flight.getPrice() >= min &&
                flight.getPrice() <= max) {

                result.put(flight.getId(), flight);
            }
        }

        return result;
    }

    public static HashMap<Integer, Flight> getFlightsByCity(
            String city) {

        HashMap<Integer, Flight> result = new HashMap<>();

        for (Flight flight : flights.values()) {
            if (flight.getOrigin().equalsIgnoreCase(city) ||
                flight.getDestination().equalsIgnoreCase(city)) {

                result.put(flight.getId(), flight);
            }
        }

        return result;
    }
}
