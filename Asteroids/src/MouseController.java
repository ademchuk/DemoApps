import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by demch_000 on 11/3/2015.
 */
public class MouseController extends MouseAdapter {
    GameField gameField;

    public MouseController(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void mouseMoved (MouseEvent e) {
        gameField.engine.mousePointer.x = (int) e.getPoint().getX();
        gameField.engine.mousePointer.y = (int) e.getPoint().getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //TODO start shooting
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //TODO stop shoting
    }


}
