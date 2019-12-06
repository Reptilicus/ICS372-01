package states;

import display.RefrigeratorDisplay;
import events.*;
import timer.Thermometer;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class RefrigeratorContext {
    private RefrigeratorDisplay display;
    private RefrigeratorState currentState;
    private static RefrigeratorContext instance;
    private Thermometer thermometer = new Thermometer(70, 70);
    private int desiredTemp = 30;
    
    /**
     * Make it a singleton
     */
    private RefrigeratorContext() {
        instance = this;
        currentState = OffState.instance();
    }

    /**
     * Return the instance
     * 
     * @return the object
     */
    public static RefrigeratorContext instance() {
        if (instance == null) {
            instance = new RefrigeratorContext();
        }
        return instance;
    }

    /**
     * Our Display is able to change, setter allows to change the display object easily
     * 
     * @param display The current display object
     */
    public void setDisplay(RefrigeratorDisplay display) {
        this.display = display;
    }
    
    /**\
     * setter for the desired temp inside the fridge
     * @param temp number of degrees to be set 
     */
    public void setDesiredTemp(int temp) {
    	this.desiredTemp = temp;
    }
    /**
     * Lets the off(door closed) state be the starting state adds the object as an
     * observable for clock
     */
    public void initialize() {
        instance.changeState(OffState.instance());
    }

    //??may be refactored or deleted
    public int getFridgeTemp() {
    	return thermometer.getFridgeTemp();
    }
    
    ///??may be refactored or deleted
    public int getOutsideTemp() {
    	return thermometer.getOutsideTemp();
    }
    
    ///??may be refactored or deleted
    public int getDesiredTemp() {
    	return desiredTemp;
    }
    
    ///??may be refactored or deleted
    public void decrementFridgeTemp() {
    	thermometer.decrementFridgeTemp();
    	display.showFridgeTemp(getFridgeTemp());
    }
    
    ///??may be refactored or deleted
    public void incrementFridgeTemp() {
    	thermometer.incrementFridgeTemp();
    	display.showFridgeTemp(getFridgeTemp());
    }
    
    /**
     * Changes the state that the refrigerator is in
     * 
     * @param nextStat the state that is to be changed to
     */
    public void changeState(RefrigeratorState nextState) {
        currentState.leave();
        currentState = nextState;
        currentState.enter();
    }

    /**
     * process on button
     */
    public void handleEvent(OnRequestEvent event) {
        currentState.handleEvent(event);
    }
    
    /**
     * process off button
     */
    public void handleEvent(OffRequestEvent event) {
        currentState.handleEvent(event);
    }

    /**
     * Process door open request
     */
    public void handleEvent(DoorOpenEvent event) {
        currentState.handleEvent(event);
    }

    /**
     * Process door close request
     */
    public void handleEvent(DoorCloseEvent event) {
        currentState.handleEvent(event);
    }
    
    /**
     * Process desired temp set event
     */
    public void handleEvent(DesiredTempSetEvent event) {
    	//to do
        //currentState.handleEvent(event);
    }
    
    /**
     * Process outside temp set event
     */
    public void handleEvent(OutsideTempSetEvent event) {
    	//to do
       // currentState.handleEvent(event);
    }
    
    /**
     * process temp below 3 event
     */
    public void handleEvent(Temp3AboveEvent event) {
    	currentState.handleEvent(event);
    }
    
    /**
     * Process temp below 3 event
     */
     public void handleEvent(Temp3BelowEvent event) {
    	 currentState.handleEvent(event);
     }
    
    
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showPowerOn() {
        display.showPowerOn();
    }
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showPowerOff() {
        display.showPowerOff();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     * @param temp
     *            temp inside the fridgeS
     */
    public void showFridgeTemp(int temp) {
        display.showFridgeTemp(temp);
    }
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     * @param temp
     *            temperature outside the fridgeS
     */
    public void showOutsideTemp(int temp) {
        display.showOutsideTemp(temp);
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showLightOn() {
        display.showLightOn();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showLightOff() {
        display.showLightOff();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showCooling() {
        display.showCooling();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showNotCooling() {
        display.showNotCooling();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showDoorOpened() {
        display.showDoorOpened();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showDoorClosed() {
        display.showDoorClosed();
    }
}