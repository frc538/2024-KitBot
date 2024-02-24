// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax top;
  private final CANSparkMax bottom;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    top = new CANSparkMax(9, MotorType.kBrushless);
    bottom = new CANSparkMax(4, MotorType.kBrushless);

    top.restoreFactoryDefaults();
    // config
    top.setInverted(true);
    top.setIdleMode(IdleMode.kBrake);
    top.burnFlash();

    bottom.restoreFactoryDefaults();
    bottom.setInverted(true);
    bottom.setIdleMode(IdleMode.kBrake);
    // bottom.follow(top);
    bottom.burnFlash();
  }
  public void shoot() {
    top.set(1);
    bottom.set(1);
  }
  public void intake() {
    top.set(-0.07);
    bottom.set(-0.07);
  }
  public void stop() {
    top.set(0);
    bottom.set(0);
  }
  public void spinup() {
    top.set(1);
    bottom.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
