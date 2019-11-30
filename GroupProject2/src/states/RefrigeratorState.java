package states;

import events.*;


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
 * Super class for all states
 * 
 *
 */
public abstract class RefrigeratorState {

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
    public abstract void leave();

    /**
     * Specifies the actions to be taken when the On button is pressed.
     */
    public void handleEvent(OnRequestEvent event) {

    }

    /**
     * Specifies the actions to be taken when the Off button is pressed.
     */
    public void handleEvent(OffRequestEvent event) {

    }
    /**
     * Process door open request
     */
    public void handleEvent(DoorOpenEvent event) {

    }

    /**
     * Process door close request
     */
    public void handleEvent(DoorCloseEvent event) {

    }

    /**
     * Process clock tick Generates the timer runs out event
     */
    public void handleEvent(TimerTickedEvent event) {

    }
    
    /**
     * Process the event where the refigerator 
     */
    public void handleEvent(Temp3AboveEvent event) {

    }
    
    /**
     * Process the event where the refigerator 
     */
    public void handleEvent(Temp3BelowEvent event) {

    }

}