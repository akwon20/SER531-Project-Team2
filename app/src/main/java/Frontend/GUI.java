package Frontend;

import javax.swing.JFrame;

public class GUI extends JFrame {

    public GUI() {
        this.setTitle("Test Frame");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
