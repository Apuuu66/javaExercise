import java.awt.*;
import javax.swing.*;

public class Exercise15_9 extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new Exercise15_9();
    frame.setSize(300, 300);
    frame.setTitle("Exercise15_9");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise15_9() {
    setTitle("Drawing a Fan");
    setLayout(new GridLayout(2, 2, 5, 5));
    add(new FanPanel());
    add(new FanPanel());
    add(new FanPanel());
    add(new FanPanel());
  }
}

class FanPanel extends JPanel {
  private int xCenter, yCenter;
  private int fanRadius, bladeLength;
  private int angle = 100;

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Set fan radius, and center
    fanRadius = (int)(Math.min(getWidth(), getHeight()) * 0.9 * 0.5);
    xCenter = getWidth() / 2;
    yCenter = getHeight() / 2;
    bladeLength = (int)(fanRadius * 0.9);

    // Draw circle
    g.setColor(Color.black);
    g.drawOval(xCenter - fanRadius, yCenter - fanRadius,
               2 * fanRadius, 2 * fanRadius);

    // Draw four blades
    drawBlade(g, angle);
    drawBlade(g, angle + 90);
    drawBlade(g, angle + 180);
    drawBlade(g, angle + 270);
  }

  private void drawBlade(Graphics g, int angle) {
    g.setColor(Color.red);
    g.fillArc(xCenter - bladeLength, yCenter - bladeLength,
              2 * bladeLength, 2 * bladeLength, angle, 30);
  }

  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }
}
