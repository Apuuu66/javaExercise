import java.awt.event.*;
import javax.swing.*;

public class Exercise16_13 extends JFrame  {
  // Number of the slides specified in the HTML page
  private final static int NUMBER_OF_SLIDES = 25;
  private final static int SHOW_TIME_PER_SLIDE = 1000;

  private int current = 0;
  private JLabel jlblImageLabel = new JLabel();

  public Exercise16_13() {
    add(jlblImageLabel);

    jlblImageLabel.setIcon(new ImageIcon("image/slide0.jpg"));
    Timer timer = new Timer(SHOW_TIME_PER_SLIDE, new Listener());
    timer.start();
  }

  class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      jlblImageLabel.setIcon(new ImageIcon("image/slide" +
                           current + ".jpg"));
      current = (current + 1) % NUMBER_OF_SLIDES;
    }
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    Exercise16_13 frame = new Exercise16_13();
    frame.setTitle("Exercise16_13: Slides Show");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
