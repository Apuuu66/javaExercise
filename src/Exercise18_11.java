import javax.swing.*;
import java.awt.*;

public class Exercise18_11 extends JApplet {
  private FanControl fanControl = new FanControl();

  public void init() {
    add(fanControl);
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_11");

    // Create an instance of the applet
    Exercise18_11 applet = new Exercise18_11();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
