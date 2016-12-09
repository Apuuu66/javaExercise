import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.event.*;

public class Exercise44_1 extends JApplet {
  public Exercise44_1() {
    add(new ShapePanel());   
  }

  class ShapePanel extends JPanel {
    private Point p = new Point();
    private Rectangle2D rectangle = new Rectangle2D.Double(20, 20, 100, 100);

    ShapePanel() {
      this.addMouseMotionListener(new MouseAdapter() {
        public void mouseMoved(MouseEvent e) {
          p.setLocation(e.getX(), e.getY());
          repaint();
        }
      });
    }
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D

      g2d.draw(rectangle);
      
      if (rectangle.contains(p)) 
        g2d.drawString("Inside", (int)p.getX(), (int)p.getY());  
      else
        g2d.drawString("Outside", (int)p.getX(), (int)p.getY());  
        
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_1 applet = new Exercise44_1();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_1");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(350, 360);
    frame.setVisible(true);
  }
}
