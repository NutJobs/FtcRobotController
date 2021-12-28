package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class HSVTelemetry extends OpenCvPipeline {
    Telemetry telemetry;
    boolean isPresent;
    Mat mat = new Mat();
    static final Rect rectangleROI= new Rect(
            new Point(75,35),
            new Point(120,75)
    );

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(200,77,40);
        Scalar highHSV = new Scalar(240,117,80);
//hsv(220,97,60) ignore


        return mat;
    }
}
