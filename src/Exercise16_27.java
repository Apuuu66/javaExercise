import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise16_27 extends JFrame {
  public Exercise16_27() {
    add(new RandomCircle());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise16_27 frame = new Exercise16_27();
    frame.setTitle("Exercise16_27");
    frame.setSize(220, 100);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

// Displaying a moving circle
class RandomCircle extends JPanel {
  private int x = 20;

  private int y = 20;

  public static int RADIUS = 10;

  private long count = 0;

  private long startTime = System.currentTimeMillis();

  public RandomCircle() {

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (insideCircle(e.getX(), e.getY())) {
          repaint();
        }
      }
    });
  }

  public boolean insideCircle(int px, int py) {
    return distance(px, py, x, y) < RADIUS;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }

  /** Paint message */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (count > 20) {
      long endTime = System.currentTimeMillis();
      g.drawString("Time spent: " + (endTime - startTime) + 
        " milliseconds", 20, 20);
    } else {
      count++; // Increase the count

      x = (int) (getWidth() * Math.random());
      y = (int) (getHeight() * Math.random());

      g.setColor(new Color((int) (Math.random() * 128),
          (int) (Math.random() * 128), (int) (Math.random() * 128)));
      g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
    }
  }
}
