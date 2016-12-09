// Exercise29_1.java: Display output from three threads to text area
import javax.swing.*;

public class Exercise29_1 extends JFrame {
  private JTextArea jta = new JTextArea();

  public static void main(String[] args) {
    Exercise29_1 frame = new Exercise29_1();
    frame.setTitle("Exercise29_1");
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise29_1() {
    JScrollPane jsp = new JScrollPane(jta);
    add(jsp);
    jta.setLineWrap(true);

    Thread printA = new Thread(new PrintChar('a', 100));
    Thread printB = new Thread(new PrintChar('b', 100));
    Thread  print100 = new Thread(new PrintNum(100));

    // Start threads
    print100.start();
    printA.start();
    printB.start();
  }

  //The thread class for printing a specified character in specified times
  class PrintChar implements Runnable {
    private char charToPrint;  //the character to print
    private int	times;  //the times to repeat

    //The thread class constructor
    public PrintChar(char c, int t) {
      charToPrint = c;
      times = t;
    }

    //override the run() method to tell the system what the thread will do
    public void run() {
      for (int i=1; i < times; i++)
        jta.append(charToPrint+"");
    }
  }

  //The thread class for printing number from 1 to n for a given n.
  class PrintNum implements Runnable {
    private int lastNum;
    public PrintNum(int i) {
      lastNum = i;
    }

    public void run() {
      for (int i=1; i <= lastNum; i++)
        jta.append(" "+i);
    }
  }
}
