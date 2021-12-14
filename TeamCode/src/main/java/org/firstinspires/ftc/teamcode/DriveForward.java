// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;

// @Autonomous(name="DriveForward", group="2020/2021 auto programms") 
// public class DriveForward extends LinearOpMode {
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
    
//     UltimateGoalHardware robot = new UltimateGoalHardware();
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

// public void runOpMode() throws InterruptedException {
//     robot.init(hardwareMap);
//     waitForStart();

//     // todo: write your code here
//     while (opModeIsActive()) {
//         encoderDriveV2(0.5, 20, 20, 10);
//         sleep(2000000);
//     }
    

// }
//      public void encoderDriveV2(double speed,
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
                        
//                         if (opModeIsActive()) {
 
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
// }
//             // //Stop all motion;
//             robot.frontLeft.setPower(0);
//             robot.frontRight.setPower(0);
//             robot.backLeft.setPower(0);
//             robot.backRight.setPower(0);
 
//             // Turn off RUN_TO_POSITION
//             robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//             robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        
                        
                        
//                              }
                        
                        
//                              }                      
// }