package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
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

 
public class DcMotorExHardwareMap {
    
    // hardwaremap.get(DcMotorEx.class);
    
    //NOT A REAL MOTOR (for testing)
    //public DcMotor motorTest = null;
    //Wheels Driver/motor1
    public DcMotorEx frontLeft = null;
    public DcMotorEx backLeft = null;
    public DcMotorEx frontRight = null;
    public DcMotorEx backRight = null;
    
    public DcMotor arm = null;
    
    public DcMotorEx shooter = null;
    
    
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
    public ColorSensor colorSensor2 = null;
    public ColorSensor colorSensor3 = null;
    // public ColorSensor colorSensor2 = null;
    
    
    
    
    //Arm Thinggggggy
    //public DcMotor bottomArmMotor = null;
    // public DcMotor topArmMotor = null;
    
    // //Servos
    // public Servo davidServo = null;
    // public Servo hazzardServo = null;
    // public Servo gretaServo = null;
    // public Servo tomServo = null;
    public Servo munchie = null;
    // public Servo dooterServo = null;
    
    
    //TEST SERVO
  // public Servo servoTest = null;
    
    //Servo Stuffs
    //public Servo wristServo = null;
    //public Servo fingerServo = null;
    
    // RIP Yeeeeeeeeeeeeeeeeeeeeeeet
    
    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
  
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

    //encoderDrive (gold_our_crater)
  // public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
       
    int newLeftTarget;
    int newRightTarget;

    // if (opModeIsActive()) {

        // Define and Initialize Motors
        
        frontLeft = hwMap.get(DcMotorEx.class, "frontLeft");
        backLeft = hwMap.get(DcMotorEx.class, "backLeft");
        frontRight = hwMap.get(DcMotorEx.class, "frontRight");
        backRight = hwMap.get(DcMotorEx.class, "backRight");
        // bottomArmMotor = hwMap.get(DcMotor.class, "bottomArmMotor");
        // topArmMotor = hwMap.get(DcMotor.class, "topArmMotor");
        
        arm = hwMap.get(DcMotor.class, "arm");
        
        collector = hwMap.get(DcMotor.class, "collector");
        // collectorRight = hwMap.get(DcMotor.class, "collectorRight");
        // shooter2 = hwMap.get(DcMotor.class, "shooter2");
        shooter = hwMap.get(DcMotorEx.class, "shooter");
        ramp = hwMap.get(DcMotor.class, "ramp");
        // wobble = hwMap.get(DcMotor.class, "wobble");
        // hazzardServo = hwMap.get(Servo.class, "hazzardServo");
        // gretaServo = hwMap.get(Servo.class, "gretaServo");
        // tomServo = hwMap.get(Servo.class, "tomServo");
        munchie = hwMap.get(Servo.class, "munchie");
        // dooterServo = hwMap.get(Servo.class, "dooterServo");
        //Webcam1 = hwMap.get(WebcamName.class, "Webcam1");
        
        colorSensor2 = hwMap.get(ColorSensor.class, "colorSensor2");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        colorSensor3 = hwMap.get(ColorSensor.class, "colorSensor3");
        // colorSensor2 = hwMap.get(ColorSensor.class, "colorSensor2");

    frontLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
    frontRight.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
    backLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
    backRight.setDirection(DcMotor.Direction.REVERSE);
   
    // collectorRight.setDirection(DcMotor.Direction.REVERSE);
    // collectorLeft.setDirection(DcMotor.Direction.FORWARD);
    
    
    
       
                frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        // collectorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // collectorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
    }
        
}
//}
