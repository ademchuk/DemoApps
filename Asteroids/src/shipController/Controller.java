package shipController;

import engine.Engine;
import gameObjects.Ship;
import ui.GameField;

import java.awt.event.KeyEvent;

/**
 * Created by User1 on 12/15/2015.
 */
public interface Controller {

    public void recalculateShipPosition (Ship ship);

    public void keyPressed(KeyEvent e);

    public void keyReleased(KeyEvent e);

    public void shot(Engine e, GameField gameField);
}
