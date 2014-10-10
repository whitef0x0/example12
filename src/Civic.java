public class Civic extends AbstractCar {

    private static final int timeToWash = 15;
    private static final String carName = "Honda Civic";
    private String licensePlate;

    /**
     * Create a Honda Civic with a given license plate
     * 
     * @param licensePlate
     */
    public Civic(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Get an identifier for the car
     * 
     * @return an identifier for this car
     */
    public String getCarId() {
        return carName + " " + licensePlate;
    }

    /**
     * Get the time needed to wash this car
     * 
     * @return the time needed to wash this car
     */
    public int timeToWash() {
        return timeToWash;
    }

}
