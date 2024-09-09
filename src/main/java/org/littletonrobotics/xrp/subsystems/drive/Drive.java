// Copyright (c) 2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by an MIT-style
// license that can be found in the LICENSE file at
// the root directory of this project.

package org.littletonrobotics.xrp.subsystems.drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Drive extends SubsystemBase {
  private final DriveIO io;
  private final DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();

  /**
   * IMPORTANT: We never use HID objects like this in a subsystem class. This code is provided as a
   * starting point, and we will discuss how to improve it very soon.
   */
  private final GenericHID keyboard = new GenericHID(0);

  /** Creates a new Drive. */
  public Drive(DriveIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Drive", inputs);

    drivePercent(
        -keyboard.getRawAxis(1) + keyboard.getRawAxis(0),
        -keyboard.getRawAxis(1) - keyboard.getRawAxis(0));
  }

  /** Run open loop based on percentages. */
  public void drivePercent(double left, double right) {
    io.setVoltage(left * 6.0, right * 6.0);
  }

  /** Run open loop based on voltages. */
  public void driveVolts(double leftVolts, double rightVolts) {
    io.setVoltage(leftVolts, rightVolts);
  }

  /** Stops the drive. */
  public void stop() {
    io.setVoltage(0.0, 0.0);
  }
}
