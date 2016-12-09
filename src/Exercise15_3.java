import javax.swing.*;
import java.awt.*;

public class Exercise15_3 extends JFrame {
  /** Default constructor */
  public Exercise15_3() {
    // Add buttons to the frame
    add(new CheckerBoard());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise15_3 frame = new Exercise15_3();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise15_3");
    frame.setSize(100, 80);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class CheckerBoard extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth() / 8;
    int height = getHeight() / 8;

    int x = 0;
    int y = 0;
    boolean isWhite = true;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (isWhite) {
          g.setColor(Color.white);
          isWhite = false;
        }
        else {
          g.setColor(Color.black);
          isWhite = true;
        }

        g.fillRect(x, y, width, height);
        x += width;
      }

      if (i % 2 == 0)
        isWhite = false; 
      else
        isWhite = true;
      x = 0;
      y += height;
    }
  }
}
