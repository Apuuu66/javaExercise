// Exercise30_9.java: View a remote text file
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Exercise30_9 extends JApplet implements ActionListener {
  // Button to view the file
  private JButton jbtView = new JButton("View");

  // Text field to receive file name
  private JTextField jtf = new JTextField(12);

  // Text area to store file
  private JEditorPane jep = new JEditorPane();

  // Label to display status
  private JLabel jlblStatus = new JLabel();

  // Initialize the applet
  public void init() {
    // Create a Panel to hold a label, a text field, and a button
    Panel p1 = new Panel();
    p1.setLayout(new BorderLayout());
    p1.add(new JLabel("Filename"), BorderLayout.WEST);
    p1.add(jtf, BorderLayout.CENTER);
    p1.add(jbtView, BorderLayout.EAST);

    // Place text area and panel p to the applet
    setLayout(new BorderLayout());
    add(new JScrollPane(jep), BorderLayout.CENTER);
    add(p1, BorderLayout.NORTH);
    add(jlblStatus, BorderLayout.SOUTH);

    // Register listener
    jbtView.addActionListener(this);
  }

  // Handle the "View" button
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtView)
      showFile();
  }

  private void showFile() {
    try {
      // Get the URL from text field
      URL url = new URL(jtf.getText().trim());

      // Display the HTML file
      jep.setPage(url);

      jlblStatus.setText("File loaded successfully");
    }
    catch (IOException ex) {
      jlblStatus.setText(ex.getMessage());
    }
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise30_9: Display HTML File From a Web Server");

    // Create an instance of MortgageApplet
    Exercise30_9 applet = new Exercise30_9();

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
