import java.awt.*;
import java.util.Arrays;

/**
 * Created by User1 on 11/4/2015.
 */
public class MovableObject {
    int scale = 1000;
    int xPos, yPos;
    int[] xBuffPoints, yBuffPoints;

    double rotationAngle;

    private int X_ACCELERATION;
    private int Y_ACCELERATION;

    int[] xPoints;
    int[] yPoints;

    GameField gameField;

    public MovableObject(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints, GameField gameField) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotationAngle = rotationAngle;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.gameField = gameField;

    }

    public void draw(Graphics g) {
        move();
        g.drawPolygon(xBuffPoints, yBuffPoints, xPoints.length);
    }

    public void move() {
        xBuffPoints = Arrays.copyOf(xPoints, xPoints.length);
        yBuffPoints = Arrays.copyOf(yPoints, xPoints.length);
        rotate();
        //move obj to required position
        xPos += X_ACCELERATION;
        yPos += Y_ACCELERATION;

        for (int i = 0; i < xBuffPoints.length; i++) {
            xBuffPoints[i] += xPos / scale;
            yBuffPoints[i] += yPos / scale;
        }

    }

    public void rotate() {
        for (int i = 0; i < xBuffPoints.length; i++) {
            xBuffPoints[i] = (int) (-this.xPoints[i] * Math.cos(rotationAngle) + this.yPoints[i] * Math.sin(rotationAngle));
            yBuffPoints[i] = (int) (this.yPoints[i] * Math.cos(rotationAngle) + this.xPoints[i] * Math.sin(rotationAngle));
        }
    }

    public void calculateAngle(int xDestination, int yDestination) {
        long x = xDestination - xPos;
        long y = yDestination - yPos;

        rotationAngle = Math.acos(x/Math.sqrt(x*x+y*y));

        if (y > 0) {
            rotationAngle = 2 * Math.PI - this.rotationAngle;
        }
    }

    public void setX_ACCELERATION(int x_ACCELERATION) {
        X_ACCELERATION = x_ACCELERATION;
    }

    public void setY_ACCELERATION(int y_ACCELERATION) {
        Y_ACCELERATION = y_ACCELERATION;
    }

    public int getX_ACCELERATION() {
        return X_ACCELERATION;
    }

    public int getY_ACCELERATION() {
        return Y_ACCELERATION;
    }

}
