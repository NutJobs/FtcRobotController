// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;

// //import com.qualcomm.hardware.ams.AMSColorSensor0;
// import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;

 
// public class SkyStoneHardware1 {
    
//     //NOT A REAL MOTOR (for testing)
//     public DcMotor motorTest = null;
//     //Wheels Driver/motor1
//     public DcMotor motorLeft = null;
//     public DcMotor motorLeft2 = null;
//     public DcMotor motorRight = null;
//     public DcMotor motorRight2 = null;
    
    
//     public DcMotor collectorRight = null;
//     public DcMotor collectorLeft = null;
    
//     //Color sensor
//     // public ColorSensor colorSensor = null;
//     // public ColorSensor colorSensor2 = null;
    
    
    
    
//     //Arm Thinggggggy
//     public DcMotor bottomArmMotor = null;
//     public DcMotor topArmMotor = null;
    
//     //Servos
//     public Servo davidServo = null;
//     public Servo hazzardServo = null;
//     public Servo gretaServo = null;
//     public Servo tomServo = null;
//     public Servo munchieServo = null;
//     public Servo dooterServo = null;
    
    
//     //TEST SERVO
//     public Servo servoTest = null;
    
//     //Servo Stuffs
//     //public Servo wristServo = null;
//     //public Servo fingerServo = null;
    
//     // RIP Yeeeeeeeeeeeeeeeeeeeeeeet
    
//     /* Local OpMode members. */
//     HardwareMap hwMap  = null;
//     private ElapsedTime period  = new ElapsedTime();

//     /* Constructor */
  
//     /* Initialize standard Hardware interfaces */
//     public void init(HardwareMap ahwMap) {
//         // save reference to HW Map
//         hwMap = ahwMap;

//     //encoderDrive (gold_our_crater)
//     // public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
       
//     // int newLeftTarget;
//     // int newRightTarget;

//     // if (opModeIsActive()) {

//         // Define and Initialize Motors
        
//         motorLeft = hwMap.get(DcMotor.class, "motorLeft");
//         motorLeft2 = hwMap.get(DcMotor.class, "motorLeft2");
//         motorRight = hwMap.get(DcMotor.class, "motorRight");
//         motorRight2 = hwMap.get(DcMotor.class, "motorRight2");
//         bottomArmMotor = hwMap.get(DcMotor.class, "bottomArmMotor");
//         topArmMotor = hwMap.get(DcMotor.class, "topArmMotor");
        
//         collectorLeft = hwMap.get(DcMotor.class, "collectorLeft");
//         collectorRight = hwMap.get(DcMotor.class, "collectorRight");
//         davidServo = hwMap.get(Servo.class, "davidServo");
//         hazzardServo = hwMap.get(Servo.class, "hazzardServo");
//         gretaServo = hwMap.get(Servo.class, "gretaServo");
//         tomServo = hwMap.get(Servo.class, "tomServo");
//         munchieServo = hwMap.get(Servo.class, "munchieServo");
//         dooterServo = hwMap.get(Servo.class, "dooterServo");
        
//         colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
//         colorSensor2 = hwMap.get(ColorSensor.class, "colorSensor2");

//     motorLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
//     motorRight.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
//     motorLeft2.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
//     motorRight2.setDirection(DcMotor.Direction.REVERSE);
   
//     collectorRight.setDirection(DcMotor.Direction.REVERSE);
//     collectorLeft.setDirection(DcMotor.Direction.FORWARD);
    
    
    
       
//                 motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorLeft2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorRight2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                 motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//       motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
//         collectorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//         collectorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
//     }
        
// }
