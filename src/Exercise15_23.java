import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Exercise15_23 extends JFrame {
  public Exercise15_23() {
    add(new CubePanel());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise15_23 frame = new Exercise15_23();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setTitle("Exercise15_23");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 250);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

// Draw a polygon in the panel
class CubePanel extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = (int)(getSize().width * 0.90) - 30;
    int height = (int)(getSize().height * 0.90) - 60;
    int diff = (int)(Math.min(width, height) * 0.4);
    
    // Draw the front rect
    g.drawRect(10, 60, width, height);

    // Draw the back rect
    g.drawRect(30, 60 - diff, width, height);

    // Connect the corners
    g.drawLine(10, 60, 30, 60 - diff);
    g.drawLine(10, 60 + height, 30, 60 - diff + height);
    g.drawLine(10 + width, 60, 30 + width, 60 - diff);
    g.drawLine(10 + width, 60 + height, 30 + width, 60 - diff + height);
  }
}


