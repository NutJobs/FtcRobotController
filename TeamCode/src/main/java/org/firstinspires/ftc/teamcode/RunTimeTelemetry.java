package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class RunTimeTelemetry  extends LinearOpMode {
    
    private ElapsedTime runtime = new ElapsedTime();
  UltimateGoalHardware robot = new UltimateGoalHardware();

    // @Override
    public void runOpMode() throws InterruptedException{
          robot.init(hardwareMap);
    telemetry.addData("Status", "Initialized");
    telemetry.update();


    
    waitForStart();
    runtime.reset();

    // todo: write your code here
    
    while (opModeIsActive()) {
        
        telemetry.addData("time: ", runtime.milliseconds());
        telemetry.update();
    
    }
    }
    
}
