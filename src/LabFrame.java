import java.awt.*;
import javax.swing.*;

public class LabFrame extends JPanel {
    public LabFrame(int width, int height) {
        JFrame f = new JFrame();
        setLayout(new GridLayout(width, height));
        f.setSize(100*width, 100*height);
        f.setVisible(true);
        f.add(this);
    }
}