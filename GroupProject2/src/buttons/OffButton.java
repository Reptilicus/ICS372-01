package buttons;

import events.OffRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The button to turn the fridge off
 *
 */
public class OffButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The off button
     * 
     * @param string
     */
    public OffButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(OffRequestEvent.instance());
    }
}