Example 12: Recursive Lists
=========


This example serves two purposes:

1. To illustrate the power of subtyping in processing a variety of data;
2. To illustrate recursive datatypes using a simple list structure.

In particular, this example maintains a queue of cars that are waiting at a car wash. Different cars need different wash times but there is only one queue at the car wash. To achieve this, we start with the definition of an `AbstractCar` class. This `AbstractCar` class is extended to two specific classes, a `Civic` class and a `Tesla` class.

### Subtyping

The `AbstractCar` class contains the following source code:

```java
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
     * @return
     */
    public abstract String getCarId();

}
```

This abstract class is extended as follows:

**Civic**

```java
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
```

**Tesla**

```java
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
```

### List Through Recursion

A `CarQueue` class is defined as being either (i) an empty list or (ii) a car and the rest of the list. This is the recursive definition of a list.

Using this approach, the `CarQueue` class is as follows:

```java
public class CarQueue {
	private AbstractCar firstCar;
	private CarQueue otherCars;

	/**
	 * Create an empty car queue
	 */
	public CarQueue() {
		;
	}

	/**
	 * Create a car queue with one car
	 * 
	 * @param car
	 *            to create the queue with
	 */
	public CarQueue(AbstractCar car) {
		firstCar = car;
	}

	/**
	 * Add a car to the queue
	 * 
	 * @param car
	 *            the car to add to the queue
	 */
	public void addCar(AbstractCar car) {
		if (firstCar == null) {
			firstCar = car;
		} else {
			if (otherCars == null)
				otherCars = new CarQueue();
			otherCars.addCar(car);
		}
	}

	/**
	 * Obtain an estimate of the time needed to finish washing all cars in the
	 * queue sequentially
	 * 
	 * @return the time needed to wash all cars in the queue sequentially
	 */
	public int getTotalWashTime() {
		if (firstCar == null)
			return 0;
		if ((firstCar != null) && (otherCars == null))
			return firstCar.timeToWash();
		return firstCar.timeToWash() + otherCars.getTotalWashTime();
	}

	/**
	 * Print the car queue, one car per line
	 */
	public void print() {
		if (firstCar == null) {
			System.out.println("");
		} else {
			System.out.println(firstCar.getCarId());
			if (otherCars != null) {
				otherCars.print();
			}
		}
	}

	/**
	 * Remove the first car from the queue
	 * 
	 */
	public void removeCar() {
		// TODO implement this method (think and then read the code below)

		// why will this = otherCars not work? Try it. Think about it.

		if (firstCar != null) {
			// delete only if there is something to delete
			// ideally we should throw an exception if firstCar == null

			// notice below that we can refer to private fields because of the
			// recursive definition of CarQueue.
			if (otherCars != null) {
				firstCar = otherCars.firstCar;
				otherCars = otherCars.otherCars;
			}

		}
	}

}
```

This recursive definition allows us to implement methods using recursion. See, for example, `addCar( )` or `print( )` methods in the `CarQueue` class.

### Takeaways

* Think about how subtyping simplifies the maintenance of a list.
* Use the recursive property of a list to reduce the amount of code that one would have to write.
* Also think about whether the recursive definition is actually the best representation of the list. What if we were to use an `ArrayList` instead? Would that be better from a performance perspective?
* Recursion is powerful but sometimes there are performance implications and iteration (`for` loops instead of recursive methods) may be the better implementation choice. 
* Can you think of writing other methods using recursion? For example, how would you perform matrix multiplication using recursion?
* This example also illustrates the use of the `@Before` qualifier with JUnit tests (see `CarQueueTest.java`).