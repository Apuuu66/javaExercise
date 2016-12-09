import java.awt.*;
import javax.swing.*;

public class Exercise12_7 extends JFrame {
  private ImageIcon cross = new ImageIcon("image/x.gif");
  private ImageIcon not = new ImageIcon("image/o.gif");

  public Exercise12_7() {
    setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
      int mode = (int)(Math.random() * 3);
      if (mode == 0)
        add(new JLabel(cross));
      else if (mode == 1)
        add(new JLabel(not));
      else
        add(new JLabel());
    }
  }

  public static void main(String[] args) {
    Exercise12_7 frame = new Exercise12_7();
    frame.setTitle("Exercise12_7");
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
