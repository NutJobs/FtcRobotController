package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class DIYDetectionTest extends OpenCvPipeline {

    FreightFrenzyHardware robot = new FreightFrenzyHardware();
    private ElapsedTime runtime = new ElapsedTime();
    MecanumEncoderMethods auto = new MecanumEncoderMethods();

    Telemetry telemetry;
    public enum Location {
        SPOTONE,
        SPOTTWO,
        SPOTTHREE
    }
    public boolean stoneLeft;
    public boolean stoneRight;
    public Location location;
    static double PERCENT_COLOR_THRESHOLD = 0.4;
    Mat mat = new Mat();
    /*
    static final Rect LEFT_ROI = new Rect(
            new Point(70,35),
            new Point(115,75));
    static final Rect RIGHT_ROI = new Rect(
            new Point(235,35),
            new Point(275,75));
*/
    static final Rect RIGHT_ROI = new Rect(
            new Point(235,120),
            new Point(275,160));

    static final Rect LEFT_ROI = new Rect(
            new Point(50,120),
            new Point(90,160)
    );
    public DIYDetectionTest(Telemetry t) { telemetry = t; }

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);

          /*==USE THESE TWO SCALRS IF YOU ARE LOOKING FOR TPU BLUE==*/
          /*==TPU BLUE WILL SHOW UP BLACK ON THE CAMERA STREAM==*/
          Scalar lowHSV = new Scalar(0,0,0);
          Scalar highHSV = new Scalar(100,180,180);

//        /*==USE THESE TWO SCALARS IF YOU ARE LOOKING FOR SKYSTONE YELLOW==*/
//        Scalar lowHSV = new Scalar(23,50,70);
//        Scalar highHSV = new Scalar(32,255,255);
////hsv(220,97,60) ignore

        Core.inRange(mat, lowHSV, highHSV, mat);
        Mat left = mat.submat(LEFT_ROI);
        Mat right = mat.submat(RIGHT_ROI);


        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255 ;
        double rightValue = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 255 ;

        left.release();
        right.release();

        telemetry.addData( "Left raw value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Left percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

        stoneLeft = leftValue < PERCENT_COLOR_THRESHOLD;
        stoneRight = rightValue < PERCENT_COLOR_THRESHOLD;

        if ((!(stoneLeft)) && (!(stoneRight))) {
            //not found
            location = Location.SPOTTHREE;
            telemetry.addData("Location", "spot three");
        }else if(stoneLeft) {
            //right
            location = Location.SPOTTWO;
            telemetry.addData("Location","spot two");

        }
        else  if(stoneRight){
            location = Location.SPOTONE;
            telemetry.addData("Location","spot one");
            //left

        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);
//                                      R   G   B
        Scalar colorNoDuck = new Scalar(255, 0, 0 );
        Scalar colorDuck = new Scalar(  0 ,255, 0 );
        Scalar pink = new Scalar(255,0,255);

        Imgproc.rectangle(mat, LEFT_ROI, location ==Location.SPOTONE? pink:colorNoDuck);
        Imgproc.rectangle(mat, RIGHT_ROI, location ==Location.SPOTTWO? colorDuck:colorNoDuck);

        return mat;
    }

    public Location getLocation() {
        return location;
    }
    public boolean isRight() {
        return stoneRight;
    }
    public boolean isLeft() {
        return stoneLeft;
    }
}

