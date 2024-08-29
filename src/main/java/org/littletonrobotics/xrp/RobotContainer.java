// Copyright (c) 2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by an MIT-style
// license that can be found in the LICENSE file at
// the root directory of this project.

package org.littletonrobotics.xrp;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import org.littletonrobotics.xrp.subsystems.drive.Drive;
import org.littletonrobotics.xrp.subsystems.drive.DriveIO;
import org.littletonrobotics.xrp.subsystems.drive.DriveIOXRP;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private Drive drive;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Create subsystems and IO implementations based on the current robot.
    if (!Constants.isReplay) {
      switch (Constants.robotType) {
        case XRP:
          // XRP robot, instantiate XRP IO implementations
          drive = new Drive(new DriveIOXRP());
          break;

        case SIMBOT:
          // Simulated robot, instantiate sim IO implementations
          // ...
          break;

        case REALBOT:
          // Real robot, instantiate hardware IO implementations
          // ...
          break;
      }
    }

    // Create any subsystems that were missed in the above section
    if (drive == null) {
      drive = new Drive(new DriveIO() {});
    }

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}
