package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous(name="TestingDriveMethods", group="2020/2021 auto programms")
public class TestingDriveMethods extends LinearOpMode {
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
        robot.init(hardwareMap);
        auto.init();

        waitForStart();
    }
    public void encoderDriveV2(double speed,
                               double leftInches, double rightInches,
                               double timeoutS,boolean brake) {
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

            newLeftTarget = robot.frontLeft.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.frontRight.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

            robot.frontLeft.setTargetPosition(newLeftTarget);
            robot.frontRight.setTargetPosition(newRightTarget);
            robot.backLeft.setTargetPosition(newLeftTarget);
            robot.backRight.setTargetPosition(newRightTarget);

            robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            runtime.reset();
            robot.frontLeft.setPower(Math.abs(0.1));
            robot.frontRight.setPower(Math.abs(0.1));
            robot.backLeft.setPower(Math.abs(0.1));
            robot.backRight.setPower(Math.abs(0.1));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {
                double percentL1 = (robot.frontLeft.getCurrentPosition() / newLeftTarget);
                double percentL2 = (robot.backLeft.getCurrentPosition() / newLeftTarget);
                double percentR2 = (robot.backRight.getCurrentPosition() / newLeftTarget);
                double percentR1 = (robot.frontRight.getCurrentPosition() / newLeftTarget);
                double modL1 = 0;
                double modL2 = 0;
                double modR1 = 0;
                double modR2 = 0;
                if (percentL1 < .50) {
                    modL1 = percentL1 * 2;
                } else {
                    modL1 = 1 / percentL1 / 2;
                }
                if (percentL2 < .50) {
                    modL2 = percentL2 * 2;
                } else {
                    modL2 = 1 / percentL2 / 2;
                }
                if (percentR1 < .50) {
                    modR1 = percentR1 * 2;
                } else {
                    modR1 = 1 / percentR1 / 2;
                }
                if (percentL2 < .50) {
                    modR2 = percentR2 * 2;
                } else {
                    modR2 = 1 / percentR2 / 2;
                }

                robot.frontLeft.setPower(Math.abs(speed) * modL1);
                robot.frontRight.setPower(Math.abs(speed) * modR1);
                robot.backLeft.setPower(Math.abs(speed) * modL2);
                robot.backRight.setPower(Math.abs(speed) * modR2);
                // telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                // telemetry.addData("Path2",  "Running at %7d :%7d",
                //         robot.motorLeft.getCurrentPosition(),
                //         robot.motorRight.getCurrentPosition());
                //         robot.motorLeft2.getCurrentPosition();
                //         robot.motorRight2.getCurrentPosition();
                // telemetry.update();
            }

            // Stop all motion;
            if (brake) {
                robot.frontLeft.setPower(0);
                robot.frontRight.setPower(0);
                robot.backLeft.setPower(0);
                robot.backRight.setPower(0);
            }
            // Turn off RUN_TO_POSITION
            robot.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            if (brake) {
                sleep(500);// optional pause after each move
            }else{
                sleep(200);
            }
            }
        }
        //mec time
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
                 robot.frontLeft.setPower(Math.abs(0.1));
                robot.frontRight.setPower(Math.abs(0.1));
                  robot.backLeft.setPower(Math.abs(0.1));
                 robot.backRight.setPower(Math.abs(0.1));

                while (opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (robot.frontLeft.isBusy() && robot.frontRight.isBusy())) {

                     robot.frontLeft.setPower(Math.abs(speed));
                    robot.frontRight.setPower(Math.abs(speed));
                      robot.backLeft.setPower(Math.abs(speed));
                     robot.backRight.setPower(Math.abs(speed));
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
}
