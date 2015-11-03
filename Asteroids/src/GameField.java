import javax.swing.*;
import java.awt.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class GameField extends JPanel {
    int HEIGHT, WIDTH;
    Ship ship;


    GameField(int height, int width) {
        this.HEIGHT = height;
        this.WIDTH = width;
        ship = new Ship();
    }

    public void paintComponent (Graphics g) {
        fillBackground(g);
        g.setColor(Color.WHITE);
        ship.reDraw(g);
    }

    private void fillBackground (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,HEIGHT,WIDTH);
    }

}
