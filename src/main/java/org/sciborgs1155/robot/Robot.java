package org.sciborgs1155.robot;
import org.sciborgs1155.lib.CommandRobot;
import org.sciborgs1155.robot.Drive.Drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Robot extends CommandRobot {
  private CommandXboxController controller = new CommandXboxController(1);
  private Drive drive = new Drive();
  public Robot() {
    super(0.02);
  }
  
  private void configureGameBehavior() {
    // Configure CommandScheduler.
    CommandScheduler.getInstance().enable();
    CommandScheduler.getInstance().setPeriod(.02);

    // Silence Annoying Joystick Connection Warnings When Simulating.
    DriverStation.silenceJoystickConnectionWarning(isSimulation());

    // Prevents the RoboRIO from becoming fried.
    RobotController.setBrownoutVoltage(6.0);

    // A trigger to tell whether the robot is enabled or not.
    final Trigger enabled = new Trigger(this::isEnabled);

    // If the robot is enabled, then allow driving.
    enabled.onTrue(
        drive.drive(
            () -> -controller.getLeftY(), () -> controller.getRightY()));
  }

}
