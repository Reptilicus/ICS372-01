package states;

import events.*;

/**
 * Super class for all the states, All states need to be able
 * to handle these events in there own way. Either an event triggers
 * a change of state or does nothing at all. Events are denoted with the 
 * state diagram arrows in our diagram. 
 *
 */
public abstract class RefrigeratorState {

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state, this method may not be nessesary
     * looking into mabye deleting method as state transitions do not need cleanup
     * 
     */
    public abstract void leave();

    /**
     * Specifies the actions to be taken when the On button is pressed. 
     */
    public void handleEvent(OnRequestEvent event) {

    }

    /**
     * Specifies the actions to be taken when the Off button is pressed.
     * @param event an event object of type OffRequestEvent
     */
    public void handleEvent(OffRequestEvent event) {

    }
    /**
     * Process door open request
     * @param event an event object of type DoorOpenEvent
     */
    public void handleEvent(DoorOpenEvent event) {

    }

    /**
     * Process door close request
     * @param event an event object of type DoorCloseEvent
     */
    public void handleEvent(DoorCloseEvent event) {

    }

    /**
     * Process clock tick Generates the timer runs out event
     * @param event an event object of TimerTickerEvent
     */
    public void handleEvent(TimerTickedEvent event) {

    }
    
    /**
     * Process the event where the refigerator 
     * @param event an event object of type Temp3AboveEvent
     */
    public void handleEvent(Temp3AboveEvent event) {

    }
    
    /**
     * Process the event where the refigerator 
     * @param event an event object of type Temp3BelowEvent
     */
    public void handleEvent(Temp3BelowEvent event) {

    }

}