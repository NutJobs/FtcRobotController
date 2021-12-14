// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.hardware.ams.AMSColorSensor;
// import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;

 
// public class NutJobsHardwear{
    
//     public DcMotor motorLeft = null;
//     public DcMotor motorLeft2 = null;
//     public DcMotor motorRight = null;
//     public DcMotor motorRight2 = null;
//     public DcMotor collector = null;
    
//     public DcMotor armRight = null;
//     public DcMotor armLeft = null;
//     // public Servo trapdoor = null;
//     public Servo Nutz = null;
//     public DcMotor clasp = null;

//     /* Local OpMode members. */
//     HardwareMap hwMap  = null;
//     private ElapsedTime period  = new ElapsedTime();

//     /* Constructor */
  
//     /* Initialize standard Hardware interfaces */
//     public void init(HardwareMap ahwMap) {
//         // save reference to HW Map
//         hwMap = ahwMap;

//         // Define and Initialize Motors
        
//         motorLeft = hwMap.get(DcMotor.class, "motorLeft");
//         motorLeft2 = hwMap.get(DcMotor.class, "motorLeft2");
//         motorRight = hwMap.get(DcMotor.class, "MotorRight");
//         motorRight2 = hwMap.get(DcMotor.class, "MotorRight2");
//         collector = hwMap.get(DcMotor.class, "Collector");
//         armLeft = hwMap.get(DcMotor.class, "ArmLeft");
//         armRight = hwMap.get(DcMotor.class, "ArmRight");
//         clasp = hwMap.get(DcMotor.class, "clasp");

//     motorLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
//     motorRight.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
//     motorLeft2.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
//     motorRight2.setDirection(DcMotor.Direction.REVERSE);
//     collector.setDirection(DcMotor.Direction.REVERSE);
//     armRight.setDirection(DcMotor.Direction.REVERSE);
//     armLeft.setDirection(DcMotor.Direction.FORWARD);
//     clasp.setDirection(DcMotor.Direction.FORWARD);
    
//         // trapdoor = hwMap.get(Servo.class, "trapdoor");
//       Nutz = hwMap.get(Servo.class, "Nutz");
       
//                 motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorLeft2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//         motorRight2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                 motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//       motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         motorLeft2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//         motorRight2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
//     }
        
// }
