// package org.firstinspires.ftc.teamcode;// package org.firstinspires.ftc.teamcode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotorSimple;
// import com.qualcomm.robotcore.hardware.DistanceSensor;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;



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

// @TeleOp(name="UltimateGoalTele1", group="Drive programms")  // @Autonomous(...) is the other common choice

// public class UltimateGoalTele1 extends LinearOpMode {
// public boolean shooterOn;
// private ElapsedTime runtime = new ElapsedTime();
//   UltimateGoalHardware robot = new UltimateGoalHardware();
//     private DistanceSensor sensorRange;
//     // @Override
//     public void runOpMode() throws InterruptedException{
//           robot.init(hardwareMap);
//     telemetry.addData("Status", "Initialized");
//     telemetry.update();


    
//     waitForStart();
//     runtime.reset();
    
//     double frontright;
//     double frontleft;
//     double backright;
//     double backleft2;
//     // double BottomArm;
//     // double upperarm;
//     float Left;
//     float Right;
//     float Left2;
//     float Right2;
    
//     double blue = 0;
    
//     double switch1 = 0;
    
//     double switch2 = 0;
    
    
//     //sensorRange = hardwareMap.get(DistanceSensor.class, "sensor_range");
//     // while (opModeIsActive()) {
//     // //telemetry.addData("Status", "Initialized");
//     // telemetry.update();
//     // telemetry.addData("blue: ", robot.colorSensor2.blue());
//     //             telemetry.update();
//     //     }

//     while (opModeIsActive()) {
        
//          //blue = robot.colorSensor2.red();
//                 //sleep(250);
        
//     //Fix variable
// //  upperarm = -gamepad2.right_stick_y;
// // BottomArm = gamepad2.left_stick_y;
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
//      //robot.frontLeft.setPower(Left*.2);
//      //robot.frontRight.setPower(Right*.2);
//      //robot.backLeft.setPower(Left2*.2);
//      //robot.backRight.setPower(Right2*.2);
//      }
//      //wheels fast
//      if(gamepad1.right_bumper){
//      robot.frontLeft.setPower(Left);
//      robot.frontRight.setPower(Right);
//      robot.backLeft.setPower(Left2);
//      robot.backRight.setPower(Right2);
//      }
    
//      else{
//     //wheels normal
//      robot.frontLeft.setPower(Left * .75);
//      robot.frontRight.setPower(Right * .75);
//      robot.backLeft.setPower(Left2 * .75);
//      robot.backRight.setPower(Right2 * .75);
//      }
//      if(gamepad1.a) {
         
//          robot.frontLeft.setPower(-0.25);
//          robot.backRight.setPower(-0.25);
//          robot.frontRight.setPower(-0.25);
//          robot.backLeft.setPower(-0.25);
//      }
     
//      if(gamepad1.y) {
//          robot.frontRight.setPower(0.25);
//          robot.backLeft.setPower(0.25);
//          robot.frontLeft.setPower(0.25);
//          robot.backRight.setPower(0.25);
//      }
//     //  if(gamepad1.left_trigger > 0) {
         
                
//     //             telemetry.addData("blue: ", robot.colorSensor2.blue());
//     //             telemetry.update();
                
//     //             switch1 = 1;
//     //  }
//     //             if (robot.colorSensor2.blue() >= blue+3) {
//     //                 switch1 = 0;
//     //             }
                
//                 // while (robot.colorSensor2.blue() < blue+3 && switch1 == 1) {
//                 //     robot.frontRight.setPower(0.1);
//                 // robot.backRight.setPower(0.1);
//                 // robot.frontLeft.setPower(0.1);
//                 // robot.backLeft.setPower(0.1);
//                 // }
                
//                 // while (robot.colorSensor2.blue() >= blue+3 && switch1 == 1 && switch2 == 0) {
//                 //     robot.frontRight.setPower(0);
//                 // robot.backRight.setPower(0);
//                 // robot.frontLeft.setPower(0);
//                 // robot.backLeft.setPower(0);
                
//                 // }
//                 // if (switch1 == 1) {
//                 // // if(robot.colorSensor2.red() < blue+2 && switch1 == 0) {
//                 // robot.frontRight.setPower(0.1);
//                 // robot.backRight.setPower(0.1);
//                 // robot.frontLeft.setPower(0.1);
//                 // robot.backLeft.setPower(0.1);
//                 // sleep(10000);
//                 // }
                
//                 // else {
//                 //   robot.frontRight.setPower(0);
//                 // robot.backRight.setPower(0);
//                 // robot.frontLeft.setPower(0);
//                 // robot.backLeft.setPower(0);  
//                 // }
                
//                 // while ((switch1 == 1 && robot.colorSensor2.blue() > blue+2) || (robot.colorSensor2.blue() > 8)) {
//                 //     robot.frontRight.setPower(0);
//                 //     robot.backRight.setPower(0);
//                 //     robot.frontLeft.setPower(0);
//                 //     robot.backLeft.setPower(0);
//                 //     switch1 = 0;                
                    
//                 // }
                
                
                
//                 // }
//                 // switch1 = 1;
//                 // robot.frontRight.setPower(0);
//                 // robot.backRight.setPower(0);
//                 // robot.frontLeft.setPower(0);
//                 // robot.backLeft.setPower(0);
//         if(gamepad2.a) {
//             robot.collectorServo.setPosition(1);
//         }
//         else {
//             robot.collectorServo.setPosition(0);
//         }

     
//     //  if(gamepad1.y) {
//     //      robot.wheelServo.setPosition(0);
//     //      sleep(500);
//     //      robot.wheelServo.setPosition(1);
//     //  }
     
//      if(gamepad1.right_trigger > 0) {
//         // robot.frontRight.setPower(0.1);
//         //         robot.backRight.setPower(0.1);
//         //         robot.frontLeft.setPower(0.1);
//         //         robot.backLeft.setPower(0.1);
//         //         sleep(500);
//          switch2 = 0;
         
         
//      }
     
//      if(gamepad1.x) {
         
//          robot.frontLeft.setPower(-0.25);
//          robot.backRight.setPower(0.25);
         
//      }
     
//      if(gamepad1.b) {
//          robot.frontRight.setPower(-0.25);
//          robot.backLeft.setPower(0.25);
//      }
    
    
    
//     telemetry.addData("Left", robot.frontLeft.getCurrentPosition());
//     telemetry.addData("Left2", robot.backLeft.getCurrentPosition());
//     telemetry.addData("Right", robot.frontRight.getCurrentPosition());
//     telemetry.addData("Right2", robot.backRight.getCurrentPosition());
    
//     // robot.collectorRight.setPower(gamepad1.left_trigger);
//     // robot.collectorLeft.setPower(gamepad1.left_trigger);
    
//     // robot.collectorRight.setPower(-gamepad1.right_trigger);
//     // robot.collectorLeft.setPower(-gamepad1.right_trigger);
    
     
    
//     //gamePad2
//     if(Math.abs(gamepad2.left_stick_y)>0.15  || Math.abs(gamepad2.right_stick_y)>0.15  || Math.abs(gamepad2.right_stick_x)>0.15){
    
//       //robot.ramp.setPower(0.25); //+ gamepad2.right_stick_y;
//       robot.ramp.setPower(.25*(-gamepad2.left_stick_y - gamepad2.left_stick_x));
//     //robot.ramp.setPower(-gamepad1.right_stick_y + gamepad1.left_stick_x);
    
//      }
    
    
//     else{
//       robot.ramp.setPower(0);
//     //   robot.topArmMotor.setPower(0);
//     //   Right = 0;
//     //   Left2 = 0;
//     //   Right2 = 0;
//      }
    
//     //David Servo
//     // check to see if we need to move the servo.
//         //if(gamepad1.y) {
//         // move to 0 degrees.
//             //robot.davidServo.setPosition(1);
// //}
    
//       // else if (gamepad1.x || gamepad1.b) {
//         // move to 90 degrees.
            
//         //}
//         //else if (gamepad1.a) {
//         // move to 180 degrees.
//     //         robot.davidServo.setPosition(0);
//     //     }
//     //         // else command used to move servo back to slack position
//     //     else{
//     // //        robot.davidServo.setPosition(0.5);
//     //     }
//     // telemetry.addData("Servo Position", robot.hazzardServo.getPosition());
//     // telemetry.addData("Status", "Running");
//     // telemetry.update();

// //}


//   //ramp
  
//   if(gamepad2.x) {
//       robot.ramp.setPower(-1);
      
//   }

//     if(gamepad2.y) {
//         robot.shooter.setPower(0);
//     }
    
//     //collectorServo
//     if (gamepad2.a) {
//         robot.collectorServo.setPosition(1);
//     }
    
//     if(gamepad2.b) {
//         robot.collectorServo.setPosition(0);
//     }

//     //Collector
//         if(gamepad2.left_trigger > 0) {
//         // move to 0 degrees.
//             robot.collector.setPower(-1);
//         }
//         // if(gamepad2.y){
//         // robot.shooter.setPower(0.3);
//         // robot.shooter2.setPower(-0.3);
//         // }
//         // if(gamepad2.x) {
//         //     robot.collector.setPower(1);
//         // }
//       // else if (gamepad1.x || gamepad1.b) {
//         //move to 90 degrees.
        
//         else{ 
//             robot.collector.setPower(0);
//         }
            
//       // }
//         if (gamepad2.right_trigger > 0) {
//         // move to 180 degrees.
//             // robot.shooter.setPower(1);
//             // robot.shooter2.setPower(1);
//             robot.collector.setPower(1);
//         }
//         // else{
//         //     robot.hazzardServo.setPosition(0.5);
//         // }
    
    
//     if(gamepad2.right_bumper) {
        
//         // robot.shooter2.setPower(-1);
//         // shooterOn= true;
//     robot.shooter.setPower(-1);
//     } 
//     // if(gamepad2.right_bumper && shooterOn == true) {
//     //     shooterOn=false;
//     // }
//     // if(shooterOn == true) {
//     //     robot.shooter.setPower(-0.9);
//     // }
//     // else {
//     //     robot.shooter.setPower(0);
//     //}
//     if(gamepad2.left_bumper) {
//         robot.shooter.setPower(0.3);
//         //13.5 volts, -0.7 power
//         // robot.shooter2.setPower(0);
//     }
    
//     if (gamepad2.dpad_down) {
        
//          robot.arm.setPower(0.5);
        
//         //sleep(1000);
//     }
    
//     else {
//         robot.arm.setPower(0);
        
//     }
    
//     if (gamepad2.dpad_up) {
//         robot.arm.setPower(-0.5);
//         //sleep(1000);
//     }
    
//   if (gamepad2.dpad_left) {
//       robot.munchie.setPosition(1);
//   }
   
//   if(gamepad2.dpad_right) {
//       robot.munchie.setPosition(0);
//   }
//     // } else if (gamepad2.dpad_left) {
//     //     // move to 90 degrees.
//     //     robot.hazzardServo.setPosition(0.5);
//     // } else if (gamepad2.right_bumper) {
//     //     // move to 180 degrees.
//     //     robot.hazzardServo.setPosition(1);
//      //}
//     // telemetry.addData("Servo Position", robot.servoTest.getPosition());
//     // telemetry.addData("Target Power", tgtPower);
//     // telemetry.addData("Motor Power", motorTest.getPower());
//     // telemetry.addData("Status", "Running");
//     // telemetry.update();


//     //     telemetry.addData("Servo Position", robot.hazzardServo.getPosition());
//     // telemetry.addData("Status", "Running");
//     // telemetry.update();

//         // Greta Servo
//         // if (gamepad2.x) {
//         // // move to 90 degrees.
//         //     robot.gretaServo.setPosition(1);
//         // }
        

//         // else if (gamepad2.b) {
//         //     robot.gretaServo.setPosition(0);
//         // }
//         // else{
//         //     robot.gretaServo.setPosition(0.5);
//         // }
        
       
        
//         //Tom Servo
//     //     if(gamepad2.a) {
//     //     // move to 0 degrees.
//     //         robot.tomServo.setPosition(1);
//     //     }
    
//     //   // else if (gamepad1.x || gamepad1.b) {
//     //     // move to 90 degrees.
            
//     //     //}
//     //         else if (gamepad2.y) {
//     //     // move to 180 degrees.
//     //             robot.tomServo.setPosition(0);
//     //         }
//     //         else{
//     //             robot.tomServo.setPosition(0.5);
//     //         }
    
//     //         if (gamepad1.dpad_up || gamepad2.dpad_up) {
//     //             robot.munchieServo.setPosition(0);
//     //             robot.dooterServo.setPosition(1);
//     //         } 
//     //         else if (gamepad1.dpad_down || gamepad2.dpad_down) {
//     //             robot.munchieServo.setPosition(1);
//     //             robot.dooterServo.setPosition(0);


//     //         }
//     //         if (gamepad1.dpad_left || gamepad2.dpad_left) {
//     //             robot.dooterServo.setPosition(0);
//     //             robot.munchieServo.setPosition(1);

//     //         } 
//     //         else if (gamepad1.dpad_right || gamepad2.dpad_right) {
//     //             robot.dooterServo.setPosition(0);
//     //             robot.munchieServo.setPosition(1);

//     //         }

// }
// }
// }
//   //}

// //}
// //}
// //}
