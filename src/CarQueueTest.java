import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class CarQueueTest {

    private CarQueue carQ;

    @Before
    public void setUp() {
        carQ = new CarQueue();
        carQ.addCar(new Civic("000ABC"));
        carQ.addCar(new Tesla("111DEF"));
        carQ.addCar(new Tesla("111GHI"));
    }

    @Test
    public void test1() {
        carQ.print( );
        assertEquals(carQ.getTotalWashTime(), 79);
    }
    
    @Test
    public void test2() {
    	carQ.removeCar();
    	assertEquals(carQ.getTotalWashTime(), 64);
    }

}
