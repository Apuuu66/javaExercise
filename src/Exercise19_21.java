import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Exercise19_21 extends JFrame {
  private JTextField jtfFilename = new JTextField();
  private JButton jbtSave = new JButton("Save the bits to the file");
  private JTextArea jtaBits = new JTextArea();
  
  public Exercise19_21() {
    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.add(new JLabel("Enter a file"), BorderLayout.WEST);
    panel1.add(jtfFilename, BorderLayout.CENTER);

    add(panel1, BorderLayout.NORTH);
    jtaBits.setLineWrap(true);   
    add(new JScrollPane(jtaBits));
    add(jbtSave, BorderLayout.SOUTH);
    
    jtfFilename.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          FileInputStream in = new FileInputStream(jtfFilename.getText().trim());
          
          String s = "";
          int value;
          while ((value = in.read()) != -1) {
            s += getHex(getBits(value));
          }
          
          in.close();
          jtaBits.setText(s);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
    
    jbtSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          BitOutputStream output = new BitOutputStream(new File(jtfFilename.getText().trim()));
          output.writeBit(toBits(jtaBits.getText().trim()));
          output.close();    
        } 
        catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
  }
  
  /** Convert a hex string to bit string */
  public static String toBits(String hex) {
    String s = "";
    for (int i = 0; i < hex.length(); i++) {
      char hexChar = hex.charAt(i);
      switch (hexChar) {
        case '0': s += "0000"; break;
        case '1': s += "0001"; break;
        case '2': s += "0010"; break;
        case '3': s += "0011"; break;
        case '4': s += "0100"; break;
        case '5': s += "0101"; break;
        case '6': s += "0110"; break;
        case '7': s += "0111"; break;
        case '8': s += "1000"; break;
        case '9': s += "1001"; break;
        case 'A': s += "1010"; break;
        case 'B': s += "1011"; break;
        case 'C': s += "1100"; break;
        case 'D': s += "1101"; break;
        case 'E': s += "1110"; break;
        case 'F': s += "1111"; break;
      }
    }
    
    return s;
  }
  
  public static int hexCharToDecimal(char ch) {
    ch = Character.toUpperCase(ch); // Change it to uppercase
    if (ch >= 'A' && ch <= 'F')
      return 10 + ch - 'A';
    else // ch is '0', '1', ..., or '9'
      return ch - '0';
  }

  /** Convert the 8-bit string to a 2-digit hex number */
  public static String getHex(String bitString) {
    // Get the first half hex number
    int value = (bitString.charAt(0) - '0') * 8 + 
      (bitString.charAt(1) - '0') * 4 +
      (bitString.charAt(2) - '0') * 2 +
      (bitString.charAt(3) - '0') * 1;
    
    String result = "" + toHexChar(value);

    // Get the second half hex number
    value = (bitString.charAt(4) - '0') * 8 + 
    (bitString.charAt(5) - '0') * 4 +
    (bitString.charAt(6) - '0') * 2 +
    (bitString.charAt(7) - '0') * 1;

    return result + toHexChar(value);
  }
  
  /** Convert an integer to a single hex digit in a character */
  public static char toHexChar(int hexValue) {
    if (hexValue <= 9 && hexValue >= 0)
      return (char)(hexValue + '0');
    else  // hexValue <= 15 && hexValue >= 10
      return (char)(hexValue - 10 + 'A');
  }
  
  public static String getBits(int value) {
    String result = "";
    
    int mask = 1;
    for (int i = 7; i >= 0; i--) {
      int temp = value >> i;
      int bit = temp & mask;
      result = result + bit;
    }
    return result;
  }
  
  public static class BitOutputStream {
    private FileOutputStream output;
    private int value;
    private int count = 0;
    private int mask = 1; // The bits are all zeros except the last one
    
    public BitOutputStream(File file) throws IOException {
      output = new FileOutputStream(file);
    }
    
    public void writeBit(char bit) throws IOException {
      count++;
      value = value << 1;
      
      if (bit == '1') 
        value = value | mask;
      
      if (count == 8) {
        output.write(value);
        count = 0;
      }
    }
    
    public void writeBit(String bitString) throws IOException {
      for (int i = 0; i < bitString.length(); i++)
        writeBit(bitString.charAt(i));
    }
    
    /** Write the last byte and close the stream. If the last byte is not full, right-shfit with zeros */
    public void close() throws IOException {     
      if (count > 0) {
        value = value << (8 - count);
        output.write(value);
      }
      
      output.close();
    }   
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new Exercise19_21();
    frame.setTitle("Exercise19_21");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
