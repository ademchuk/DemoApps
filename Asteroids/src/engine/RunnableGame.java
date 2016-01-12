package engine;

import gameController.MainController;
import main.Main;

/**
 * Created by User1 on 1/12/2016.
 */
public class RunnableGame implements Runnable {
    MainController mainController;

    public RunnableGame (MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void run() {
        mainController.showGameScreen();
    }
}
