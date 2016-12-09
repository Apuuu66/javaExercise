import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Exercise16_39 extends JFrame {
  public Exercise16_39() {
    add(new View());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise16_39 frame = new Exercise16_39();
    frame.setTitle("Exercise16_39");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
    
  class View extends JPanel {
    private ArrayList<Vertex> list = new ArrayList<Vertex>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();  	
  	private Vertex startV = null;
  	private boolean isLineOn = false;
  	private int endOfLineX, endOfLineY;

  	View() {
  		addMouseListener(new MouseAdapter() {
  			public void mouseClicked(MouseEvent e) {
  				if (e.getButton() == MouseEvent.BUTTON1) {
  					// Add a vertex
	  				if (!isTooCloseToVertex(e.getPoint())) {
	    				list.add(new Vertex(e.getPoint()));
	  					repaint();
	  				}
  				}
  				else if (e.getButton() == MouseEvent.BUTTON3) {
  					// remove a vertex
    				Vertex c = getContainingVertex(e.getPoint());
    				if (c != null) {
    					list.remove(c);
    					removeAdjacentEdges(c);
    					repaint();
    				}
    			}  					
  		  }
  			
  			public void mousePressed(MouseEvent e) {
  				Vertex c = getContainingVertex(e.getPoint());
  				if (c != null) {
  					startV = c;  				  
  					endOfLineX = e.getX();
  				  endOfLineY = e.getY();
  					isLineOn = true;  				
    				repaint();
  				}
  		  }
  			
  			public void mouseReleased(MouseEvent e) {
  				Vertex c = getContainingVertex(e.getPoint());
  				if (isLineOn && c != null && !c.equals(startV)) {
  					// Add a new edge
  					edges.add(new Edge(startV, c)); 				  
  				}
  				
  				isLineOn = false;
					repaint();
  		  }
  		});
  		
  		addMouseMotionListener(new MouseMotionAdapter() {
  			public void mouseDragged(MouseEvent e) {
  				if (e.isControlDown()) {
  					isLineOn = false;
    				Vertex c = getContainingVertex(e.getPoint());
    				if (c != null) {
    					c.setX(e.getX());
    					c.setY(e.getY());
    					repaint();
    				}				
  				}
  				else if (isLineOn) {
  				  endOfLineX = e.getX();
  				  endOfLineY = e.getY();
  				  repaint();
  				}
  		  }
  		});
  	}
  	
  	boolean isTooCloseToVertex(Point p) {
  		for (int i = 0; i < list.size(); i++)
  			if (Vertex.getDistance(list.get(i).getX(), list.get(i).getY(), p.x, p.y) <= 2 * Vertex.RADIUS + 20)
  				return true;
  		
  		return false;
  	}
  	
  	Vertex getContainingVertex(Point p) {
  		for (int i = 0; i < list.size(); i++)
  			if (list.get(i).contains(p))
  				return list.get(i);
  		
  		return null;
  	}
  	
  	void removeAdjacentEdges(Vertex vertex) {
  		for (int i = 0; i < edges.size(); i++)
  			if (edges.get(i).u.equals(vertex) || edges.get(i).v.equals(vertex)) {
  				edges.remove(i--); 
  			}
  	}
  	
  	protected void paintComponent(Graphics g) {
  		super.paintComponent(g);
  		
  		g.setColor(Color.RED);
  		for (int i = 0; i < list.size(); i++) {
  			g.fillOval(list.get(i).getX() - Vertex.RADIUS, list.get(i).getY() - Vertex.RADIUS, 2 * Vertex.RADIUS, 2 * Vertex.RADIUS);
  		}

  		if (isLineOn) {
  			g.drawLine(startV.getX(), startV.getY(), endOfLineX, endOfLineY);
  		}
  		
  		for (int i = 0; i < edges.size(); i++) {
  			g.drawLine(edges.get(i).u.getX(), edges.get(i).u.getY(), edges.get(i).v.getX(), edges.get(i).v.getY());
  		}
  		
			drawInstructions(g, 20, 20);
  	}
  	
		final String[] instructions = { "INSTRUCTIONS", "Add:", "Left Click",
				"Move:", "Ctrl Drag", "Connect:", "Drag", "Remove:",
				"Right Click" };

		void drawInstructions(Graphics g, int x, int y) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, x + 200, y + 90);
			g.drawString(instructions[0], x + 10, y + 20);
			for (int i = 1; i < instructions.length; i = i + 2) {
				g.drawString(instructions[i], x + 10, y + 20 + (i + 1) * 10);
				g.drawString(instructions[i + 1], x + 100, y + 20 + (i + 1) * 10);
			}
		}
  }
  
  static class Vertex {
  	final static int RADIUS = 20;
  	int x, y;
  	
  	public Vertex() {
  	}
  	
  	public Vertex(int x, int y) {
  		this.x = x;
  		this.y = y;
  	}
  	
  	public Vertex(Point p) {
  		this(p.x, p.y);
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
  	
  	public boolean equals(Object o) {
  		Vertex c = (Vertex)o;
  		return c.getX() == x && c.getY() == y; 
  	}
  	
  	public double getDistance(Vertex c) {
  		return getDistance(x, y, c.x, c.y);
  	}
  	
  	public static double getDistance(Vertex c1, Vertex c2) {
  		return getDistance(c1.x, c1.y, c2.x, c2.y);
  	}
  	
  	public static double getDistance(double x1, double y1, double x2, double y2) {
  		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  	}
  	
  	public boolean contains(Point p) {
  		return getDistance(x, y, p.x, p.y) <= RADIUS;
  	}
  }
  
  class Edge {
  	Vertex u, v;
  	
  	public Edge(Vertex u, Vertex v) {
  		this.u = u;
  		this.v = v;
  	}
  }
}