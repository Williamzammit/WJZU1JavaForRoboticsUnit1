// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static final int motor1id=61;
  private static final int motor2id=62;

  private CANSparkMax motor1 = new CANSparkMax(motor1id, MotorType.kBrushless);
  private CANSparkMax motor2 = new CANSparkMax(motor2id, MotorType.kBrushless);
  private double speed;
  private double voltage;
  public Shooter() {

    REVPhysicsSim.getInstance().addSparkMax(motor1, DCMotor.getNeo550(1));
    REVPhysicsSim.getInstance().addSparkMax(motor2, DCMotor.getNeo550(1));
    speed = 0.0;
    voltage = 0.0;

    motor2.setInverted(true);

    //Shooter.setInverted(motor2, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    motor1.set(speed);
    motor2.set(speed);
    System.out.println(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    motor1.setVoltage(voltage);
    motor2.setVoltage(voltage);
  }

  public void setJoystickSpeed(double throttle){
    speed = throttle;
    voltage = speed*12;
    System.out.println(throttle);
  }

  public void setMotorSpeed() {
    speed = 0.5;
    voltage = speed*12;
  }

  public void stopMotor() {
    speed = 0.0;
    speed = 0.0;
    voltage = speed;
  }
}