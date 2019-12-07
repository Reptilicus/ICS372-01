package timer;

/**
 * The thermometer class stores the different temperatures that are relevant to
 * the refrigerator's operation
 */
public class Thermometer {
	private int desiredTemp;
	private int fridgeTemp;
	private int outsideTemp;

	/**
	 * Sets up the timer for a certain client with an initial time value
	 *
	 * @param client    the client, a Notifiable object
	 * @param timeValue the initial time value after which the timer runs out of
	 *                  time.
	 */
	public Thermometer(int desiredTemp, int fridgeTemp, int outsideTemp) {
		this.desiredTemp = desiredTemp;
		this.fridgeTemp = fridgeTemp;
		this.outsideTemp = outsideTemp;
	}

	/**
	 * Returns the fridge's target temp
	 *
	 * @return the temp
	 */
	public int getdesiredTemp() {
		return desiredTemp;
	}

	/**
	 * Returns the temp in the fridge
	 *
	 * @return the temp
	 */
	public int getFridgeTemp() {
		return fridgeTemp;
	}

	/**
	 * Returns the temp outside the fridge
	 *
	 * @return the temp
	 */
	public int getOutsideTemp() {
		return outsideTemp;
	}

	/**
	 * Set the fridge's target temp
	 * 
	 */
	public void setDesiredTemp(int temp) {
		desiredTemp = temp;
	}

	/**
	 * Set the frige temp
	 */
	public void setFridgeTemp(int temp) {
		fridgeTemp = temp;
	}

	/**
	 * Set the outside temp
	 */
	public void setOutsideTemp(int temp) {
		outsideTemp = temp;
	}

	/**
	 * 
	 * raise the temp in the fridge by 1 degree
	 */
	public void incrementFridgeTemp() {
		incrementFridgeTemp(1);
	}

	/**
	 * decrease the temp in the fridge by 1 degree
	 */
	public void decrementFridgeTemp() {
		decrementFridgeTemp(1);
	}

	/**
	 * 
	 * raise the temp in the fridge by 1 degree
	 */
	public void incrementFridgeTemp(int numberOfDegrees) {
		fridgeTemp += numberOfDegrees;
	}

	/**
	 * decrease the temp in the fridge by 1 degree
	 */
	public void decrementFridgeTemp(int numberOfDegrees) {
		fridgeTemp -= numberOfDegrees;
	}
}