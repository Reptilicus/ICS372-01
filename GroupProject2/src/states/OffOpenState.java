package states;

import events.*;
import timer.Notifiable;


/**
 * The state where the Fridge is off and the door is open. Whenever the door is open
 * it turns the light on regardless if it is on or off.
 *
 */
public class OffOpenState extends RefrigeratorState implements Notifiable {
    private static OffOpenState instance;

    /**
     * Private constructor for the singleton pattern
     */
    private OffOpenState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static OffOpenState instance() {
        if (instance == null) {
            instance = new OffOpenState();
        }
        return instance;
    }
    
    /**
     * Process on button request, This does nothing as door is already
     * opened
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	System.out.println("This event does not trigger any changes");
    }

    /**
     * Process off button request, This does nothing as refridgerator is already off
     */
    @Override
    public void handleEvent(OffRequestEvent event) {
    	
    }

    /**
     * Process door open request, this does nothing as the refridgerator's door is already open
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
    	System.out.println("This event does not trigger any changes");
    }
    
    /**
     * Process door close request, Changes the state to OffState
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
    	 RefrigeratorContext.instance().changeState(OffState.instance());
    }

    /**
     * Process clock tick event, This does nothing refridgerator is off
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	System.out.println("This event does not trigger any changes");

    }
    
    /**
     * process the 3 degreess above event, This does nothing as the refridgerator is off
     */
    @Override 
    public void handleEvent(Temp3AboveEvent event) {
    	
    }
    
    /**
     * process the 3 degrees below event, This does nothing as the refridgerator is off
     */
    @Override
    public void handleEvent(Temp3BelowEvent event) {
    	
    }

    /**
     * Initializes the state Adds itself as a listener to managers Updates the
     * displays. In this state the refridgerator is not cooling, the door is open, the light
     * is on and the power is off. 
     * 
     */
    @Override
    public void enter() {
    	
    	//update the GUI with correct values
        RefrigeratorContext.instance().showNotCooling();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showLightOn();
        RefrigeratorContext.instance().showPowerOff();
    }
    
    /**
     * Handles any clean up needed for this state, This method may not be needed in our implementation
     * may look into deleting, as none of the states need to do any cleanup.
     * 
     * THIS METHOD MAY NEED TO BE DELETED AS IT APPEARS TO DO NOTHING
     */
    @Override
    public void leave() {
    }

}