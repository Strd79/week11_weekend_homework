import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Flight flight1;
    Flight flight2;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before() {
        flight1 = new Flight(PlaneType.LEARJET_23, "TJ0805", "LCY", "GLA", "14:00");
        flight2 = new Flight(PlaneType.GULFSTREAM_G500, "TJ9752", "SXF", "GLA", "19:00");
        flightManager = new FlightManager();
        passenger1 = new Passenger("David", 1);
        passenger2 = new Passenger("Kyle", 0);
        passenger3 = new Passenger("Ewen", 2);
        flight2.bookPassengerOnFlight(passenger1);
        flight2.bookPassengerOnFlight(passenger2);
        flight2.bookPassengerOnFlight(passenger3);
    }

    @Test
    public void checkBaggageWeightPerPassenger() {
        assertEquals(174, flightManager.baggageWeightPerPassenger(flight1));
    }

    @Test
    public void checkBaggageWeightBookedOnFlight() {
        assertEquals(1734, flightManager.baggageWeightBookedOnFlight(flight2));
    }
}
