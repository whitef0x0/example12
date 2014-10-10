
public class Tesla extends AbstractCar {
    
    private static final int timeToWash = 32;
    private String licensePlate;
    
    public Tesla( String licensePlate ) {
        this.licensePlate = licensePlate;
    }
    
    public String getCarId( ) {
        return "Tesla Model S "+licensePlate;
    }
    
    public int timeToWash( ) {
        return timeToWash;
    }

}
