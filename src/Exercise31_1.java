import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise31_1 extends JApplet {
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTextField jtfUnicode = new JTextField();
  private JTextArea jtaUnicodeCharacters = new JTextArea();

  public void init() {
    // Panel to hold input text field
    JPanel p = new JPanel();
    p.add(jtfUnicode);
    p.setBorder(new TitledBorder("Specify Unicode"));
    jtfUnicode.setColumns(4);
    jtaUnicodeCharacters.setFont(new Font("Monospaced", 0, 18));
    jtfUnicode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jtfUnicode_actionPerformed(e);
      }
    });

    add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jtaUnicodeCharacters, null);
    add(p, BorderLayout.NORTH);
  }

  void jtfUnicode_actionPerformed(ActionEvent e) {
    int code = Integer.parseInt(jtfUnicode.getText().toString(), 16);
    System.out.println(code);
    displayUnicode(code);
  }

  private void displayUnicode(int code) {
    jtaUnicodeCharacters.setText(null);
    for (int i = 0; i < 20; i++) {
      jtaUnicodeCharacters.append(Integer.toHexString(code) + "  ");
      for (int j = 0; j < 16; j++) {
        jtaUnicodeCharacters.append((char)code + " ");
        code++;
      }
      jtaUnicodeCharacters.append("\n");
    }
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Unicode Viewer");

    // Create an instance of the applet
    Exercise31_1 applet = new Exercise31_1();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

