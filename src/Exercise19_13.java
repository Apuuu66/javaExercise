import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise19_13 extends JFrame {
  private JTextField jtfInputFile = new JTextField(20);
  private JTextField jtfNumberOfFiles = new JTextField(2);
  private JButton jbtStart = new JButton("Start");

  public Exercise19_13() {
    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.add(new JLabel("Enter a base file: "), BorderLayout.WEST);
    panel1.add(jtfInputFile, BorderLayout.CENTER);

    JPanel panel2 = new JPanel(new BorderLayout());
    panel2.add(new JLabel("Specify the number of smaller files: "),
        BorderLayout.WEST);
    panel2.add(jtfNumberOfFiles, BorderLayout.CENTER);

    JPanel panel = new JPanel(new GridLayout(4, 1));
    JTextArea jta = new JTextArea(
        "If the base file is named temp.txt with three pieces, temp.txt.1, temp.txt.2, and temp.txt.3 are combined into temp.txt.");
    jta.setWrapStyleWord(true);
    jta.setLineWrap(true);

    panel.add(jta);
    panel.add(panel1);
    panel.add(panel2);
    panel.add(jbtStart);

    add(panel);

    jbtStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        joinFile(jtfInputFile.getText(), Integer.parseInt(jtfNumberOfFiles.getText()));
      }
    });
  }

  public void joinFile(String filename, int numberOfPieces) {
    try {
      // The last file TargetFile is for output
      BufferedOutputStream output = new BufferedOutputStream(
        new FileOutputStream(new File(filename)));

      for (int i = 1; i <= numberOfPieces; i++) {
        BufferedInputStream input = new BufferedInputStream(
          new FileInputStream(new File(filename + "." + i)));

        int value;
        while ((value = input.read()) != -1) {
          output.write(value);
        }
        
        input.close();
      }

      output.close();
      System.out.println("Done!");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Exercise19_13 frame = new Exercise19_13();
    frame.pack();
    frame.setTitle("Exercise19_13: Combine Files");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
