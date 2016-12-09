import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class Exercise18_23 extends JApplet {
  public Exercise18_23() {
    URL imageURL = this.getClass().getResource("image/us.gif");
    Image image = new ImageIcon(imageURL).getImage();
    add(new FlagAnthemPanel(image));
  }

  public static class FlagAnthemPanel extends JPanel {
    private Image image;
    private Timer timer = new Timer(400, 
      new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        repaint();
	      }    	
    });
    
    int x = 20;
    int y = 150;

    public FlagAnthemPanel(Image image) {
      this.image = image;
      timer.start();

      URL audioURL = this.getClass().getResource("audio/us.mid");
      AudioClip audioClip = Applet.newAudioClip(audioURL);
      audioClip.play();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (y > 0) {
        y -= 1;
      }

      g.drawImage(image, x, y, 60, 40, this);
    }
  }

  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_23");

    // Create an instance of the applet
    JApplet applet = new Exercise18_23();

    // Add the applet to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke applet's init method
    applet.init();

    // Display the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
