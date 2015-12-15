import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User1 on 11/2/2015.
 */
public class Engine {
    GameField gameField;
    Ship ship;

    private int DEFAULT_ACCELERATION;

    Point mousePointer;
    int timer;
    CopyOnWriteArrayList<Asteroid> asteroids;

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

        cleanUp();
        collisionDetection();
        removeDestroyedObjects();

        gameField.repaint();

        if (timer  > 20) {
            int randomizedSpeed = (int) (Math.random()*5);
            int randomizedSize = (int) (Math.random()*20+5);
            asteroids.add(Asteroid.createAsteroid(gameField, randomizedSpeed, randomizedSize, false));
            timer = 0;
        }

        try {
            timer++;
            Thread.sleep(10); //~100 framees per second
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void removeDestroyedObjects() {
        for (Asteroid asteroid : asteroids) {
            if (asteroid.destroyed) {
                asteroid.stopObject();
                asteroid.destroyObject();
            }
            if (ship.destroyed) {
                ship.destroyObject();
            }
        }
    }

    public void collisionDetection() {
        for (Asteroid asteroid : asteroids) {
            for (Asteroid asteroid1 : asteroids) {
                if (!asteroid.equals(asteroid1)) {
                    if (asteroid.isCollide(asteroid1)) {
                        asteroid.destroyed = true;
                        asteroid1.destroyed = true;
                    }
                }
            }
            if (asteroid.isCollide(ship) && !asteroid.isBullet) {
                asteroid.destroyed = true;
                ship.destroyed = true;
            }
        }
    }

    public void cleanUp () {
        for (int i = 0; i < asteroids.size(); i++ ) {
            if (asteroids.get(i).isOutOfSight) {
                asteroids.remove(i);
            }
        }
    }

}
