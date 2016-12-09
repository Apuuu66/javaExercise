import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise18_17 extends JApplet {
  private JTextField jtfCar1Speed = new JTextField(4);
  private JTextField jtfCar2Speed = new JTextField(4);
  private JTextField jtfCar3Speed = new JTextField(4);
  private JTextField jtfCar4Speed = new JTextField(4);

  private RaceCar car1 = new RaceCar();
  private RaceCar car2 = new RaceCar();
  private RaceCar car3 = new RaceCar();
  private RaceCar car4 = new RaceCar();

  public Exercise18_17() {
    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("Car 1: "));
    panel1.add(jtfCar1Speed);
    panel1.add(new JLabel("Car 2: "));
    panel1.add(jtfCar2Speed);
    panel1.add(new JLabel("Car 3: "));
    panel1.add(jtfCar3Speed);
    panel1.add(new JLabel("Car 4: "));
    panel1.add(jtfCar4Speed);

    JPanel panel2 = new JPanel(new GridLayout(4, 1));
    panel2.add(car1);
    panel2.add(car2);
    panel2.add(car3);
    panel2.add(car4);

    add(panel1, BorderLayout.NORTH);
    add(panel2, BorderLayout.CENTER);
      
    jtfCar1Speed.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        car1.setSpeed(Integer.parseInt(jtfCar1Speed.getText()));    	
      }
    });
    jtfCar2Speed.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        car2.setSpeed(Integer.parseInt(jtfCar2Speed.getText()));    	
      }
    });
    jtfCar3Speed.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        car3.setSpeed(Integer.parseInt(jtfCar3Speed.getText()));    	
      }
    });
    jtfCar4Speed.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        car4.setSpeed(Integer.parseInt(jtfCar4Speed.getText()));    	
        }
    });
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet applet = new Exercise18_17();
    frame.add(applet);
    frame.setTitle("Exercise18_17");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  // Displaying a moving message
  class RaceCar extends JPanel {
	final static int MAX_SPEED = 100;
    private int xBase = 0;
    private Timer timer = new Timer(200, 
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          repaint();
        }
    });

    public RaceCar() { 
      setBorder(BorderFactory.createLineBorder(Color.BLACK));
      // Create a timer for the listener raceCar
      timer.start();  
    }
    
    public void setSpeed(int speed) {
      timer.setDelay((speed < MAX_SPEED) ? MAX_SPEED - speed : 0);
    }

    /** Paint message */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      int yBase = getHeight();
      if (xBase > getWidth()) {
        xBase = -20;
      }
      else {
        xBase += 1;
      }

      // Draw two wheels
      g.setColor(Color.BLACK);
      g.fillOval(xBase + 10, yBase - 10, 10, 10);
      g.fillOval(xBase + 30, yBase - 10, 10, 10);

      // Draw the car body
      g.setColor(Color.GREEN);
      g.fillRect(xBase, yBase - 20, 50, 10);

      // Draw the top
      g.setColor(Color.RED);
      Polygon polygon = new Polygon();
      polygon.addPoint(xBase + 10, yBase - 20);
      polygon.addPoint(xBase + 20, yBase - 30);
      polygon.addPoint(xBase + 30, yBase - 30);
      polygon.addPoint(xBase + 40, yBase - 20);
      g.fillPolygon(polygon);
    }
  }
}
