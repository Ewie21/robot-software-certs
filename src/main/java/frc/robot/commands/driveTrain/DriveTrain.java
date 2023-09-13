package frc.robot.commands.driveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private final TalonSRX frontLeft = new TalonSRX(1);
    private final TalonSRX frontRight = new TalonSRX(4);
    private final TalonSRX backLeft = new TalonSRX(2);
    private final TalonSRX backRight = new TalonSRX(3);
    
    public DriveTrain(){
        frontLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    // public void setLeftRightPercent(double leftPercent, double rightPercent) {
    //     frontLeft.set(ControlMode.PercentOutput, leftPercent);
    //     frontRight.set(ControlMode.PercentOutput, rightPercent);
    //     backLeft.set(ControlMode.PercentOutput, leftPercent);
    //     backRight.set(ControlMode.PercentOutput, rightPercent);
    // }

    public void setPercents(double FL, double BL, double FR, double BR) {
        frontLeft.set(ControlMode.PercentOutput, FL);
        backLeft.set(ControlMode.PercentOutput, BL);
        frontRight.set(ControlMode.PercentOutput, FR);
        backRight.set(ControlMode.PercentOutput, BR);
    }
}
