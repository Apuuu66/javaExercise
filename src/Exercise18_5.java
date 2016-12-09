import javax.swing.*;
import java.awt.event.*;

public class Exercise18_5 extends JApplet {
  private DetailedClock clock = new DetailedClock();

  public Exercise18_5() {
    clock.setSecondHandVisible(false);
    setTime();
    add(clock);
    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        setTime();
      }
    });
  }

  private void setTime() {
    clock.setHour((int)(Math.random() * 12));
    int fourChoices = (int)(Math.random() * 4);
    if (fourChoices == 0)
      clock.setMinute(0);
    else if (fourChoices == 1)
      clock.setMinute(15);
    else if (fourChoices == 2)
      clock.setMinute(30);
    else if (fourChoices ==3)
      clock.setMinute(45);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise18_5");
    Exercise18_5 applet = new Exercise18_5();

    frame.add(applet);
    frame.setSize(400, 400);
    frame.setTitle("Exercise18_5");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
