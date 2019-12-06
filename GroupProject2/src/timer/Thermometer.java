package timer;

/**
 * The timer allows a certain time period to be set when created. It sends
 * signals back to its creator every second and a timer runs out message when
 * the time period has elapsed.
 *
 * @author Brahma Dathan
 *
 */
public class Thermometer {
	private int desiredTemp;
    private int fridgeTemp;
    private int outsideTemp;

    /**
     * Sets up the timer for a certain client with an initial time value
     *
     * @param client
     *            the client, a Notifiable object
     * @param timeValue
     *            the initial time value after which the timer runs out of time.
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
    	fridgeTemp++;
    }
    
    /**
     * decrease the temp in the fridge by 1 degree
     */
    public void decrementFridgeTemp() {
    	fridgeTemp--;
    }
}