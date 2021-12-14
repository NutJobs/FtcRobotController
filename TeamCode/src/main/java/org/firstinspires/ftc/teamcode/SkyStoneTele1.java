// package org.firstinspires.ftc.teamcode;// package org.firstinspires.ftc.teamcode;


// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
// //import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import org.firstinspires.ftc.robotcore.external.ClassFactory;
// //import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
// import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
// //import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
// import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
// import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
// import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
// import java.util.List;



// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

// import org.firstinspires.ftc.robotcore.external.ClassFactory;
// import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
// import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
// import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
// import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
// import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
// import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

// @TeleOp(name="SkyStoneTele1", group="Drive programms")  // @Autonomous(...) is the other common choice

// public class SkyStoneTele1 extends LinearOpMode {

// private ElapsedTime runtime = new ElapsedTime();
//   SkyStoneHardware1 robot = new SkyStoneHardware1();

//     // @Override
//     public void runOpMode() throws InterruptedException{
//           robot.init(hardwareMap);
//     telemetry.addData("Status", "Initialized");
//     telemetry.update();


    
//     waitForStart();
//     runtime.reset();
    
//     double right;
//     double left;
//     double right2;
//     double left2;
//     double BottomArm;
//     double upperarm;
//     float Left;
//     float Right;
//     float Left2;
//     float Right2;
    
    

//     while (opModeIsActive()) {
        
//     //Fix variable
//  upperarm = -gamepad2.right_stick_y;
// BottomArm = gamepad2.left_stick_y;
//     //deadzone/variable creation

// if(Math.abs(gamepad1.left_stick_y)>0.15 || Math.abs(gamepad1.right_stick_y)>0.15 || Math.abs(gamepad1.left_stick_x)>0.15){
//       Left = -gamepad1.left_stick_y + gamepad1.left_stick_x;
//       Right = -gamepad1.right_stick_y - gamepad1.left_stick_x;
//       Left2 = -gamepad1.left_stick_y - gamepad1.left_stick_x;
//       Right2 = -gamepad1.right_stick_y + gamepad1.left_stick_x;
//      }
     
//      else{
//       Left = 0;
//       Right = 0;
//       Left2 = 0;
//       Right2 = 0;
//      }
    
//     //wheels slow
//      if(gamepad1.left_bumper){
//      robot.motorLeft.setPower(Left*.25);
//      robot.motorRight.setPower(Right*.25);
//      robot.motorLeft2.setPower(Left2*.25);
//      robot.motorRight2.setPower(Right2*.25);
//      }
//      //wheels fast
//      if(gamepad1.right_bumper){
//      robot.motorLeft.setPower(Left);
//      robot.motorRight.setPower(Right);
//      robot.motorLeft2.setPower(Left2);
//      robot.motorRight2.setPower(Right2);
//      }
    
//      else{
//     //wheels normal
//      robot.motorLeft.setPower(Left*.5);
//      robot.motorRight.setPower(Right*.5);
//      robot.motorLeft2.setPower(Left2*.5);
//      robot.motorRight2.setPower(Right2*.5);
//      }
     
    
    
    
//     telemetry.addData("Left1", robot.motorLeft.getCurrentPosition());
//     telemetry.addData("Left2", robot.motorLeft2.getCurrentPosition());
//     telemetry.addData("Right1", robot.motorRight.getCurrentPosition());
//     telemetry.addData("Right2", robot.motorRight2.getCurrentPosition());
    
//     robot.collectorRight.setPower(gamepad1.left_trigger);
//     robot.collectorLeft.setPower(gamepad1.left_trigger);
    
//     robot.collectorRight.setPower(-gamepad1.right_trigger);
//     robot.collectorLeft.setPower(-gamepad1.right_trigger);
    
     
    
//     //gamePad2
//     if(Math.abs(gamepad2.left_stick_y)>0.15  || Math.abs(gamepad2.right_stick_y)>0.15  || Math.abs(gamepad2.right_stick_x)>0.15){
    
//       robot.bottomArmMotor.setPower(BottomArm * .5); //+ gamepad2.right_stick_y;
//       robot.topArmMotor.setPower(upperarm * .5);
//     // //   Left2 = -gamepad1.left_stick_y - gamepad2.left_stick_x;
//     // //   Right2 = -gamepad1.right_stick_y + gamepad1.left_stick_x;
    
//      }
    
    
//     else{
//       robot.bottomArmMotor.setPower(0);
//       robot.topArmMotor.setPower(0);
//     //   Right = 0;
//     //   Left2 = 0;
//     //   Right2 = 0;
//      }
    
//     //David Servo
//     // check to see if we need to move the servo.
//         if(gamepad1.y) {
//         // move to 0 degrees.
//             robot.davidServo.setPosition(1);
//         }
    
//       // else if (gamepad1.x || gamepad1.b) {
//         // move to 90 degrees.
            
//         //}
//         else if (gamepad1.a) {
//         // move to 180 degrees.
//             robot.davidServo.setPosition(0);
//         }
//             // else command used to move servo back to slack position
//         else{
//     //        robot.davidServo.setPosition(0.5);
//         }
//     telemetry.addData("Servo Position", robot.hazzardServo.getPosition());
//     telemetry.addData("Status", "Running");
//     telemetry.update();

// //}
//     //Hazzard Servo
//         if(gamepad2.left_bumper) {
//         // move to 0 degrees.
//             robot.hazzardServo.setPosition(1);
//         }
//       // else if (gamepad1.x || gamepad1.b) {
//         //move to 90 degrees.
            
//       // }
//         else if (gamepad2.right_bumper) {
//         // move to 180 degrees.
//             robot.hazzardServo.setPosition(1);
//         }
//         else{
//             robot.hazzardServo.setPosition(0.5);
//         }
    
//     // check to see if we need to move the servo.
//     if(gamepad2.left_bumper) {
//         // move to 0 degrees.
//         robot.hazzardServo.setPosition(0);
//     } else if (gamepad2.dpad_left) {
//         // move to 90 degrees.
//         robot.hazzardServo.setPosition(0.5);
//     } else if (gamepad2.right_bumper) {
//         // move to 180 degrees.
//         robot.hazzardServo.setPosition(1);
//     }
//     // telemetry.addData("Servo Position", robot.servoTest.getPosition());
//     // telemetry.addData("Target Power", tgtPower);
//     // telemetry.addData("Motor Power", motorTest.getPower());
//     // telemetry.addData("Status", "Running");
//     // telemetry.update();


//         telemetry.addData("Servo Position", robot.hazzardServo.getPosition());
//     telemetry.addData("Status", "Running");
//     telemetry.update();

//         // Greta Servo
//         if (gamepad2.x) {
//         // move to 90 degrees.
//             robot.gretaServo.setPosition(1);
//         }
        

//         else if (gamepad2.b) {
//             robot.gretaServo.setPosition(0);
//         }
//         else{
//             robot.gretaServo.setPosition(0.5);
//         }
        
       
        
//         //Tom Servo
//         if(gamepad2.a) {
//         // move to 0 degrees.
//             robot.tomServo.setPosition(1);
//         }
    
//       // else if (gamepad1.x || gamepad1.b) {
//         // move to 90 degrees.
            
//         //}
//             else if (gamepad2.y) {
//         // move to 180 degrees.
//                 robot.tomServo.setPosition(0);
//             }
//             else{
//                 robot.tomServo.setPosition(0.5);
//             }
    
//             if (gamepad1.dpad_up || gamepad2.dpad_up) {
//                 robot.munchieServo.setPosition(0);
//                 robot.dooterServo.setPosition(1);
//             } 
//             else if (gamepad1.dpad_down || gamepad2.dpad_down) {
//                 robot.munchieServo.setPosition(1);
//                 robot.dooterServo.setPosition(0);


//             }
//             if (gamepad1.dpad_left || gamepad2.dpad_left) {
//                 robot.dooterServo.setPosition(0);
//                 robot.munchieServo.setPosition(1);

//             } 
//             else if (gamepad1.dpad_right || gamepad2.dpad_right) {
//                 robot.dooterServo.setPosition(0);
//                 robot.munchieServo.setPosition(1);

//             }

// }
// }
// }
