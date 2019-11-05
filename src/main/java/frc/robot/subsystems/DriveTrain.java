/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
  private TalonSRX rightMotor1;
  private VictorSPX rightMotor2;
  private TalonSRX leftMotor1;
  private VictorSPX leftMotor2;

  private double leftSpeed;
  private double rightSpeed;

  public DriveTrain(){
    rightMotor1 = new TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
    rightMotor2 = new VictorSPX(RobotMap.MOTOR_RIGHT_2_ID);
    leftMotor1 = new TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
    leftMotor2 = new VictorSPX(RobotMap.MOTOR_LEFT_2_ID);
  }

  public void tankDrive(double left, double right){

    if(left > 1){
      left = 1;
    } else if(left < -1){
      left = -1;
    } else {
      // these are valid inputs. do we want to change them?
      if(left < 0){
        left = -left*left;
      }else {
        left = left*left;
      }
    }
    if(right > 1){
      right = 1;
    } else if(right < -1){
      right = -1;
    } else {
      // these are valid inputs. do we want to change them?
      if(right < 0){
        right = -right*right;
      }else {
        right = right*right;
      }
    }

    leftSpeed = left;
    rightSpeed = right;

    rightMotor1.set(ControlMode.PercentOutput, rightSpeed);
    rightMotor2.set(ControlMode.PercentOutput, rightSpeed);
    leftMotor1.set(ControlMode.PercentOutput, leftSpeed);
    leftMotor2.set(ControlMode.PercentOutput, leftSpeed);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
