import java.awt.*;
import javax.swing.*;

public class Exercise15_5 extends JFrame {
  public Exercise15_5() {
    setLayout(new BorderLayout());
    add(new DrawPyramid(), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    Exercise15_5 frame = new Exercise15_5();
    frame.setSize(400, 400);
    frame.setTitle("Exercise15_5");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  // Inner class
  class DrawPyramid extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      setFont(new Font("SansSerif", Font.BOLD, 17));

      int width = getWidth();
      int height = getHeight();

      int xInterval = 20;
      int yInterval = 20;
      int x = 10;
      int y = 10;

      for (int row = 1; row <= 1 + (height - 20) / 20; row++) {
        for (int column = 1; column < row; column++) {
          g.drawString(column + "", x, y);
          x += 20;
        }

        y += 20;
        x = 20;
      }
    }
  }
}

