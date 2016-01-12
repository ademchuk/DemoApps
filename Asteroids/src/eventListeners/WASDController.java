package eventListeners;

import shipController.Controller;
import engine.Engine;
import ui.GameField;

import java.awt.event.*;

/**
 * Created by User1 on 11/2/2015.
 */
//
public class WASDController implements KeyListener {
    GameField gameField;
    Engine engine;
    Controller controller;

    public WASDController(GameField gameField) {
        this.gameField = gameField;
        engine = gameField.engine;
        controller = gameField.controller;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            controller.shot(engine,gameField);
        }
        controller.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controller.keyReleased(e);
    }
}