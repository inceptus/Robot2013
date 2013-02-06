package org.inceptus.OI;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author innoying
 */
public class OI {
    
    //Joysticks
    private InJoystick mainJoy;
    private Joystick otherJoy;
    
    public OI(){
        
        //Init the joysticks
        mainJoy = new InJoystick(1);
        otherJoy = new Joystick(2);
        
    }

}
