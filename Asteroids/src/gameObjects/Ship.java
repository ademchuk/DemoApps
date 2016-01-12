package gameObjects;

import gameObjects.MovableObject;
import shipController.Controller;
import ui.GameField;

/**
 * Created by User1 on 11/3/2015.
 */
public class Ship extends MovableObject {
    //TODO - add lives
    int[][] firePoint;
    //TODO - remove; move test
    Controller controller;

    public Ship(GameField gameField, Controller controller) {
        super(gameField.WIDTH * gameField.scale / 2, gameField.HEIGHT * gameField.scale / 2, 0, new int[]{15, -15, 15, 10}, new int[]{-5, 0, 5, 0}, gameField);
        firePoint = new  int[2][];
        firePoint[0] = new int[] {-15}; //x
        firePoint[1] = new int[] {0};   //y
        size = 15;
        this.controller = controller;
    }

    public void move() {
        controller.recalculateShipPosition(this);
        continuousParty();
        recalcPolygon();
    }


    public void recalcPolygon() {
        buffPoints = rotate(xPoints, yPoints);
//        calculateAngle(gameField.mousePointer.x, gameField.mousePointer.y);

        for (int i = 0; i < buffPoints[0].length; i++) {
            buffPoints[0][i] += xPos / scale;
            buffPoints[1][i] += yPos / scale;
        }

    }

}