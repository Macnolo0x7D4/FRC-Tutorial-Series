// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private final PWMTalonSRX m_frontLeftMotor = new PWMTalonSRX(Constants.FL_MOTOR);
  private final PWMTalonSRX m_frontRightMotor = new PWMTalonSRX(Constants.FR_MOTOR);

  private final PWMTalonSRX m_rearLeftMotor = new PWMTalonSRX(Constants.RL_MOTOR);
  private final PWMTalonSRX m_rearRightMotor = new PWMTalonSRX(Constants.RR_MOTOR);

  private final MotorControllerGroup m_leftMotor = new MotorControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
  private final MotorControllerGroup m_rightMotor = new MotorControllerGroup(m_frontRightMotor, m_rearRightMotor);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  /** Creates a new Drivetrain. */
  public Drivetrain() { }

  @Override
  public void periodic() { }

  public void drive(double speed, double rot) {
    m_drive.arcadeDrive(speed, rot);
  }
}
