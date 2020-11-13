import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Passenger passenger7;
    Passenger passenger8;
    Passenger passenger9;

    @Before
    public void before() {
        flight = new Flight(PlaneType.LEARJET_23, "TJ0805", "LCY", "GLA", "14:00");
        passenger1 = new Passenger("David", 1);
        passenger2 = new Passenger("Kyle", 0);
        passenger3 = new Passenger("Ewen", 2);
        passenger4 = new Passenger("Ronald", 3);
        passenger5 = new Passenger("Jay", 2);
        passenger6 = new Passenger("Antonia", 1);
        passenger7 = new Passenger("Peter", 4);
        passenger8 = new Passenger("Brian-John", 4);
        passenger9 = new Passenger("Grant", 1);
    }

    @Test
    public void hasPlane() {
        assertEquals(PlaneType.LEARJET_23, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("TJ0805", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("LCY", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("14:00", flight.getDepartureTime());
    }

    @Test
    public void canGetAvailableSeats() {
        assertEquals(8, flight.getNumOfAvailSeats());
    }

    @Test
    public void canAddPassenger() {
        flight.getPassengers().add(passenger1);
        flight.getPassengers().add(passenger2);
        assertEquals(2, flight.getPassengers().size());
    }

    @Test
    public void canBookPassengerOnFlight() {
        flight.bookPassengerOnFlight(passenger1);
        flight.bookPassengerOnFlight(passenger2);
        assertEquals(2, flight.getPassengers().size());
    }

    @Test
    public void cannotBookPassengerOnFlight() {
        flight.bookPassengerOnFlight(passenger1);
        flight.bookPassengerOnFlight(passenger2);
        flight.bookPassengerOnFlight(passenger3);
        flight.bookPassengerOnFlight(passenger4);
        flight.bookPassengerOnFlight(passenger5);
        flight.bookPassengerOnFlight(passenger6);
        flight.bookPassengerOnFlight(passenger7);
        flight.bookPassengerOnFlight(passenger8);
        flight.bookPassengerOnFlight(passenger9);
        assertEquals(8, flight.getPassengers().size());
    }
}
