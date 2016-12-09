import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise17_3 extends JFrame {
  // Declare radio buttons
  private JRadioButton jrbRed, jrbYellow, jrbGreen;

  // Create a radio button group
  private ButtonGroup btg = new ButtonGroup();

  // Create a traffic light display panel
  private Light light = new Light();

  /** Main method */
  public static void main(String[] args) {
    Exercise17_3 frame = new Exercise17_3();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 170);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  /** Default constructor */
  public Exercise17_3() {
    setTitle("Exercise17_3");

    // Add traffic light panel to panel p1
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    p1.add(light);

    // Put the radio button in Panel p2
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jrbRed = new JRadioButton("Red"));
    p2.add(jrbYellow = new JRadioButton("Yellow"));
    p2.add(jrbGreen = new JRadioButton("Green"));

    // Set keyboard mnemonics
    jrbRed.setMnemonic('R');
    jrbYellow.setMnemonic('Y');
    jrbGreen.setMnemonic('G');

    // Group radio buttons
    btg.add(jrbRed);
    btg.add(jrbYellow);
    btg.add(jrbGreen);

    // Place p1 and p2 in the frame
    setLayout(new BorderLayout());
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listeners for check boxes
    jrbRed.addItemListener(new MyItemEventListener());
    jrbYellow.addItemListener(new MyItemEventListener());
    jrbGreen.addItemListener(new MyItemEventListener());

    // Set initial light green
    jrbGreen.setSelected(true);
    light.turnOnGreen();
  }

  class MyItemEventListener implements ItemListener {
    /** Handle checkbox events */
    public void itemStateChanged(ItemEvent e) {
      if (jrbRed.isSelected()) {
        light.turnOnRed(); // Set red light
      }
      if (jrbYellow.isSelected()) {
        light.turnOnYellow(); // Set yellow light
      }
      if (jrbGreen.isSelected()) {
        light.turnOnGreen(); // Set green light
      }
    }
  }

// Three traffic lights shown in a panel
  class Light extends JPanel {
    private boolean red;
    private boolean yellow;
    private boolean green;

    /** Default constructor */
    public Light() {
    }

    /** Set red light on */
    public void turnOnRed() {
      red = true;
      yellow = false;
      green = false;
      repaint();
    }

    /** Set yellow light on */
    public void turnOnYellow() {
      red = false;
      yellow = true;
      green = false;
      repaint();
    }

    /** Set green light on */
    public void turnOnGreen() {
      red = false;
      yellow = false;
      green = true;
      repaint();
    }

    /** Display lights */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (red) {
        g.setColor(Color.red);
        g.fillOval(10, 10, 20, 20);
        g.setColor(Color.black);
        g.drawOval(10, 35, 20, 20);
        g.drawOval(10, 60, 20, 20);
        g.drawRect(5, 5, 30, 80);
      }
      else if (yellow) {
        g.setColor(Color.yellow);
        g.fillOval(10, 35, 20, 20);
        g.setColor(Color.black);
        g.drawRect(5, 5, 30, 80);
        g.drawOval(10, 10, 20, 20);
        g.drawOval(10, 60, 20, 20);
      }
      else if (green) {
        g.setColor(Color.green);
        g.fillOval(10, 60, 20, 20);
        g.setColor(Color.black);
        g.drawRect(5, 5, 30, 80);
        g.drawOval(10, 10, 20, 20);
        g.drawOval(10, 35, 20, 20);
      }
      else {
        g.setColor(Color.black);
        g.drawRect(5, 5, 30, 80);
        g.drawOval(10, 10, 20, 20);
        g.drawOval(10, 35, 20, 20);
        g.drawOval(10, 60, 20, 20);
      }
    }

    /** Set preferred size */
    public Dimension getPreferredSize() {
      return new Dimension(40, 90);
    }
  }
}
