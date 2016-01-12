package shipController;

import engine.Engine;
import gameObjects.Asteroid;
import gameObjects.Ship;
import ui.GameField;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User1 on 12/15/2015.
 */
public class RealGravity implements Controller {
    int speed;
    int maxSpeed;
    int speedAccelerationLength;
    int speedCounter;
    int rotationCounter;
    int rotationAccelerationLength;
    int currentXVelocity;
    int currentYVelocity;
    double rotationAngleIncrement;
    public Set<Character> pressed;


    public RealGravity(int speed) {
        pressed = new HashSet<Character>();
        this.speed = speed;
        maxSpeed = 5000;
        speedAccelerationLength = 20;
        rotationAngleIncrement = 0.01;
        rotationAccelerationLength = 5;
    }

    @Override
    public void recalculateShipPosition(Ship ship) {
        rotate(ship);
        accelerateShip(ship);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyChar());
    }

    @Override
    public void shot(Engine e, GameField gameField) {
        e.asteroids.add(Asteroid.createAsteroid(gameField,5,2,true));
    }

    private void rotate(Ship ship) {
        if (pressed.contains('a')) {
            if (rotationCounter > 0 || Math.abs(rotationCounter) < rotationAccelerationLength) {
                rotationCounter++;
            } else {
                rotationCounter = 0;
            }
        } else if (pressed.contains('d')) {
            if (rotationCounter < 0 || Math.abs(rotationCounter) < rotationAccelerationLength) {
                rotationCounter--;
            } else {
                rotationCounter = 0;
            }
        } else {
            rotationCounter = 0;
        }
        ship.rotationAngle+=rotationAngleIncrement*rotationCounter;
    }

    private void accelerateShip(Ship ship) {
        if (pressed.contains('w')) {
            if (speedCounter < speedAccelerationLength) {
                speedCounter++;
            }
        } else {
            speedCounter = 0;
        }
        ship.calculateXYAccelerations(speed* speedCounter);

        if ((currentXVelocity < maxSpeed && ship.X_ACCELERATION > 0) || (-currentXVelocity < maxSpeed && ship.X_ACCELERATION < 0)) {
            currentXVelocity += ship.X_ACCELERATION;
        }
        if ((currentYVelocity < maxSpeed && ship.Y_ACCELERATION > 0) || (-currentYVelocity < maxSpeed && ship.Y_ACCELERATION < 0)) {
            currentYVelocity += ship.Y_ACCELERATION;
        }
        ship.xPos += currentXVelocity;
        ship.yPos += currentYVelocity;

    }
}
