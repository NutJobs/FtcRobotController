package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Disabled
@Autonomous(name="ElevatorTest", group="2020/2021 auto programms")
public class ElevatorTest extends LinearOpMode {
    FreightFrenzyHardware robot = new FreightFrenzyHardware();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        telemetry.addData("This Code will move the liftMotor for one second at max speed, to determine velocity.",0);
        telemetry.update();
        waitForStart();
        robot.liftMotor.setPower(1);
        sleep(1000);
        robot.liftMotor.setPower(0);
        sleep(90000);

    }
}
