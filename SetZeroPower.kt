package org.firstinspires.ftc.teamcode.commands.camp

import kotlinx.serialization.Serializable
import org.firstinspires.ftc.teamcode.framework.Command
import org.firstinspires.ftc.teamcode.other.Vector
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain

@Serializable
class SetZeroPower : Command() {
    override fun init() {
        Drivetrain.drive(Vector(0.0,0.0),0.0)
    }

    override fun isFinished()=true

    override fun loop() {

    }

    override fun stop() {

    }


}