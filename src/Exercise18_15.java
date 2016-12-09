import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Exercise18_15 extends JApplet {
  private Image image;

  public void init() {
    // Get the URL for the file name
    URL url = this.getClass().getResource("blackTicker.gif");

    // Get the image
    image = new ImageIcon(url).getImage();
    add(new DisplayImage());
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_15");

    // Create an instance of the applet
    Exercise18_15 applet = new Exercise18_15();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

	// Inner class
	class DisplayImage extends JPanel {
	  int width = 300;
	  int height = 300;
	  int delta = -10;
	
	  public DisplayImage() {
	    Timer timer = new Timer(100, new Listener());
	    timer.start();
	  }
	
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	
	    g.drawImage(image, 0, 0, width, height, this);

	    if (width < 50) {
	      delta = 1;
	    }
	    else if (width > 300) {
	      delta = -1;
	    }
	
	    width = width + delta;
	    height = height + delta;
	  }
	
	  class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      repaint();
	    }
	  }
	}
}

