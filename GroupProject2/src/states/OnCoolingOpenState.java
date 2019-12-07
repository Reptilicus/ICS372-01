package states;

import events.DoorCloseEvent;
import events.DoorOpenEvent;
import events.OffRequestEvent;
import events.OnRequestEvent;
import events.Temp3AboveEvent;
import events.Temp3BelowEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

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
	 * Process On Button request, this does not do anything
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {

	}

	/**
	 * Process Off Button request, changes the state to the offOpenState. (Turns the
	 * refrigerator off)
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
		RefrigeratorContext.instance().changeState(OffOpenState.instance());
	}

	/**
	 * Process door open request, this does nothing as the door is alreay open
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {

	}

	/**
	 * Process door close request, changes the state to onCoolingState (with the
	 * door closed)
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

		// decrement the fridge temp value since the door is open
		RefrigeratorContext.instance().decrementFridgeTemp(3 + RefrigeratorContext.instance().environmentEffect(2));
	}

	/**
	 * process the 3 degreess above event, this does nothing as the refridgerator is
	 * cooling in this state.
	 */
	@Override
	public void handleEvent(Temp3AboveEvent event) {
	}

	/**
	 * process the 3 degrees below event, changes the state to OnNotCoolingOpenState
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {
		RefrigeratorContext.instance().changeState(OnNotCoolingOpenState.instance());

	}

	/**
	 * Initializes the state, in this state the door is opened, the light is on, and
	 * the device is cooling
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

		// THIS MAY BE UNNESSARY AND WE MIGHT NEED TO LOOK INTO DELETING
		timer.stop();
		timer = null;
	}
}