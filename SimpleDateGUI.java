package project1;
import javax.swing.*;

public class SimpleDateGUI {

        public static void main (String[] args) {
            JFrame frame = new JFrame("Simple Date");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar menuBar;
            JMenu menu;

            menuBar = new JMenuBar();
            menu = new JMenu("File");
            menuBar.add(menu);               //TODO How to create the rest of menu?? Is this right class to put in?
            JMenuItem save = new JMenuItem("Save");
            JMenuItem load = new JMenuItem("Load");
            menu.add(save);
            menu.add(load);

            SimpleDateGUIPanel panel = new SimpleDateGUIPanel(save, load);
            frame.getContentPane().add(panel);
            frame.setJMenuBar(menuBar);
            frame.pack();
            frame.setSize(400, 400);
            frame.setVisible(true);
        }
}
