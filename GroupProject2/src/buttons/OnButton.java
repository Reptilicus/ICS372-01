package buttons;

import events.OnRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The on button
 * 
 * @author Brahma Dathan
 * 
 *
 */
public class OnButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The on button
     * 
     * @param string
     */
    public OnButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(OnRequestEvent.instance());
    }
}