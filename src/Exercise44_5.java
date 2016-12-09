import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise44_5 extends JApplet {
  private JButton jbtScale = new JButton("Scale");
  private JTextField jtfX = new JTextField("1", 4);
  private JTextField jtfY = new JTextField("1", 4);
  private ShapePanel shapePanel = new ShapePanel();

  public Exercise44_5() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Scale factor for x: "));
    panel.add(jtfX);
    panel.add(new JLabel("y: "));
    panel.add(jtfY);    
    panel.add(jbtScale);
        
    add(shapePanel);   
    add(panel, BorderLayout.SOUTH);
    
    jbtScale.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        shapePanel.repaint();
      }
    });
  }

  class ShapePanel extends JPanel {
    //private Shape shape = new Rectangle2D.Double(50, 75, 100, 50);
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D
      
      g2d.translate(150, 50);
      g2d.scale(Double.parseDouble(jtfX.getText()), Double.parseDouble(jtfY.getText()));
      g2d.draw(new Ellipse2D.Double(-30, -20, 60, 40));
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_5 applet = new Exercise44_5();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_5");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(350, 180);
    frame.setVisible(true);
  }
}
