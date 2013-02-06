package org.inceptus.chassis;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author innoying
 */
public class Drive {
    
    //Motors
    private CANJaguar leftFront;
    private CANJaguar rightFront;
    private CANJaguar leftRear;
    private CANJaguar rightRear;
    
    //Drive
    private RobotDrive robotDrive;
    
    //Initilize
    public Drive(){
        
        try {
            
            //Setup the drive motors
            leftFront = new CANJaguar(1);
            rightFront = new CANJaguar(2);
            leftRear = new CANJaguar(3);
            rightRear = new CANJaguar(4);

            //Setup the Drive
            robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }

    public void driveWithValues(double x, double y, double rotation){

        //Drive using values
        robotDrive.mecanumDrive_Cartesian(-x, -y, -rotation, 0);
            
    }
    
    public void stop(){
        
        //Stop the motors
        robotDrive.stopMotor();
    }
    
}
