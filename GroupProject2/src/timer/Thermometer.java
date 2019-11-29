package timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import events.TimerTickedEvent;

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
 * The timer allows a certain time period to be set when created. It sends
 * signals back to its creator every second and a timer runs out message when
 * the time period has elapsed.
 *
 * @author Brahma Dathan
 *
 */
public class Thermometer {
    private int fridgeTemp;
    private int outsideTemp;

    /**
     * Sets up the timer for a certain client with an initial time value
     *
     * @param client
     *            the client, a Notifiable object
     * @param timeValue
     *            the initial time value after which the timer runs out of time.
     */
    public Thermometer( int fridgeTemp, int outsideTemp) {
        this.fridgeTemp = fridgeTemp;       
        this.outsideTemp = outsideTemp;
    }


    /**
     * Returns the temp in the fridge
     *
     * @return the temp
     */
    public int getFridgeTemp() {
        return fridgeTemp;
    }

    /**
     * Returns the temp outside the fridge
     *
     * @return the temp
     */
    public int getOutsideTemp() {
    	return outsideTemp;
    }
    
    /**
     * raise the temp in the fridge by 1 degree
     */
    public void incrementFridgeTemp() {
    	fridgeTemp++;
    }
    
    /**
     * decrease the temp in the fridge by 1 degree
     */
    public void decrementFridgeTemp() {
    	fridgeTemp--;
    }
}