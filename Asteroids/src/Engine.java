import java.awt.*;

import static java.lang.Math.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Engine {

    public void calculateCollisions() {

    }

    public void move() {

    }

    public static void rotateObject(int[] defaultX, int defaultY[], double rotateAngle, int[] resultX, int[] resultY) {
        for (int i = 0; i < defaultX.length; i++ ) {
            resultX[i] = (int) ((defaultX[i] * Math.cos(rotateAngle)) - (defaultY[i] * Math.sin(rotateAngle)));
            resultY[i] = (int) ((defaultY[i] * Math.cos(rotateAngle)) - (defaultX[i] * Math.sin(rotateAngle)));
        }


    }
}
