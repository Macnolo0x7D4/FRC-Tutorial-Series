// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final PWMTalonSRX m_motor = new PWMTalonSRX(Constants.SHOOTER_MOTOR);
  private final Encoder m_encoder = new Encoder(Constants.SHOOTER_ENCODER_1, Constants.SHOOTER_ENCODER_2);
  private final PIDController m_pid = new PIDController(2, 0, 0);

  private boolean state = false;

  /** Creates a new Shooter. */
  public Shooter() {
    m_encoder.setDistancePerPulse(2 * Math.PI / 2048);
  }

  @Override
  public void periodic() {
    if (state) {
      m_motor.set(m_pid.calculate(m_encoder.getDistance()));
    } else {
      m_pid.reset();
      m_motor.set(0);
    }
  }

  public void shoot() {
    state = true;
  }

  public void stop() {
    state = false;
  }
}
