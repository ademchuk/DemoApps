import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by User1 on 11/1/2015.
 */
public class MouseListenerImpl implements MouseInputListener{
    MyDrawPanel drawPanel;

    public MouseListenerImpl(MyDrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        System.out.println("x: "+p.getX());
        System.out.println("y: "+p.getY());
        drawPanel.changeHexState(p);
        drawPanel.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
