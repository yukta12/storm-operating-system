
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;

public class Test {
    private JLabel imageView;
    private static JFrame jFrame;
    static{
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat mat = new Mat(10, 20,CvType.CV_8U, new Scalar(12, 13, 14));
        System.out.println("mat.dump() = " + mat.dump());
    }
}



