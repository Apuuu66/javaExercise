import java.awt.BorderLayout;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise28_13 extends JApplet {
  private JTextField jtfStartCity = new JTextField(15);
  private JTextField jtfEndCity = new JTextField(15);
  private JButton jbtSP = new JButton("Display Shortest Path");
  private City[] vertices = { new City("Seattle", 75, 50),
    new City("San Francisco", 50, 210),
    new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
    new City("Kansas City", 400, 245),
    new City("Chicago", 450, 100), new City("Boston", 700, 80),
    new City("New York", 675, 120), new City("Atlanta", 575, 295),
    new City("Miami", 600, 400), new City("Dallas", 408, 325),
    new City("Houston", 450, 360) };

  private int[][] edges = {
    {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
    {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
    {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
    {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, 
      {3, 5, 1003},
    {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
      {4, 8, 864}, {4, 10, 496},
    {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, 
      {5, 6, 983}, {5, 7, 787},
    {6, 5, 983}, {6, 7, 214},
    {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
    {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, 
      {8, 10, 781}, {8, 11, 810},
    {9, 8, 661}, {9, 11, 1187},
    {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
    {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
  };

  private WeightedGraph<City> graph1 = 
    new WeightedGraph<City>(edges, vertices);
  private GraphView view = new GraphView(graph1);
  
  public Exercise28_13() {   
    JPanel panel = new JPanel();
    panel.add(new JLabel("Starting City:"));
    panel.add(jtfStartCity);
    panel.add(new JLabel("Ending City:"));
    panel.add(jtfEndCity);
    panel.add(jbtSP);
    
    add(view);
    add(panel, BorderLayout.SOUTH);  
    
    jbtSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name1 = jtfStartCity.getText();
        int index1 = graph1.getIndex(new City(name1, 0, 0));
        if (index1 < 0) {
          JOptionPane.showMessageDialog(null, name1 + " is not in the map");
          return;
        }
        
        String name2 = jtfEndCity.getText();
        int index2 = graph1.getIndex(new City(name2, 0, 0));
        if (index2 < 0) 
          JOptionPane.showMessageDialog(null, name2 + " is not in the map");
        else {
          List<City> path = graph1.getShortestPath(index1).getPath(index2);          
          view.setPath(path);
        }
      }
    });
  }
  
  class GraphView extends javax.swing.JPanel {
    Graph<? extends Displayable> graph;
    List<? extends Displayable> path;
    
    public GraphView(Graph<? extends Displayable> graph, 
        List<? extends Displayable> path) {
      this.graph = graph;
      this.path = path;
    }
    
    public GraphView(Graph<? extends Displayable> graph) {
      this.graph = graph;
    }

    public void setPath(List<? extends Displayable> path) {
      this.path = path;
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
        List<Integer> neighbors = graph.getNeighbors(i);
        for (int j = 0; j < neighbors.size(); j++) {
          int v = neighbors.get(j);
          int x1 = graph.getVertex(i).getX();
          int y1 = graph.getVertex(i).getY();
          int x2 = graph.getVertex(v).getX();
          int y2 = graph.getVertex(v).getY();
          
          g.drawLine(x1, y1, x2, y2);
        }
      }
      
      // Display weights
      List<PriorityQueue<WeightedEdge>> queues = 
        ((WeightedGraph<? extends Displayable>)graph).getWeightedEdges();    
      
      for (int i = 0; i < graph.getSize(); i++) {
        ArrayList<WeightedEdge> list = new ArrayList<WeightedEdge>(queues.get(i));
        
        for (WeightedEdge edge: list) {
          int u = edge.u;
          int v = edge.v;
          double weight = edge.weight;
          int x1 = graph.getVertex(u).getX();
          int y1 = graph.getVertex(u).getY();
          int x2 = graph.getVertex(v).getX();
          int y2 = graph.getVertex(v).getY();
          g.drawString(weight + "", (x1 + x2) / 2, (y1 + y2) / 2 - 6);
        }
      }
      
      // Display the path
      if (path == null) return;
      g.setColor(Color.RED);
      for (int i = 1; i < path.size(); i++) {
        int x1 = path.get(i).getX();
        int y1 = path.get(i).getY();
        int x2 = path.get(i - 1).getX();
        int y2 = path.get(i - 1).getY();
        g.drawLine(x1, y1, x2, y2);
      }
    }
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
    JFrame frame = new JFrame("Exercise28_13");
    Exercise28_13 applet = new Exercise28_13();
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();

    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750, 500);
    frame.setVisible(true);
  }
}