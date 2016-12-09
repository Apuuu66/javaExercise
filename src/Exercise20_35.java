import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise20_35 extends JApplet {
  private JTextField jtfOrder = new JTextField(5); // To hold order
  private Exercise20_31Panel hTreePanel =
    new Exercise20_31Panel(); // To display the pattern

  public Exercise20_35() {
    // Panel to hold label, text field, and a button
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter an order: "));
    panel.add(jtfOrder);
    jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);

    // Add a H-tree panel to the applet
    add(hTreePanel);
    add(panel, BorderLayout.SOUTH);

    // Register a listener
    jtfOrder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        hTreePanel.setOrder(Integer.parseInt(jtfOrder.getText()));
      } 	
    });
  }

  static class Exercise20_31Panel extends JPanel {
    private int order = 0;

    /** Set a new order */
    public void setOrder(int order) {
      this.order = order;
      repaint();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      // (xCenter, yCenter) is the center of the H shape
      int xCenter = getWidth() / 2; 
      int yCenter = getHeight() / 2;
      int length = getWidth() / 2; // Length of the a line

      displayHTree(g, order, xCenter, yCenter, length);
    }

    private static void displayHTree(Graphics g, int order,
        int xCenter, int yCenter, int length) {
      // Locate four endpoints
      Point p1 = new Point(xCenter - length / 2, yCenter - length / 2);
      Point p2 = new Point(xCenter + length / 2, yCenter - length / 2);
      Point p3 = new Point(xCenter - length / 2, yCenter + length / 2);
      Point p4 = new Point(xCenter + length / 2, yCenter + length / 2);
      
      // Draw three lines in an H-shape
      g.drawLine(p1.x, p1.y, p3.x, p3.y);
      g.drawLine(p2.x, p2.y, p4.x, p4.y);
      g.drawLine(xCenter - length / 2, yCenter, 
        xCenter + length / 2, yCenter);

      if (order > 0) {
        // Recursively display H-tree
        displayHTree(g, order - 1, p1.x, p1.y, length / 2);
        displayHTree(g, order - 1, p2.x, p2.y, length / 2);
        displayHTree(g, order - 1, p3.x, p3.y, length / 2);
        displayHTree(g, order - 1, p4.x, p4.y, length / 2);
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise20_35");
    Exercise20_35 applet = new Exercise20_35();
    frame.add(applet);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
