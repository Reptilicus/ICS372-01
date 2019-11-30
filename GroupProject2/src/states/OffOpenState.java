package states;

import events.OnRequestEvent;
import events.Temp3AboveEvent;
import events.Temp3BelowEvent;
import events.OffRequestEvent;
import events.DoorOpenEvent;
import events.DoorCloseEvent;
import events.TimerTickedEvent;
import timer.Notifiable;

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
 * The state where the Fridge is off and the door is open(so the light will be on).
 *
 */
public class OffOpenState extends RefrigeratorState implements Notifiable {
    private static OffOpenState instance;

    /**
     * Private for the singleton pattern
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
     * Process on button request
     */
    @Override
    public void handleEvent(OnRequestEvent event) {
    	
    }

    /**
     * Process off button request
     */
    @Override
    public void handleEvent(OffRequestEvent event) {
    	
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
    	 RefrigeratorContext.instance().changeState(OffState.instance());
    }

    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {

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
    	
    }

    /**
     * Initializes the state Adds itself as a listener to managers Updates the
     * displays
     * 
     */
    @Override
    public void enter() {
        RefrigeratorContext.instance().showNotCooling();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showLightOn();
        RefrigeratorContext.instance().showPowerOff();
    }
    
    

    @Override
    public void leave() {
    }

}