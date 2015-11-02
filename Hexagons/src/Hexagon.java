import java.awt.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Hexagon {
    private Point middlePoint;
    private boolean checked = false;

    public void setMiddlePoint(Point middlePoint) {
        this.middlePoint = middlePoint;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Point getMiddlePoint() {

        return middlePoint;
    }

    public Hexagon(Point middlePoint) {
        this.middlePoint = middlePoint;

    }

    public Hexagon(int x, int y) {
        this.middlePoint.x = x;
        this.middlePoint.y = y;
    }


    public boolean isChecked() {
        return checked;

    }

    public void changeState() {
        checked = !checked;
    }
}
