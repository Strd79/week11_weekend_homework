import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight1;
    Flight flight2;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Passenger passenger7;
    Passenger passenger8;
    Passenger passenger9;
    Date date1;
    Date date2;

    @Before
    public void before() {
        date1 = new java.util.Date(2020, 10, 15, 14, 0, 0);
        date2 = new java.util.Date(2020, 10, 16, 20, 30, 0);
        flight1 = new Flight(PlaneType.LEARJET_23, "TJ0805", "LCY", "GLA", date1);
        flight2 = new Flight(PlaneType.BOEING_787, "TJ3456", "LAX", "GLA", date2);
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
        assertEquals(PlaneType.LEARJET_23, flight1.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("TJ0805", flight1.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("LCY", flight1.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("GLA", flight1.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals(date1, flight1.getDepartureTime());
    }

    @Test
    public void canGetAvailableSeats() {
        assertEquals(8, flight1.getNumOfAvailSeats());
    }

    @Test
    public void canAddPassenger() {
        flight1.getPassengers().add(passenger1);
        flight1.getPassengers().add(passenger2);
        assertEquals(2, flight1.getPassengers().size());
    }

    @Test
    public void canBookPassengerOnFlight() {
        flight1.bookPassengerOnFlight(passenger1);
        flight1.bookPassengerOnFlight(passenger2);
        assertEquals(2, flight1.getPassengers().size());
    }

    @Test
    public void cannotBookPassengerOnFlight() {
        flight1.bookPassengerOnFlight(passenger1);
        flight1.bookPassengerOnFlight(passenger2);
        flight1.bookPassengerOnFlight(passenger3);
        flight1.bookPassengerOnFlight(passenger4);
        flight1.bookPassengerOnFlight(passenger5);
        flight1.bookPassengerOnFlight(passenger6);
        flight1.bookPassengerOnFlight(passenger7);
        flight1.bookPassengerOnFlight(passenger8);
        flight1.bookPassengerOnFlight(passenger9);
        assertEquals(8, flight1.getPassengers().size());
    }

    @Test
    public void canGetBaggageTotalWeight() {
        assertEquals(114000, flight2.getBaggageTotalWeight());
    }

    @Test
    public void passengerHasFlightNumberAssigned() {
        flight2.bookPassengerOnFlight(passenger1);
        assertEquals("TJ3456", passenger1.getFlight());
    }

    @Test
    public void passengerHasNoFlightNumberAssigned() {
        assertNull(passenger2.getFlight());
    }

    @Test
    public void passengerHasSeatNumber() {
        flight1.bookPassengerOnFlight(passenger6);
        assertNotNull(passenger6.getSeatNumber());
    }

    @Test
    public void passengerHasNoSeatNumber() {
        assertNull(passenger7.getSeatNumber());
    }

    @Test
    public void checkSeatNumbersAreNotDuplicated() {
        flight1.bookPassengerOnFlight(passenger1);
        flight1.bookPassengerOnFlight(passenger2);
        flight1.bookPassengerOnFlight(passenger3);
        flight1.bookPassengerOnFlight(passenger4);
        flight1.bookPassengerOnFlight(passenger5);
        flight1.bookPassengerOnFlight(passenger6);
        flight1.bookPassengerOnFlight(passenger7);
        flight1.bookPassengerOnFlight(passenger8);
        assertEquals ("", flight1.getSeatNumbersBooked());
    }
}
