import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise29_15 extends JFrame {
  private JTextField jtfInputFile = new JTextField(20);
  private JTextField jtfNumberOfFiles = new JTextField(2);
  private JButton jbtBrowse = new JButton("Browse");
  private JButton jbtStart = new JButton("Start");
  private JProgressBar jpb = new JProgressBar();
  
  public Exercise29_15() {
    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.add(new JLabel("Enter or choose a file: "), BorderLayout.WEST);
    panel1.add(jtfInputFile, BorderLayout.CENTER);
    panel1.add(jbtBrowse, BorderLayout.EAST);

    JPanel panel2 = new JPanel(new BorderLayout());
    panel2.add(new JLabel("Specify the number of smaller files: "),
        BorderLayout.WEST);
    panel2.add(jtfNumberOfFiles, BorderLayout.CENTER);

    JPanel panel = new JPanel(new GridLayout(5, 1));
    JTextArea jta = new JTextArea(
        "If you split a file named temp.txt into 3 smaller files, the three smaller files are temp.txt.1, temp.txt.2, and temp.txt.3.");
    jta.setWrapStyleWord(true);
    jta.setLineWrap(true);

    panel.add(jta);
    panel.add(panel1);
    panel.add(panel2);
    panel.add(jbtStart);
    panel.add(jpb);
    add(panel);

    jpb.setStringPainted(true); // Paint the percent in a string
    jpb.setValue(0);
    jpb.setMaximum(100);
    jpb.setValue(16);
    
    jbtStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        splitFile(jtfInputFile.getText(), Integer.parseInt(jtfNumberOfFiles.getText()));
      }
    });

    jbtBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) 
            == JFileChooser.APPROVE_OPTION) {
          // Get the selected file
          // Get the selected file
          java.io.File file = fileChooser.getSelectedFile();
          jtfInputFile.setText(file.toString());
        }
      }
    });
  }

  public void splitFile(String filename, int numberOfPieces) {
    try {
      BufferedInputStream input = new BufferedInputStream(
        new FileInputStream(new File(filename)));

      System.out.println("File size: " + input.available() + " bytes");
      long fileSize = input.available();
      int splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces);

      for (int i = 1; i <= numberOfPieces; i++) {
        BufferedOutputStream output = new BufferedOutputStream(
            new FileOutputStream(new File(filename + "." + i)));
        int value;
        int count = 0;
        // What is wrong if these two conditions are placed in a different
        // order?
        while (count++ < splitFileSize && (value = input.read()) != -1) {
          output.write(value);
        }
        output.close();
      }

      input.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Exercise29_15 frame = new Exercise29_15();
    frame.pack();
    frame.setTitle("Exercise29_15: Split a File");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
