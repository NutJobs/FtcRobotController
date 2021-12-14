// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
// import com.qualcomm.robotcore.hardware.DistanceSensor;
// import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
// import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
// import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
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

// /**
//  * This 2020-2021 OpMode illustrates the basics of using the TensorFlow Object Detection API to
//  * determine the position of the Ultimate Goal game elements.
//  *
//  * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
//  * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list.
//  *
//  * IMPORTANT: In order to use this OpMode, you need to obtain your own Vuforia license key as
//  * is explained below.
//  */

// @Autonomous(name="FreightFrenzyAuto1", group="2020/2021 auto programms") 
// public class FreightFrenzyAuto1 extends LinearOpMode {
//     private DistanceSensor sensorRange;
//     private DistanceSensor sensorRange2;
//     private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
//     private static final String LABEL_FIRST_ELEMENT = "Quad";
//     private static final String LABEL_SECOND_ELEMENT = "Single"; 
//     public int Timer = 10001;
//     public int Threshold = 10000;
//     public int didItDo = 0;
//     public String Ring = "blahblah";
//     public int Attempts = 0;
//     public String Labels = "";
//     public int colorAttempts = 0;
//      // color sensor stuff (declarations)
//      final double SCALE_FACTOR = 255;
//      float hsvValues[] = {0F, 0F, 0F};
//      final float values[] = hsvValues;
//      double ringColor;
//      double ringRGB;
//      double ringMinus2;
//      double ringPlus2;
//      public int button = 0;
//      public int red = 0;
//      public int red2 = 0;
//      public int color = 0;
//      public int redarm = 0;
    
//     FreightFrenzyHardware robot = new FreightFrenzyHardware();
//     private ElapsedTime     runtime = new ElapsedTime();
    
//     MecanumEncoderMethods auto = new MecanumEncoderMethods();
    
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
    
    

//     /*
//      * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
//      * 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
//      * A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
//      * web site at https://developer.vuforia.com/license-manager.
//      *
//      * Vuforia license keys are always 380 characters long, and look as if they contain mostly
//      * random data. As an example, here is a example of a fragment of a valid key:
//      *      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
//      * Once you've obtained a license key, copy the string from the Vuforia web site
//      * and paste it in to your code on the next line, between the double quotes.
//      */
//     private static final String VUFORIA_KEY =
//             "AWOq+Sb/////AAABmR8LgVv9q0czoyIWGYYU/k6GpmDKuquGhPsGgwsceOj2XRTcnDVVM3cBHsvhkm7ExnitUUTB38I28NbOVwL8XH1a8xeAHkDj6sq1P+tRE+b9+IyMt3AUGpuxI9HbBol7LoqjDD9gdTkMzX9UX4k4IYbg6I5a8v5M7VCSwxw4/LLXqx0wLgMLuElQlL/WZCndCc4oGZSNxkdC06PZiQiUUiaZBajRM6ExmrMcBjpzIXCYyKzcaeBeP29rG4TPLs3vdrXTvxuTw0Dm845DJTVvPlD6DmeW32njVdPk4KN3mBdnuYq33BeF5JVtbng1sY8R0IU3qDekxF65G1kg9JUyAR/tFbIwlglNJ0X6msOIN9H/";

//     /**
//      * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
//      * localization engine.
//      */
//     private VuforiaLocalizer vuforia;

//     /**
//      * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
//      * Detection engine.
//      */
//     private TFObjectDetector tfod;

//     @Override
//     public void runOpMode() throws InterruptedException {
//         // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
//         // first.
//         //       public void runOpMode() throws InterruptedException {       
//         robot.init(hardwareMap);
//         // sensorRange = hardwareMap.get(DistanceSensor.class, "sensor_range");
//         // sensorRange2 = hardwareMap.get(DistanceSensor.class, "sensor_range2");
//         //initVuforia();
//         //initTfod();
//         auto.init();
        
        
        

     

        
//         //if (tfod != null) {
//       //     tfod.activate();

            
//       // }
        
//         /** Wait for the game to begin */
//         telemetry.addData(">", "Press Play to start op mode");
//         telemetry.update();
//         waitForStart();
        
//              // robot.collectorServo.setPosition(0);
//                 red = robot.colorSensor1.red();
//                 red2 = robot.colorSensor2.red();
//                 sleep(250);
                
//                 robot.elbowMotor.setPower(0.3);
//                 sleep(1000);
                
//                 mecanum_encoder_drive(0.2, 2, 2, 10);
//                 sleep(250);
                
                        
//                     if (robot.colorSensor1.red() > red) {
//                         // if (colorSensor2.red() > red+4) {
//                         mecanum_encoder_drive(0.1, -3, 3, 10);
                            
//                         robot.elbowMotor.setPower(-0.3);
//                         sleep(800);
                            
//                         robot.wheelMotor.setPower(1);
//                         sleep(700);
                                
//                     } 
//                     else {
//                         robot.frontLeft.setPower(0);
//                     }
//     }
//         // Meccanum Drive
//         public void mecanum_encoder_drive(double speed,
//                              double leftBackRightInches, double rightBackLeftInches,
//                              double timeoutS) {
//         robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         int newLeft_backRight_Target;
//         int newRight_backLeft_Target;

//         if (opModeIsActive()) {

//             newLeft_backRight_Target = robot.frontLeft.getCurrentPosition() + (int)(leftBackRightInches * COUNTS_PER_INCH);
//             newRight_backLeft_Target = robot.frontRight.getCurrentPosition() + (int)(rightBackLeftInches * COUNTS_PER_INCH);
            
//             robot.frontLeft.setTargetPosition(newLeft_backRight_Target);
//             robot.frontRight.setTargetPosition(newRight_backLeft_Target);
//             robot.backLeft.setTargetPosition(newRight_backLeft_Target);
//             robot.backRight.setTargetPosition(newLeft_backRight_Target);

//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


//             runtime.reset();
//             robot.frontLeft.setPower(Math.abs(speed));
//             robot.frontRight.setPower(Math.abs(speed));
//             robot.backLeft.setPower(Math.abs(speed));
//             robot.backRight.setPower(Math.abs(speed));

//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {

              
//                 telemetry.addData("Path1",  "Running to %7d :%7d", newLeft_backRight_Target,  newRight_backLeft_Target);
//                 // telemetry.addData("Path",  "Running at %7d :%7d",
//                         robot.frontLeft.getCurrentPosition();
//                         robot.frontRight.getCurrentPosition();
//                         robot.backLeft.getCurrentPosition();
//                         robot.backRight.getCurrentPosition();
//                 telemetry.update();
//             }

//             // Stop all motion;
//             robot.frontLeft.setPower(0);
//             robot.frontRight.setPower(0);
//             robot.backLeft.setPower(0);
//             robot.backRight.setPower(0);

//             // Turn off RUN_TO_POSITION
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//              sleep(500);   // optional pause after each move
//         }
//     }
//     //Wheel drive
//     public void encoderDriveV2(double speed,
//                              double leftInches, double rightInches,
//                              double timeoutS) {
//         robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         int newLeftTarget;
//         int newRightTarget;
//         robot.frontLeft.setPower(0);
//         robot.frontRight.setPower(0);
//         robot.backLeft.setPower(0);
//         robot.backRight.setPower(0);
        
 
//         if (opModeIsActive()) {
 
//             newLeftTarget = robot.frontLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//             newRightTarget = robot.frontRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            
//             robot.frontLeft.setTargetPosition(newLeftTarget);
//             robot.frontRight.setTargetPosition(newRightTarget);
//             robot.backLeft.setTargetPosition(newLeftTarget);
//             robot.backRight.setTargetPosition(newRightTarget);
 
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
 
 
//             runtime.reset();
//             robot.frontLeft.setPower(Math.abs(speed));
//             robot.frontRight.setPower(Math.abs(speed));
//             robot.backLeft.setPower(Math.abs(speed));
//             robot.backRight.setPower(Math.abs(speed));
 
//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {
 
              
//                 // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
//                 // telemetry.addData("Path2",  "Running at %7d :%7d",
//                 //         robot.motorLeft.getCurrentPosition(),
//                 //         robot.motorRight.getCurrentPosition());
//                 //         robot.motorLeft2.getCurrentPosition();
//                 //         robot.motorRight2.getCurrentPosition();
//                 // telemetry.update();
//             }
 
//             // Stop all motion;
//             robot.frontLeft.setPower(0);
//             robot.frontRight.setPower(0);
//             robot.backLeft.setPower(0);
//             robot.backRight.setPower(0);
 
//             // Turn off RUN_TO_POSITION
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
 
//               sleep(500);   // optional pause after each move
//         }
// //     }
    
// // }
                             
//         /*distanceDrive(0.5, 8, 8, 8);*/
                                   
//                              }
//     public void distanceDrive(double maxPower, double leftDistance, double rightDistance, double sensorThreshold){
    
//         robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         int newLeftTarget;
//         int newRightTarget;
//         robot.frontLeft.setPower(0);
//         robot.frontRight.setPower(0);
//         robot.backLeft.setPower(0);
//         robot.backRight.setPower(0);
        
 
//         if (opModeIsActive()) {
 
//             newLeftTarget = robot.frontLeft.getCurrentPosition() + (int)(leftDistance * COUNTS_PER_INCH);
//             newRightTarget = robot.frontRight.getCurrentPosition() + (int)(rightDistance * COUNTS_PER_INCH);
            
//             robot.frontLeft.setTargetPosition(newLeftTarget);
//             robot.frontRight.setTargetPosition(newRightTarget);
//             robot.backLeft.setTargetPosition(newLeftTarget);
//             robot.backRight.setTargetPosition(newRightTarget);
 
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
 
 
//             runtime.reset();
//             robot.frontLeft.setPower(maxPower);
//             robot.frontRight.setPower(maxPower);
//             robot.backLeft.setPower(maxPower);
//             robot.backRight.setPower(maxPower);
        
                
            
//             if (sensorRange.getDistance(DistanceUnit.INCH) > sensorThreshold) {
//                 robot.frontLeft.setPower(maxPower*0.75);
//                 //robot.backLeft.setPower(maxPower);
//                 robot.frontRight.setPower(maxPower);
//                 //robot.backRight.setPower(maxPower*.75);
//             }
//             if (sensorRange.getDistance(DistanceUnit.INCH) > sensorThreshold) {
//                 robot.frontLeft.setPower(maxPower);
//                 //robot.backLeft.setPower(maxPower*0.75);
//                 robot.frontRight.setPower(maxPower*0.75);
//                 //robot.backRight.setPower(maxPower);
//             }
//             if (sensorRange2.getDistance(DistanceUnit.INCH) > sensorThreshold) {
//                 //robot.frontLeft.setPower(maxPower*0.75);
//                 robot.backLeft.setPower(maxPower);
//                 //robot.frontRight.setPower(maxPower);
//                 robot.backRight.setPower(maxPower*.75);
//             }
//             if (sensorRange2.getDistance(DistanceUnit.INCH) > sensorThreshold) {
//                 //robot.frontLeft.setPower(maxPower);
//                 robot.backLeft.setPower(maxPower*0.75);
//                 //robot.frontRight.setPower(maxPower*0.75);
//                 robot.backRight.setPower(maxPower);
//             }
        
//             /*
//             while (opModeIsActive() &&
//                   (runtime.seconds() < timeoutS) &&
//                   (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {
 
              
//                 // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
//                 // telemetry.addData("Path2",  "Running at %7d :%7d",
//                 //         robot.motorLeft.getCurrentPosition(),
//                 //         robot.motorRight.getCurrentPosition());
//                 //         robot.motorLeft2.getCurrentPosition();
//                 //        robot.motorRight2.getCurrentPosition();
//                 // telemetry.update();
//             }
//             */
 
//             // Stop all motion;
//             robot.frontLeft.setPower(0);
//             robot.frontRight.setPower(0);
//             robot.backLeft.setPower(0);
//             robot.backRight.setPower(0);
 
//             // Turn off RUN_TO_POSITION
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
 
//               sleep(500);   // optional pause after each move
//         }

                             
        
                                   
                                 
//     }
//  }