import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise16_17 extends JFrame {
  public Exercise16_17() {
    add(new MoveLabel());
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    Exercise16_17 frame = new Exercise16_17();
    frame.setTitle("Exercise16_17: Move Label");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class MoveLabel extends JPanel {
  private int x = getWidth();
  private int y = 40;
  private Timer timer = new Timer(200, 
    new ActionListener() {
	  public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		repaint();
	  }
    });

  public MoveLabel() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        timer.stop();
      }

   	  public void mouseReleased(MouseEvent e) {
   	    timer.start();
   	  }
    });
    timer.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (x < -20)
      x = getSize().width;
    else
      x -= 10;
    g.drawString("Welcom to Java!", x, y);
  }
}