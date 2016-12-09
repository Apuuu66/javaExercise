import java.awt.*;
import javax.swing.*;

public class Exercise31_3 extends JApplet {
  public void init() {
    add(new CalendarPanel(), BorderLayout.CENTER);
    add(new WorldClock(), BorderLayout.EAST);
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Calendar and Clock");

    // Create an instance of the applet
    Exercise31_3 applet = new Exercise31_3();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
