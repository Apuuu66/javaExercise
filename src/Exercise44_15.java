import java.awt.*;

import javax.swing.*;
import java.awt.geom.*;

public class Exercise44_15 extends JApplet {
  public Exercise44_15() {
    add(new ShapePanel());   
  }

  class ShapePanel extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D
      
      g2d.translate(70, 70);
      
      Ellipse2D circle = new Ellipse2D.Double(-50, -50, 100, 100);
      Path2D path = new Path2D.Double();
      path.moveTo(0, -50);
      path.curveTo(50, -25, -50, 25, 0, 50);
      path.curveTo(50, 25, -50, -25, 0, -50);
      g2d.draw(circle);
      g2d.draw(path);
      
      Area area1 = new Area(circle);
      Area area2 = new Area(path);     
      area1.subtract(area2);      
      g2d.translate(110, 0);
      g2d.draw(area1);
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_15 applet = new Exercise44_15();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_15");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(250, 180);
    frame.setVisible(true);
  }
}
