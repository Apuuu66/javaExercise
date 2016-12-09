import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise27_23 extends JApplet {
  // Rectangles are stored in a list
  private List<Rectangle> rectangles = new ArrayList<Rectangle>();
  
  public Exercise27_23() {
    add (new RectanglePanel()); // Add to rectangle panel to applet
  }
    
  /** Panel for displaying rectangles */
  class RectanglePanel extends JPanel {
		public RectanglePanel() {
		  addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			  if (!isInsideARectangle(e.getPoint())) { // Add a new rectangle
				rectangles.add(new Rectangle(e.getX(), e.getY()));
				repaint();
		      }
			}
		  });
		}
		
		/** Returns true if the point is inside an existing rectangle */
		private boolean isInsideARectangle(Point p) {
		  for (Rectangle rectangle: rectangles) 
			if (rectangle.contains(p)) return true;
	
		  return false;
		}
		
		protected void paintComponent(Graphics g) {
		  if (rectangles.size() == 0) return; // Nothing to paint
			  
		  super.paintComponent(g);
		  
		  // Build the edges
		  List<AbstractGraph.Edge> edges 
		    = new ArrayList<AbstractGraph.Edge>();
		  for (int i = 0; i < rectangles.size(); i++)
			for (int j = i + 1; j < rectangles.size(); j++)
			  if (rectangles.get(i).overlaps(rectangles.get(j))) {
				 edges.add(new AbstractGraph.Edge(i, j));
				 edges.add(new AbstractGraph.Edge(j, i));
			  }
		  
		  // Create a graph with rectangles as vertices
		  Graph<Rectangle> graph 
		    = new UnweightedGraph<Rectangle>(edges, rectangles);
		  AbstractGraph<Rectangle>.Tree tree = graph.dfs(0); // a DFS tree
		  boolean isAllRectanglesConnected = 
			rectangles.size() == tree.getNumberOfVerticesFound(); 
		  
		  for (Rectangle rectangle: rectangles) {
			int w = rectangle.width;		
			int h = rectangle.height;		
			if (isAllRectanglesConnected) { // All rectangles are connected
			  g.setColor(Color.RED);
			  g.fillRect(rectangle.x - w / 2, rectangle.y - h / 2, w, h);
			}
			else // rectangles are not all connected
		      g.drawRect(rectangle.x - w / 2, rectangle.y - h / 2, w, h);
		  }
		}
  }
  
  private static class Rectangle {
		int width = 40;
		int height = 40;
		int x, y;
		
		Rectangle(int x, int y) {
		  this.x = x;
		  this.y = y;
		}	
		
		public boolean contains(Point p) {
	      return Math.abs(p.x - x) <= width / 2 && Math.abs(p.y - y) <= height / 2;
	    }
		
		public boolean overlaps(Rectangle rectangle) {    
		  return Math.abs(rectangle.x - x) <= rectangle.width / 2 + width / 2
		     && Math.abs(rectangle.y - y) <= rectangle.height / 2 + height / 2;
		}
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet applet = new Exercise27_23();
    frame.add(applet);
    frame.setTitle("Exercise27_23");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}