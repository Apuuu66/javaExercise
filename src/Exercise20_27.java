import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise20_27 extends JApplet {
  private JTextField jtfOrder = new JTextField(5); // To hold order
  private Exercise20_27Panel snowflakePanel =
    new Exercise20_27Panel(); // To display the pattern

  public Exercise20_27() {
    // Panel to hold label, text field, and a button
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter an order: "));
    panel.add(jtfOrder);
    jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);

    add(snowflakePanel);
    add(panel, BorderLayout.SOUTH);

    // Register a listener
    jtfOrder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        snowflakePanel.setOrder(Integer.parseInt(jtfOrder.getText()));
      }   	
    });
  }

  static class Exercise20_27Panel extends JPanel {
    private int order = 0;

    /** Set a new order */
    public void setOrder(int order) {
      this.order = order;
      repaint();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      int side = (int)(Math.min(getWidth(), getHeight()) * 0.8);
      int triangleHeight = (int)(side * Math.sin(Math.toRadians(60)));
      
      // Set initial three points
      Point p1 = new Point(getWidth() / 2, 10);
      Point p2 = new Point(getWidth() / 2 - side / 2, 10 + triangleHeight);
      Point p3 = new Point(getWidth() / 2 + side / 2, 10 + triangleHeight);

      displayKochSnowFlake(g, order, p1, p2);
      displayKochSnowFlake(g, order, p2, p3);
      displayKochSnowFlake(g, order, p3, p1);
    }

    private static void displayKochSnowFlake(Graphics g, int order, Point p1, Point p2) {
      if (order == 0) {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
      }
      else { // order > 0
        int deltaX = p2.x - p1.x;
        int deltaY = p2.y - p1.y;

        Point x = new Point(p1.x + deltaX / 3, p1.y + deltaY / 3);
        Point y = new Point(p1.x + deltaX * 2 / 3, p1.y + deltaY * 2 / 3);
        Point z = new Point(
          (int)((p1.x + p2.x) / 2 + Math.cos(Math.toRadians(30)) * (p1.y - p2.y) / 3),
          (int)((p1.y + p2.y) / 2 + Math.cos(Math.toRadians(30)) * (p2.x - p1.x) / 3));

        // Recursively display snow flakes on lines
        displayKochSnowFlake(g, order - 1, p1, x);
        displayKochSnowFlake(g, order - 1, x, z);
        displayKochSnowFlake(g, order - 1, z, y);
        displayKochSnowFlake(g, order - 1, y, p2);
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise20_27");
    Exercise20_27 applet = new Exercise20_27();
    frame.add(applet);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
