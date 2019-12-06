package states;

import events.*;
import timer.Notifiable;
import timer.Timer;

/**
 * The State where the fridge is on and not cooling.
 * The fridge temp approaches the outside temp by one degree per second in this state
 * 
 */
public class OnNotCoolingState extends RefrigeratorState implements Notifiable {
    private static OnNotCoolingState instance;
    private Timer timer;
    
    /**
     * Private for the singleton pattern
     */
    private OnNotCoolingState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static OnNotCoolingState instance() {
        if (instance == null) {
            instance = new OnNotCoolingState();
        }
        return instance;
    }

    /**
     * Process On button request, Does nothing as the refridgerator is already on
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	
    }
    
    /**
     * Process Off button request, changes thes state to OffState
     */
    @Override
    public void handleEvent(OffRequestEvent event) {
    	RefrigeratorContext.instance().changeState(OffState.instance());
    }

    /**
     * Process door open request, changes the state to OnNotCoolingOpenState
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(OnNotCoolingOpenState.instance());
    }
    
    /**
     * Process door close request, does nothing as the door is already closed
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
    	
    }
    
    /**
     * Process the temp3 above event
     */
    public void handleEvent(Temp3AboveEvent event) {
    	RefrigeratorContext.instance().changeState(OnCoolingState.instance());
    }
    
    /**
     * process the temp3 below event
     */
    public void handleEvent(Temp3BelowEvent event) {
    	
    }
    /**
     * Process clock tick event, while the refridgerator is not on the temp will increase
     * by 1 degree every second.
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	
    	//increase the fridge temp by 1 degree every second
    	if (RefrigeratorContext.instance().getOutsideTemp() > RefrigeratorContext.instance().getFridgeTemp()){
	    	RefrigeratorContext.instance().incrementFridgeTemp();
    	}
    	if (RefrigeratorContext.instance().getOutsideTemp() < RefrigeratorContext.instance().getFridgeTemp()) {
    		RefrigeratorContext.instance().decrementFridgeTemp();
    	}
    }

    /**
     * Initializes the state Adds itself as a listener to managers Updates the
     * displays
     * 
     */
    @Override
    public void enter() {
    	timer = new Timer(this, 0);
        RefrigeratorContext.instance().showNotCooling();
        RefrigeratorContext.instance().showPowerOn();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showLightOff();
        RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
    	RefrigeratorContext.instance().showOutsideTemp(RefrigeratorContext.instance().getOutsideTemp());
    }

    @Override
    public void leave() {
    	timer.stop();
    	timer = null;
    }
}
