import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise17_7 extends JFrame {
  private JTextField jtfHour = new JTextField(2);
  private JTextField jtfMinute = new JTextField(2);
  private JTextField jtfSecond = new JTextField(2);
  private StillClock clock = new StillClock();

  public Exercise17_7() {
    JPanel p = new JPanel();
    p.add(new JLabel("Hour"));
    p.add(jtfHour);
    p.add(new JLabel("Minute"));
    p.add(jtfMinute);
    p.add(new JLabel("Second"));
    p.add(jtfSecond);

    add(p, BorderLayout.SOUTH);
    add(clock, BorderLayout.CENTER);

    jtfHour.addActionListener(new Listener());
    jtfMinute.addActionListener(new Listener());
    jtfSecond.addActionListener(new Listener());
  }

  public static void main(String[] args) {
    Exercise17_7 frame = new Exercise17_7();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise17_7");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == jtfHour)
        clock.setHour(Integer.parseInt(jtfHour.getText()));
      else if (e.getSource() == jtfMinute)
        clock.setMinute(Integer.parseInt(jtfMinute.getText()));
      else if (e.getSource() == jtfSecond)
        clock.setSecond(Integer.parseInt(jtfSecond.getText()));
    }
  }
}

