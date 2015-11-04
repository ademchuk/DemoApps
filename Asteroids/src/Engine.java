import java.awt.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Engine {
    GameField gameField;
    Ship ship;
    int DEFAULT_ACCELERATION;
    private int X_ACCELERATION;
    private int Y_ACCELERATION;
    Point mousePointer;

    public Engine(GameField gameField) {
        this.gameField = gameField;
        this.ship = gameField.ship;
        DEFAULT_ACCELERATION = 2;
        X_ACCELERATION = 0;
        Y_ACCELERATION = 0;
        mousePointer = new Point();
    }

    public void process () {
        moveShip(X_ACCELERATION,Y_ACCELERATION);
//        moveOtherSpaceObjects();
//        detectCollisions();
        gameField.repaint();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void moveShip(int xAcceleration, int yAcceleration) {
        calculateShipAngle();
        ship.xPos+=xAcceleration;
        ship.yPos+=yAcceleration;
//        gameField.ship.recalculatePosition();
    }

    public void calculateShipAngle () {
        //get initial vector 5;15 - to get ship center
        int x = (int) (mousePointer.getX() - ship.xPos);
        int y = (int) (mousePointer.getY() - ship.yPos);
// a {x,y} b {0,-1}
//        cos α = a · b
//                |a| · |b|
        ship.rotationAngle = Math.acos(-y / Math.sqrt(x * x + y * y));

        if (x < 0) {
            ship.rotationAngle = 2*Math.PI-ship.rotationAngle;
        }
    }
    public void setX_ACCELERATION(int x_ACCELERATION) {
        X_ACCELERATION = x_ACCELERATION;
    }

    public void setY_ACCELERATION(int y_ACCELERATION) {
        Y_ACCELERATION = y_ACCELERATION;
    }
}
