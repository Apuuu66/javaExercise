import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise17_15 extends JFrame {
  // Declare scrollbars
  private JScrollBar jscbRed, jscbGreen, jscbBlue;

  // Create a label
  private JLabel jlbl = new JLabel("Show Colors", JLabel.CENTER);

  // Declare color component values
  private int redValue, greenValue, blueValue;

  // Main method
  public static void main(String[] args) {
    Exercise17_15 frame = new Exercise17_15();
    frame.setSize(300, 200);
    frame.setTitle("Exercise17_15");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise17_15() {
    // Panel p1 to hold labels
    JPanel p1 = new JPanel(new GridLayout(3, 1));
    p1.add(new JLabel("Red"));
    p1.add(new JLabel("Green"));
    p1.add(new JLabel("Blue"));

    // Panel p2 to hold labels
    JPanel p2 = new JPanel(new GridLayout(3, 1));
    p2.add(jscbRed = new JScrollBar());
    jscbRed.setOrientation(JScrollBar.HORIZONTAL);
    jscbRed.setMaximum(255);

    p2.add(jscbGreen = new JScrollBar());
    jscbGreen.setOrientation(JScrollBar.HORIZONTAL);
    jscbGreen.setMaximum(255);

    p2.add(jscbBlue = new JScrollBar());
    jscbBlue.setOrientation(JScrollBar.HORIZONTAL);
    jscbBlue.setMaximum(255);

    // Create a panel to hold p1 and p2
    JPanel p = new JPanel(new BorderLayout(10, 10));
    p.add(p1, BorderLayout.WEST);
    p.add(p2, BorderLayout.CENTER);

    add(jlbl, BorderLayout.CENTER);
    add(p, BorderLayout.SOUTH);

    // Register listener for the scroll bars
    jscbRed.addAdjustmentListener(new Listener());
    jscbGreen.addAdjustmentListener(new Listener());
    jscbBlue.addAdjustmentListener(new Listener());

    p.setBorder(new CompoundBorder(new TitledBorder("Choose colors"),
      new EmptyBorder(2, 2, 2, 2)));
  }

  class Listener implements AdjustmentListener {
	  public void adjustmentValueChanged(AdjustmentEvent e) {
	    if (e.getSource() == jscbRed)
	      redValue = jscbRed.getValue();
	    else if (e.getSource() == jscbGreen)
	      greenValue = jscbGreen.getValue();
	    else
	      blueValue = jscbBlue.getValue();
	
	    Color color = new Color(redValue, greenValue, blueValue);
	    jlbl.setForeground(color);
	  }
  }
}
