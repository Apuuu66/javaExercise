import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Exercise15_27 extends JFrame {
  public Exercise15_27() throws Exception {
    System.out.print("Enter a file name for the graph: ");
    Scanner input = new Scanner(System.in);
    String filename = input.nextLine();
    
    Scanner file = new Scanner(new File(filename));
    int n = Integer.parseInt(file.nextLine());
    
    int[][] positions = new int[n][2];
    ArrayList[] lists = new ArrayList[n];
    
    for (int i = 0; i < n; i++) {
      String[] tokens = file.nextLine().split("[\\s+]");
      positions[i][0] = Integer.parseInt(tokens[1]); 
      positions[i][1] = Integer.parseInt(tokens[2]); 
      
      lists[i] = new ArrayList();
      for (int k = 3; k < tokens.length; k++)
        lists[i].add(Integer.parseInt(tokens[k]));
    }
    
    add(new GraphView(positions, lists));
  }

  class GraphView extends JPanel {
    int[][] positions;
    ArrayList[] lists;
    
    public GraphView(int[][] positions, ArrayList[] lists) {
      this.positions = positions;
      this.lists = lists;
    }
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      // Draw vertices
      for (int i = 0; i < positions.length; i++) {
        g.fillOval(positions[i][0] - 8, positions[i][1] - 8, 16, 16);
        g.drawString(i + "", positions[i][0] - 12, positions[i][1] - 12);
      }
      
      // Draw edges
      for (int i = 0; i < lists.length; i++) {
        for (int j = 0; j < lists[i].size(); j++) {
          int v = (Integer)lists[i].get(j);
          g.drawLine(positions[i][0], positions[i][1],
              positions[v][0], positions[v][1]);
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    Exercise15_27 frame = new Exercise15_27();
    frame.setSize(400, 400);
    frame.setTitle("Exercise15_27");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
