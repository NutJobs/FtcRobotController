// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// //import com.qualcomm.robotcore.hardware.ColorSensor;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import java.lang.annotation.Target;
// import java.util.Timer;
// import com.qualcomm.robotcore.robot.Robot;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
// //import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import org.firstinspires.ftc.robotcore.external.ClassFactory;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
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

// //color sensor imports
// import android.graphics.Color;

// @Autonomous(name="BlueBlockStacker", group="2019/2020 auto programms") 
// //@Disabled
// public class BlueBlockStacker extends LinearOpMode { 
//     // todo: write your code here

//     ColorSensor colorSensor;
//     ColorSensor colorSensor2;

//     SkyStoneHardware1 robot = new SkyStoneHardware1();
//     private ElapsedTime     runtime = new ElapsedTime();
        
//     static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    
//     static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     
//     static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     
//     static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
//                                                       (WHEEL_DIAMETER_INCHES * 4);
//     static final double     DRIVE_SPEED             = 0.5;
//     static final double     TURN_SPEED              = 0.3;
//     static final double     FORWARD_SPEED           = 0.7;
//     static final double     UNLATCH_SPEED           = 0.8;
//     static final double     LOWER_SPEED             = 1.0;
//     static final double     LEFT                    = 0.5;
//     static final double     RIGHT                   = 0.5;
//     static final double     LEFT2                   = 0.5;
//     static final double     RIGHT2                  = 0.5;
//     // color sensor stuff (declarations)
//     final double SCALE_FACTOR = 255;
//     float hsvValues[] = {0F, 0F, 0F};
//     final float values[] = hsvValues;
//         int Block = 2; /* 1 = yes | 0 = no */
//         double Block1;
//         double Block2;
//         double Block3;
//         String Skystone;
//         double SkystoneN;
        
//         double attempts;
//         double attempts1;
//         double backwards;
        
//         double floorRGB = 0;
//         double floorMinus2;
//         double floorPlus2;
        
//     @Override

//       public void runOpMode() throws InterruptedException {       
//       robot.init(hardwareMap);
      
//       colorSensor = hardwareMap.colorSensor.get("colorSensor");
//       colorSensor2 = hardwareMap.colorSensor.get("colorSensor2");
      
      
      
//       robot.motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//       robot.motorLeft2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//       robot.motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//       robot.motorRight2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      
      
//         robot.motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//       robot.motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//       robot.motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//       robot.motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    

//         robot.motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         robot.motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         robot.motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         robot.motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//         telemetry.addData("Red  ", robot.colorSensor.red());
//         telemetry.addData("Green", robot.colorSensor.green());
//         telemetry.addData("Blue ", robot.colorSensor.blue());
//         telemetry.update();

       
//      Color.RGBToHSV((int) (robot.colorSensor.red() * SCALE_FACTOR),
//                     (int) (robot.colorSensor.green() * SCALE_FACTOR),
//                     (int) (robot.colorSensor.blue() * SCALE_FACTOR),
//                     hsvValues);
//         telemetry.addData("Red  ", robot.colorSensor.red());
//         telemetry.addData("Green", robot.colorSensor.green());
//         telemetry.addData("Blue ", robot.colorSensor.blue());
//         telemetry.update();
//         waitForStart();
        
//         while (attempts == 0 && opModeIsActive()) {
//         floorRGB = robot.colorSensor2.blue();
//         floorMinus2 = floorRGB-2;
//         floorPlus2 = floorRGB+2;
//         sleep(600);
//         attempts = 1;
//         }

        
        
//         //put code here
        

//         telemetry.addData("Red  ", robot.colorSensor2.red());
//         telemetry.addData("Green", robot.colorSensor2.green());
//         telemetry.addData("Blue ", robot.colorSensor2.blue());
//         telemetry.update(); 
        
//         //Drive forward to block line
//         encoderDriveV2(0.5, 8.4, 8.4, 10);
        
//         //Turn before driving down block line
//         encoderDriveV2(0.3, -5.5, 5.5, 10);
       
        
//         encoderDriveV2(0.5, -6, -6, 10);
//       // mecanum_encoder_drive(0.3, 1, -1, 15);
//       Block = 0;
//         while (Block == 0 && opModeIsActive()) {
//             sleep(100);
//             Block1 = robot.colorSensor.red();
//             telemetry.addData("Block", robot.colorSensor.red());
//             telemetry.update();
//             sleep(100);
//             encoderDriveV2(0.5, -2.4, -2.4, 15);
//             Block2 = robot.colorSensor.red();
//             telemetry.addData("Block", robot.colorSensor.red());
//             telemetry.update();
//             sleep(100);
//             encoderDriveV2(0.5, -2.4, -2.4, 15);
//             sleep(100);
//             Block3 = robot.colorSensor.red();
//             telemetry.addData("Block", robot.colorSensor.red());
//             telemetry.update();
//             sleep(100);
//             Block = 1;
            
//         }
        
//         //Sensing block
//         if (Block1 < Block2 && Block1 < Block3) {
            
//             Skystone = "Block1";
//             SkystoneN = 1;
            
//         }
//         else if (Block2 < Block3 && Block2 < Block1) {
//             Skystone = "Block2";
//             SkystoneN = 2;
//         }
//         else if (Block3 < Block2 && Block3 < Block1) {
//             Skystone = "Block3";
//             SkystoneN = 3;
//         }
        
//         telemetry.addData("Block: ", Skystone);
//         telemetry.update();
//         sleep(200);
        
//         if (SkystoneN == 1) {
//         encoderDriveV2(0.5, 1.8, 1.8, 15);
//         //SHOULD BE IN FRONT OF BLOCK
        
//         }
//         else if (SkystoneN == 2) {
//         //encoderDriveV2(0.5, -0.5, -0.5, 15);
//         // //SHOULD BE IN FRONT OF BLOCK
        
//          }
//         else if (SkystoneN == 3) {
//         encoderDriveV2(0.5, -3.5, -3.5, 10);
//         // //SHOULD BE IN FRONT OF BLOCK
        
//         }
        
//         sleep(100);
        
//         //Close davidServo
//         robot.davidServo.setPosition(1);
        
//         //Shimmy shimmy get block
//         mecanum_encoder_drive(0.3, 6, -6, 10);
        
//         //Turn on collectors
//         robot.collectorRight.setPower(1);
//         robot.collectorLeft.setPower(1);
        
//         //Drive forward collect block
//         encoderDriveV2(0.5, 4, 4, 10);
        
//         //Set slow mode on collectors
//         robot.collectorRight.setPower(0.3);
//         robot.collectorLeft.setPower(0.3);
        
//         //Turn after getting block
//         encoderDriveV2(0.5, 5.5, -5.5, 10);
        
//          //Backup after turn, before driving under bridge
//         encoderDriveV2(1, -5, -5, 10);
        
//       //put arm down
//         robot.bottomArmMotor.setPower(1);
//          runtime.reset();
//         while (opModeIsActive() && (runtime.seconds() < .15)) {
//             telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
//             telemetry.update();
//         }
        
//         encoderDriveV2(0.5, -5, 5, 10);
        
//         //Drive forward under bridge
//         while (attempts1 == 0 && opModeIsActive()) {
//         floorRGB = robot.colorSensor2.blue();
//         floorMinus2 = floorRGB-2;
//         floorPlus2 = floorRGB+2;
//         sleep(300);
//         attempts1 = 1;
//         }
        
//          while(robot.colorSensor2.blue() < floorPlus2 && robot.colorSensor2.blue() > floorMinus2 && opModeIsActive()) {
//              robot.motorLeft.setPower(1);
//              robot.motorRight.setPower(1);
//              robot.motorLeft2.setPower(1);
//              robot.motorRight2.setPower(1);
//          }
         
         
//          encoderDriveV2(1, 11.5, 11.5, 10);
        
//         //turn
//         encoderDriveV2(0.5, -5.2, 5.2, 10);
        
//         //backup to plate
//         encoderDriveV2(0.3, -6.5, -6.5, 10);
        
//         robot.munchieServo.setPosition(1);
//         robot.dooterServo.setPosition(0);
         
//          sleep(300);
         
//          encoderDriveV2(0.5, -0.5, 1, 10);
         
//          encoderDriveV2(0.5, 8.5, 8.5, 10);
//          encoderDriveV2(0.5, -9, 9, 10);
         
//          robot.collectorLeft.setPower(-1);
//          robot.collectorRight.setPower(-1);
         
//          encoderDriveV2(0.5, -1, -1, 10);
         
//          //put up servo thingys
//          robot.munchieServo.setPosition(0);
//          robot.dooterServo.setPosition(1);
         
//          encoderDriveV2(0.5, 0.5, 0.5, 10);
        
        
        
        
// }
      
      
      
//           public void mecanum_encoder_drive(double speed,
//                              double leftBackRightInches, double rightBackLeftInches,
//                              double timeoutS) {
//         robot.motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorLeft2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorRight2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         int newLeft_backRight_Target;
//         int newRight_backLeft_Target;

//         if (opModeIsActive()) {

//             newLeft_backRight_Target = robot.motorLeft.getCurrentPosition() + (int)(leftBackRightInches * COUNTS_PER_INCH);
//             newRight_backLeft_Target = robot.motorRight.getCurrentPosition() + (int)(rightBackLeftInches * COUNTS_PER_INCH);
            
//             robot.motorLeft.setTargetPosition(newLeft_backRight_Target);
//             robot.motorRight.setTargetPosition(newRight_backLeft_Target);
//             robot.motorLeft2.setTargetPosition(newRight_backLeft_Target);
//             robot.motorRight2.setTargetPosition(newLeft_backRight_Target);

//             robot.motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorLeft2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorRight2.setMode(DcMotor.RunMode.RUN_TO_POSITION);


//             runtime.reset();
//             robot.motorLeft.setPower(Math.abs(speed));
//             robot.motorRight.setPower(Math.abs(speed));
//             robot.motorLeft2.setPower(Math.abs(speed));
//             robot.motorRight2.setPower(Math.abs(speed));

//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.motorLeft.isBusy() && robot.motorRight.isBusy())) {

              
//                 telemetry.addData("Path1",  "Running to %7d :%7d", newLeft_backRight_Target,  newRight_backLeft_Target);
//                 // telemetry.addData("Path",  "Running at %7d :%7d",
//                         robot.motorLeft.getCurrentPosition();
//                         robot.motorRight.getCurrentPosition();
//                         robot.motorLeft2.getCurrentPosition();
//                         robot.motorRight2.getCurrentPosition();
//                 telemetry.update();
//             }

//             // Stop all motion;
//             robot.motorLeft.setPower(0);
//             robot.motorRight.setPower(0);
//             robot.motorLeft2.setPower(0);
//             robot.motorRight2.setPower(0);

//             // Turn off RUN_TO_POSITION
//             robot.motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//              sleep(500);   // optional pause after each move
//         }
//     }
//       //Place methods here
      
    
//     //Arms?
//     public void armDrive(double speed, double inches, double timeoutS) {
//         //robot.bottomArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//       // robot.bottomArmMotor.setPower(0);
        
//         //robot.bottomArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//          int newLeftTarget;
//          //int newRightTarget;
//         robot.bottomArmMotor.setPower(0);
        
        
 
//         if (opModeIsActive()) {
 
//             newLeftTarget = robot.bottomArmMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH);
//             // newRightTarget = robot.motorRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            
//             //robot.bottomArmMotor.setTargetPosition(newLeftTarget);
           
 
//             robot.bottomArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            
 
 
//             runtime.reset();
//             robot.bottomArmMotor.setPower(Math.abs(speed));
            
 
//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.bottomArmMotor.isBusy())) {
 
              
//             }
 
//             // Stop all motion;
//             robot.bottomArmMotor.setPower(0);
            
 
//             // Turn off RUN_TO_POSITION
//             robot.bottomArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
 
//               sleep(500);
//     }
//     }
    
//     public void drive(double speed, double timeoutS) {
        
//     }
    
//     //Regular wheel drive 
//     public void encoderDriveV2(double speed,
//                              double leftInches, double rightInches,
//                              double timeoutS) {
//         robot.motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorLeft2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.motorRight2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         int newLeftTarget;
//         int newRightTarget;
//         robot.motorLeft.setPower(0);
//         robot.motorRight.setPower(0);
//         robot.motorLeft2.setPower(0);
//         robot.motorRight2.setPower(0);
        
 
//         if (opModeIsActive()) {
 
//             newLeftTarget = robot.motorLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//             newRightTarget = robot.motorRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            
//             robot.motorLeft.setTargetPosition(newLeftTarget);
//             robot.motorRight.setTargetPosition(newRightTarget);
//             robot.motorLeft2.setTargetPosition(newLeftTarget);
//             robot.motorRight2.setTargetPosition(newRightTarget);
 
//             robot.motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorLeft2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.motorRight2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
 
 
//             runtime.reset();
//             robot.motorLeft.setPower(Math.abs(speed));
//             robot.motorRight.setPower(Math.abs(speed));
//             robot.motorLeft2.setPower(Math.abs(speed));
//             robot.motorRight2.setPower(Math.abs(speed));
 
//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.motorLeft.isBusy() && robot.motorRight.isBusy())) {
 
              
//                 // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
//                 // telemetry.addData("Path2",  "Running at %7d :%7d",
//                 //         robot.motorLeft.getCurrentPosition(),
//                 //         robot.motorRight.getCurrentPosition());
//                 //         robot.motorLeft2.getCurrentPosition();
//                 //         robot.motorRight2.getCurrentPosition();
//                 // telemetry.update();
//             }
 
//             // Stop all motion;
//             robot.motorLeft.setPower(0);
//             robot.motorRight.setPower(0);
//             robot.motorLeft2.setPower(0);
//             robot.motorRight2.setPower(0);
 
//             // Turn off RUN_TO_POSITION
//             robot.motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
 
//               sleep(500);   // optional pause after each move
//         }
//     }
    
// }
