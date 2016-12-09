import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Exercise31_11Reader extends JFrame implements ActionListener {
  private JTextArea jta = new JTextArea(40, 80);
  private JTextField jtfFilename = new JTextField(10);
  private JTextField jtfEncoding = new JTextField(6);
  private JButton jbtViewFile = new JButton("View File");

  public Exercise31_11Reader() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter a file:"));
    panel.add(jtfFilename);
    panel.add(new JLabel("Enter the encoding scheme:"));
    panel.add(jtfEncoding);
    panel.add(jbtViewFile);

    jta.setEditable(false);
    jta.setFont(new Font("Monospaced", Font.PLAIN, 16));
    add(panel, BorderLayout.NORTH);
    add(new JScrollPane(jta), BorderLayout.CENTER);

    jbtViewFile.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String filename = jtfFilename.getText().trim();
    String encoding = jtfEncoding.getText().trim();

    try {
      BufferedReader in =
          new BufferedReader(
          new InputStreamReader(new FileInputStream(filename), encoding));
      String line;
      while ((line = in.readLine()) != null) {
        jta.append(line + "\n");
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String args[]) {
      JFrame frame = new Exercise31_11Reader();
      frame.setTitle("Exercise31_11Reader");
      frame.setSize(400, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null); // Center the frame
      frame.setVisible(true);
  }
}

