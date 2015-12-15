import java.awt.*;

/**
 * Created by User1 on 11/4/2015.
 */
public class MovableObject {
    int scale = 1000;
    int size;
    int xPos, yPos;
    //    int[] xBuffPoints, yBuffPoints;
    int[][] buffPoints;
    int liveAfterDeath;

    boolean destroyed;

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
//        xBuffPoints = xPoints.clone();
//        yBuffPoints = yPoints.clone();
        buffPoints = new int[2][];
        buffPoints[0] = xPoints.clone();
        buffPoints[1] = yPoints.clone();
        destroyed = false;

    }

    public void draw(Graphics g) {
        g.drawPolygon(buffPoints[0], buffPoints[1], xPoints.length);
        if (destroyed) {
            if (liveAfterDeath > 0) {
                liveAfterDeath--;
            }  else {
                gameField.asteroids.remove(this);
            }
        }
    }

    public void move() {
        //move obj to required position
        xPos += X_ACCELERATION;
        yPos += Y_ACCELERATION;
        recalcPolygon();
    }

    public void recalcPolygon() {
//        xBuffPoints = Arrays.copyOf(xPoints, xPoints.length);
//        yBuffPoints = Arrays.copyOf(yPoints, xPoints.length);
//        buffPoints[0] = Arrays.copyOf(xPoints, xPoints.length);
//        buffPoints[1] = Arrays.copyOf(yPoints, xPoints.length);
        buffPoints = rotate(xPoints, yPoints);

        for (int i = 0; i < buffPoints[0].length; i++) {
            buffPoints[0][i] += xPos / scale;
            buffPoints[1][i] += yPos / scale;
        }
    }

    public int[][] rotate(int[] xPoints, int[] yPoints) {
        int[][] buffPoints = new int[2][];
        buffPoints[0] = new int[xPoints.length];
        buffPoints[1] = new int[yPoints.length];

        //TODO - need to rotate xFire & yFire
        for (int i = 0; i < buffPoints[0].length; i++) {
            buffPoints[0][i] = (int) (-xPoints[i] * Math.cos(rotationAngle) + yPoints[i] * Math.sin(rotationAngle));
            buffPoints[1][i] = (int) (yPoints[i] * Math.cos(rotationAngle) + xPoints[i] * Math.sin(rotationAngle));
        }

        return buffPoints;

    }

    public void calculateAngle(int xDestination, int yDestination) {
        long x = xDestination - xPos;
        long y = yDestination - yPos;

        rotationAngle = Math.acos(x / Math.sqrt(x * x + y * y));

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

    public void stopObject() {
        setY_ACCELERATION(0);
        setX_ACCELERATION(0);
    }

    public void destroyObject() {
        xPoints = new int[]{-5, -2, -2, 0, 2, 1, 5, 1, 2, 0, -2, -2};
        yPoints = new int[]{0, 1, 5, 1, 5, 1, 0, -1, -5, -3, -5, -1};
        recalcPolygon();
    }

    public boolean isCollide(MovableObject mo) {
        if (mo.xPos + mo.size * gameField.scale > xPos - size * gameField.scale && mo.xPos - mo.size * gameField.scale < xPos + size * gameField.scale &&
                mo.yPos + mo.size * gameField.scale > yPos - size * gameField.scale && mo.yPos - mo.size * gameField.scale < yPos + size * gameField.scale) {
            return true;
        } else {
            return false;
        }
    }
}
