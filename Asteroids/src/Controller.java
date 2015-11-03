import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by User1 on 11/2/2015.
 */
//
public class Controller implements KeyListener {
    GameField gameField;
    int X_INCREMENT;
    int Y_INCREMENT;

    int MAX_SPEED = 5; //should limit the increment

    public Controller(GameField gameField) {
        this.gameField = gameField;
        X_INCREMENT = 0;
        Y_INCREMENT = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char x = e.getKeyChar();
        if (x == 'w') {
            if (Math.abs(Y_INCREMENT) < MAX_SPEED) {
                Y_INCREMENT--;
            }
        } else if (x == 's') {
            if (Math.abs(Y_INCREMENT) < MAX_SPEED) {
                Y_INCREMENT++;
            }
        }
        if (x == 'a') {
            if (Math.abs(X_INCREMENT) < MAX_SPEED) {
                X_INCREMENT--;
            }
        } else if (x == 'd') {
            if (Math.abs(X_INCREMENT) < MAX_SPEED) {
                X_INCREMENT++;
            }
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