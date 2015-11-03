import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by demch_000 on 11/3/2015.
 */
public class MouseController extends MouseAdapter {

    @Override
    public void mouseMoved (MouseEvent e) {
        e.getPoint();
    }


}
