import java.awt.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Asteroid extends MovableObject{


    public Asteroid(int xPos, int yPos, double rotationAngle, int[] xPoints, int[] yPoints) {
        super(0, 0, Math.PI*3/4, new int[] {0,0,10,10}, new int[] {0,10,10,0});
    }
}
