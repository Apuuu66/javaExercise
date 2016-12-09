import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise16_1 extends JFrame {
  private JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6;

  public static void main(String[] args) {
    Exercise16_1 frame = new Exercise16_1();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise16_1");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise16_1() {
    // Create panel p1 add three buttons
    JPanel p1 = new JPanel();
    p1.add(jbt1 = new JButton("Button 1"));
    p1.add(jbt2 = new JButton("Button 2"));
    p1.add(jbt3 = new JButton("Button 3"));

    // Create Panel p2 and add three buttons
    JPanel p2 = new JPanel();
    p2.add(jbt4 = new JButton("Button 4"));
    p2.add(jbt5 = new JButton("Button 5"));
    p2.add(jbt6 = new JButton("Button 6"));

    // Place p1 and p2 in the frame
    setLayout(new FlowLayout());
    add(p1);
    add(p2);

    // Register listeners
    jbt1.addActionListener(new Listener());
    jbt2.addActionListener(new Listener());
    jbt3.addActionListener(new Listener());
    jbt4.addActionListener(new Listener());
    jbt5.addActionListener(new Listener());
    jbt6.addActionListener(new Listener());
  }

  class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(e.getActionCommand() + " was clicked");
    }
  }
}
