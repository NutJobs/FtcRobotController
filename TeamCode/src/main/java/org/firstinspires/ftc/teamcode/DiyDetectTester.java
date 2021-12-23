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
        int cameraMonitorViewId = (int)hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        FreightFrenzyHardware robot = new FreightFrenzyHardware();
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
        waitForStart();
        double loc = 0;
        switch (detector.getLocation()) {
            case LEFT:
            loc = 1;
            break;
            case RIGHT:
            loc = 2;
            break;
            case NOT_FOUND:
            loc = 0;
            break;
        }
        if (loc == 1) {
            robot.wheelMotor.setPower(1);
        } else if(loc == 2) {
            robot.wheelMotor.setPower(-1);
        } else {
            robot.wheelMotor.setPower(0);
        }
        phoneCam.stopStreaming();
}}
