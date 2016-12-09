import java.awt.*;
import javax.swing.*;

public class Exercise15_7 extends JFrame {
  public Exercise15_7() {
    setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
      add(new Cell());
    }
  }

  public static void main(String[] args) {
    Exercise15_7 frame = new Exercise15_7();
    frame.setTitle("Exercise15_7");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
   frame.setVisible(true);
  }

  class Cell extends JPanel {
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      int mode = (int)(Math.random() * 3);

      if (mode == 0) {
        g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
        g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
      }
      else if (mode == 1) {
        g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
      }
    }
  }
}
