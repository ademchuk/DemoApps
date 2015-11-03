import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by User1 on 11/2/2015.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);

        GameField gameField = new GameField(frame.getWidth(), frame.getHeight());
        frame.add(gameField);
        gameField.addKeyListener(new Controller(gameField));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        gameField.setFocusable(true);

    }
}
