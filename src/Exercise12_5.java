import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Exercise12_5 extends JFrame {
  public Exercise12_5() {
    JLabel jlbl1 = new JLabel("Department of Computer Science");
    JLabel jlbl2 = new JLabel("School of Computing");
    JLabel jlbl3 = new JLabel("Armstrong Atlantic State University");
    JLabel jlbl4 = new JLabel("Tel: (912) 921-6440");

    jlbl1.setBorder(new LineBorder(Color.BLUE, 1));
    jlbl2.setBorder(new LineBorder(Color.BLUE, 1));
    jlbl3.setBorder(new LineBorder(Color.BLUE, 1));
    jlbl4.setBorder(new LineBorder(Color.BLUE, 1));

    setLayout(new GridLayout(4, 1));
    add(jlbl1);
    add(jlbl2);
    add(jlbl3);
    add(jlbl4);
  }

  public static void main(String[] args) {
    Exercise12_5 frame = new Exercise12_5();
    frame.setTitle("Exercise12_5");
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
