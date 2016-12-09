import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Exercise16_15 extends JFrame {
  public Exercise16_15() {
    add(new RaceCar());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise16_15 frame = new Exercise16_15();
    frame.setTitle("Exercise16_15");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 100);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

// Displaying a moving message
class RaceCar extends JPanel {
  private int xBase = 0;
  private Timer timer = new Timer(1, new Listener());

  public RaceCar() {
    // Create a timer for the listener raceCar
    timer.start();
    
    this.setFocusable(true);

    // Control speed
    this.addKeyListener(new KeyAdapter() {
	  public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == 61) {
	      if (timer.getDelay() > 5)
		    timer.setDelay(timer.getDelay() - 5);
		  }
		else if (e.isControlDown() && e.getKeyCode() == 45)
		  timer.setDelay(timer.getDelay() + 1);
	  }
    });
  }

  class Listener implements ActionListener {
    /** Handle ActionEvent */
    public void actionPerformed(ActionEvent e) {
     repaint();
    }
  }

  /** Paint message */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int yBase = getHeight();
    if (xBase > getWidth())
      xBase = -20;
    else
      xBase += 1;

    // Draw two wheels
    g.setColor(Color.BLACK);
    g.fillOval(xBase + 10, yBase - 10, 10, 10);
    g.fillOval(xBase + 30, yBase - 10, 10, 10);

    // Draw the car body
    g.setColor(Color.GREEN);
    g.fillRect(xBase, yBase - 20, 50, 10);

    // Draw the top
    g.setColor(Color.RED);
    Polygon polygon = new Polygon();
    polygon.addPoint(xBase + 10, yBase - 20);
    polygon.addPoint(xBase + 20, yBase - 30);
    polygon.addPoint(xBase + 30, yBase - 30);
    polygon.addPoint(xBase + 40, yBase - 20);
    g.fillPolygon(polygon);
  }
}
