import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise25_17 extends JApplet {
  private LinkedList<Integer> list = new LinkedList<Integer>();
  private LinkedListView view = new LinkedListView();
  private JButton jbtSearch = new JButton("Search");
  private JButton jbtInsert = new JButton("Insert");
  private JButton jbtDelete = new JButton("Delete");
  private JTextField jtfNumber = new JTextField(2);
  private JTextField jtfIndex = new JTextField(2);
  
  public Exercise25_17() {    
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter a value: "));
    panel.add(jtfNumber);
    panel.add(new JLabel("Enter an index: "));
    panel.add(jtfIndex);
    panel.add(jbtSearch);
    panel.add(jbtInsert);
    panel.add(jbtDelete);
    
    add(view);  
    add(panel, BorderLayout.SOUTH);
    
    jbtSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!list.contains(Integer.parseInt(jtfNumber.getText()))) {
          JOptionPane.showMessageDialog(null, "key is not in the list");
        }       
        view.repaint();
      }
    });

    jbtInsert.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (jtfIndex.getText().trim().length() > 0)
          list.add(Integer.parseInt(jtfIndex.getText()), Integer.parseInt(jtfNumber.getText()));
        else
          list.add(Integer.parseInt(jtfNumber.getText()));
        view.repaint();
      }
    });
    
    jbtDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!list.contains(Integer.parseInt(jtfNumber.getText()))) {
          JOptionPane.showMessageDialog(null, "key is not in the list");
        }       
        else {
          list.remove(new Integer(Integer.parseInt(jtfNumber.getText())));
          view.repaint();
        }
      }
    });
  }
  
  public class LinkedListView extends JPanel {
    private int startingX = 20;
    private int startingY = 20;
    private int boxWidth = 50;
    private int boxHeight = 20;
    private int arrowLineLength = 30;
    private int hGap = 80;
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      if (list.size() == 0) {
        g.drawString("head: null", startingX, startingY);
        g.drawString("tail: null", startingX, startingY + 15);
      }
      else {
        g.drawString("head", startingX, startingY);
        
        int x = startingX + 30;
        int y = startingY + 20;
        drawArrowLine(startingX + 5, startingY, x, y, g);
        g.setColor(Color.BLACK);
        
        for (int i = 0; i < list.size(); i++) {
          g.drawRect(x, y, boxWidth, boxHeight);
          g.drawLine(x + arrowLineLength, y, x + arrowLineLength, y + boxHeight);
          g.setColor(Color.RED);
          
          if (i < list.size() - 1)
            drawArrowLine(x + 40, y + boxHeight / 2, x + hGap, y + boxHeight / 2, g);
          g.setColor(Color.BLACK);
          g.drawString(list.get(i) + "", x + 10, y + 15);
          x = x + hGap;
        }

        g.drawString("tail", x, startingY);
        drawArrowLine(x, startingY, x - hGap, y, g);
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
    int arrlen = 10;

    // draw arrows on line
    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan + set45) * arrlen))),
      (int)(((y2)) + (Math.sin(arctan + set45) * arrlen)));

    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan - set45) * arrlen))),
      (int)(((y2)) + (Math.sin(arctan - set45) * arrlen)));
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new Exercise25_17());
    frame.setTitle("Exercise25_17");
    frame.setSize(500, 160);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}