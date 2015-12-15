import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User1 on 11/2/2015.
 */
public class GameField extends JPanel {
    int scale;
    int HEIGHT, WIDTH;
    Ship ship;
    Engine engine;
    Point mousePointer;
    CopyOnWriteArrayList<Asteroid> asteroids = new CopyOnWriteArrayList<Asteroid>();

    GameField(int height, int width) {
        scale = 1000;
        this.HEIGHT = height;
        this.WIDTH = width;
        ship = new Ship(this);

        engine = new Engine(this);
        this.addKeyListener(new WASDController(this));
        this.addMouseMotionListener(new MouseController(this));
    }

    public void paintComponent (Graphics g) {
        fillBackground(g);
        g.setColor(Color.WHITE);
        ship.draw(g);
        for (Asteroid asteroid : asteroids) {
            if (asteroid.destroyed) {
                asteroid.liveAfterDeath--;
            }
            if (asteroid.liveAfterDeath <= 0 ) {
                asteroids.remove(asteroid);
            } else {
                asteroid.draw(g);
            }
        }
    }

    public void fillBackground (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }

}
