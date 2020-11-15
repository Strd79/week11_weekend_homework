public class Passenger {

    private String name;
    private int numOfBags;
    private String flight;
    private Integer seatNumber;

    public Passenger(String name, int numOfBags) {
        this.name = name;
        this.numOfBags = numOfBags;
        this.flight = null;
        this.seatNumber = null;
    }

    public String getName() {
        return name;
    }

    public int getNumOfBags() {
        return numOfBags;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flightNumber) {
        this.flight = flightNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
