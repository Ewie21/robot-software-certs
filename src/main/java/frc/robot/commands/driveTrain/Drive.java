package frc.robot.commands.driveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
    private final DriveTrain driveTrain;
    private final XboxController driver;

/**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    public Drive(DriveTrain subsystem, XboxController driver) {
        this.driveTrain = subsystem;
        this.driver = driver;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        double raw_x = driver.getLeftY();
        double raw_y = driver.getLeftX();
        double raw_z = driver.getRightX();

        double x = Math.abs(raw_x * 0.5) > 0.1 ? 0 : raw_x;
        double y = Math.abs(raw_y * 0.5) > 0.1 ? 0 : raw_y;
        double z = Math.abs(raw_z * 0.5) > 0.1 ? 0 : raw_z;

        // I don't know if there's another good way to do this math
        // Thanks for Simon for it
        double FL = y + z + x;
        double BL = y + z - x;
        double FR = y - z - x;
        double BR = y - z + x;

        double maxVal = Math.abs(largest(FL, BL, FR, BR));

        if (maxVal > 1) {
            FL /= maxVal;
            FR /= maxVal;
            BL /= maxVal;
            BR /= maxVal;
        }

        driveTrain.setPercents(FL, BL, FR, BR);
    }
    double largest(double a, double b, double c, double d) {
        return compare(compare(a, b), compare(c, d));
    }

    double compare(double a, double b) {
        if (a > b) {
            return a;
        } else return b;
    }
}