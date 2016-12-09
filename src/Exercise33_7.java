// Exercise33_7.java: Use tabbed pane
import java.awt.*;
import javax.swing.*;

public class Exercise33_7 extends JApplet {
  // Create a tabbed pane to hold figure panels
  private JTabbedPane jtpPanels = new JTabbedPane();

  public Exercise33_7() {
    // Create intPanel for integer arithmetic
    JPanel intPanel = new IntPanel();

    // Create rationalPanel for rational arithmetic
    JPanel rationalPanel = new RationalPanel();

    jtpPanels.add(intPanel, "Integer Operations");
    jtpPanels.add(rationalPanel, "Rational Operations");

    //set FlowLayout in the frame
    setLayout(new BorderLayout());
    add(jtpPanels, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    Exercise33_7 applet = new Exercise33_7();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise33_7");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
