import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise16_37 extends JFrame {
  public Exercise16_37() {
    add(new TwoCircles());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise16_37 frame = new Exercise16_37();
    frame.setTitle("Exercise16_37");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
  
  static class TwoCircles extends JPanel {
  	Circle c1 = new Circle(20, 20);
  	Circle c2 = new Circle(120, 50);
  	
  	TwoCircles() {
  		this.addMouseMotionListener(new MouseMotionAdapter() {
  			public void mouseDragged(MouseEvent e) {
  				if (c1.contains(e.getPoint()) && Circle.getDistance(e.getX(), e.getY(), c2.getX(), c2.getY()) > 70) {
    				c1.setX(e.getX());
    				c1.setY(e.getY());
  					repaint();
  				}
  				else if (c2.contains(e.getPoint()) && Circle.getDistance(e.getX(), e.getY(), c1.getX(), c1.getY()) > 70) {
    				c2.setX(e.getX());
    				c2.setY(e.getY());
  					repaint();
  				}	
  			}
  		});
  	}
  	
  	protected void paintComponent(Graphics g) {
  		super.paintComponent(g);
  		g.setColor(Color.RED);
  		g.fillOval(c1.getX() - Circle.RADIUS, c1.getY() - Circle.RADIUS, 2 * Circle.RADIUS, 2 * Circle.RADIUS);
  		g.fillOval(c2.getX() - Circle.RADIUS, c2.getY() - Circle.RADIUS, 2 * Circle.RADIUS, 2 * Circle.RADIUS);  		
  		g.setColor(Color.BLACK);
  		g.drawLine(c1.getX(), c1.getY(), c2.getX(), c2.getY());
  		int distance = (int)c1.getDistance(c2);
  		g.drawString(distance + "", (c1.getX() + c2.getX()) / 2, (c1.getY() + c2.getY()) / 2);
  	}
  }
  
  static class Circle {
  	final static int RADIUS = 20;
  	int x, y;
  	
  	public Circle() {
  	}
  	
  	public Circle(int x, int y) {
  		this.x = x;
  		this.y = y;
  	}
  	
  	public int getX() {
  		return x;
  	}
  	
  	public void setX(int x) {
  		this.x = x;
  	}
  	
  	public int getY() {
  		return y;
  	}
  	
  	public void setY(int y) {
  		this.y = y;
  	}
  	
  	public double getDistance(Circle c) {
  		return getDistance(x, y, c.x, c.y);
  	}
  	
  	public static double getDistance(Circle c1, Circle c2) {
  		return getDistance(c1.x, c1.y, c2.x, c2.y);
  	}
  	
  	public static double getDistance(double x1, double y1, double x2, double y2) {
  		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  	}
  	
  	public boolean contains(Point p) {
  		return getDistance(x, y, p.x, p.y) <= RADIUS;
  	}
  }
}
