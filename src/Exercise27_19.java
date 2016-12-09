import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise27_19 extends JApplet {
  private JTextField jtfStartCity = new JTextField(15);
  private JButton jbtDisplayDFS = new JButton("Display DFS Tree");
  private JButton jbtDisplayBFS = new JButton("Display BFS Tree");
  private City[] vertices = {new City("Seattle", 75, 50),
    new City("San Francisco", 50, 210), new City("Los Angeles", 75, 275), 
    new City("Denver", 275, 175), new City("Kansas City", 400, 245),
    new City("Chicago", 450, 100), new City("Boston", 700, 80),
    new City("New York", 675, 120), new City("Atlanta", 575, 295),
    new City("Miami", 600, 400), new City("Dallas", 408, 325),
    new City("Houston", 450, 360)};

  // Edge array for graph in Figure 27.1
  private int[][] edges = {
    {0, 1}, {0, 3}, {0, 5},
    {1, 0}, {1, 2}, {1, 3},
    {2, 1}, {2, 3}, {2, 4}, {2, 10},
    {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
    {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
    {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
    {6, 5}, {6, 7},
    {7, 4}, {7, 5}, {7, 6}, {7, 8},
    {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
    {9, 8}, {9, 11},
    {10, 2}, {10, 4}, {10, 8}, {10, 11},
    {11, 8}, {11, 9}, {11, 10}
  };

  private Graph<City> graph1 = new UnweightedGraph<City>(edges, vertices);
  private GraphView view = new GraphView(graph1);
  
  public Exercise27_19() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Starting City:"));
    panel.add(jtfStartCity);
    panel.add(jbtDisplayDFS);
    panel.add(jbtDisplayBFS);
    
    add(view);
    add(panel, BorderLayout.SOUTH);  
    
    jbtDisplayDFS.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = jtfStartCity.getText();
        int index = graph1.getIndex(new City(name, 0, 0));
        if (index < 0) 
          JOptionPane.showMessageDialog(null, name + " is not in the map");
        else
          view.setTree(graph1.dfs(index));
      }
    });
    
    jbtDisplayBFS.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = jtfStartCity.getText();
        int index = graph1.getIndex(new City(name, 0, 0));
        if (index < 0) 
          JOptionPane.showMessageDialog(null, name + " is not in the map");
        else
          view.setTree(graph1.bfs(index));
      }
    });
  }
  
  class GraphView extends javax.swing.JPanel {
    private Graph<? extends Displayable> graph;
    private AbstractGraph<? extends Displayable>.Tree tree;
    
    public GraphView(Graph<? extends Displayable> graph, 
        AbstractGraph<? extends Displayable>.Tree tree) {
      this.graph = graph;
      this.tree = tree;
    }
    
    public GraphView(Graph<? extends Displayable> graph) {
      this.graph = graph;
    }

    public void setTree(AbstractGraph<? extends Displayable>.Tree tree) {
      this.tree = tree;
      repaint();
    }
    
    protected void paintComponent(java.awt.Graphics g) {
      super.paintComponent(g);
      
      // Draw vertices
      List<? extends Displayable> vertices = graph.getVertices();
      
      for (int i = 0; i < graph.getSize(); i++) {
        int x = vertices.get(i).getX();
        int y = vertices.get(i).getY();
        String name = vertices.get(i).getName();
        
        g.fillOval(x - 8, y - 8, 16, 16);
        g.drawString(name, x - 12, y - 12);
      }
      
      // Draw edges
      for (int i = 0; i < graph.getSize(); i++) {
        List<Integer> edges = graph.getNeighbors(i);
        for (int j = 0; j < edges.size(); j++) {
          int v = edges.get(j);
          int x1 = graph.getVertex(i).getX();
          int y1 = graph.getVertex(i).getY();
          int x2 = graph.getVertex(v).getX();
          int y2 = graph.getVertex(v).getY();
          
          g.drawLine(x1, y1, x2, y2);
        }
      }
      
      // Highlight the edges in the spanning tree
      if (tree == null) return;
      
      g.setColor(java.awt.Color.RED);
      for (int i = 0; i < graph.getSize(); i++) {
        if (tree.getParent(i) != -1) {
          int v = tree.getParent(i);
          int x1 = graph.getVertex(i).getX();
          int y1 = graph.getVertex(i).getY();
          int x2 = graph.getVertex(v).getX();
          int y2 = graph.getVertex(v).getY();
          
          drawArrowLine(x2, y2, x1, y1, g);  
        }
      }
    }
  }

  public static void drawArrowLine(int x1, int y1, 
      int x2, int y2, Graphics g) {
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
  
  class City implements Displayable {
    private int x, y;
    private String name;
    
    City(String name, int x, int y) {
      this.name = name;
      this.x = x;
      this.y = y;
    }
    
    public int getX() {
      return x;
    }
    
    public int getY() {
      return y;
    }
    
    public String getName() {
      return name;
    }
    
    public boolean equals(Object o) {
      return ((City)o).name.equals(this.name);
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise27_19");
    Exercise27_19 applet = new Exercise27_19();
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();

    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750, 500);
    frame.setVisible(true);
  }
}