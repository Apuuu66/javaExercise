import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Exercise17_5 extends JFrame {
  int[] counts = new int[26];
  private JTextField jtf = new JTextField(20);
  private Histogram display = new Histogram();

  public Exercise17_5() {
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Text File"), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);

    display.setBorder(new LineBorder(Color.red, 1));

    setLayout(new BorderLayout());
    add(p, BorderLayout.SOUTH);
    add(display, BorderLayout.CENTER);

    jtf.addActionListener(new Listener());
  }

  class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Reset counts
      for (int i = 0; i < 26; i++) {
        counts[i] = 0;
      }

      try {
        // Create file input stream
        Scanner input = new Scanner(new File(jtf.getText().trim()));

        while (input.hasNext()) {
          String line = input.nextLine();

          for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
              counts[Character.toUpperCase(line.charAt(i)) - 'A']++;
            }
          }
        }

        display.showHistogram(counts);
      }
      catch (FileNotFoundException ex) {
        System.out.println("File not found: " + jtf.getText().trim());
      }
      catch (IOException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  public static void main (String[] args) {
    Exercise17_5 frame = new Exercise17_5();
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Exercise17_5");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
