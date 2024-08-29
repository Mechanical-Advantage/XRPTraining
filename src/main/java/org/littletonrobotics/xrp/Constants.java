// Copyright (c) 2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by an MIT-style
// license that can be found in the LICENSE file at
// the root directory of this project.

package org.littletonrobotics.xrp;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  /** Period of main loop in milliseconds */
  public static final double loopPeriodSecs = 0.02;

  /** The robot being used */
  public static final RobotType robotType = RobotType.XRP;

  /** Whether to load a log file and run simulation replay */
  public static final boolean isReplay = false;

  /** Whether to publish and allow editing of tunable numbers */
  public static final boolean tuningMode = true;

  public enum RobotType {
    XRP,
    SIMBOT,
    REALBOT
  }
}
