public class FlightManager {

    public FlightManager() {
    }

    public int baggageWeightPerPassenger(Flight flight) {
        int baggageTotal = flight.getPlane().getWeight() / 2;
        int planeCapacity = flight.getPlane().getCapacity();
        return baggageTotal / planeCapacity;
    }

    public int baggageWeightBookedOnFlight(Flight flight) {
        int baggageCount = 0;
        for (Passenger person : flight.getPassengers()) {
            baggageCount += person.getNumOfBags();
        }
        int baggageWeight = baggageWeightPerPassenger(flight);
        return baggageCount * baggageWeight;
    }
}
