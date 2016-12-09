import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise44_3 extends JApplet {
  private JButton jbtTranslate = new JButton("Translate");
  private JTextField jtfX = new JTextField("0", 4);
  private JTextField jtfY = new JTextField("0", 4);
  private ShapePanel shapePanel = new ShapePanel();

  public Exercise44_3() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("x: "));
    panel.add(jtfX);
    panel.add(new JLabel(" y: "));
    panel.add(jtfY);
    panel.add(jbtTranslate);
        
    add(shapePanel);   
    add(panel, BorderLayout.SOUTH);
    
    jbtTranslate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        shapePanel.repaint();
      }
    });
  }

  class ShapePanel extends JPanel {
    private Rectangle2D rectangle = new Rectangle2D.Double(40, 40, 50, 40);
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g; // Create Graphics2D
      g2d.translate(Double.parseDouble(jtfX.getText()), Double.parseDouble(jtfY.getText()));
      g2d.draw(rectangle);
    }
  }
  
  /** Main method */
  public static void main(String[] args) {
    Exercise44_3 applet = new Exercise44_3();
    applet.init();
    applet.start();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise44_3");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(250, 160);
    frame.setVisible(true);
  }
}
