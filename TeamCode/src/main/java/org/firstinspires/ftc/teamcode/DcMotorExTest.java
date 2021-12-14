// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.DcMotorEx;
// import com.qualcomm.robotcore.hardware.PIDFCoefficients;
// //import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// //import com.qualcomm.robotcore.hardware.ColorSensor;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import java.lang.annotation.Target;
// import java.util.Timer;
// import com.qualcomm.robotcore.robot.Robot;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
// //import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
// import com.qualcomm.robotcore.hardware.ColorSensor;
// //import com.qualcomm.robotcore.hardware.DcMotorEx;
// import org.firstinspires.ftc.robotcore.external.ClassFactory;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
// import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
// //import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
// import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
// import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
// import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
// import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
// import java.util.List;


// import com.qualcomm.robotcore.hardware.Blinker;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.Gyroscope;



    

// public class DcMotorExTest extends LinearOpMode {
    
//     // SkyStoneHardware1 robot = new SkyStoneHardware1();
//     private Blinker expansion_Hub_2;
    
//     private Gyroscope imu;
//     private ElapsedTime runtime = new ElapsedTime();
// // IMPORTANT: If you are using a USB WebCam, you must select CAMERA_CHOICE = BACK; and
// //PHONE_IS_PORTRAIT = false;
// //private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
// //private static final boolean PHONE_IS_PORTRAIT = false ;
// //private static final String TFOD_MODEL_ASSET = &quot;UltimateGoal.tflite&quot;;
// //private static final String LABEL_FIRST_ELEMENT = &quot;Quad&quot;;
// //private static final String LABEL_SECOND_ELEMENT = &quot;Single&quot;;
// public static final double NEW_P = 200;//base value 10
// public static final double NEW_I = 0;//base value 3
// public static final double NEW_D = 0;//base value 0
// public static final double NEW_F = 0;//base value 0

// @Override public void runOpMode() {
// PIDFCoefficients pidNew = new PIDFCoefficients(NEW_P, NEW_I, NEW_D, NEW_F);
// robot.init(hardwareMap);
// robot.fw.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidNew);
// PIDFCoefficients pidModified =
// robot.fw.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);
//     }
// }
