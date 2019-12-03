package states;

import events.*;
import timer.Notifiable;
import timer.Timer;


/**
 * The state where the fridge is on and cooling. This is the state that it is in 
 * when the refrigerator is first turned on (the on button is pressed) 
 *
 */
public class OnCoolingState extends RefrigeratorState implements Notifiable {
    private static OnCoolingState instance;
    
    //is this nessasary????? COME BACK TO THE CODE AND DECIDE IF THIS IS NESSESARY
    private Timer timer;
    
    /**
     * Private for the singleton pattern
     */
    private OnCoolingState() {
    	
    }

    /**
     * For singleton, retrives the only instance of this object
     * 
     * @return the object
     */
    public static OnCoolingState instance() {
        if (instance == null) {
            instance = new OnCoolingState();
        }
        return instance;
    }

    /**
     * Process On button request, Does nothing refrigerator is already on
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	System.out.println("This event does not trigger any changes");
    }
    
    /**
     * Process Off button request, Changes the state to Offstate
     */
    @Override
    public void handleEvent(OffRequestEvent event) {
    	RefrigeratorContext.instance().changeState(OffState.instance());
    }

    /**
     * Process door open request, Changes state to onCoolingOpenState
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
    }
    
    /**
     * Process door close request, Does nothing door is already closed
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
    	System.out.println("This event does not trigger any changes");
    }

    /**
     * Process clock tick event, decreases the temp by 3 degress each second,
     * this is the "normal" cooling for the refridgerator
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	
    	//decrement the temp by 3 degrees every second
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	
        
    }
    
    /**
     * process the 3 degreess above event, does nothing as it is cooling
     */
    @Override 
    public void handleEvent(Temp3AboveEvent event) {
    	
    }
    
    /**
     * process the 3 degrees below event, changes the state to OnNotCooling
     */
    @Override
    public void handleEvent(Temp3BelowEvent event) {
    	RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
    }
    
    

    /**
     * Initializes the state by updating the GUI with the proper values, In this state the refrigerator
     * is cooling, the power is on, the door is closed, Along with the light being off.
     * 
     */
    @Override
    public void enter() {
    	
    	//update the GUI and create a new Timer object
    	timer = new Timer(this, 0);
        RefrigeratorContext.instance().showCooling();
        RefrigeratorContext.instance().showPowerOn();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showLightOff();
        RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
    	RefrigeratorContext.instance().showOutsideTemp(RefrigeratorContext.instance().getOutsideTemp());
    }

    @Override
    public void leave() {
    	
    	//THIS BLOCK MAY NOT BE NESSASARY LOOK AT THE POTENTIAL TO REMOVE.
    	timer.stop();
    	timer = null;
    }

}