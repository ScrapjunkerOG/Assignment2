
package flights;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.HashMap;

@Path("/flights")
public class FlightResource {

    // 1. Add a new flight
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addFlight(Flight flight) {

        Database.addFlight(flight);

        return Response.status(Response.Status.CREATED)
                .entity("Flight added successfully")
                .build();
    }

    // 2. Get flight by ID (XML)
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Flight getFlight(@PathParam("id") int id) {

        Flight flight = Database.getFlight(id);

        if (flight == null) {
            throw new NotFoundException("Flight not found");
        }

        return flight;
    }

    // 3. Get flights by date (XML)
    @GET
    @Path("/date/{date}")
    @Produces(MediaType.APPLICATION_XML)
    public FlightList getFlightsByDate(
            @PathParam("date") String date) {

        return new FlightList(Database.getFlightsByDate(date));
    }

    // 4. Get flights by price (JSON)
    @GET
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<Integer, Flight> getFlightsByPrice(
            @QueryParam("min") double min,
            @QueryParam("max") double max) {

        return Database.getFlightsByPrice(min, max);
    }

    // 5. Get flights by city (JSON)
    @GET
    @Path("/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<Integer, Flight> getFlightsByCity(
            @PathParam("city") String city) {

        return Database.getFlightsByCity(city);
    }
}
