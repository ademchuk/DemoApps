package ui;

import engine.RunnableGame;
import gameController.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User1 on 12/22/2015.
 */
public class StartScreen extends JFrame {
    JButton jbutton;
    MainController mainController;


    public StartScreen(MainController mainController) {
        jbutton = new JButton("Start");

        this.mainController = mainController;
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        this.setLayout(new GridLayout(3, 1));

        jbutton.addActionListener(startButtonActionListener(this));

        this.add(jbutton);

    }

    public ActionListener startButtonActionListener(StartScreen startScreen) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                   mainController.showGameScreen();
                Thread t = new Thread(new RunnableGame(mainController));
                t.start();
            }
        };

                return actionListener;
    }
}
