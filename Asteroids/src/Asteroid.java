import java.util.Random;

/**
 * Created by User1 on 11/2/2015.
 */
public class Asteroid extends MovableObject {
    //TODO - memory leak remove objects from the memory when they are out of rich

    public Asteroid(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints, GameField gameField) {
        super(xPos, yPos, rotationAngle, xPoints, yPoints, gameField);
    }

    public Asteroid(GameField gameField, int DEFAULT_ACCELERATION) {
        super(0, 0, 0, new int[]{-5, -5, 5, 5}, new int[]{-5, 5, 5, -5}, gameField);

        calculateStartPosition();
        calculateAngle(gameField.ship.xPos, gameField.ship.yPos);
        calculateXYAccelerations(DEFAULT_ACCELERATION);
    }

    public void calculateXYAccelerations (int DEFAULT_ACCELERATION) {
        setX_ACCELERATION((int) (DEFAULT_ACCELERATION*Math.cos(rotationAngle)));
        setY_ACCELERATION((int) (-DEFAULT_ACCELERATION*Math.sin(rotationAngle)));
    }

    private void calculateStartPosition() {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            xPos = random.nextInt(gameField.WIDTH*gameField.scale);
            if (random.nextInt(2) == 1) {
                yPos = 0;
            } else {
                yPos = gameField.getHeight()*gameField.scale;
            }
        } else {
            yPos = random.nextInt(gameField.HEIGHT*gameField.scale);
            if (random.nextInt(2) == 1) {
                xPos = 0;
            } else {
                xPos = gameField.WIDTH*gameField.scale;
            }
        }
    }

}
