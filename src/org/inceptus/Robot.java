/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.inceptus;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import org.inceptus.OI.OI;
import org.inceptus.chassis.Drive;
import org.inceptus.chassis.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    
    //Global drive class
    private Drive drive;
    
    //Global shooter class
    private Shooter shooter;
    
    //Global Operator Interface class
    private OI oi;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
        try {
            
            //Disable the watchdog
            Watchdog.getInstance().setEnabled(false);
            
            //Get the drive class
            drive = new Drive();
            
            //Get the shooter class
            shooter = new Shooter();
            
            //Get the OI class
            oi = new OI();
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * This function is run when the robot is disabled
     */
    public void disabledInit(){
        
        //Stop the drive
        drive.stop();
        
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        try {
            
            //Drive with the latest Joystick values
            oi.driveWithJoy(drive);
            
            //Shoot with the latest Joystick values
            oi.shootWithJoy(shooter);
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
