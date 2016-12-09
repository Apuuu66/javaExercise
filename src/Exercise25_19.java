import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise25_19 extends JApplet {
  private LinkedList<Integer> queue = new LinkedList<Integer>();
  private QueueView view = new QueueView();
  private JButton jbtInsert = new JButton("Insert (enqueue)");
  private JButton jbtDelete = new JButton("Delete (dequeue)");
  private JTextField jtfNumber = new JTextField(2);
  
  public Exercise25_19() {    
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter a value: "));
    panel.add(jtfNumber);
    panel.add(jbtInsert);
    panel.add(jbtDelete);
    
    add(view);  
    add(panel, BorderLayout.SOUTH);

    jbtInsert.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        queue.addLast(Integer.parseInt(jtfNumber.getText()));
        view.repaint();
      }
    });
    
    jbtDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        queue.removeFirst(); 
        view.repaint();
      }
    });
  }
  
  public class QueueView extends JPanel {
    private int startingX = 20;
    private int startingY = 20;
    private int boxWidth = 30;
    private int boxHeight = 20;
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      if (queue.size() == 0) {
        g.drawString("queue is empty", startingX, startingY);
      }
      else {
        g.drawString("queue", startingX, startingY);        
        int x = startingX + 10;
        int y = startingY + 10;        
        
        for (int i = 0; i < queue.size(); i++) {
          g.drawRect(x, y, boxWidth, boxHeight);
          g.drawString(queue.get(i) + "", x + 10, y + 15);
          x = x + boxWidth;
        }
      }
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new Exercise25_19());
    frame.setTitle("Exercise25_19");
    frame.setSize(400, 130);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}