package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import com.qualcomm.robotcore.util.Device;
import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;

//import com.qualcomm.hardware.ams.AMSColorSensor0;
import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
 
public class UltimateGoalHardware {
   
    //NOT A REAL MOTOR (for testing)
    public DcMotor motorTest = null;
    //Wheels Driver/motor1
    public DcMotor frontLeft = null;
    public DcMotor backLeft = null;
    public DcMotor frontRight = null;
    public DcMotor backRight = null;
   
    public DcMotor arm = null;
   
    public DcMotor shooter = null;
    // public DcMotor shooter2 = null;
    public DcMotor ramp = null;
    // public DcMotor wobble = null;
    public DcMotor collector = null;
    // public DcMotor collectorRight = null;
    // public DcMotor collectorLeft = null;
   
    //Camera Vuforia
    //public WebcamName Webcam1 = null;
    // public parameters.cameraName = webcamName;

   
    //Color sensor
    public ColorSensor colorSensor = null;
    // public ColorSensor colorSensor2 = null;
    // public ColorSensor colorSensor3 = null;
   
    // public DistanceSensor wobbleDistance = null;
   
    // public DistanceSensor frontDistanceSensor;
    //Munchie servo holds wobble goals
    public Servo munchie = null;
    //collectorServo pushes last ring up when stuck
    public Servo collectorServo = null;
    //public Servo wheelServo = null;
   
   
    // RIP Yeeeeeeeeeeeeeeeeeeeeeeet
   
    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
 
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

    int newLeftTarget;
    int newRightTarget;

       
        frontLeft = hwMap.get(DcMotor.class, "frontLeft");
        backLeft = hwMap.get(DcMotor.class, "backLeft");
        frontRight = hwMap.get(DcMotor.class, "frontRight");
        backRight = hwMap.get(DcMotor.class, "backRight");
       
        arm = hwMap.get(DcMotor.class, "arm");
       
        collector = hwMap.get(DcMotor.class, "collector");
        shooter = hwMap.get(DcMotor.class, "shooter");
        ramp = hwMap.get(DcMotor.class, "ramp");
        munchie = hwMap.get(Servo.class, "munchie");
        collectorServo = hwMap.get(Servo.class, "collectorServo");
        //wheelServo = hwMap.get(Servo.class, "wheelServo");
       
        // colorSensor2 = hwMap.get(ColorSensor.class, "colorSensor2");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        // colorSensor3 = hwMap.get(ColorSensor.class, "colorSensor3");
       
        //wobbleDistance = hwMap.get(DistanceSensor.class, "wobble Distance");
   
    frontLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
    frontRight.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
    backLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
    backRight.setDirection(DcMotor.Direction.REVERSE);
   
   
   
   
       
                frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       
       
    }
       
}