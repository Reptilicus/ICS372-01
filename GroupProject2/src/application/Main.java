package application;

import display.GUIDisplay;
import display.RefrigeratorDisplay;
import javafx.application.Application;
import states.RefrigeratorContext;
import timer.Clock;

/**
 * moving our Main to the application folder
 * @author armando
 *
 */
public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, null);
            }
        }.start();
        try {
            while (GUIDisplay.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        RefrigeratorDisplay display = GUIDisplay.getInstance();
        RefrigeratorContext.instance().setDisplay(display);
    } 
} //enter a change here then save
