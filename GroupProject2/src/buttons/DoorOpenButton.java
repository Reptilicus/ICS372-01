package buttons;

import events.DoorOpenEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The door open request is made using an instance of this class
 *
 */
public class DoorOpenButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper display
     * 
     * @param string
     *            the text to be put
     */
    public DoorOpenButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorOpenEvent.instance());
    }
}