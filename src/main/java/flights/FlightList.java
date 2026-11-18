package flights;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightList {

    private List<Flight> flights;

    public FlightList() {
    }

    public FlightList(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}