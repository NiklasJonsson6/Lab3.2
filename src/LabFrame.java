import java.awt.*;
import javax.swing.*;

public class LabFrame extends JPanel {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public LabFrame(int width, int height) {
        JFrame f = new JFrame();
        setLayout(new GridLayout(height, width));
        if (width/(double)height < 16.0/9.0) {
            f.setSize((int) (screenSize.getHeight() * 0.9 * (width / (double) height)),
                    (int) (screenSize.getHeight() * 0.9));
        } else {
            f.setSize((int) (screenSize.getWidth()),
                    (int) (screenSize.getWidth() * height / (double) width));
        }
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
    }
}