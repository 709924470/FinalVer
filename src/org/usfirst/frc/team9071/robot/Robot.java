
package org.usfirst.frc.team9071.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team9071.robot.commands.AuDGr;
import org.usfirst.frc.team9071.robot.subsystems.AuDrive;
import org.usfirst.frc.team9071.robot.subsystems.Gear;
import org.usfirst.frc.team9071.robot.subsystems.Rope;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Gear gear = new Gear();
	public static final Rope rope = new Rope();
	public static final AuDrive adr = new AuDrive();
	public static OI oi;
	Thread vi;

	Command aucs = new AuDGr();
	
	@Override
	public void robotInit() {
		oi = new OI();
		vi = new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640,480);
			camera.setFPS(25);
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);
			Mat mat = new Mat();
			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				outputStream.putFrame(mat);
			}
		});
		vi.setDaemon(true);
		vi.start();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void autonomousInit() {
		aucs.start();
	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		adr.jsdrive(oi.j1(), 1);
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		adr.jsdrive(oi.j1(), 1);
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
