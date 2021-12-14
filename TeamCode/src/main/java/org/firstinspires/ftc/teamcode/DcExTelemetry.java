// package org.firstinspires.ftc.teamcode;
// // import lines were omitted. OnBotJava will add them automatically.
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.DcMotorEx;
// import com.qualcomm.robotcore.hardware.DcMotor;

// @TeleOp
// public class DcExTelemetry extends LinearOpMode {
    
    
//     @Override
//     public void runOpMode() {
//     FreightFrenzyHardware robot = new FreightFrenzyHardware();
        
//         // Reset the encoder during initialization
//         robot.liftMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
 
//         waitForStart();
        
//         // Set the motor's target position to 300 ticks
//         robot.liftMotor.setTargetPosition(300);
        
//         // Switch to RUN_TO_POSITION mode
//         robot.liftMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        
//         // Start the motor moving by setting the max velocity to 200 ticks per second
//         robot.liftMotor.setVelocity(200);
 
//         // While the Op Mode is running, show the motor's status via telemetry
//         while (opModeIsActive()) {
//             telemetry.addData("velocity", robot.liftMotor.getVelocity());
//             telemetry.addData("position", robot.liftMotor.getCurrentPosition());
//             telemetry.addData("is at target", !robot.liftMotor.isBusy());
//             telemetry.update();
//         }
//     }
// }