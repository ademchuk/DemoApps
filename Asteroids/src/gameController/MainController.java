package gameController;

import ui.GameField;
import ui.GameScreen;
import ui.StartScreen;

import javax.swing.*;

/**
 * Created by User1 on 12/23/2015.
 */
public class MainController {
    public StartScreen startScreen;
    public GameScreen gameScreen;

    public void showStartScreen() {
        startScreen = new StartScreen(this);

//        JFrame frame = new JFrame();
//        frame.setSize(1000, 1000);
//        startScreen.setSize(1000, 1000);


//        gameField = new GameField(startScreen.getWidth(), startScreen.getHeight());
//        startScreen.add(gameField);

        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setResizable(false);
        startScreen.setVisible(true);

//        gameField.setFocusable(true);

//        while (!gameField.engine.ship.destroyed) {
//            gameField.engine.process();
//        }
    }


    private void switchTheScreens(JFrame currentScreen, JFrame nextScreen) {
        currentScreen.setVisible(false);
        nextScreen.setVisible(true);
    }


    public void showGameScreen() {
        gameScreen = new GameScreen(startScreen.getHeight(), startScreen.getWidth());
        switchTheScreens(startScreen, gameScreen);
        gameScreen.gameField.engine.process();
        switchTheScreens(gameScreen, startScreen);
    }
}
