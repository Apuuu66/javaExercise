import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

public class Exercise16_19 extends JFrame { 
  private PaintPanel paintPanel = new PaintPanel();
  
  public Exercise16_19() {
    add(paintPanel);
  }

  static class PaintPanel extends JPanel {
    private int x = 100;
    private int y = 60;
    private boolean isInside = false;
    private Point mousePoint = new Point(0, 0); 
    public static int RADIUS = 50;
    

    public PaintPanel() {    
      this.addMouseMotionListener(new MouseAdapter() {
        public void mouseMoved(MouseEvent e) { 
          if (insideCircle(e.getX(), e.getY())) 
            isInside = true;
          else
            isInside = false;
          
          mousePoint.x = e.getX();
          mousePoint.y = e.getY();
          
          repaint();
        }
      });
    }

    public boolean insideCircle(int px, int py) {
      return distance(px, py, x, y) < RADIUS;
    }

    public static double distance(
        double x1, double y1, double x2, double y2) {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /** Paint message */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
      
      g.drawString(isInside ? "Mouse point is in the circle" :
        "Mouse point is not in the circle", 
        mousePoint.x, mousePoint.y);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new Exercise16_19();
    frame.setTitle("Exercise16_19");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
