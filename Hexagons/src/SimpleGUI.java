import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User1 on 11/1/2015.
 */
public class    SimpleGUI implements ActionListener {
    JButton button;
    public static void main(String[] args) {
        SimpleGUI simpleGUI = new SimpleGUI();
        simpleGUI.go();
    }


    public void go () {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        MyDrawPanel drawPanel = new MyDrawPanel(frame.getWidth(), frame.getHeight());
        frame.add(drawPanel);
        drawPanel.addMouseListener(new MouseListenerImpl(drawPanel));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);




    }



    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked");
    }
}
