package org.firstinspires.ftc.teamcode.commands.camp

import kotlinx.serialization.Serializable
import org.firstinspires.ftc.teamcode.base.BaseHardware
import org.firstinspires.ftc.teamcode.framework.Command
import org.firstinspires.ftc.teamcode.framework.hardware.MotorModes
import org.firstinspires.ftc.teamcode.other.Vector
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain

@Serializable
class GyroTurn(val angle: Double, val p: Double): Command() {
    override fun init() {

        Drivetrain.group.mode = MotorModes.ControllerVelocityLoop
    }

    override fun isFinished(): Boolean {
        val error = angle - BaseHardware.gyro.derivedAbsoluteAngle
        if(Math.abs(error) < 2) {
            return true
        } else {
            return false
        }
    }

    override fun loop() {
        val error = angle - BaseHardware.gyro.derivedAbsoluteAngle
        Drivetrain.drive(Vector(0.0, 0.0), -p * error)

    }

    override fun stop() {
        Drivetrain.drive(Vector(0.0,0.0),0.0)
    }
}