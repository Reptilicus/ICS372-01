package states;

import events.OnRequestEvent;
import events.OffRequestEvent;
import events.DoorOpenEvent;
import events.DoorCloseEvent;
import events.TimerTickedEvent;
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
 * The State where the fridge is not cooling and the door is open.
 * The fridge temp appoaches the outside temp by two degrees per second in this state
 * 
 */
public class OnNotCoolingOpenState extends RefrigeratorState implements Notifiable {
    private static OnNotCoolingOpenState instance;
    private Timer timer;
    
    /**
     * Private for the singleton pattern
     */
    private OnNotCoolingOpenState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static OnNotCoolingOpenState instance() {
        if (instance == null) {
            instance = new OnNotCoolingOpenState();
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
    	RefrigeratorContext.instance().changeState(OffOpenState.instance());
    }

    /**
     * Process door open request
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        
    }
    
    /**
     * Process door close request
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
    	RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
    }

    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	if(RefrigeratorContext.instance().getFridgeTemp() > RefrigeratorContext.instance().getDesiredTemp() + 3) {
        	RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
        }
    	else {
    			if(RefrigeratorContext.instance().getOutsideTemp() < RefrigeratorContext.instance().getDesiredTemp()) {
    				RefrigeratorContext.instance().decrementFridgeTemp();
    				RefrigeratorContext.instance().decrementFridgeTemp();
    				RefrigeratorContext.instance().decrementFridgeTemp();
    			}
            	RefrigeratorContext.instance().incrementFridgeTemp();
            	RefrigeratorContext.instance().incrementFridgeTemp();
                RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
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
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showLightOn();
        RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
    	RefrigeratorContext.instance().showOutsideTemp(RefrigeratorContext.instance().getOutsideTemp());
    }

    @Override
    public void leave() {
    	timer.stop();
    	timer = null;
    }

}
