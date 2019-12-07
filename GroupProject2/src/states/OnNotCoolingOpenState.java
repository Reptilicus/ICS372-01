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
 * The State where the fridge is not cooling and the door is open. The fridge
 * temp appoaches the outside temp by two degrees per second in this state
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
	 * Process On button request, This does nothing because the refridgerator is
	 * already on
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {

	}

	/**
	 * Process Off button request, changes the state to OffOpenState
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
		RefrigeratorContext.instance().changeState(OffOpenState.instance());
	}

	/**
	 * Process door open request, the door is already open this does nothing
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {

	}

	/**
	 * Process door close request, changes the state to OnNotCoolingState
	 */
	@Override
	public void handleEvent(DoorCloseEvent event) {
		RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
	}

	/**
	 * Process the temp3 above event
	 */
	@Override
	public void handleEvent(Temp3AboveEvent event) {
		RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
	}

	/**
	 * process the temp3 below event
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {

	}

	/**
	 * Process clock tick event, because the refridgerator's door is open and it is
	 * not cooling this means that the fridge temp will rise faster every second, in
	 * our case we are increasing the fridge temp every second
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {

		// increase the fridgetemp by 3 degrees every second.
		if (RefrigeratorContext.instance().getOutsideTemp() > RefrigeratorContext.instance().getFridgeTemp()) {
			RefrigeratorContext.instance().incrementFridgeTemp(3);
		}
		if (RefrigeratorContext.instance().getOutsideTemp() < RefrigeratorContext.instance().getFridgeTemp()) {
			RefrigeratorContext.instance().decrementFridgeTemp(2);
		}
	}

	/**
	 * Initializes the state, displays the GUI with the proper values, In this state
	 * the refrigerator is not cooling the power is on, the door is opened and the
	 * light is on
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

		// CHECK TO SEE IF THIS IS EVEN NESSASARY, MAY NEED TO DELETE IF ITS UNUSED CODE
		// TO AVOID LOSING POINTS
		timer.stop();
		timer = null;
	}

}
