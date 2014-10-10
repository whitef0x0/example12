/**
 * 
 * A class to maintain a queue of cars that need to be washed
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
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