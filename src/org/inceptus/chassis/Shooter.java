package org.inceptus.chassis;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author innoying
 */
public class Shooter {
    
    private CANJaguar firstShootingMotor;
    private CANJaguar secondShootingMotor;
    private CANJaguar loadingStick;
    private DigitalInput frontSwitch;
    private DigitalInput backSwitch;
    
    public Shooter() throws CANTimeoutException{
        
        loadingStick = new CANJaguar(5);
        firstShootingMotor = new CANJaguar(6);
        secondShootingMotor = new CANJaguar(7);
        
        frontSwitch = new DigitalInput(1);
        backSwitch = new DigitalInput(1);
        
    }
    
    public void shoot() throws CANTimeoutException{
       
        firstShootingMotor.setX(0.7);
        secondShootingMotor.setX(0.7);     
        
    }
    
    public void stop() throws CANTimeoutException{
       
        firstShootingMotor.setX(0);
        secondShootingMotor.setX(0);     
        
    }
    
    public void load() throws CANTimeoutException{
        
        if (frontSwitch.get()) {
            loadingStick.setX(0);
        } else {
            loadingStick.setX(.8);
        }
        
    }
    
    public void reload() throws CANTimeoutException{
        
        if (backSwitch.get()) {
            loadingStick.setX(0);
        } else {
            loadingStick.setX(-.8);
        }
        
    }
    
}
