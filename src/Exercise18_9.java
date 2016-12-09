import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.applet.*;
import javax.swing.*;

public class Exercise18_9 extends JApplet {
	private JTextField jtfDecimal = new JTextField();
	private JTextField jtfHex = new JTextField();
	private JTextField jtfBinary = new JTextField();
	
	public Exercise18_9() {
	  JPanel p1 = new JPanel(new GridLayout(3, 1));
	  p1.add(new JLabel("Decimal"));
	  p1.add(new JLabel("Hexdecimal"));
	  p1.add(new JLabel("Binary"));
	
    JPanel p2 = new JPanel(new GridLayout(3, 1));
    p2.add(jtfDecimal);
    p2.add(jtfHex);
    p2.add(jtfBinary);

    jtfDecimal.setHorizontalAlignment(JTextField.RIGHT);
    jtfHex.setHorizontalAlignment(JTextField.RIGHT);
    jtfBinary.setHorizontalAlignment(JTextField.RIGHT);

    add(p1, BorderLayout.WEST);
    add(p2, BorderLayout.CENTER);

    jtfDecimal.addActionListener(new Listener());
    jtfHex.addActionListener(new Listener());
    jtfBinary.addActionListener(new Listener());
	}
	
	class Listener implements ActionListener {
  	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == jtfDecimal) {
        String hex = convertDecimalToHex(jtfDecimal.getText());
        jtfHex.setText(hex);

        String binary = convertDecimalToBianry(jtfDecimal.getText());
        jtfBinary.setText(binary);
	    }
	    else if (e.getSource() == jtfHex) {
        int decimal = convertHexToDecimal(jtfHex.getText());
        jtfDecimal.setText(decimal + "");
	
	      String binary = convertDecimalToBianry(decimal + "");
	      jtfBinary.setText(binary);
		  }
		  else if (e.getSource() == jtfBinary) {
	      int decimal = convertBinaryToDecimal(jtfBinary.getText());
	      jtfDecimal.setText(decimal + "");
	
	      String hex = convertDecimalToHex(decimal + "");
	        jtfHex.setText(hex);
		  }
		}
	}
	
	public static int convertBinaryToDecimal(String binaryString) {
	  int value = binaryString.charAt(0) - '0';
	  for (int i = 1; i < binaryString.length(); i++) {
	    value = value * 2 + binaryString.charAt(i) - '0';
	  }
	
	  return value;
	}
	
	public static int convertHexToDecimal(String hexString) {
    int value = convertHexToDec(hexString.charAt(0));
    for (int i = 1; i < hexString.length(); i++) {
        value = value * 16 + hexString.charAt(i) - '0';
    }

    return value;
	}
	
	static int convertHexToDec(char ch) {
    if (ch == 'A')
      return 10;
	  else if (ch == 'B')
	      return 11;
	  else if (ch == 'C')
	      return 12;
	  else if (ch == 'D')
	      return 13;
	  else if (ch == 'E')
	      return 14;
	  else if (ch == 'F')
	      return 15;
	
	  return ch - '0';
	}
	
	public static String convertDecimalToBianry(String s) {
    int value = Integer.parseInt(s);
    StringBuffer buffer = new StringBuffer();

    while (value != 0) {
        int bit = value % 2;
        buffer.insert(0, bit);
        value = value / 2;
    }

    return buffer.toString();
	}
	
	public static String convertDecimalToHex(String s) {
    int value = Integer.parseInt(s);
    StringBuffer buffer = new StringBuffer();

    while (value != 0) {
        int number = value % 16;
        char ch = convertToHex(number);
        buffer.insert(0, ch);
        value = value / 16;
    }

    return buffer.toString();
	}
	
	public static char convertToHex(int number) {
    if (number == 10)
      return 'A';
	  else if (number == 11)
	    return 'B';
	  else if (number == 12)
	    return 'C';
	  else if (number == 13)
	    return 'D';
	  else if (number == 14)
	    return 'E';
	  else if (number == 15)
	    return 'F';
	
	  return (char)(number + '0');
	}
	
	/**This main method enables the applet to run as an application*/
	public static void main(String[] args) {
	  // Create a frame
	  JFrame frame = new JFrame("Exercise18_9");
	
	  // Create an instance of the applet
	  Exercise18_9 applet = new Exercise18_9();
	
	  // Add the applet instance to the frame
	  frame.add(applet, BorderLayout.CENTER);
	
	  // Invoke init() and start()
	  applet.init();
	  applet.start();
	
	  // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
	}
}
