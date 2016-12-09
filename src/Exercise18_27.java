import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Exercise18_27 extends JApplet {
  // Not completely implemented at this time

  public Exercise18_27() {
    add(new SimulationPanel());
  }

  class SimulationPanel extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      int width = getWidth();
      int height = getHeight();
      
      int d = 30;
      
      g.drawLine(width / 2 - d / 2, 10, width / 2 - d / 2, height / 2 - d / 2);
      g.drawLine(width / 2 + d / 2, 10, width / 2 + d / 2, height / 2 - d / 2);
      g.drawLine(width / 2 - d / 2, height / 2 + d / 2, width / 2 - d / 2, height - 10);
      g.drawLine(width / 2 + d / 2, height / 2 + d / 2, width / 2 + d / 2, height - 10);

      g.drawLine(10, height / 2 - d / 2, width / 2 - d / 2, height / 2 - d / 2);
      g.drawLine(width / 2 + d / 2, height / 2 - d / 2, width - 10, height / 2 - d / 2);
      g.drawLine(10, height / 2 + d / 2, width / 2 - d / 2, height / 2 + d / 2);
      g.drawLine(width / 2 + d / 2, height / 2 + d / 2, width - 10, height / 2 + d / 2);
      
      g.drawRect(width / 2 - d / 2 - 25, height / 2 + d / 2 + 5, 20, 60);
      g.setColor(Color.GREEN);
      g.fillOval(width / 2 - d / 2 - 25 + 3, height / 2 + d / 2 + 5 + 3, 14, 14);
      g.setColor(Color.BLACK);
      // g.setColor(Color.YELLOW);
      g.drawOval(width / 2 - d / 2 - 25 + 3, height / 2 + d / 2 + 5 + 3 + 20, 14, 14);
      // g.setColor(Color.RED);
      g.drawOval(width / 2 - d / 2 - 25 + 3, height / 2 + d / 2 + 5 + 3 + 40, 14, 14);
      g.setColor(Color.BLACK);
      
      // Traffic flows horizontally
      for (int i = 0; i < width - 20; i = i + 40)
        g.fillRect(10 + i, height / 2 - d / 2 + 10, 20, 10);

      for (int i = 0; i < height / 2 - 20; i = i + 25)
        g.fillRect(width / 2 - d / 2 + 10, height / 2 - d / 2 - 20 - i, 10, 20);

/*
      // Traffic flows vertically
      for (int i = 0; i < width / 2 - 20; i = i + 25)
        g.fillRect(width / 2 - d / 2 - 20 - i, height / 2 - d / 2 + 10, 20, 10);

      for (int i = 0; i < height - 20; i = i + 40)
        g.fillRect(width / 2 - d / 2 + 10, height - 20 - i, 10, 20);
*/
      }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise18_27");
    JApplet applet = new Exercise18_27();
    frame.add(applet);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
