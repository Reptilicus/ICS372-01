package states;

import events.*;
import timer.Notifiable;
import timer.Timer;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * The state where the fridge is on and cooling. THis is the state that it is in 
 * when the refrigerator is first turned on
 *
 */
public class OnCoolingState extends RefrigeratorState implements Notifiable {
    private static OnCoolingState instance;
    private Timer timer;
    
    /**
     * Private for the singleton pattern
     */
    private OnCoolingState() {
    	
    }

    /**
     * For singleton
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
     * Process On button request
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	
    }
    
    /**
     * Process Off button request
     */
    @Override
    public void handleEvent(OffRequestEvent event) {
    	RefrigeratorContext.instance().changeState(OffState.instance());
    }

    /**
     * Process door open request
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
    }
    
    /**
     * Process door close request
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
    	
    }

    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	
    	//decrement the temp by 3 degrees every second
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	RefrigeratorContext.instance().decrementFridgeTemp();
    	
        
    }
    
    /**
     * process the 3 degreess above event
     */
    @Override 
    public void handleEvent(Temp3AboveEvent event) {
    	
    }
    
    /**
     * process the 3 degrees below event
     */
    @Override
    public void handleEvent(Temp3BelowEvent event) {
    	RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
    }
    
    

    /**
     * Initializes the state Adds itself as a listener to managers Updates the
     * displays
     * 
     */
    @Override
    public void enter() {
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
    	timer.stop();
    	timer = null;
    }

}