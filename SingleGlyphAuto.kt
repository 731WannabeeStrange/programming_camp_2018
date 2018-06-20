package org.firstinspires.ftc.teamcode.autonomous

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import org.firstinspires.ftc.teamcode.base.BaseAuto
import org.firstinspires.ftc.teamcode.commands.Turn
import org.firstinspires.ftc.teamcode.commands.camp.TimeDrive2
import org.firstinspires.ftc.teamcode.framework.commands.Stop
import org.firstinspires.ftc.teamcode.other.Vector

@Autonomous
class SingleGlyphAuto: BaseAuto() {
    override fun list() {
        addSequential(TimeDrive2(Vector(-1.0, 1.0), 500))
        addSequential(Turn(90))
        addSequential(TimeDrive2(Vector(1.0, 0.0), 500))
        addSequential(Stop())
    }
}