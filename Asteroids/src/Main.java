import javax.swing.*;

/**
 * Created by User1 on 11/2/2015.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);

        GameField gameField = new GameField(frame.getWidth(), frame.getHeight());
        frame.add(gameField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        gameField.setFocusable(true);
        for (;;)
            gameField.engine.process();
    }
}
