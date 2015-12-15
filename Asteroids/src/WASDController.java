import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User1 on 11/2/2015.
 */
//
public class WASDController implements KeyListener {
    GameField gameField;
    Engine engine;
    private final Set<Character> pressed = new HashSet<Character>();


    public WASDController(GameField gameField) {
        this.gameField = gameField;
        engine = gameField.engine;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char x = e.getKeyChar();

        if (pressed.add(x)) {
            switch (x) {
                case 'w':
                    engine.ship.setY_ACCELERATION(-engine.getDEFAULT_ACCELERATION());
                    pressed.remove('s');
                    break;
                case 's':
                    engine.ship.setY_ACCELERATION(engine.getDEFAULT_ACCELERATION());
                    pressed.remove('w');
                    break;
                case 'a':
                    engine.ship.setX_ACCELERATION(-engine.getDEFAULT_ACCELERATION());
                    pressed.remove('d');
                    break;
                case 'd':
                    engine.ship.setX_ACCELERATION(engine.getDEFAULT_ACCELERATION());
                    pressed.remove('a');
                    break;
                case ' ':
                    gameField.asteroids.add(Asteroid.createAsteroid(gameField,5,2,true));
                    break;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (pressed.remove(e.getKeyChar()))
            switch (e.getKeyChar()) {
                case 'w':
                    engine.ship.setY_ACCELERATION(0);
                    break;
                case 's':
                    engine.ship.setY_ACCELERATION(0);
                    break;
                case 'a':
                    engine.ship.setX_ACCELERATION(0);
                    break;
                case 'd':
                    engine.ship.setX_ACCELERATION(0);
                    break;
                case ' ':
                    break;
            }
    }
}