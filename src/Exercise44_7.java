import java.awt.*;
import javax.swing.*;

public class Exercise44_7 extends JApplet {
  public Exercise44_7() {
    add(new ShapePanel());   
  }

  class ShapePanel extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D

      g2d.translate(150, 150);
      g2d.setFont(new Font("Serif", Font.BOLD, 40));
      
      String s = "WELCOME TO JAVA ";
      for (int i = 0; i < s.length(); i++) { 
        g2d.drawString(s.charAt(i) + "", 0, -100);
        g2d.rotate(2 * Math.PI / s.length());
      }
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_7 applet = new Exercise44_7();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_7");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(350, 360);
    frame.setVisible(true);
  }
}
