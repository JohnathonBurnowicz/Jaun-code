// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.PowerTurret;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class TurretINTAKE extends CommandBase {

  private final PowerTurret shooter;
  private final FeederTurret feeder;
  private final double RPMTarget;


  public TurretINTAKE(PowerTurret shooter, FeederTurret feeder){
    this.shooter = shooter;
    this.feeder = feeder;
    this.RPMTarget =0.25;
    
    addRequirements(shooter, feeder);

}
public TurretINTAKE(PowerTurret shooter, FeederTurret feeder, int rpmTarget){
  this.shooter = shooter;
  this.RPMTarget = rpmTarget;
  this.feeder = feeder;
  
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    double rpm;
    if(this.RPMTarget == 0.25){
    rpm = SmartDashboard.getNumber("Target Shooter RPM",1500);
    }else{
      rpm = this.RPMTarget;
    }
      shooter.setFlywheelRPM(rpm);
      feeder.setFlywheelRPM(rpm);
  }
      

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return shooter.isStable();
  }
}