import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Exercise16_23 extends JFrame { 
  private PointsPanel paintPanel = new PointsPanel();
  
  public Exercise16_23() {
    add(paintPanel);
  }

  class PointsPanel extends JPanel {
    final static int RADIUS = 5;
    ArrayList list = new ArrayList();
    // p1 and p2 are the indices of the two closest points in list
    int p1 = -1; 
    int p2 = -1;
    double d = Double.MAX_VALUE; // current minimum distance
    
    public PointsPanel() {
      this.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        	if (!isCovered(e.getPoint()))
            list.add(e.getPoint());
        	
          recalculateDistance();
          repaint();
        }
      });
    }
    
    public boolean isCovered(Point point) {
    	for (int i = 0; i < list.size(); i++)
    		if (distance(point.x, point.y, ((Point)(list.get(i))).x, 
    				((Point)(list.get(i))).y) < RADIUS)
    			return true;
    	return false;
    }
    
    /** Find two points that are nearest to each other */
    private void recalculateDistance() {
      // Compare the distance from the newly-added point to all others
      if (list.size() < 1)
        return;
      if (list.size() == 2) {
        p1 = 0;
        p2 = 1;
        d = distance(((Point)list.get(p1)).x, ((Point)list.get(p1)).y,
          ((Point)list.get(p2)).x, ((Point)list.get(p2)).y);
      }
      else {
        for (int i = 0; i < list.size() - 1; i++) {
          double dis = distance(((Point)list.get(i)).x, 
              ((Point)list.get(i)).y,
              ((Point)list.get(list.size() - 1)).x, 
              ((Point)list.get(list.size() - 1)).y);
          if (dis < d) {
            d = dis;
            p1 = i;
            p2 = list.size() - 1;
          }
        }
      }
    }
    
    /** Compute the distance between two points (x1, y1) and (x2, y2)*/
    private double distance(
        double x1, double y1, double x2, double y2) {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    
    /** Paint points */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
 
      for (int i = 0; i < list.size(); i++) {
        g.drawOval(((Point)list.get(i)).x - RADIUS, 
            ((Point)list.get(i)).y - RADIUS, 2 * RADIUS, 2 * RADIUS);
      }
      
      if (p1 >= 0) {
        g.fillOval(((Point)list.get(p1)).x - RADIUS, 
            ((Point)list.get(p1)).y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        g.fillOval(((Point)list.get(p2)).x - RADIUS, 
            ((Point)list.get(p2)).y - RADIUS, 2 * RADIUS, 2 * RADIUS);  
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new Exercise16_23();
    frame.setTitle("Exercise16_23");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}