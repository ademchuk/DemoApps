import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User1 on 11/1/2015.
 */
public class SimpleGUI implements ActionListener {
    JButton button;
    public static void main(String[] args) {
        SimpleGUI simpleGUI = new SimpleGUI();
        simpleGUI.go();
    }


    public void go () {
        JFrame frame = new JFrame();
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.add(drawPanel);
//        button = new JButton("click me");
//x
//        button.addActionListener(this);
//
//        frame.agetContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked");
    }
}
