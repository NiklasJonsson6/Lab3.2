import java.awt.*;
import javax.swing.*;

public class LabTile extends JPanel {
    private boolean topEdge;
    private boolean sideEdge;
    private boolean mark;

    public void setTopEdge(boolean topEdge) {
        this.topEdge = topEdge;
    }

    public void setSideEdge(boolean sideEdge) {
        this.sideEdge = sideEdge;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (topEdge) {
            g.drawLine(0, 0, getWidth(), 0);
        }
        if (sideEdge) {
            g.drawLine(0, 0, 0, getHeight());
        }
        if (mark) {
            g.setColor(new Color(200, 0, 0));
            g.fillRect((int)(getWidth()*0.2), (int)(getHeight()*0.2),
                    (int)(getWidth()*0.6), (int)(getHeight()*0.6));
        }
    }
}
