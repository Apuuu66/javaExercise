import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise17_1 extends JFrame {
  // Radio buttons for selecting colors
  private JRadioButton jrbRed, jrbYellow, jrbWhite,
    jrbGray, jrbGreen;

  // Declare a panel for displaying message
  private MessagePanel messagePanel;

  // Declare two buttons to move the message left and right
  private JButton jbtLeft, jbtRight;

  // Main method
  public static void main(String[] args) {
    Exercise17_1 frame = new Exercise17_1();
    frame.pack();
    frame.setTitle("Exercise17_1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise17_1() {
    // Create a MovingMessageCanvas instance and set colors
    messagePanel = new MessagePanel("Welcome to Java");
    messagePanel.setBackground(Color.white);

    // Create Panel jpButtons to hold two Buttons "<=" and "right =>"
    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new FlowLayout());
    jpButtons.add(jbtLeft = new JButton());
    jpButtons.add(jbtRight = new JButton());

    // Set button text
    jbtLeft.setText("<=");
    jbtRight.setText("=>");

    // Set keyboard mnemonics
    jbtLeft.setMnemonic('L');
    jbtRight.setMnemonic('R');

    // Set icons
    //jbtLeft.setIcon(new ImageIcon("images/left.gif"));
    //jbtRight.setIcon(new ImageIcon("images/right.gif"));

    // Set toolTipText on the "<=" and "=>" buttons
    jbtLeft.setToolTipText("Move message to left");
    jbtRight.setToolTipText("Move message to right");

    // Panel to hold radio buttons
    JPanel jpRadioButtons = new JPanel();
    jpRadioButtons.setBorder(new javax.swing.border.TitledBorder("Select Message Panel Background"));
    jpRadioButtons.add(jrbRed = new JRadioButton("Red"));
    jpRadioButtons.add(jrbYellow = new JRadioButton("Yellow"));
    jpRadioButtons.add(jrbWhite = new JRadioButton("White"));
    jpRadioButtons.add(jrbGray = new JRadioButton("Gray"));
    jpRadioButtons.add(jrbGreen = new JRadioButton("Green"));

    // Group radio buttons
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbRed);
    btg.add(jrbYellow);
    btg.add(jrbWhite);
    btg.add(jrbGray);
    btg.add(jrbGreen);

    // Place panels in the frame
    setLayout(new BorderLayout());
    add(messagePanel, BorderLayout.CENTER);
    add(jpButtons, BorderLayout.SOUTH);
    add(jpRadioButtons, BorderLayout.NORTH);

    // Register listeners with the buttons
    jbtLeft.addActionListener(new MyActionListener());
    jbtRight.addActionListener(new MyActionListener());
    jrbRed.addItemListener(new MyItemEventListener());
    jrbYellow.addItemListener(new MyItemEventListener());
    jrbWhite.addItemListener(new MyItemEventListener());
    jrbGray.addItemListener(new MyItemEventListener());
    jrbGreen.addItemListener(new MyItemEventListener());
  }

  // Move the message in the panel left
  private void left() {
    int x = messagePanel.getXCoordinate();
    if (x > 10) {
      // Shift the message to the left
      messagePanel.setXCoordinate(x-10);
      messagePanel.repaint();
    }
  }

  // Move the message in the panel right
  private void right() {
    int x = messagePanel.getXCoordinate();
    if (x < getSize().width - 20) {
      // Shift the message to the right
      messagePanel.setXCoordinate(x+10);
      messagePanel.repaint();
    }
  }
  
  class MyActionListener implements ActionListener {
    // Handler for button events
	public void actionPerformed(ActionEvent e) {
	  if (e.getSource() == jbtLeft) {
	    left();
	  }
	  else if (e.getSource() == jbtRight) {
	    right();
	  }
	}
  }

  // Handle radio button selections
  class MyItemEventListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      if (jrbRed.isSelected())
        messagePanel.setBackground(Color.red);
      if (jrbYellow.isSelected())
        messagePanel.setBackground(Color.yellow);
      if (jrbWhite.isSelected())
        messagePanel.setBackground(Color.white);
      if (jrbGreen.isSelected())
        messagePanel.setBackground(Color.green);
      if (jrbGray.isSelected())
        messagePanel.setBackground(Color.gray);
    }
  }
}
