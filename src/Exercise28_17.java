import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.List;

public class Exercise28_17 extends JApplet {
  private JButton jbtMST = new JButton("Show MST");

  private JTextField jtfStartVertex = new JTextField(2);
  private JButton jbtAllSP = new JButton("Show All SP From the Source");
  
  private JTextField jtfStartVertex1 = new JTextField(2);
  private JTextField jtfEndVertex1 = new JTextField(2);
  private JButton jbtShortestPath = new JButton("Show Shortest Path");
  
  private ArrayList<Vertex> list = new ArrayList<Vertex>();
  private ArrayList<Edge> edges = new ArrayList<Edge>();  	
  
  private WeightedGraph<Vertex> graph = null;
  private GraphView view = new GraphView();  
  private AbstractGraph<Vertex>.Tree tree = null;
  
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet applet = new Exercise28_17();
    frame.add(applet);
    frame.setTitle("Exercise27_37");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1050, 400);
    frame.setVisible(true);
  }
  
  public Exercise28_17() {
  	jtfStartVertex.setHorizontalAlignment(JTextField.RIGHT);
    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("Source vertex: "));
    panel1.add(jtfStartVertex);
    panel1.add(jbtAllSP);

    JPanel panel2 = new JPanel();
    panel2.add(new JLabel("Starting vertex: "));
    panel2.add(jtfStartVertex1);
    panel2.add(new JLabel("Ending vertex: "));
    panel2.add(jtfEndVertex1);
    panel2.add(new JLabel(""));
    panel2.add(jbtShortestPath);
    panel2.setBorder(new TitledBorder("Find a shortest path"));

    JPanel panel = new JPanel();
    panel.add(jbtMST);
    panel.add(panel1);
    panel.add(panel2);
    
    add(view);
    add(panel, BorderLayout.SOUTH);
    
    jbtMST.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateGraph();
        WeightedGraph<Vertex>.Tree tree = graph.getMinimumSpanningTree();
        view.setTree(tree);
        view.setPath(null); // repaint is invoked
      }
    });  
    
    jbtAllSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try {
          int u = Integer.parseInt(jtfStartVertex.getText().trim());
	        if (u < 0 || u >= list.size())
	          JOptionPane.showMessageDialog(
	            null, "Vertex " + u + " is not in the graph");
          
          updateGraph();
          AbstractGraph<Vertex>.Tree tree = graph.getShortestPath(u);

          view.setTree(tree);
          view.repaint();
       }
       catch (Exception ex) {
         ex.printStackTrace();   		
  	   }
     }
    });    
    
    jbtShortestPath.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try {
          int u = Integer.parseInt(jtfStartVertex1.getText().trim());
	        if (u < 0 || u >= list.size())
	          JOptionPane.showMessageDialog(
	            null, "Vertex " + u + " is not in the graph");

	        int v = Integer.parseInt(jtfEndVertex1.getText().trim());
	        if (v < 0 || v >= list.size())
	          JOptionPane.showMessageDialog(
	            null, "Vertex " + v + " is not in the graph");
          
          updateGraph();
          AbstractGraph<Vertex>.Tree tree = graph.getShortestPath(u);
          List<Vertex> path = tree.getPath(v);
          
          view.setTree(null);
          view.setPath(path);
          view.repaint();
       }
       catch (Exception ex) {
         ex.printStackTrace();   		
  	   }
     }
    });    
  }
  
  void updateGraph() {
    ArrayList<WeightedEdge> listOfEdges = new ArrayList<WeightedEdge>();
    for (int i = 0; i < edges.size(); i++) {
    	int x = list.indexOf(edges.get(i).u);
    	int y = list.indexOf(edges.get(i).v);
    	int w = (int)Vertex.getDistance(edges.get(i).u, edges.get(i).v);
    	listOfEdges.add(new WeightedEdge(x, y, w));
    	listOfEdges.add(new WeightedEdge(y, x, w));
    }
   
    graph = new WeightedGraph<Vertex>(listOfEdges, list);
  }
  
  class GraphView extends JPanel {
  	private Vertex startV = null;
  	private boolean isLineOn = false;
  	private int endOfLineX, endOfLineY;
  	private AbstractGraph<Vertex>.Tree tree = null;
    List<Vertex> path = null;

  	GraphView() {
  		addMouseListener(new MouseAdapter() {
  			public void mouseClicked(MouseEvent e) {
  				if (e.getButton() == MouseEvent.BUTTON1) {
  					// Add a vertex
	  				if (!isTooCloseToVertex(e.getPoint())) {
	    				list.add(new Vertex(e.getPoint()));
	            view.setTree(null); // repaint is invoked
	  				}
  				}
  				else if (e.getButton() == MouseEvent.BUTTON3) {
  					// remove a vertex
    				Vertex c = getContainingVertex(e.getPoint());
    				if (c != null) {
    					list.remove(c);
    					removeAdjacentEdges(c);
              view.setTree(null); // repaint is invoked
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
            view.setTree(null); // repaint is invoked
            view.setPath(null); // repaint is invoked
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
              view.setTree(null); // repaint is invoked
              view.setPath(null); // repaint is invoked
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
  	
    public void setTree(AbstractGraph<Vertex>.Tree tree) {
      this.tree = tree;
      repaint();
    }
    
    public void setPath(List<Vertex> path) {
      this.path = path;
      repaint();
    }
  	
  	boolean isTooCloseToVertex(Point p) {
  		for (int i = 0; i < list.size(); i++)
  			if (Vertex.getDistance(list.get(i).getX(), list.get(i).getY(), p.x, p.y) <= 2 * Vertex.RADIUS + 5)
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
  		
  		g.setColor(Color.BLACK);
  		for (int i = 0; i < list.size(); i++) {
  			g.drawOval(list.get(i).getX() - Vertex.RADIUS, list.get(i).getY() - Vertex.RADIUS, 2 * Vertex.RADIUS, 2 * Vertex.RADIUS);
  			g.drawString(i + "",  list.get(i).getX() - 4, list.get(i).getY() + 4);
  		}

  		if (isLineOn) {
  			g.drawLine(startV.getX(), startV.getY(), endOfLineX, endOfLineY);
  		}
  		
  		// Draw edges
  		for (int i = 0; i < edges.size(); i++) {
  			int x1 = edges.get(i).u.getX();
  			int y1 = edges.get(i).u.getY();
  			int x2 = edges.get(i).v.getX();
  			int y2 = edges.get(i).v.getY();
  			connectTwoCircles(g, x1, y1, x2, y2, Vertex.RADIUS);
  			// draw distance
  			int distance = (int)Vertex.getDistance(x1, y1, x2, y2);
  			g.drawString(distance + "", (x1 + x2) / 2, (y1 + y2) / 2);
  		}
  		
			drawInstructions(g, 20, 20);
			
      // Highlight the edges in the spanning tree
      if (tree != null) {
        g.setColor(java.awt.Color.RED);
        for (int i = 0; i < graph.getSize(); i++) {
          if (tree.getParent(i) != -1) {
            int v = tree.getParent(i);
            int x1 = graph.getVertex(i).getX();
            int y1 = graph.getVertex(i).getY();
            int x2 = graph.getVertex(v).getX();
            int y2 = graph.getVertex(v).getY();
          
            drawArrowLine(g, x2, y2, x1, y1, Vertex.RADIUS);  
          }
        }
      }
      else if (path != null) {
        // Display the path    
        g.setColor(Color.RED);
        for (int i = 1; i < path.size(); i++) {
          int x1 = path.get(i).getX();
          int y1 = path.get(i).getY();
          int x2 = path.get(i - 1).getX();
          int y2 = path.get(i - 1).getY();
          drawArrowLine(g, x1, y1, x2, y2, Vertex.RADIUS);
        }  
      }
  	}
  	
		final String[] instructions = { "INSTRUCTIONS", "Add:", "Left Click",
				"Move:", "Ctrl Drag", "Connect:", "Drag", "Remove:",
				"Right Click" };

		void drawInstructions(Graphics g, int x, int y) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, x + 150, y + 90);
			g.drawString(instructions[0], x + 10, y + 20);
			for (int i = 1; i < instructions.length; i = i + 2) {
				g.drawString(instructions[i], x + 10, y + 20 + (i + 1) * 10);
				g.drawString(instructions[i + 1], x + 100, y + 20 + (i + 1) * 10);
			}
		}	
  }
  
  /** Connect two circles centered at (x1, y1) and (x2, y2) */
  private static void connectTwoCircles(Graphics g, 
      int x1, int y1, int x2, int y2, int radius) {
  	double vGap = Math.abs(y2 - y1);
    double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    int x11 = (int)(x1 - radius * (x1 - x2) / d);
    int y11 = (int)(y1 - radius * (y1 - y2) / d);
    int x21 = (int)(x2 + radius * (x1 - x2) / d);
    int y21 = (int)(y2 + radius * (y1 - y2) / d);
    g.drawLine(x11, y11, x21, y21);
  }  
  
  /** Connect two circles centered at (x1, y1) and (x2, y2) */
  private static void drawArrowLine(Graphics g, 
      int x1, int y1, int x2, int y2, int radius) {
  	double vGap = Math.abs(y2 - y1);
    double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    int x11 = (int)(x1 - radius * (x1 - x2) / d);
    int y11 = (int)(y1 - radius * (y1 - y2) / d);
    int x21 = (int)(x2 + radius * (x1 - x2) / d);
    int y21 = (int)(y2 + radius * (y1 - y2) / d);
    drawArrowLine(g, x11, y11, x21, y21);
  }  
  
  private static void drawArrowLine(Graphics g, int x1, int y1, 
      int x2, int y2) {
    g.setColor(Color.red);
    g.drawLine(x1, y1, x2, y2);
    
    // find slope of this line
    double slope = ((((double) y1) - (double) y2))
        / (((double) x1) - (((double) x2)));

    double arctan = Math.atan(slope);

    // This will flip the arrow 45 off of a
    // perpendicular line at pt x2
    double set45 = 1.57 / 2;
    
    // arrows should always point towards i, not i+1
    if (x1 < x2) {
      // add 90 degrees to arrow lines
      set45 = -1.57 * 1.5;
    }

    // set length of arrows
    int arrlen = 15;

    // draw arrows on line
    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan + set45) * arrlen))),
        (int) (((y2)) + (Math.sin(arctan + set45) * arrlen)));

    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan - set45) * arrlen))),
        (int) (((y2)) + (Math.sin(arctan - set45) * arrlen)));
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