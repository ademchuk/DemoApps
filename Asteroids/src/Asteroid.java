import java.util.Random;

/**
 * Created by User1 on 11/2/2015.
 */
public class Asteroid extends MovableObject {
    int ASTEROID_RADIUS;
    boolean isOutOfSight;
    boolean isBullet;

    private Asteroid(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints, GameField gameField) {
        super(xPos, yPos, rotationAngle, xPoints, yPoints, gameField);
    }

    public void calculateXYAccelerations(int defaultAcceleration) {
        setX_ACCELERATION((int) (defaultAcceleration * Math.cos(rotationAngle)));
        setY_ACCELERATION((int) (-defaultAcceleration * Math.sin(rotationAngle)));
    }

    private void calculateStartPosition() {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            xPos = random.nextInt(gameField.WIDTH * gameField.scale);
            if (random.nextInt(2) == 1) {
                yPos = 0;
            } else {
                yPos = gameField.getHeight() * gameField.scale;
            }
        } else {
            yPos = random.nextInt(gameField.HEIGHT * gameField.scale);
            if (random.nextInt(2) == 1) {
                xPos = 0;
            } else {
                xPos = gameField.WIDTH * gameField.scale;
            }
        }
    }

    @Override
    public void move() {
        super.move();
        if (xPos / scale < -ASTEROID_RADIUS || xPos / scale > gameField.WIDTH + ASTEROID_RADIUS ||
                yPos / scale < -ASTEROID_RADIUS || yPos / scale > gameField.HEIGHT + ASTEROID_RADIUS) {
            isOutOfSight = true;
        }
    }

    static Asteroid createAsteroid(GameField gameField, int defaultAcceleration, int size, boolean isBullet) {
        int[][] points = new int[2][];
        points[0] = new int[]{-1, -1, 1, 1};
        points[1] = new int[]{-1, 1, 1, -1};

        for (int i = 0; i < points[0].length; i++) {
            points[0][i] = points[0][i] * size;
            points[1][i] = points[1][i] * size;
        }

        Asteroid asteroid = new Asteroid(0, 0, 0, points[0], points[1], gameField);

        asteroid.isBullet = isBullet;
        asteroid.size = size;
        asteroid.liveAfterDeath = 10;

        if (isBullet) {
            //TODO - refactor this shit
            asteroid.xPos = asteroid.rotate(gameField.ship.firePoint[0], gameField.ship.firePoint[1])[0][0] + gameField.ship.xPos;
            asteroid.yPos = asteroid.rotate(gameField.ship.firePoint[0], gameField.ship.firePoint[1])[1][0] + gameField.ship.yPos;
            asteroid.rotationAngle = gameField.ship.rotationAngle;
        } else {
            asteroid.calculateStartPosition();
            asteroid.calculateAngle(gameField.ship.xPos, gameField.ship.yPos);
        }
        asteroid.calculateXYAccelerations(defaultAcceleration * gameField.scale);

        return asteroid;
    }
}