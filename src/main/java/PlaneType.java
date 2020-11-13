public enum PlaneType {

    LEARJET_23(8, 2790),
    GULFSTREAM_G500(19, 22000),
    BOEING_787(250, 228000),
    AIRBUS_A380(853, 574000);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }
}
