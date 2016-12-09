import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise27_21 extends JApplet {
  private List<Circle> circles = new ArrayList<Circle>();
  
  public Exercise27_21() {
    add (new CirclePanel());
  }
    
  class CirclePanel extends JPanel {
	int colorIndex = 0;
	private Color[] colorList = {Color.BLACK, Color.BLUE, Color.CYAN, 
	  Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, 
	  Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
	  Color.YELLOW};
			  
	public CirclePanel() {
	  addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		  if (!isInsideACircle(e.getPoint())) { // Add a new circle
			circles.add(new Circle(e.getX(), e.getY()));
			repaint();
	      }
		}
	  });
	}
	
	private boolean isInsideACircle(Point p) {
	  for (Circle circle: circles) 
		if (circle.contains(p)) return true;

	  return false;
	}
	
	protected void paintComponent(Graphics g) {
	  if (circles.size() == 0) return; // Nothing to paint
		  
	  super.paintComponent(g);
	  
	  // Build the edges
	  List<AbstractGraph.Edge> edges 
	    = new ArrayList<AbstractGraph.Edge>();
	  for (int i = 0; i < circles.size(); i++)
		for (int j = i + 1; j < circles.size(); j++)
		  if (circles.get(i).overlaps(circles.get(j))) {
			 edges.add(new AbstractGraph.Edge(i, j));
			 edges.add(new AbstractGraph.Edge(j, i));
		  }
	  
	  // Create a graph with circles as vertices
	  Exercise27_4.MyGraph<Circle> graph = new Exercise27_4.MyGraph<Circle>(edges, circles);
	  
	  List<List<Integer>> connectedComponents = graph.getConnectedComponents();
	  	  
	  for (List<Integer> list: connectedComponents) {
		g.setColor(colorList[(colorIndex++) % colorList.length]);
		for (int i: list) {  
		  Circle circle = circles.get(i);
		  int radius = circle.radius;		

		  g.fillOval(circle.x - radius, circle.y - radius, 
		    2 * radius, 2 * radius);
		}
	  }
	}
  }
  
  private static class Circle {
	int radius = 20;
	int x, y;
	
	Circle(int x, int y) {
	  this.x = x;
	  this.y = y;
	}	
	
	public boolean contains(Point p) {
	  double d = distance(x, y, p.x, p.y) ;
      return d <= radius;
    }
	
	public boolean overlaps(Circle circle) {    
	  return distance(this.x, this.y, circle.x, circle.y) 
	    <= radius + circle.radius;
	}
	  
	private static double distance(int x1, int y1, int x2, int y2) {
	  return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet applet = new Exercise27_21();
    frame.add(applet);
    frame.setTitle("Exercise27_21");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}