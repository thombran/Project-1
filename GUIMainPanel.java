package project1;

import javax.swing.*;
import java.awt.*;

public class GUIMainPanel extends JPanel {
    private SimpleDateGUIPanel s;
    private SimpleDateGUIPanel s2;
    private SimpleDateGUIPanel s3;

    public GUIMainPanel() {
        setLayout(new GridLayout(1,3));


        s = new SimpleDateGUIPanel();
        s2 = new SimpleDateGUIPanel();
        s3 = new SimpleDateGUIPanel();

        add(s);
        add(s2);
        add(s3);
    }
}
