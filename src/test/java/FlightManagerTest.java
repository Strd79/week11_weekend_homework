import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Flight flight1;
    Flight flight2;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Date date1;
    Date date2;

    @Before
    public void before() {
        date1 = new java.util.Date(2020, 10, 14, 17, 23, 0);
        date2 = new java.util.Date(2020, 10, 17, 23, 35, 0);
        flight1 = new Flight(PlaneType.LEARJET_23, "TJ0805", "LCY", "GLA", date1);
        flight2 = new Flight(PlaneType.GULFSTREAM_G500, "TJ9752", "SXF", "GLA", date2);
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

    @Test
    public void checkRemainingBaggageWeightOnFlight() {
        assertEquals(9266, flightManager.remainingBaggageWeightOnFlight(flight2));
    }

}
