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

// import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
// import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
// import com.qualcomm.robotcore.hardware.DistanceSensor;

// @Autonomous(name="Telemetry", group="2020/2021 auto programms")
// //@Disabled

// public class Telemetry extends LinearOpMode {
//     public int red1 = 0;
//     public int green1 = 0;
//     public int red2 = 0;
//     public int green2 = 0;
//     public int blue1 = 0;
//     public int blue2 = 0;
//     public int redMax1 = 0;
//     public int greenMax1 = 0;
//     public int redMax2 = 0;
//     public int greenMax2 = 0;
//     public void runOpMode() throws InterruptedException {
        
//           FreightFrenzyHardware robot = new FreightFrenzyHardware();
//           MecanumEncoderMethods auto = new MecanumEncoderMethods();
//         //   wobbleDistance = hardwareMap.get(DistanceSensor.class, "wobbleDistance");
//         //   Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)wobbleDistance;
//         // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
//         // first.
//         //       public void runOpMode() throws InterruptedException {       
//         robot.init(hardwareMap);
//         //initVuforia();
//         //initTfod();
//         auto.init();
//         waitForStart();
//         telemetry.addData("Status", "Initialized");
    
//         //distance = robot.distanceSensor.getDistance(DistanceUnit.CM);
    
//         //red = robot.colorSensor1.getColor(red);
    
//     telemetry.addData(">", "Press Play to start op mode");
//         while (opModeIsActive()) {
    
//         telemetry.update();
        
//          //distance = robot.distanceSensor.distance();
         

//          red1 = robot.colorSensor1.red();
//          green1 = robot.colorSensor1.green();
//          blue1 = robot.colorSensor1.blue();
//          red2 = robot.colorSensor2.red();
//          green2 = robot.colorSensor2.green();
//          blue2 = robot.colorSensor2.blue();
         
//     telemetry.addData("red1: ", red1);
//     telemetry.addData("green1: ", green1);
//     telemetry.addData("blue1: ", blue1);
    
//     telemetry.addData("red2: ", red2);
//     telemetry.addData("green2: ", green2);
//     telemetry.addData("blue2: ", blue2);
//                 telemetry.update();
//         if (red1 < robot.colorSensor1.red()){
//             redMax1 = robot.colorSensor1.red();
//         }else{
//             redMax1 = red1;
//         }
//         if (green1 < robot.colorSensor1.green()){
//             greenMax1 = robot.colorSensor1.green();
//         }else{
//             greenMax1 = green1;
//         }
//     // robot.wobbleDistance.getDistance(DistanceUnit.CM);
    
//     // telemetry.update();
//     // telemetry.addData("DistanceUnit ", robot.wobbleDistance.CM);
//     //             telemetry.update();
//         }
//     }
// }