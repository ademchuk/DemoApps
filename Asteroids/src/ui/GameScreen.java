package ui;

import javax.swing.*;

/**
 * Created by User1 on 12/27/2015.
 */
public class GameScreen extends JFrame {
    public GameField gameField;


    public GameScreen(int height, int width) {
        gameField = new GameField(height, width);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(gameField);

        this.gameField.setFocusable(true);
    }
}
