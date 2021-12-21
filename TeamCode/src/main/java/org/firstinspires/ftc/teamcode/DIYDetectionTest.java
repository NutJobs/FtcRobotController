package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class DIYDetectionTest extends OpenCvPipeline {
    Telemetry telemetry;
    public enum Location {
        LEFT,
        RIGHT,
        NOT_FOUND
    }
    private Location location;
    static double PERCENT_COLOR_THRESHOLD = 0.4;
    Mat mat = new Mat();
    static final Rect LEFT_ROI = new Rect(
            new Point(75,35),
            new Point(120,75));
    static final Rect RIGHT_ROI = new Rect(
            new Point(240,35),
            new Point(280,75));

    public DIYDetectionTest(Telemetry t) { telemetry = t; }

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(23,50,70);
        Scalar highHSV = new Scalar(32,255,255);


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

        boolean stoneLeft = leftValue > PERCENT_COLOR_THRESHOLD;
        boolean stoneRight = rightValue > PERCENT_COLOR_THRESHOLD;

        if (stoneLeft && stoneRight) {
            //not found
            location = Location.NOT_FOUND;
            telemetry.addData("Location", "not found");
        }else if(stoneLeft) {
            //right
            location = Location.LEFT;
            telemetry.addData("Location","left");
        }
        else {
            location = Location.RIGHT;
            telemetry.addData("Location","right");
            //left
        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar colorNoDuck = new Scalar(255, 0,0 );
        Scalar colorDuck = new Scalar(0,255,0);

        Imgproc.rectangle(mat, LEFT_ROI, location ==Location.LEFT? colorDuck:colorNoDuck);
        Imgproc.rectangle(mat, RIGHT_ROI, location ==Location.RIGHT? colorDuck:colorNoDuck);

        return mat;
    }

    public Location getLocation() {
        return location;
    }
}
