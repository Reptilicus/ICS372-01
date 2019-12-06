package buttons;

import events.OutsideTempSetEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The Outside temp set button is made using an instance of this class
 *
 */
public class OutsideTempSetButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper display
     * 
     * @param string
     *            the text to be put
     */
    public OutsideTempSetButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(OutsideTempSetEvent.instance());
    }
}