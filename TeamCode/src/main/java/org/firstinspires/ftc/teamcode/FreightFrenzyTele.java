package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
//import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
//import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import java.util.List;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@TeleOp(name="FreightFrenzyTele", group="Drive programms")  // @Autonomous(...) is the other common choice

public class FreightFrenzyTele extends LinearOpMode {
    double rotations;
public boolean shooterOn;
private ElapsedTime runtime = new ElapsedTime();
private ElapsedTime lftbmpr = new ElapsedTime();
  FreightFrenzyHardware robot = new FreightFrenzyHardware();
    private DistanceSensor sensorRange;
    // @Override
    public void runOpMode() throws InterruptedException{
          robot.init(hardwareMap);
    telemetry.addData("Status", "Initialized");
    telemetry.update();


    
    waitForStart();
    runtime.reset();
    lftbmpr.reset();
    
    double frontright;
    double frontleft;
    double backright;
    double backleft2;
    double wheelMotor; 
    double elbowMotor;
    
    
    // double BottomArm;
    // double upperarm;
    float Left;
    float Right;
    float Left2;
    float Right2;
    
    double blue = 0;
    
    double switch1 = 0;
    
    double switch2 = 0;

    while (opModeIsActive()) {
        
        

if(Math.abs(gamepad1.left_stick_y)>0.2 || Math.abs(gamepad1.right_stick_y)>0.2 || Math.abs(gamepad1.left_stick_x)>0.2){
      Left = -gamepad1.left_stick_y + gamepad1.left_stick_x;
      Right = -gamepad1.right_stick_y - gamepad1.left_stick_x;
      Left2 = -gamepad1.left_stick_y - gamepad1.left_stick_x;
      Right2 = -gamepad1.right_stick_y + gamepad1.left_stick_x;
     }
     
     else{
      Left = 0;
      Right = 0;
      Left2 = 0;
      Right2 = 0;
     }
    
    //wheels slow
     if(gamepad1.left_bumper){
     robot.frontLeft.setPower(Left*.25);
     robot.frontRight.setPower(Right*.25);
     robot.backLeft.setPower(Left2*.25);
     robot.backRight.setPower(Right2*.25);
     }
     //wheels fast
     if(gamepad1.right_bumper){
     robot.frontLeft.setPower(Left);
     robot.frontRight.setPower(Right);
     robot.backLeft.setPower(Left2);
     robot.backRight.setPower(Right2);
     }
    
     else{
    //wheels normal
     robot.frontLeft.setPower(Left * 0.5);
     robot.frontRight.setPower(Right * 0.5);
     robot.backLeft.setPower(Left2 * 0.5);
     robot.backRight.setPower(Right2 * 0.5);
     }
    
    telemetry.addData("Left", robot.frontLeft.getCurrentPosition());
    telemetry.addData("Left2", robot.backLeft.getCurrentPosition());
    telemetry.addData("Right", robot.frontRight.getCurrentPosition());
    telemetry.addData("Right2", robot.backRight.getCurrentPosition());
    
    // if(gamepad1.a) {
    //     robot.liftMotor.setPower(1);
    // }
    // else{
    //     robot.liftMotor.setPower(0);
    // }
    //gamePad2
    // if(Math.abs(gamepad2.left_stick_y)>0.2  || Math.abs(gamepad2.left_stick_y)<-0.2 ){ //|| Math.abs(gamepad2.right_stick_x)>0.5){
    
    //   //robot.elbowMotor.setPower(0.25); //+ gamepad2.right_stick_y;
    //   //robot.liftMotor.setPower((gamepad2.left_stick_y ));
    //   robot.liftMotor.setPower(-gamepad2.left_stick_y + gamepad2.left_stick_y);
    //   //robot.elbowMotor.setPower(-gamepad1.right_stick_y + gamepad1.left_stick_x);
    
    //  }else{
    //   robot.liftMotor.setPower(0);
    // //   robot.topArmMotor.setPower(0);
    // //   Right = 0;
    // //   Left2 = 0;
    // //   Right2 = 0;
    //  }
     
     if(Math.abs(gamepad2.right_stick_y)>0.2 || Math.abs(gamepad2.right_stick_y)<-0.2){
         robot.armMotor.setPower((-gamepad2.right_stick_y - gamepad2.right_stick_x));
     } else {
         robot.armMotor.setPower(0);
     }
     
     if (gamepad2.y) {
        robot.collectorServo.setPosition(1);
         robot.fingerServo.setPosition(0);
     
     } else if (gamepad2.a) {
         robot.collectorServo.setPosition(0);
         robot.fingerServo.setPosition(1);
     } else {
         robot.collectorServo.setPosition(0.5);
         robot.fingerServo.setPosition(0.5);
     }
     
     if (gamepad2.x) {
         robot.wheelMotor.setPower(1);
     } else {
         robot.wheelMotor.setPower(0);
     }
     
     if (gamepad2.b) {
         robot.wheelMotor.setPower(-1);
     } else {
         robot.wheelMotor.setPower(0);
     }
     
     if(gamepad2.dpad_up) {
         robot.liftMotor.setPower(-1);
     } else {
         robot.liftMotor.setPower(0);
     }
     
     if (gamepad2.dpad_down) {
         robot.liftMotor.setPower(1);
     } else {
         robot.liftMotor.setPower(0);
     }
     
    //  if (gamepad2.dpad_right) {
    //      robot.markerServo.setPosition(1);
    //  }
     
    //  if (gamepad2.dpad_left) {
    //      robot.markerServo.setPosition(0);
    //  }
     

}
 
}

}