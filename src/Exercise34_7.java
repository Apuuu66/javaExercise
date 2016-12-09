// Exercise34_7: Display file in a text area. File is chosen from
// a dialog box
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Exercise34_7 extends JFrame implements ActionListener {
  private JButton jbtBrowse = new JButton("Browse");

  // Text field to receive file name
  private JTextField jtfFile = new JTextField();

  // Text area to display file
  private JTextArea jtaFileContent = new JTextArea();

  // Create jFileChooser
  private JFileChooser jFileChooser = new JFileChooser();

  public static void main(String[] args) {
    Exercise34_7 frame = new Exercise34_7();
    frame.setSize(400, 300);
    frame.setTitle("Exercise34_7");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise34_7() {
    // Create a Panel to hold a label, a text field, and a button
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Filename"), BorderLayout.WEST);
    p.add(jtfFile, BorderLayout.CENTER);
    jtfFile.setBackground(Color.white);
    jtfFile.setForeground(Color.black);
    p.add(jbtBrowse, BorderLayout.EAST);

    // Create a scrollabel text area
    JScrollPane jsp = new JScrollPane(jtaFileContent);

    // Set default directory to the current directory
    jFileChooser.setCurrentDirectory(new File("."));

    // Use BorderLayout for the frame
    setLayout(new BorderLayout());
    add(jsp, BorderLayout.CENTER);
    add(p, BorderLayout.SOUTH);
    jtaFileContent.setBackground(Color.white);
    jtaFileContent.setForeground(Color.black);

    // Register listener
    jbtBrowse.addActionListener(this);
    jtfFile.addActionListener(this);
  }

  //handling the "View" button
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtBrowse) {
      browse();
    }
    else if (e.getSource() == jtfFile) {
      showFile(new File(jtfFile.getText().trim()));
    }
  }

  private void browse() {
    if (jFileChooser.showOpenDialog(this) ==
      JFileChooser.APPROVE_OPTION) {
      showFile(jFileChooser.getSelectedFile());
    }
  }

  private void showFile(File file) {
    BufferedReader infile = null;  //declare buffered stream
    //get file name from the text field
    String inLine;

    jtfFile.setText(file.getName());

    try {
      //create a buffered stream
      infile = new BufferedReader(new FileReader(file));

      //read a line
      inLine = infile.readLine();

      boolean firstLine = true;

      //append the line to the text area
      while (inLine != null) {
        if (firstLine) {
          firstLine = false;
          jtaFileContent.append(inLine);
        }
        else {
          jtaFileContent.append("\n" + inLine);
        }

        inLine = infile.readLine();
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + file.getName());
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        if (infile != null) infile.close();
      }
      catch (IOException ex) {
      }
    }
  }
}
