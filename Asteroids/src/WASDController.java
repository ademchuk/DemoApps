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
        keyPressedFilter(x);

        if (pressed.add(x)) {
            switch (x) {
                case 'w':
                    engine.ship.setY_ACCELERATION(-engine.getDEFAULT_ACCELERATION());
                    break;
                case 's':
                    engine.ship.setY_ACCELERATION(engine.getDEFAULT_ACCELERATION());
                    break;
                case 'a':
                    engine.ship.setX_ACCELERATION(-engine.getDEFAULT_ACCELERATION());
                    break;
                case 'd':
                    engine.ship.setX_ACCELERATION(engine.getDEFAULT_ACCELERATION());
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        pressed.remove(e.getKeyChar());
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
        }
    }

    private void keyPressedFilter (char x) {
        //TODO to sort out action when 'a' & 'd' pressed at the same time
    }

}