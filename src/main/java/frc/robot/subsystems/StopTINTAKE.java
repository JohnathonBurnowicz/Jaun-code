// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

public class StopTINTAKE extends Command {
  PowerTurret shooter;
  FeederTurret feeder;
  /** Creates a new StopShooter. */
  public StopTINTAKE(PowerTurret shooter, FeederTurret feeder) {
    this.shooter = shooter;
    this.feeder = feeder;
    addRequirements(shooter, feeder);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.shooter.stopMotors();
     this.feeder.stopMotors();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}