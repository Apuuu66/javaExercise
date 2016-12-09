import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class Exercise17_17 extends JFrame {
  public Exercise17_17() {
    add(new CalendarPanel());
  }

  public static void main(String[] args) {
    Exercise17_17 frame = new Exercise17_17();
    frame.setTitle("Exercise17_17");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public class CalendarPanel extends JPanel {
    private Calendar calendar = new GregorianCalendar();
    private int month = calendar.get(Calendar.MONTH);
    private int year = calendar.get(Calendar.YEAR);
    private int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    // The header label
    private JLabel jlblHeader = new JLabel(month + 1 + "/" + year, JLabel.CENTER);

    // Labels to display day names and days
    private JLabel[] jlblDay = new JLabel[49];

    public CalendarPanel() {
      calendar.set(Calendar.YEAR, year);
      calendar.set(Calendar.MONTH, month);
      calendar.set(Calendar.DATE, 1); // Set calendar to the first day in a month

      int firstDay = calendar.get(Calendar.DAY_OF_WEEK);

      // Panel jpDays to hold day names and days
      JPanel jpDays = new JPanel(new GridLayout(6, 7));

      jpDays.add(new JLabel("Sunday", JLabel.CENTER));
      jpDays.add(new JLabel("Monday", JLabel.CENTER));
      jpDays.add(new JLabel("Tuesday", JLabel.CENTER));
      jpDays.add(new JLabel("Wednesday", JLabel.CENTER));
      jpDays.add(new JLabel("Thursday", JLabel.CENTER));
      jpDays.add(new JLabel("Friday", JLabel.CENTER));
      jpDays.add(new JLabel("Saturday", JLabel.CENTER));

      for (int i = 0; i < firstDay - 1; i++) {
        jpDays.add(new JLabel());
      }

      for (int i = 1; i <= daysInMonth; i++) {
        jpDays.add(jlblDay[i] = new JLabel(i + ""));
        jlblDay[i].setBorder(new LineBorder(Color.black, 1));
        jlblDay[i].setHorizontalAlignment(JLabel.RIGHT);
        jlblDay[i].setVerticalAlignment(JLabel.TOP);
      }

      // Place header and calendar body in the panel
      this.setLayout(new BorderLayout());
      this.add(jlblHeader, BorderLayout.NORTH);
      this.add(jpDays, BorderLayout.CENTER);

      jpDays.setBorder(new EmptyBorder(4, 4, 4, 4));
    }
  }
}
