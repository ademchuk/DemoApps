import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User1 on 11/2/2015.
 */
//
public class WASDController implements KeyListener{
    GameField gameField;
    int X_INCREMENT;
    int Y_INCREMENT;
    int SLEEP_TIME;
    int DEFAULT_INCREMENT;
    private final Set<Character> pressed = new HashSet<Character>();


    int MAX_SPEED = 5; //should limit the increment

    public WASDController(GameField gameField) {
        this.gameField = gameField;
        X_INCREMENT = 0;
        Y_INCREMENT = 0;
        SLEEP_TIME = 200; //ms
        DEFAULT_INCREMENT = 1;
    }

    public void moveX (int defaultIncrement) {
        while (Math.abs(X_INCREMENT) < MAX_SPEED) {
            X_INCREMENT+=defaultIncrement;
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                System.out.println(e.fillInStackTrace());
            }
        }
    }

    public void moveY (int defaultIncrement) {
        while (Math.abs(Y_INCREMENT) < MAX_SPEED) {
            Y_INCREMENT+=defaultIncrement;
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                System.out.println(e.fillInStackTrace());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char x = e.getKeyChar();
        pressed.add(x);
        System.out.println(x);
        if (x == 'w') {
            moveY(-DEFAULT_INCREMENT);
        } else if (x == 's') {
            moveY(DEFAULT_INCREMENT);
        }
        if (x == 'a') {
            moveX(-DEFAULT_INCREMENT);
        } else if (x == 'd') {
            moveX(DEFAULT_INCREMENT);
        }
        moveShipOnPressedKey();
        gameField.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Y_INCREMENT = 0;
        X_INCREMENT = 0;
        gameField.repaint();
    }

    private void moveShipOnPressedKey() {
        gameField.ship.xPos+=X_INCREMENT;
        gameField.ship.yPos+=Y_INCREMENT;
    }
}