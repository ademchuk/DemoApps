package engine;

import gameObjects.Asteroid;
import gameObjects.Ship;
import ui.GameField;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User1 on 11/2/2015.
 */
public class Engine {
    GameField gameField;
    public Ship ship;

    private int DEFAULT_ACCELERATION;

    public Point mousePointer;
    int timer = 0;
    public CopyOnWriteArrayList<Asteroid> asteroids;

    public Engine(GameField gameField) {
        this.gameField = gameField;
        this.ship = gameField.ship;
        DEFAULT_ACCELERATION = 2000;
        mousePointer = new Point(0, 0);
        asteroids = gameField.asteroids;
        gameField.mousePointer = this.mousePointer;
    }
    //TODO - Limit max speed - so objects can move with max speed; x=2 y=2 speed should be same as x=2 y=0 ???

    public void process() {

        while (!ship.destroyed) {
            ship.move();
            for (Asteroid asteroid : asteroids) {
                asteroid.move();
            }

            cleanUp();
            collisionDetection();
            removeDestroyedObjects();
            addAsteroid();

            gameField.repaint();


            try {
                Thread.sleep(10); //~100 framees per second
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
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
            if (asteroid.isCollide(ship)) {
                asteroid.destroyed = true;
                ship.destroyed = true;
            }
        }
    }

    public void cleanUp() {
//        for (Asteroid asteroid : asteroids) {
//            if (asteroid.getTravelLength() > 1000 && asteroid.isBullet) {
//                asteroids.remove(asteroid);
//            }
//        }
        for (Asteroid asteroid : asteroids) {
            if (asteroid.isBullet) {
                System.out.println(asteroid.getTravelLength());
            }
        }
    }

    private void addAsteroid() {
        if (timer > 20) {
            //TODO - use asteroid factory
            int randomizedSpeed = (int) (Math.random() * 5 + 1);
            int randomizedSize = (int) (Math.random() * 20 + 5);
            asteroids.add(Asteroid.createAsteroid(gameField, randomizedSpeed, randomizedSize, false));
            timer = 0;
        }
        timer++;
    }


}
