/**
 * 
 * The AbstractCar class needs to extended to create cars. Only maintains
 * default wash time to support a car cleaning enterprise.
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public abstract class AbstractCar {

    private static final int defaultWashTime = 20;

    /**
     * Get the time needed to wash the car
     * 
     * @return time needed to wash the car
     */
    public int timeToWash() {
        return defaultWashTime;
    }

    /**
     * Get a string to identify the car. This method must be implemented by the
     * classes that extend AbstractCar.
     * 
     * @return the car identifier
     */
    public abstract String getCarId();

}
