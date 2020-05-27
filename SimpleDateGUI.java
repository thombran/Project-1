package project1;
import javax.swing.*;

public class SimpleDateGUI {

        public static void main (String[] args) {
            JFrame frame = new JFrame("Simple Date");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GUIMainPanel panel = new GUIMainPanel();
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setSize(400, 400);
            frame.setVisible(true);
        }
}
