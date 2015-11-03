import java.awt.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Ship {
//    Polygon triangleShip;

    //ship coordinates defaults
    final int[] X = new int[]{0, 5, 10, 0};
    final int[] Y = new int[]{30, 0, 30, 30};

    //position of the ship
    double rotationAngle;

    int xPos, yPos;

    Ship() {
        rotationAngle = Math.PI;
        xPos = 500;
        yPos = 500;
    }

    public void reDraw(Graphics g) {
        int x[] = new int[X.length];
        int y[] = new int[Y.length];

        Engine.rotateObject(X, Y, rotationAngle, x, y);
        recalculatePosition(xPos, yPos, x, y);

        for (int i = 0; i < X.length - 1; i++) {
            g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }
        g.drawLine(x[x.length - 1], y[x.length - 1], x[0], y[0]);
    }

    public void recalculatePosition(int xOffset, int yOffset, int[] x, int y[]) {
        for (int i = 0; i < X.length; i++) {
            x[i] += xOffset;
            y[i] += yOffset;
        }
    }


}
