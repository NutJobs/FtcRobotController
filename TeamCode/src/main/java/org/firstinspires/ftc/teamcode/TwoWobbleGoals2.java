// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

// @Autonomous(name="TwoWobbleGoals2", group="2020/2021 auto programms") 
// public class TwoWobbleGoals2 extends LinearOpMode {
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
//      int isRing = 2; /* 1 = yes | 0 = no */
//      double ringColor;
//      double ringRGB;
//      double ringMinus2;
//      double ringPlus2;
//      public int button = 0;
//      public int red = 0;
//      public int color = 0;
//      public int redarm = 0;
    
//     UltimateGoalHardware robot = new UltimateGoalHardware();
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
        
//         //
//         //Code here 
//         // while (colorAttempts == 0 && opModeIsActive()) {
//         // ringRGB = robot.colorSensor.red();
//         // ringMinus2 = ringRGB-2;
//         // ringPlus2 = ringRGB+2;
//         // sleep(600);
//         // colorAttempts = 1;
//         // }
//         //  encoderDriveV2(0.5, -20, -20, 10);
         
//         // while (button == 0) {
//         // telemetry.addData("Red  ", robot.colorSensor.red());
//         // telemetry.addData("Green", robot.colorSensor.green());
//         // telemetry.addData("Blue ", robot.colorSensor.blue());
//         // telemetry.update(); 
//         // }
       
        
//         // while (tfod == null && opModeIsActive()) {
//         //      encoderDriveV2(0.5, 2, 2, 10);
//         // }

                    
//         //if (opModeIsActive()) {
//           // while (opModeIsActive()) {
           
//           robot.shooter.setPower(-1);
                
//                 robot.collectorServo.setPosition(0);
//                 red = robot.colorSensor.red();
//                 sleep(250);
                
//                 telemetry.addData("red: ", red);
//                 telemetry.update();
                
//                 mecanum_encoder_drive(0.2, 8.5, 8.5, 15);
//                 sleep(400);
//                 //mecanum_encoder_drive(0.2, -8, 8, 15);
//                 // encoderDriveV2(0.5, -15, 15, 15);
//                 // sleep(25000);
//                 // button = 1;
//                 // sleep(20000);
//                 telemetry.addData("red: ", robot.colorSensor.red());
//                 telemetry.update();
//                 //sleep(90000)
                
//                 if (robot.colorSensor.red() > red ) {
//                     sleep(1000);
                     
                        
                        
                        
//                         //sleep(1000);
                        
//                     if (robot.colorSensor.red() > red+10) {
//                         color = 4;
                        
//                         //robot.munchie.setPosition(1);
                        
//                     //    
                    
//                     robot.ramp.setPower(-1);
//                     sleep(300);
                    
//                     // robot.shooter.setPower(-0.5);
//                     encoderDriveV2(0.25, 9, 9, 10);
                    
//                     robot.ramp.setPower(-0.4);
//                     //sleep(1000);
                    
//                     //robot.ramp.setPower(0);
                    
//                     encoderDriveV2(0.5, 0.5, -0.5, 10);
                    
//                      robot.collector.setPower(1);
//                      sleep(2000);
                    
//                     robot.collectorServo.setPosition(1);
                    
//                     //sleep(1800);
//                     //robot.shooter.setPower(-0.8);
//                     //encoderDriveV2(0.25, 10.5, 10.5, 10); 
                    
//                     robot.munchie.setPosition(1);
//                     sleep(700);
                   
                    
//                     robot.collector.setPower(0);
//                     robot.shooter.setPower(0);
                    
                    
                    
//                     encoderDriveV2(0.5, 12, 12, 10);
                        
                    
//                         //mecanum_encoder_drive(0.5,6,6,15);
//                         sleep(250);
                        
//                         //encoderDriveV2(0.3, 3, 3, 10);
                        
//                         // encoderDriveV2(0.2, 4, -4, 10);
//                         // encoderDriveV2(0.2, -4, 4, 10);
                        
//                         //encoderDriveV2(1, 20, 20, 10);
                        
//                         encoderDriveV2(0.2, 2.75, -2.75, 10);
                        
//                         robot.arm.setPower(-0.5);
//                         //sleep(200);
//                         robot.munchie.setPosition(1);
                        
//                     sleep(2000);
                    
//                      robot.munchie.setPosition(0);
                    
//                     robot.arm.setPower(0.5);
//                     // sleep(2000);
                    
                    
                    
                   
                    
//                     encoderDriveV2(0.2, 9.75, -10, 10);
                    
//                     encoderDriveV2(0.2, 2, 2, 10);
                    
//                     robot.arm.setPower(0);
                    
//                     mecanum_encoder_drive(0.25, -9.5, 9.5, 10);
                    
//                     mecanum_encoder_drive(0.25, 2, -2, 10);
                    
//                     //encoderDriveV2(0.5, 3, 3, 10);
                    
//                     encoderDriveV2(0.5, 15.5, 15.5, 10);
                    
//                     robot.arm.setPower(-0.5);
//                     sleep(1700);
                    
//                     robot.munchie.setPosition(1);
//                     sleep(200);
                    
//                     sleep(500);
                    
                    
                    
//                     robot.arm.setPower(0.5);
//                     sleep(600);
                    
//                     robot.arm.setPower(0);
                    
//                     encoderDriveV2(1, -19, -19, 10);
                    
//                     encoderDriveV2(0.75, 13.5, -13.5, 10);
                    
//                     robot.munchie.setPosition(0);
                    
//                     sleep(500);
//                     // robot.arm.setPower(0.5);
//                     // sleep(800);
                    
//                 encoderDriveV2(1, -8, -8, 10);
                
//                 ///////////////////////////////////////////////////////////////

//                     // sleep(1000);
                    
//                     // robot.munchie.setPosition(0);
                    
//                     // robot.arm.setPower(0.5);
//                     // sleep(1500);
//                     //     sleep(1000);
                        
//                     //     encoderDriveV2(0.5, -15, -15, 10);
                        
//                     //blaaaaaaaaaaaaaaaaaaaahhhhhhhh
//                         // encoderDriveV2(0.2, -4, 4, 10);
//                         // encoderDriveV2(0.5, 2, 2, 10);
                        
//                         // encoderDriveV2(0.2, 4, -4, 10);
//                         // encoderDriveV2(0.75, -23, -23, 10);
//                         // encoderDriveV2(0.2, -10, 10, 10);
//                         // encoderDriveV2(0.75, -12, -12, 10);
//                         //mecanum_encoder_drive(0.2, -4, 4, 10);
//                         //mecanum_encoder_drive(0.5, -26, -26, 10);
                        
//                     }  else {
//                         color = 1;
                        
                
//                 robot.ramp.setPower(-1);
//                     sleep(1500);
                
//                 robot.shooter.setPower(-0.5);
//                     encoderDriveV2(0.25, 8.5, 8.5, 10); 
                    
//                     //robot.ramp.setPower(-0.2);
                    
//                     encoderDriveV2(0.2, 0.6, -0.6, 10);
                    
//                     // encoderDriveV2(0.5, 2, 2, 10);
                    
                    
//                     sleep(500);
                    
//                     robot.collector.setPower(1);
//                     robot.shooter.setPower(-0.5);
                    
                    
                    
//                     sleep(1700);
                    
//                     robot.collectorServo.setPosition(0);
//                     sleep(1000);
                    
//                     robot.collectorServo.setPosition(1);
//                     sleep(500);
                    
//                     //mecanum_encoder_drive(0.25, -2, 2, 10);
//                     robot.collector.setPower(0);
//                     robot.shooter.setPower(0);
//                         mecanum_encoder_drive(0.5,5,5,15);
                        
//                         encoderDriveV2(0.2, -0.75, 0.75, 10);
                        
//                         robot.arm.setPower(-0.5);
//                         //sleep(200);
//                         robot.munchie.setPosition(1);
                        
//                     sleep(2000);
                    
//                     robot.arm.setPower(0);
//                     robot.munchie.setPosition(0);
                    
//                     robot.arm.setPower(0.25);
//                     sleep(350);
//                     robot.arm.setPower(0);
//                     // robot.arm.setPower(0.5);
//                     // sleep(75);
                    
//                     encoderDriveV2(0.5, -13, -13, 10);
                    
                    
                    
//                     encoderDriveV2(0.25, -14.9, 14.9, 10);
                    
//                     encoderDriveV2(0.25, -0.25, -0.25, 10);
                    
//                     // robot.arm.setPower(-0.25);
//                     // sleep(750);
                    
//                     //encoderDriveV2(0.25, -2, 2, 10);
                    
//                     robot.arm.setPower(-0.5);
//                     sleep(500);
//                     robot.arm.setPower(0);
                    
//                     sleep(1000);
                    
//                     robot.munchie.setPosition(1);
//                     sleep(1300);
                    
//                     //sleep(900);
                    
//                     // robot.arm.setPower(0.5);
//                     // sleep(700);
                    
//                     //aaaaaaaaaaaaaaaaaaaa
                    
//                     // robot.arm.setPower(0.5);
//                     // sleep(700);
                    
//                     encoderDriveV2(0.5, 15, -15, 10);
                    
//                     encoderDriveV2(0.75, 9, 9, 10);
                    
//                     sleep(800);
                    
//                     mecanum_encoder_drive(0.5, -5, 5, 10);
                    
//                     // robot.arm.setPower(-0.5);
//                     // sleep(700);
                    
//                     robot.munchie.setPosition(0);
                    
//                     robot.arm.setPower(0.5);
//                     sleep(1150);
                    
                    
                    
//                     // robot.arm.setPower(0.5);
//                     // sleep(1500);
                    
                    
//                     // robot.arm.setPower(0);
                    

//                     // sleep(1000);
                    
//                     // robot.munchie.setPosition(0);
                    
//                     // robot.arm.setPower(0.5);
//                     // sleep(1500);
//                     //     sleep(1000);
                        
//                     //     encoderDriveV2(0.2, 0.75, -0.75, 10);
//                     //     robot.ramp.setPower(0);
//                     //     encoderDriveV2(0.5, -6, -6, 10);
                        
//                     //     robot.collector.setPower(1);
                        
//                     //     sleep(1000);
                        
//                     //     robot.collector.setPower(0);
                        
//                     //     robot.shooter.setPower(1);
                        
//                     //     encoderDriveV2(0.5, 1.5, 1.5, 10);
                        
                        
//                     //     robot.collector.setPower(1);
                        
//                     //     sleep(800);
                        
//                     //     robot.shooter.setPower(0);
//                     //     robot.collector.setPower(0);
                        
//                     //     encoderDriveV2(0.3, 2, 2, 10);
                        
//                     //     robot.arm.setPower(-0.5);
//                     //     sleep(1200);
//                     //     robot.arm.setPower(0);
                        
                         
                        
                        
//                     }
//                 }
//                 else {
//                     color = 0;
//                     //redarm = robot.colorSensor3.red();
                    
                    
//                     robot.shooter.setPower(-.5);
                    
//                 //robot.wheelServo.setPosition(1);
                    
//                     robot.ramp.setPower(-1);
                    
//                     encoderDriveV2(0.2, 8.5, 8.5, 10);
                    
//                     encoderDriveV2(0.2, 0.35, -0.35, 10);
                    
                    
                    
//                     robot.collector.setPower(1);
//                     robot.shooter.setPower(-.5);
//                     robot.ramp.setPower(-1);
//                     sleep(2000);
                    
//                     robot.collectorServo.setPosition(0);
//                     sleep(400);
//                     robot.collectorServo.setPosition(1);
                    
//                     sleep(1000);
                    
//                     robot.ramp.setPower(-1);
                    
//                     robot.shooter.setPower(0);
//                     robot.collector.setPower(0);
                    
//                     robot.ramp.setPower(0);
                    
                  
//                     encoderDriveV2(0.5, 3, -3, 10);
//                     // mecanum_encoder_drive(0.2, 3,-3, 10);
//                     sleep(500);
                    
//                      encoderDriveV2(0.5, 2, 2, 10);
                     
//                     robot.arm.setPower(-0.5);
//                         //sleep(200);
//                         robot.munchie.setPosition(1);
                        
//                     sleep(1750);
                    
                    
                    
//                     robot.arm.setPower(0);
                    

//                     sleep(1000);
                    
//                     robot.munchie.setPosition(0);
                    
//                     robot.arm.setPower(0.5);
//                     sleep(500);
                    
//                     robot.arm.setPower(0);
                    
//                     encoderDriveV2(0.5, -2, -2, 10);
                    
//                     // new stuff
//                     encoderDriveV2(0.25, 8.75, -8.75, 10);
                    
                    
                    
//                     //thingy thing
//                     // robot.arm.setPower(-0.5);
//                     // sleep(50);
                    
//                     robot.arm.setPower(0);
                    
//                     //thingy thing2
//                     encoderDriveV2(0.5, 7, 7, 10);
                    
//                     encoderDriveV2(0.2, -1.5, 1.5, 10);
                    
//                     robot.munchie.setPosition(1);
                    
//                     sleep(2000);
                    
//                     robot.arm.setPower(0.5);
//                     sleep(1000);
//                     robot.arm.setPower(0);
                    
//                     encoderDriveV2(0.5, -10, 10, 10);
                    
//                     encoderDriveV2(0.5, 7.5, 7.5, 10);
                    
//                     encoderDriveV2(0.5, -0.5, -0.5, 10);
                    
//                     // robot.arm.setPower(-0.5);
//                     // sleep(1000);
//                     // robot.arm.setPower(0);
                    
//                     robot.munchie.setPosition(0);
                    
//                     robot.arm.setPower(0.5);
//                     sleep(650);
//                     robot.arm.setPower(0);
                    
//                     encoderDriveV2(1, 2.5, 0.25, 10);
                    
//                     mecanum_encoder_drive(1, -7, 7, 10);
                    
//                     //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//                     //encoderDriveV2(1, 4.5, 4.5, 10);
                    
                
//                     // robot.munchie.setPosition(1);
                    
//                     // robot.arm.setPower(-0.5);
//                     // sleep(700);
                    
//                     // robot.arm.setPower(0);
                    
//                     // encoderDriveV2(1, 6, -6, 10);
                    
//                     // encoderDriveV2(1, 6, 6, 10);
                   
                    
//                 }
//                 robot.collectorServo.setPosition(0);
//                 sleep(300);
//                 //out of loop  back up and turn
//                 // mecanum_encoder_drive(0.5, -10, -10, 10);
//                 // mecanum_encoder_drive(0.5, 5, 5, -10);
                
//                 // encoderDriveV2(0.2, -9, 9, 10);
                
                    
//                     //drive up to wobble goal
//                     // sleep(500);
//                     // encoderDriveV2(0.5, 6, 6, 10);
                    
           
//                 // encoderDriveV2(0.5, -6, -6, 10);
//                 // sleep(500);
                
//                 // encoderDriveV2(0.2, 9, -9, 10);
                    
//                 //     sleep(500);
//                 //     mecanum_encoder_drive(0.5, 11, 11, 10);
                
//                 //if(color == 0) {
//                     // encoderDriveV2(0.5, -12, -12, 10);
//                     // encoderDriveV2(0.2, -9, 9, 10);
//                     // encoderDriveV2(0.5, 5, 5, 10);
//                     // encoderDriveV2(0.5, -5, -5, 10);
//                     // encoderDriveV2(0.2, 9, -9, 10);
//                     // encoderDriveV2(0.5, 10.5, 10.5, 10);
//                 //}
                    
//                     //if (color == 4) {
                         
//                         //  encoderDriveV2(0.2, -9, 9, 10);
//                         //  encoderDriveV2(0.5, 5, 5, 10);
//                         //  encoderDriveV2(0.5, -5, -5, 10);
//                         // encoderDriveV2(0.2, 8.75, -8.75, 10);
//                         // encoderDriveV2(1, 24, 24, 10);
//                         // sleep(500);
//                         // encoderDriveV2(0.2, -1.5, -1.5, 10);
//                         // encoderDriveV2(0.5, -9, -9, 10);
//                         // encoderDriveV2(0.5, 14, 14, 10);
                        
//                         // encoderDriveV2(0.5, -12, -12, 10);
//                     //}
                    
//                     //if (color == 1) {
                        
//                         // encoderDriveV2(0.2, -14, 14, 10);
//                         // encoderDriveV2(0.2, 5, 5, 10);
//                         // encoderDriveV2(0.5, -2.5, -2.5, 10);
                        
//                         // encoderDriveV2(0.3, 3, 3, 10);
//                         // mecanum_encoder_drive(0.2,-8,8,15);
//                         // mecanum_encoder_drive(0.3, 3.5, 3.5, 10);
//                         // sleep(500);
//                         // mecanum_encoder_drive(0.3,-3.5,-3.5,10);
//                         // mecanum_encoder_drive(-0.2, 9, -9, 10);
//                         // sleep(500);
//                         // encoderDriveV2(0.2, -1, -1, 10);
//                     //}
                    
                
            
               
                    
//                 // ****DROP WOBBLE GOAL HERE****//
//                 /*
//                 if (tfod != null) {
//                     // getUpdatedRecognitions() will return null if no new information is available since
//                     // the last time that call was made.
                    
//                     List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
//                     // if (updatedRecognitions == null && Attempts == 3) {
                        
//                     //}
//                     if (updatedRecognitions != null) {
//                       telemetry.addData("# Object Detected", updatedRecognitions.size());
                      
                    
//                       // step through the list of recognitions and display boundary info.
//                       int i = 0;
//                       for (Recognition recognition : updatedRecognitions) {
//                         telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
//                         telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
//                                 recognition.getLeft(), recognition.getTop());
//                         telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
//                                 recognition.getRight(), recognition.getBottom());
//                                 if (Timer > 2500 && recognition.getLabel() != "Single" && recognition.getLabel() != "Quad") {
                                  
//                                   Labels = tfod.getUpdatedRecognitions(); 
                                 
//                                 }
//                                 Labels = tfod.getLabel(); 
                                
//                       }
//                       }            
//                                 Timer = 0;
//                                 if (Timer < Threshold) {
//                                     Timer = Timer + 1;
//                                     sleep(1);
//                                     // if (didItDo == 0) {
//                                     //     Ring = "None";
//                                     // }
//                                 }
                                
//                                 else if (Timer > 8000) {
//                                     encoderDriveV2(0.5, -60, -60, 10);
//                                     encoderDriveV2(0.5, -20, 20, 10);
//                                     encoderDriveV2(0.5, -10, -10, 10);
//                                     encoderDriveV2(0.5, 10, 10, 10);
//                                     encoderDriveV2(0.5, 20, -20, 10);
//                                     encoderDriveV2(0.5, 30, 30, 10);
//                                 } 
                      
                      
//                       telemetry.update();
//                     }
                
    
//                      if (Timer == 3000) {
//                     //0 RING HERE
//                     encoderDriveV2(0.5, -16, -16, 10);
//                      tfod = null;
//                     }
//         //     }
//         //     encoderDriveV2(0.5, 2, 2, 10);
//         // }
//         // if () {
//         //      encoderDriveV2(0.5, 2, 2, 10);
//         // }
        
// }
//         // if (tfod != null) {
//         //     tfod.shutdown();
//         // }
//     }
// //}

//     private void initVuforia() {
//         //
//          //* Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
//          //
//         VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

//         parameters.vuforiaLicenseKey = VUFORIA_KEY;
//         parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam1");

//         //  Instantiate the Vuforia engine
//         vuforia = ClassFactory.getInstance().createVuforia(parameters);

//         // Loading trackables is not necessary for the TensorFlow Object Detection engine.
//     }
// */
//     /**
//      * Initialize the TensorFlow Object Detection engine.
//      */
//             //}
//             }
//     private void initTfod() {
//         int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//             "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//         TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
//       tfodParameters.minResultConfidence = 0.8f;
//       tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
//       tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
//     }
//     //Wheel drive
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
        
//         if (runtime.seconds() < 2) {
//             robot.frontLeft.setPower(runtime.seconds()/2);
//             robot.backLeft.setPower(runtime.seconds()/2);
//             robot.frontRight.setPower(runtime.seconds()/2);
//             robot.backRight.setPower(runtime.seconds()/2);
            
//         }
        
 
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
 
//               //sleep(500);   // optional pause after each move
//         }
// //     }
    
// // }
                             
        
                                   
//                              }
//  }