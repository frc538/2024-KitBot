// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final CANSparkMax frontLeft;
  private final CANSparkMax frontRight;
  private final CANSparkMax rearLeft;
  private final CANSparkMax rearRight;
  private final MecanumDrive mDrive;
  private final Pigeon2 mGyro;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    frontLeft = new CANSparkMax(8, MotorType.kBrushless);
    frontRight = new CANSparkMax(1, MotorType.kBrushless);
    rearLeft = new CANSparkMax(5, MotorType.kBrushless);
    rearRight = new CANSparkMax(2, MotorType.kBrushless);
    mGyro = new Pigeon2(1);

    mGyro.reset();

    frontLeft.restoreFactoryDefaults();
    // config
    frontLeft.setInverted(false);
    frontLeft.setIdleMode(IdleMode.kBrake);
    frontLeft.burnFlash();

    frontRight.restoreFactoryDefaults();
    // config
    frontRight.setInverted(true);
    frontRight.setIdleMode(IdleMode.kBrake);
    frontRight.burnFlash();

    rearLeft.restoreFactoryDefaults();
    rearLeft.setInverted(false);
    rearLeft.setIdleMode(IdleMode.kBrake);
    rearLeft.burnFlash();

    rearRight.restoreFactoryDefaults();
    rearRight.setInverted(true);
    rearRight.setIdleMode(IdleMode.kBrake);
    rearRight.burnFlash();

    mDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Yaw", mGyro.getYaw().getValueAsDouble());
    SmartDashboard.putNumber("Pitch", mGyro.getPitch().getValueAsDouble());
    SmartDashboard.putNumber("Roll", mGyro.getRoll().getValueAsDouble());

    // This method will be called once per scheduler run
  }
  public void drive(double forward, double left, double ccw) {
  mDrive.driveCartesian(forward, left, ccw);
  }
}
