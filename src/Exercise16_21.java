import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_21 extends JFrame { 
  private PaintPanel paintPanel = new PaintPanel();
  
  public Exercise16_21() {
    add(paintPanel);
  }

  static class PaintPanel extends JPanel {
    private Triangle2D triangle = new Triangle2D(20, 20, 100, 100, 140, 40);
    private boolean isInside = false;
    private Point mousePoint = new Point(0, 0); 
    public static int RADIUS = 50;
    

    public PaintPanel() {    
      this.addMouseMotionListener(new MouseAdapter() {
        public void mouseMoved(MouseEvent e) { 
          if (triangle.contains(e.getX(), e.getY())) 
            isInside = true;
          else
            isInside = false;
          
          mousePoint.x = e.getX();
          mousePoint.y = e.getY();
          
          repaint();
        }
      });
    }

    /** Paint message */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawLine((int)(triangle.getP1().getX()), (int)(triangle.getP1().getY()),
        (int)(triangle.getP2().getX()), (int)(triangle.getP2().getY()));
      g.drawLine((int)(triangle.getP1().getX()), (int)(triangle.getP1().getY()),
          (int)(triangle.getP3().getX()), (int)(triangle.getP3().getY()));
      g.drawLine((int)(triangle.getP2().getX()), (int)(triangle.getP2().getY()),
          (int)(triangle.getP3().getX()), (int)(triangle.getP3().getY()));

      g.drawString(isInside ? "Mouse point is in the triangle" :
        "Mouse point is not in the triangle", 
        mousePoint.x, mousePoint.y);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new Exercise16_21();
    frame.setTitle("Exercise16_21");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}