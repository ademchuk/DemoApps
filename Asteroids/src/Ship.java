
/**
 * Created by User1 on 11/3/2015.
 */
public class Ship extends MovableObject {
    //TODO - add more lives
//    int lives;
    int[][] firePoint;

    public Ship(GameField gameField) {
        super(gameField.WIDTH * gameField.scale / 2, gameField.HEIGHT * gameField.scale / 2, 0, new int[]{15, -15, 15, 10}, new int[]{-5, 0, 5, 0}, gameField);
//        lives = 3;
        firePoint = new  int[2][];
        firePoint[0] = new int[] {-15}; //x
        firePoint[1] = new int[] {0};   //y
        size = 15;

    }

    public void move() {
        //check boundaries
        if (getX_ACCELERATION() < 0 && xPos > 30 * scale || getX_ACCELERATION() > 0 && xPos < (gameField.WIDTH - 30) * scale) {
            xPos += getX_ACCELERATION();
        }
        if (getY_ACCELERATION() < 0 && yPos > 30 * scale || getY_ACCELERATION() > 0 && yPos < (gameField.HEIGHT - 30) * scale) {
            yPos += getY_ACCELERATION();
        }
        recalcPolygon();

    }

    public void recalcPolygon() {
//        xBuffPoints = Arrays.copyOf(xPoints, xPoints.length);
//        yBuffPoints = Arrays.copyOf(yPoints, xPoints.length);
        buffPoints = rotate(xPoints, yPoints);
        calculateAngle(gameField.mousePointer.x, gameField.mousePointer.y);

        for (int i = 0; i < buffPoints[0].length; i++) {
            buffPoints[0][i] += xPos / scale;
            buffPoints[1][i] += yPos / scale;
        }

    }

}