// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private final PWMVictorSPX m_frontLeftMotor = new PWMVictorSPX(0);
  private final PWMVictorSPX m_rearLeftMotor = new PWMVictorSPX(1);

  private final PWMVictorSPX m_frontRightMotor = new PWMVictorSPX(2);
  private final PWMVictorSPX m_rearRightMotor = new PWMVictorSPX(3);

  private final MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_rearLeftMotor, m_frontRightMotor, m_rearRightMotor);

  private final XboxController m_xboxController = new XboxController(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    // m_rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.driveCartesian(-m_xboxController.getLeftY(), m_xboxController.getLeftX(), 0);
  }
}
