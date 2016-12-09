import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_31 extends JFrame {
  private JButton jbtEnlarge = new JButton("+1");
  private JButton jbtShrink = new JButton("-1");
  private RegularPolygonPanel canvas = new RegularPolygonPanel();
  
  public Exercise16_31() {
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(jbtEnlarge);
    panel.add(jbtShrink);
    
    this.add(canvas, BorderLayout.CENTER); // Add canvas to center
    this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame
    
    jbtEnlarge.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.setNumberOfSides(canvas.getNumberOfSides() + 1);
      }
    });

    jbtShrink.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.setNumberOfSides(canvas.getNumberOfSides() - 1);
      }
    });    
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new Exercise16_31();
    frame.setTitle("Exercise16_31");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
