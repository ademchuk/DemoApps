import java.awt.*;

/**
 * Created by User1 on 11/4/2015.
 */
public class MovableObject {
    //TODO - Figure out what to do with this shit
    int xPos, yPos;

    double rotationAngle;

    int[] xPoints;
    int[] yPoints;

    public MovableObject(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotationAngle = rotationAngle;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
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
//      for object rotation
//        x' = x cos f - y sin f
//        y' = y cos f + x sin f

        //move obj to required position
        for (int i = 0; i < xPoints.length; i++) {
            x[0][i] += xPos;
            x[1][i] += yPos;
        }
        return x;
    }
}
