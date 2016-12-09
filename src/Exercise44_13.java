import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Exercise44_13 extends JApplet {
  public Exercise44_13() {
    add(new ShapePanel());   
  }

  class ShapePanel extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D
      
      g2d.translate(100, 40);
      g2d.draw(new Ellipse2D.Double(-50, -13, 100, 26));
      g2d.draw(new Line2D.Double(-50, 0, -50, 70));
      g2d.draw(new Line2D.Double(50, 0, 50, 70));
      g2d.draw(new Arc2D.Double(-50, -13 + 70, 100, 26, 0, -180, Arc2D.OPEN));
      
      Stroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
          BasicStroke.JOIN_ROUND, 1.0f, new float[]{8}, 0);      
      g2d.setStroke(stroke);
      g2d.draw(new Arc2D.Double(-50, -13 + 70, 100, 26, 0, 180, Arc2D.OPEN));
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_13 applet = new Exercise44_13();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_13");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(220, 180);
    frame.setVisible(true);
  }
}
