// Exercise29_7.java: Display a group of international clocks
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Exercise29_7 extends JApplet implements ActionListener {
  // Declare three clock panels
  private ClockControl clockControl1, clockControl2, clockControl3;

  // Declare group control buttons
  private JButton jbtResumeAll, jbtSuspendAll;

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise29_7");

    // Create an instance of the applet
    Exercise29_7 applet = new Exercise29_7();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(600, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  /** Initialize the applet */
  public void init() {
    // Panel p1 for holding three clocks
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1, 3));

    // Create a clock for Berlin
    p1.add(clockControl1 = new ClockControl());

    // Create a clock for San Francisco
    p1.add(clockControl2 = new ClockControl());

    // Create a clock for Taichung
    p1.add(clockControl3 = new ClockControl());

    // Panel p2 for holding two group control buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jbtResumeAll = new JButton("Resume All"));
    p2.add(jbtSuspendAll = new JButton("Suspend All"));

    // Add panel p1 and p2 into the applet
    setLayout(new BorderLayout());
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listeners
    jbtResumeAll.addActionListener(this);
    jbtSuspendAll.addActionListener(this);
  }

  /** Handle group control buttons */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtResumeAll) {
      // Start all clocks
      clockControl1.resume();
      clockControl2.resume();
      clockControl3.resume();
    }
    else if (e.getSource() == jbtSuspendAll) {
      // Stop all clocks
      clockControl1.suspend();
      clockControl2.suspend();
      clockControl3.suspend();
    }
  }

  class ClockControl extends JPanel implements ActionListener {
    private Clock clock = new Clock();
    private JButton jbtSuspend = new JButton("Suspend");
    private JButton jbtResume = new JButton("Resume");

    public ClockControl() {
      // Group buttons in a panel
      JPanel panel = new JPanel();
      panel.add(jbtSuspend);
      panel.add(jbtResume);

      // Add clock and buttons to the panel
      setLayout(new BorderLayout());
      add(clock, BorderLayout.CENTER);
      add(panel, BorderLayout.SOUTH);

      // Register listeners
      jbtSuspend.addActionListener(this);
      jbtResume.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == jbtSuspend) {
        clock.suspend();
      }
      else if (e.getSource() == jbtResume) {
        clock.resume();
      }
    }

    public void suspend() {
      clock.suspend();
    }

    public void resume() {
      clock.resume();
    }
  }

  class Clock extends StillClock implements Runnable {
    private boolean suspended;

    public Clock() {
      new Thread(this).start();
    }

    public void run() {
      while (true) {
        setCurrentTime();
        repaint();

        try {
          Thread.sleep(1000);
          waitForNotificationToResume();
        }
        catch (InterruptedException ex) {
        }
      }
    }

    public synchronized void suspend() {
      suspended = true;
    }

    public synchronized void resume() {
      if (suspended) {
        suspended = false;
        notifyAll();
      }
    }

    private synchronized void waitForNotificationToResume() throws
      InterruptedException {
      while (suspended) {
        wait();
      }
    }
  }
}
