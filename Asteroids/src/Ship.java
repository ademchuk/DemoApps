import java.awt.*;

/**
 * Created by User1 on 11/3/2015.
 */
public class Ship extends MovableObject {

    public Ship(int xPos, int yPos) {
        super(xPos, yPos, 0, new int[]{0, 5, 10, 5}, new int[]{30, 0, 30, 25});
    }

    public void draw(Graphics g) {
        int[][] Points;
        Points = recalculatePosition();
        g.drawPolygon(Points[0], Points[1], xPoints.length);
    }

    public int[][] recalculatePosition() {
        int[][] x = new int[2][];
        x[0] = new int[xPoints.length];
        x[1] = new int[xPoints.length];

        transpose(x,5,15,false);
        rotateShip(x);
        transpose(x,5,15,false);

        //move obj to required position
        for (int i = 0; i < xPoints.length; i++) {
            x[0][i] += xPos;
            x[1][i] += yPos;
        }

        return x;
    }

    public void rotateShip(int[][] x) {
//      for object rotation
//        x' = x cos f - y sin f
//        y' = y cos f + x sin f
        for (int i = 0; i < xPoints.length; i++) {
            //TODO - need to rotate about the mid
            x[0][i] = (int) (xPoints[i] * Math.cos(rotationAngle) - yPoints[i] * Math.sin(rotationAngle));
            x[1][i] = (int) (yPoints[i] * Math.cos(rotationAngle) + xPoints[i] * Math.sin(rotationAngle));
        }
    }

    public void transpose (int [][] points, int xCenter, int yCenter, boolean reverseTranspose) {
        if (!reverseTranspose) {
            for (int i = 0; i < points[0].length; i++) {
                points[0][i] -= xCenter;
                points[1][i] -= yCenter;
            }
        }else {
                for (int i = 0; i < points[0].length; i++ ) {
                    points[0][i] += xCenter;
                    points[1][i] += yCenter;
                }
            }
        }

}
