import javax.swing.*;
import java.awt.*;

public class Exercise15_17 extends JFrame {
  private HangmanPanel canvas = new HangmanPanel();
  
  public Exercise15_17() {   
    this.add(canvas, BorderLayout.CENTER); // Add canvas to center  
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new Exercise15_17();
    frame.setTitle("Exercise15_17");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 280);
    frame.setVisible(true);
  }
  
  class HangmanPanel extends JPanel {   
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.drawArc(20, 220, 80, 40, 0, 180); // Draw the base
      g.drawLine(20 + 40, 220, 20 + 40, 20); // Draw the pole
      g.drawLine(20 + 40, 20, 20 + 40 + 100, 20); // Draw the hanger
      g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100, 40); // Draw the hanger
      
      // Draw the circle
      int radius = 20;
      g.drawOval(20 + 40 + 100 - radius, 40, 2 * radius, 2 * radius); // Draw the hanger

      // Draw the left arm
      g.drawLine(20 + 40 + 100 - (int)(radius * Math.cos(Math.toRadians(45))), 
          40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
          20 + 40 + 100 - 60, 40 + radius + 60);
      
      // Draw the right arm
      g.drawLine(20 + 40 + 100 + (int)(radius * Math.cos(Math.toRadians(45))), 
          40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
          20 + 40 + 100 + 60, 40 + radius + 60);

      // Draw the body
      g.drawLine(20 + 40 + 100, 40 + 2* radius,
          20 + 40 + 100, 40 + radius + 80);

      // Draw the left leg
      g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 - 40, 40 + radius + 80 + 40);

      // Draw the right leg
      g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 + 40, 40 + radius + 80 + 40);
    }
  }
}
