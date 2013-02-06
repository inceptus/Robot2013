package org.inceptus.OI;

import edu.wpi.first.wpilibj.Joystick;
import org.inceptus.chassis.Drive;

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
    
    public boolean driveWithJoy(Drive drive){
        
        //Drive
        drive.driveWithValues(
                mainJoy.getScaledX(), 
                mainJoy.getScaledY(), 
                mainJoy.getScaledTwist()
        );
        
        //Return Success
        return true;
        
    }

}
