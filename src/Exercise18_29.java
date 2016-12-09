import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Exercise18_29 extends JApplet {
  private MyRectangle2D rectangle1 = new MyRectangle2D(50, 50, 70, 50);
  private MyRectangle2D rectangle2 = new MyRectangle2D(90, 50, 50, 70);
	
  private JTextField jtfCenterx1 = new JTextField(rectangle1.getX() + "");
  private JTextField jtfCentery1 = new JTextField(rectangle1.getY() + "");
  private JTextField jtfWidth1 = new JTextField(rectangle1.getWidth() + "");
  private JTextField jtfHeight1 = new JTextField(rectangle1.getHeight() + "");
  private JTextField jtfCenterx2 = new JTextField(rectangle2.getX() + "");
  private JTextField jtfCentery2 = new JTextField(rectangle2.getY() + "");
  private JTextField jtfWidth2 = new JTextField(rectangle2.getWidth() + "");
  private JTextField jtfHeight2 = new JTextField(rectangle2.getHeight() + "");
  private JButton jbtRedraw = new JButton("Redraw Rectangles");
  
  private JLabel jlblStatus = new JLabel("Two rectangles intersect? " +
    (rectangle1.overlaps(rectangle2) ? "Yes" : "No"), JLabel.CENTER);

  private PaintPanel paintPanel = new PaintPanel();
  
  public Exercise18_29() {
    JPanel p1 = new JPanel(new GridLayout(4, 2));
    p1.setBorder(new TitledBorder("Enter rectangle 1 info"));
    p1.add(new JLabel("Center x:"));
    p1.add(jtfCenterx1);
    p1.add(new JLabel("Center y:"));
    p1.add(jtfCentery1);
    p1.add(new JLabel("Width:"));
    p1.add(jtfWidth1);
    p1.add(new JLabel("Height:"));
    p1.add(jtfHeight1);
    
    JPanel p2 = new JPanel(new GridLayout(4, 2));
    p2.setBorder(new TitledBorder("Enter rectangle 2 info"));
    p2.add(new JLabel("Center x:"));
    p2.add(jtfCenterx2);
    p2.add(new JLabel("Center y:"));
    p2.add(jtfCentery2);
    p2.add(new JLabel("Width:"));
    p2.add(jtfWidth2);
    p2.add(new JLabel("Height:"));
    p2.add(jtfHeight2);
    
    JPanel p3 = new JPanel(new GridLayout(1, 2));    
    p3.add(p1);
    p3.add(p2);
    
    JPanel p4 = new JPanel(new BorderLayout());    
    p4.add(p3, BorderLayout.CENTER);    
    p4.add(jbtRedraw, BorderLayout.SOUTH);
    
    add(jlblStatus, BorderLayout.NORTH);
    add(p4, BorderLayout.SOUTH);
    add(paintPanel, BorderLayout.CENTER);
    
    jbtRedraw.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rectangle1.setX(Double.parseDouble(jtfCenterx1.getText()));
        rectangle1.setY(Double.parseDouble(jtfCentery1.getText()));
        rectangle1.setWidth(Double.parseDouble(jtfWidth1.getText()));
        rectangle1.setHeight(Double.parseDouble(jtfHeight1.getText()));
        rectangle2.setX(Double.parseDouble(jtfCenterx2.getText()));
        rectangle2.setY(Double.parseDouble(jtfCentery2.getText()));
        rectangle2.setWidth(Double.parseDouble(jtfWidth2.getText()));
        rectangle2.setHeight(Double.parseDouble(jtfHeight2.getText()));
        jlblStatus.setText("Two rectangles intersect? " +
            (rectangle1.overlaps(rectangle2) ? "Yes" : "No"));

        paintPanel.repaint();
      }
    });
  }
  
  class PaintPanel extends JPanel {	
	  
	public PaintPanel() {
	  this.addMouseMotionListener(new MouseMotionAdapter() {
		public void mouseDragged(MouseEvent e) {
		  if (rectangle1.contains(e.getX(), e.getY())) {
			rectangle1.setX(e.getX());
			rectangle1.setY(e.getY());
	        jlblStatus.setText("Two rectangles intersect? " +
	                (rectangle1.overlaps(rectangle2) ? "Yes" : "No"));
	        jtfCenterx1.setText(rectangle1.getX() + "");
	        jtfCentery1.setText(rectangle1.getY() + "");
	        
			repaint();
		  }
		}
	  });
	}
	
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.drawString("r1", (int)(rectangle1.getX()), (int)(rectangle1.getY()));
      g.drawString("r2", (int)(rectangle2.getX()), (int)(rectangle2.getY()));
      
      g.drawRect((int)(rectangle1.getX() - rectangle1.getWidth() / 2), 
        (int)(rectangle1.getY() - rectangle1.getHeight() / 2),
        (int)(rectangle1.getWidth()),
        (int)(rectangle1.getHeight()));

      g.drawRect((int)(rectangle2.getX() - rectangle2.getWidth() / 2), 
          (int)(rectangle2.getY() - rectangle2.getHeight() / 2),
          (int)(rectangle2.getWidth()),
          (int)(rectangle2.getHeight()));
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise18_29");
    JApplet applet = new Exercise18_29();
    frame.add(applet);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
