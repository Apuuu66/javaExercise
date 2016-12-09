import javax.swing.*;
import java.awt.*;

public class Exercise15_19 extends JFrame {
    public Exercise15_19() {
    StillClock clock = new StillClock();
    clock.setSecondHandVisible(false);
    clock.setHour((int)(Math.random() * 12));
    clock.setMinute((int)(Math.random() * 2) == 0 ? 0 : 30);

    add(clock);
  }

  public static void main(String[] args) {
    Exercise15_19 frame = new Exercise15_19();
    frame.setSize(400, 400);
    frame.setTitle("Exercise15_19");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
