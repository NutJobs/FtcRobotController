package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import java.util.logging.Level;

@Autonomous(name="DiyDetectTester", group = "Auto")
public class DiyDetectTester extends LinearOpMode {
    OpenCvCamera phoneCam;
    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        FreightFrenzyHardware robot = new FreightFrenzyHardware();
        DIYDetectionTest detector = new DIYDetectionTest(telemetry);

        double frontright;
        double frontleft;
        double backright;
        double backleft2;
        double wheelMotor;
        double elbowMotor;

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
        waitForStart();
        switch (detector.getLocation()) {
            case LEFT:;

            break;
            case RIGHT:;

            break;
            case NOT_FOUND:;



        }
        if ( detector.getLocation() == DIYDetectionTest.Location.LEFT) {
            robot.wheelMotor.setPower(1);
        } else {
            robot.wheelMotor.setPower(0);
        }
        phoneCam.stopStreaming();
}}
