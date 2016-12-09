import java.awt.*;
import javax.swing.*;

public class Exercise15_21 extends JFrame {
  public Exercise15_21() {
    setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
      add(new Cell());
    }
  }

  public static void main(String[] args) {
    Exercise15_21 frame = new Exercise15_21();
    frame.setTitle("Exercise15_21");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  class Cell extends JPanel {
    Image cross = new ImageIcon("image/x.gif").getImage();
    Image not = new ImageIcon("image/o.gif").getImage();

    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      int mode = (int)(Math.random() * 3);

      if (mode == 0) {
        g.drawImage(cross, 0, 0, getWidth(), getHeight(), this);
      }
      else if (mode == 1) {
        g.drawImage(not, 0, 0, getWidth(), getHeight(), this);
      }
    }
  }
}
