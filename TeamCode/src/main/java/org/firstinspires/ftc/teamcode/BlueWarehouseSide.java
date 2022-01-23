package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;


@Autonomous(name="BlueWarehouseSide", group="2020/2021 auto programms")
public class BlueWarehouseSide extends LinearOpMode {
    OpenCvCamera phoneCam;
    private int blockState1 = 0;
    private int blockState = 0;
    //private enum detectState {
    //     spotONE,
    //     spotTWO,
    //     spotTHREE
    // }
    //detectState dtState;
    private DistanceSensor sensorRange;
    private DistanceSensor sensorRange2;
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";
    public int Timer = 10001;
    public int Threshold = 10000;
    public int didItDo = 0;
    public String Ring = "blahblah";
    public int Attempts = 0;
    public String Labels = "";
    public int colorAttempts = 0;
    // color sensor stuff (declarations)
    final double SCALE_FACTOR = 255;
    float hsvValues[] = {0F, 0F, 0F};
    final float values[] = hsvValues;
    int isRing = 2; /* 1 = yes | 0 = no */
    double ringColor;
    double ringRGB;
    double ringMinus2;
    double ringPlus2;
    public int button = 0;

    public int green = 0;
    public int green2 = 0;
    public int red = 0;
    public int red2 = 0;
    public int blue = 0;
    public int blue2 = 0;

    public int green3 = 0;
    public int red3 = 0;
    public int blue3 = 0;
    public int green4 = 0;
    public int red4 = 0;
    public int blue4 = 0;

    public int color = 0;
    public int redarm = 0;

    FreightFrenzyHardware robot = new FreightFrenzyHardware();
    private ElapsedTime runtime = new ElapsedTime();
    MecanumEncoderMethods auto = new MecanumEncoderMethods();



    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 4);
    static final double     DRIVE_SPEED             = 0.5;
    static final double     TURN_SPEED              = 0.3;
    static final double     FORWARD_SPEED           = 0.7;
    static final double     UNLATCH_SPEED           = 0.8;
    static final double     LOWER_SPEED             = 1.0;
    static final double     LEFT                    = 0.5;
    static final double     RIGHT                   = 0.5;
    static final double     LEFT2                   = 0.5;
    static final double     RIGHT2                  = 0.5;



    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = (int)hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        //FreightFrenzyHardware robot = new FreightFrenzyHardware();
        DIYDetectionTest detector = new DIYDetectionTest(telemetry);

        phoneCam.setPipeline(detector);
        phoneCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                phoneCam.startStreaming(320, 240, OpenCvCameraRotation.SIDEWAYS_LEFT);
            }

            @Override
            public void onError(int errorCode) {

            }


        });

        robot.init(hardwareMap);
        auto.init();
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        //DIYDetectionTest.Location L = detector.getLocation();
        waitForStart();
//==========code here==========\\
        while (opModeIsActive()) {

            //DIYDetectionTest.Location L = detector.getLocation();
            sleep(100);
            if ((detector.isRight())){
                //spot two
                blockState = 1;
            }if((detector.isLeft())){
                //spot one
                blockState = 2;
            }if((!(detector.isLeft()))&&(!(detector.isRight()))) {
                blockState = 3;
                //detector.getLocation() should be spot three
                //spot three
            }
            sleep(200);
            //if pointed straight at barcode, do these
            //(0.2, 1.8,1.8,10);
            //encoderDriveV2(0.2, -3.2,3.2,10);

            //if sideways, do these
            blockState1 = blockState;
            telemetry.addData("Location: ",detector.getLocation());
            telemetry.addData("BlockState: ",blockState);
            telemetry.addData("BlockState1: ", blockState1);
            telemetry.update();
            sleep(200);
            if(blockState1 == 1) {
                //move up like 5cm
                robot.liftMotor.setPower(1);
                sleep(350);
                robot.liftMotor.setPower(0);


            }else if(blockState1 == 2) {
                //move up like 6in
                robot.liftMotor.setPower(1);
                sleep(1000);
                robot.liftMotor.setPower(0);

            }else if(blockState1 == 3) {
                //move up like 9in
                robot.liftMotor.setPower(1);
                sleep(1600);
                robot.liftMotor.setPower(0);

            }
            robot.frontRight.setPower(-0.3);
            robot.backRight.setPower(-0.3);
            sleep(1400);
            robot.frontRight.setPower(0);
            robot.backRight.setPower(0);
            sleep(300);
            mecanum_encoder_drive(0.3, -2.8,2.8,10);
            sleep(300);
            encoderDriveV2(0.2,4.75,4.75,10);
            encoderDriveV2(0.2,3,-3,10);

            encoderDriveV2(0.1,-0.6,-0.6,1.5);
            mecanum_encoder_drive(0.2,-2,2,10);
            encoderDriveV2(0.2,1.25,1.25,10);
            encoderDriveV2(0.2,0.3,-0.3,10);
            robot.elevMotor.setPower(-1);
            sleep(800);
            robot.elevMotor.setPower(0);
            encoderDriveV2(0.3, -1.25,-1.25,10);
            encoderDriveV2(0.3,-3,3,10);
            encoderDriveV2(0.2,-8.2,-8.2,3);
            mecanum_encoder_drive(0.2,-2,2,10);
            encoderDriveV2(0.2,-1,-1,1.5);
            mecanum_encoder_drive(0.2,-1.5,1.5,1.5);
            encoderDriveV2(0.2,-1,-1,1.5);
            mecanum_encoder_drive(0.3, -7,7,10);


            sleep(1900000000);

        }

    }
    public void mecanum_encoder_drive(double speed,
                                      double leftBackRightInches, double rightBackLeftInches,
                                      double timeoutS) {
        robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        int newLeft_backRight_Target;
        int newRight_backLeft_Target;

        if (opModeIsActive()) {

            newLeft_backRight_Target = robot.frontLeft.getCurrentPosition() + (int)(leftBackRightInches * COUNTS_PER_INCH);
            newRight_backLeft_Target = robot.frontRight.getCurrentPosition() + (int)(rightBackLeftInches * COUNTS_PER_INCH);

            robot.frontLeft.setTargetPosition(newLeft_backRight_Target);
            robot.frontRight.setTargetPosition(newRight_backLeft_Target);
            robot.backLeft.setTargetPosition(newRight_backLeft_Target);
            robot.backRight.setTargetPosition(newLeft_backRight_Target);

            robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            runtime.reset();
            robot.frontLeft.setPower(Math.abs(speed));
            robot.frontRight.setPower(Math.abs(speed));
            robot.backLeft.setPower(Math.abs(speed));
            robot.backRight.setPower(Math.abs(speed));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {


                telemetry.addData("Path1",  "Running to %7d :%7d", newLeft_backRight_Target,  newRight_backLeft_Target);
                // telemetry.addData("Path",  "Running at %7d :%7d",
                robot.frontLeft.getCurrentPosition();
                robot.frontRight.getCurrentPosition();
                robot.backLeft.getCurrentPosition();
                robot.backRight.getCurrentPosition();
                telemetry.update();
            }

            // Stop all motion;
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(500);   // optional pause after each move
        }
    }
    public void encoderDriveV2(double speed,
                               double leftInches, double rightInches,
                               double timeoutS) {
        robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        int newLeftTarget;
        int newRightTarget;
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);


        if (opModeIsActive()) {

            newLeftTarget = robot.frontLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.frontRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);

            robot.frontLeft.setTargetPosition(newLeftTarget);
            robot.frontRight.setTargetPosition(newRightTarget);
            robot.backLeft.setTargetPosition(newLeftTarget);
            robot.backRight.setTargetPosition(newRightTarget);

            robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            runtime.reset();
            robot.frontLeft.setPower(Math.abs(speed));
            robot.frontRight.setPower(Math.abs(speed));
            robot.backLeft.setPower(Math.abs(speed));
            robot.backRight.setPower(Math.abs(speed));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {


                // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                // telemetry.addData("Path2",  "Running at %7d :%7d",
                //         robot.motorLeft.getCurrentPosition(),
                //         robot.motorRight.getCurrentPosition());
                //         robot.motorLeft2.getCurrentPosition();
                //         robot.motorRight2.getCurrentPosition();
                // telemetry.update();
            }

            // Stop all motion;
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(500);   // optional pause after each move
        }
//     }

// }

        /*distanceDrive(0.5, 8, 8, 8);*/

    }
    public void distanceDrive(double maxPower, double leftDistance, double rightDistance, double sensorThreshold){

        robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        int newLeftTarget;
        int newRightTarget;
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);


        if (opModeIsActive()) {

            newLeftTarget = robot.frontLeft.getCurrentPosition() + (int)(leftDistance * COUNTS_PER_INCH);
            newRightTarget = robot.frontRight.getCurrentPosition() + (int)(rightDistance * COUNTS_PER_INCH);

            robot.frontLeft.setTargetPosition(newLeftTarget);
            robot.frontRight.setTargetPosition(newRightTarget);
            robot.backLeft.setTargetPosition(newLeftTarget);
            robot.backRight.setTargetPosition(newRightTarget);

            robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            runtime.reset();
            robot.frontLeft.setPower(maxPower);
            robot.frontRight.setPower(maxPower);
            robot.backLeft.setPower(maxPower);
            robot.backRight.setPower(maxPower);



            if (sensorRange.getDistance(DistanceUnit.INCH) > sensorThreshold) {
                robot.frontLeft.setPower(maxPower*0.75);
                //robot.backLeft.setPower(maxPower);
                robot.frontRight.setPower(maxPower);
                //robot.backRight.setPower(maxPower*.75);
            }
            if (sensorRange.getDistance(DistanceUnit.INCH) > sensorThreshold) {
                robot.frontLeft.setPower(maxPower);
                //robot.backLeft.setPower(maxPower*0.75);
                robot.frontRight.setPower(maxPower*0.75);
                //robot.backRight.setPower(maxPower);
            }
            if (sensorRange2.getDistance(DistanceUnit.INCH) > sensorThreshold) {
                //robot.frontLeft.setPower(maxPower*0.75);
                robot.backLeft.setPower(maxPower);
                //robot.frontRight.setPower(maxPower);
                robot.backRight.setPower(maxPower*.75);
            }
            if (sensorRange2.getDistance(DistanceUnit.INCH) > sensorThreshold) {
                //robot.frontLeft.setPower(maxPower);
                robot.backLeft.setPower(maxPower*0.75);
                //robot.frontRight.setPower(maxPower*0.75);
                robot.backRight.setPower(maxPower);
            }

            /*
            while (opModeIsActive() &&
                  (runtime.seconds() < timeoutS) &&
                  (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {


                // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                // telemetry.addData("Path2",  "Running at %7d :%7d",
                //         robot.motorLeft.getCurrentPosition(),
                //         robot.motorRight.getCurrentPosition());
                //         robot.motorLeft2.getCurrentPosition();
                //         robot.motorRight2.getCurrentPosition();
                // telemetry.update();
            }
            */

            // Stop all motion;
            robot.frontLeft.setPower(-.5);
            robot.frontRight.setPower(-.5);
            robot.backLeft.setPower(-.5);
            robot.backRight.setPower(-.5);
            sleep(10);
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);


            // Turn off RUN_TO_POSITION
            robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(500);   // optional pause after each move
        }





    }
}