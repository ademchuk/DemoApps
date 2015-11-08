import java.util.Arrays;

/**
 * Created by User1 on 11/3/2015.
 */
public class Ship extends MovableObject {

    public Ship(GameField gameField) {
        super(gameField.WIDTH * gameField.scale / 2, gameField.HEIGHT * gameField.scale / 2, 0, new int[]{15, -15, 15, 10}, new int[]{-5, 0, 5, 0}, gameField);
    }

    public void move() {
        xBuffPoints = Arrays.copyOf(xPoints, xPoints.length);
        yBuffPoints = Arrays.copyOf(yPoints, xPoints.length);
        rotate();
        calculateAngle(gameField.mousePointer.x, gameField.mousePointer.y);
        //move obj to required position
        //TODO - limit ship movement with borders
        xPos += getX_ACCELERATION();
        yPos += getY_ACCELERATION();

        for (int i = 0; i < xBuffPoints.length; i++) {
            xBuffPoints[i] += xPos / scale;
            yBuffPoints[i] += yPos / scale;
        }
    }

    public boolean compareArrayToNumber(int array[], int number, boolean isMore) {
        boolean compare;
        for (int i = 0; i < array.length; i++) {
            if (isMore) {
                if (i > number) {
                    compare = true;
                }
            } else {
                if (i < number) {
                    compare = true;
                }
            }
        }
        return true;
    }

}