package org.firstinspires.ftc.teamcode.commands.camp

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.firstinspires.ftc.teamcode.framework.Command
import org.firstinspires.ftc.teamcode.framework.hardware.MotorModes
import org.firstinspires.ftc.teamcode.other.Vector
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain

@Serializable
class TimeDrive2(val direction: Vector, val duration: Int): Command() {

    @Transient
    var initialTime: Long = 0
    override fun init() {
        initialTime = System.currentTimeMillis()

        Drivetrain.group.mode = MotorModes.ControllerVelocityLoop
    }

    override fun loop() {
        Drivetrain.drive(direction, 0.0)
    }

    override fun stop() {
        Drivetrain.drive(Vector(0.0, 0.0), 0.0)
    }

    override fun isFinished(): Boolean {
        return (System.currentTimeMillis()-initialTime >= duration)
    }
}