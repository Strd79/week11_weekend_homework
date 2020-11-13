import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("David", 2);
    }

    @Test
    public void passengerHasName() {
        assertEquals("David", passenger.getName());
    }

    @Test
    public void passengerNumOfBags() {
        assertEquals(2, passenger.getNumOfBags());
    }
}
