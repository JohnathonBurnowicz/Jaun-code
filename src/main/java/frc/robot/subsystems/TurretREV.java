package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Timer;
import java.util.TimerTask;

public class TurretREV extends CommandBase {
    
    private final PowerTurret shooter;
    private final FeederTurret feeder;
    private final int RPMTarget;
private Timer timer = new Timer();
    public TurretREV(PowerTurret shooter, FeederTurret feeder) {
        this.shooter = shooter;
        this.feeder = feeder;
        this.RPMTarget = 1; // Default RPM target
        addRequirements(shooter);
    }

    public TurretREV(PowerTurret shooter, FeederTurret feeder, int rpmTarget) {
        this.shooter = shooter;
        this.RPMTarget = rpmTarget;
        this.feeder = feeder;
        addRequirements(shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        double rpm;
        
        if (this.RPMTarget == 1) {
            rpm = SmartDashboard.getNumber("Target Shooter RPM", -8000);
        } else {
            rpm = this.RPMTarget;
        }
        shooter.setFlywheelRPM(rpm);
      
     
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            double rpm2 = SmartDashboard.getNumber("Target Shooter RPM", -1000);
            feeder.setFlywheelRPM(rpm2);
        }
    };
    timer.schedule(task, 2000); // 2000 milliseconds = 2 seconds
}
     
      
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Add any necessary cleanup code here
        // This method is called when the command ends or is interrupted
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Add condition for when the command should end
        // This method should return true when the command's execution is complete
       // return shooter.isStable();
        return shooter.isStable();
        
    }
}
