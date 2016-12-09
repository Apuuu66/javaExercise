import javax.swing.*;
import java.awt.*;

public class Exercise15_1 extends JFrame {
  /** Default constructor */
  public Exercise15_1() {
    // Add buttons to the frame
    add(new Grid());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise15_1 frame = new Exercise15_1();
    frame.setTitle("Exercise15_1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class Grid extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    g.setColor(Color.red);
    g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
    g.drawLine(getWidth() * 2 / 3, 0, getWidth() * 2 / 3, getHeight());

    g.setColor(Color.blue);
    g.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3);
    g.drawLine(0, getHeight() * 2 / 3, getWidth(), getHeight() * 2 / 3);
  }
}
