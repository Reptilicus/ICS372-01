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
 * The state where the Fridge is on, the cooler is on, and the door is open.
 * fridge does not cool as efficiently in this state.
 *
 */
public class OnCoolingOpenState extends RefrigeratorState implements Notifiable {
    private static OnCoolingOpenState instance;
    private Timer timer;
    /**
     * Private for the singleton pattern
     */
    private OnCoolingOpenState() {
    	
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static OnCoolingOpenState instance() {
        if (instance == null) {
            instance = new OnCoolingOpenState();
        }
        return instance;
    }

    /**
     * Process On Button request
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	
    }
    
    /**
     * Process Off Button request
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
    	RefrigeratorContext.instance().changeState(OnCoolingState.instance());
    }

    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
    	if(RefrigeratorContext.instance().getFridgeTemp() > RefrigeratorContext.instance().getDesiredTemp()) {
        	RefrigeratorContext.instance().decrementFridgeTemp();
        	if(timer.getTimeValue() % 3 == 0) {
        		RefrigeratorContext.instance().incrementFridgeTemp();
        	}
            RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
        } else {
        	RefrigeratorContext.instance().changeState(OnNotCoolingOpenState.instance());
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
    	RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showCooling();
        RefrigeratorContext.instance().showLightOn();
    }

    @Override
    public void leave() {
    	timer.stop();
    	timer = null;
    }
}