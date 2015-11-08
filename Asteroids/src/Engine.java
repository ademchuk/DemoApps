import java.awt.*;
import java.util.ArrayList;

/**
 * Created by User1 on 11/2/2015.
 */
public class Engine {
    GameField gameField;
    Ship ship;

    private int DEFAULT_ACCELERATION;

//    private int X_ACCELERATION;
//    private int Y_ACCELERATION;
    Point mousePointer;
    int timer;
    ArrayList<Asteroid> asteroids;

    //TODO - use unitVsPicRation var
    int unitVsPicRation = 100;

    public Engine(GameField gameField) {
        this.gameField = gameField;
        this.ship = gameField.ship;
        DEFAULT_ACCELERATION = 2000;
        mousePointer = new Point();
        asteroids = gameField.asteroids;
        gameField.mousePointer = this.mousePointer;
    }
    //TODO - Limit max speed - so objects can move with max speed; x=2 y=2 speed should be same as x=2 y=0 ???

    public int getDEFAULT_ACCELERATION() {
        return DEFAULT_ACCELERATION;
    }

    public void process () {

        ship.move();
        for (Asteroid asteroid : asteroids) {
            asteroid.move();
        }

        //TODO - DETECT COLLISIONS

        gameField.repaint();


        if (timer  > 200) {
            asteroids.add(new Asteroid(gameField, DEFAULT_ACCELERATION));
            timer = 0;
        }

        try {
            timer++;
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
