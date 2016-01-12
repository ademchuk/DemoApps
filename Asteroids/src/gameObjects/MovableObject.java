package gameObjects;

import ui.GameField;

import java.awt.*;

/**
 * Created by User1 on 11/4/2015.
 */
public class MovableObject {
    int scale = 1000;
    public int size;
    public int xPos;
    public int yPos;
    int[][] buffPoints;
    public int liveAfterDeath;
    public boolean destroyed;
    public double rotationAngle;
    public int X_ACCELERATION;
    public int Y_ACCELERATION;
    int[] xPoints;
    int[] yPoints;

    GameField gameField;

    public MovableObject(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints, GameField gameField) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotationAngle = rotationAngle;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        buffPoints = new int[2][];
        buffPoints[0] = xPoints.clone();
        buffPoints[1] = yPoints.clone();
        destroyed = false;
        this.gameField = gameField;

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

    public void calculateXYAccelerations(int defaultAcceleration) {
        X_ACCELERATION = ((int) (defaultAcceleration * Math.cos(rotationAngle)));
        Y_ACCELERATION = ((int) (-defaultAcceleration * Math.sin(rotationAngle)));
    }

    public void move() {
        //move obj to required position
        xPos += X_ACCELERATION;
        yPos += Y_ACCELERATION;
        continuousParty();
        recalcPolygon();
    }

    public void recalcPolygon() {
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

    public void stopObject() {
        Y_ACCELERATION = 0;
        X_ACCELERATION = 0;
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

    public void continuousParty() {
        if (xPos / scale < 0 ) {
            xPos = gameField.WIDTH*scale;
        } else if (xPos / scale > gameField.WIDTH) {
            xPos = 0;
        }
        if (yPos / scale < 0) {
            yPos = gameField.HEIGHT*scale;
        } else if (yPos / scale > gameField.HEIGHT) {
            yPos = 0;
        }
    }
}
