package org.inceptus.chassis;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author innoying
 */
public class Shooter {
    
    private CANJaguar firstShootingMotor;
    private CANJaguar secondShootingMotor;
    private CANJaguar loadingStick;
    private CANJaguar angleMotor;
    private DigitalInput frontSwitch;
    private DigitalInput backSwitch;
    private DigitalInput topSwitch;
    private DigitalInput bottomSwitch;
    private NetworkTable table;

    
    public Shooter() throws CANTimeoutException{
        
        loadingStick = new CANJaguar(5);
        //http://www.chiefdelphi.com/forums/showthread.php?t=101737
        //Configuring firstShootMotor in order to control speed with encoder
        firstShootingMotor = new CANJaguar(6, CANJaguar.ControlMode.kSpeed);
        firstShootingMotor.configEncoderCodesPerRev(256);
        firstShootingMotor.enableControl();
        firstShootingMotor.changeControlMode(CANJaguar.ControlMode.kVoltage);
        firstShootingMotor.enableControl();
       
        //Configuring secondShootMotor in order to control speed with encoder
        secondShootingMotor = new CANJaguar(7, CANJaguar.ControlMode.kSpeed);
        secondShootingMotor.configEncoderCodesPerRev(256);
        secondShootingMotor.enableControl();
        secondShootingMotor.changeControlMode(CANJaguar.ControlMode.kVoltage);
        secondShootingMotor.enableControl();
        
        angleMotor = new CANJaguar(8);
     
        frontSwitch = new DigitalInput(1);
        backSwitch = new DigitalInput(1);
       
        
        table = NetworkTable.getTable("shooter");
        
        table.putNumber("firstSpeed", 0);
        table.putNumber("angle", 0);
        
    }
        
    // Shoots the frisbee once it is angled and loaded
    public void shoot() throws CANTimeoutException{
        
        firstShootingMotor.setX(0.7);
        secondShootingMotor.setX(0.7);     
        
    }
    
    // Stops all motors once frisbee is thrown
    public void stop() throws CANTimeoutException{
       
        angleMotor.setX(0);
        firstShootingMotor.setX(0);
        secondShootingMotor.setX(0);
                
    }
    
    // Loads the frisbee into the shooter
    public void load() throws CANTimeoutException{
        
        if (frontSwitch.get()) {
            loadingStick.setX(0);
        } else {
            loadingStick.setX(.8);
        }
        
    }
    
    // Resets position in order to reload frisbee later
    public void reload() throws CANTimeoutException{
        
        if (backSwitch.get()) {
            loadingStick.setX(0);
        } else {
            loadingStick.setX(-.8);
        }
       
    }
    
    //
    public double getSpeed(int motorNumber) throws CANTimeoutException {
        
        double speed = -1;
             
        if(motorNumber == 1){
            
        speed = firstShootingMotor.getSpeed();
        table.putNumber("firstSpeed", speed);           
        }
        
        if(motorNumber == 2){
        speed = secondShootingMotor.getSpeed();
        table.putNumber("secondSpeed", speed);     
        }
        
        return speed;
               
    }
    
    public void setSpeed(double rpm) throws CANTimeoutException {
         
        //Right now, we're using voltage control mode 
        // guess voltage to rpm relationship
        double voltage = rpm / 0;

        //Check to see if 'rpm' works
        if ((firstShootingMotor.getControlMode() == CANJaguar.ControlMode.kVoltage)
                && (secondShootingMotor.getControlMode() == CANJaguar.ControlMode.kVoltage)) {
            firstShootingMotor.setX(voltage);
        } else {
            firstShootingMotor.setX(rpm);

            secondShootingMotor.setX(rpm);

        }

    }
    
}
