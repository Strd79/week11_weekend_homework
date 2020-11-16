import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private PlaneType plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;
    private ArrayList<Integer> seatNumbersBooked;

    public Flight(PlaneType plane, String flightNumber, String destination, String departureAirport, Date departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.seatNumbersBooked = new ArrayList<Integer>();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public PlaneType getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public ArrayList<Integer> getSeatNumbersBooked() {
        return seatNumbersBooked;
    }

    public int getNumOfAvailSeats() {
        int planeCapacity = this.plane.getCapacity();
        int bookedPassengers = this.passengers.size();
        return planeCapacity - bookedPassengers;
    }

    public int assignSeatNumber() {
        Random rand = new Random();
        int upperBound = plane.getCapacity();
        int seatNumber = rand.nextInt(upperBound);
        int newSeatNumber = seatNumber += 1;
        if (this.seatNumbersBooked.contains(newSeatNumber)) {
            return assignSeatNumber();
        } else {
            this.seatNumbersBooked.add(seatNumber);
            return seatNumber;
        }
    }

    public void bookPassengerOnFlight(Passenger passenger) {
        int availSeats = this.getNumOfAvailSeats();
        if (availSeats > 0) {
            this.getPassengers().add(passenger);
            passenger.setFlight(this.flightNumber);
            passenger.setSeatNumber(assignSeatNumber());
        }
    }

    public int getBaggageTotalWeight() {
        return this.plane.getWeight() / 2;
    }
}
