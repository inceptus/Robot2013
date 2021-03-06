package org.inceptus.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import org.inceptus.chassis.Drive;
import org.inceptus.chassis.Shooter;

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
    
    public boolean shootWithJoy(Shooter shooter) throws CANTimeoutException{
        
        //Shooting wheel
        if(otherJoy.getRawButton(1)){
            shooter.shoot();
        }else{
            shooter.stop();
        }
        
        //Hopper
        if(otherJoy.getRawButton(2)){
            shooter.load();
        }else{
            shooter.reload();
        }
        
        //Return Success
        return true;
        
    }

}
