// Exercise29_5.java: Simulate a running fan
import javax.swing.*;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.util.concurrent.locks.*;

public class Exercise29_5 extends JApplet {
  private FanControlUsingThread fanControl = new FanControlUsingThread();

  public void init() {
    add(fanControl);
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise29_5");

    // Create an instance of the applet
    Exercise29_5 applet = new Exercise29_5();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class FanControlUsingThread extends JPanel implements ActionListener,
  AdjustmentListener {
  private JButton jbtStart, jbtStop, jbtReverse;
  private JScrollBar jscb;
  private FanUsingThread fan;

  public FanControlUsingThread() {
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1, 3));
    p1.add(jbtStart = new JButton("Start"));
    p1.add(jbtStop = new JButton("Stop"));
    p1.add(jbtReverse = new JButton("Reverse"));
    p1.setBorder(new LineBorder(Color.black, 1));

    JPanel p2 = new JPanel();
    setLayout(new BorderLayout());
    add("North", p1);
    add("Center", fan = new FanUsingThread());
    add("South", jscb = new JScrollBar(
      JScrollBar.HORIZONTAL, 100, 100, 0, 800));
    jscb.setMaximum(1000);

    jbtStart.addActionListener(this);
    jbtStop.addActionListener(this);
    jbtReverse.addActionListener(this);
    jscb.addAdjustmentListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String arg = e.getActionCommand();
    if (e.getSource() instanceof JButton) {
      if ("Start".equals(arg)) {
        start();
      }
      else if ("Stop".equals(arg)) {
        stop();
      }
      else if ("Reverse".equals(arg)) {
        reverse();
      }
    }
  }

  // Start the fan
  public void start() {
    fan.start();
  }

  // Stop the fan
  public void stop() {
    fan.stop();
  }

  // Reverse the fan
  public void reverse() {
    fan.reverse();
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    fan.setSpeed((jscb.getMaximum() - jscb.getValue()) / 10);
  }

  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }
}

class FanUsingThread extends JPanel implements Runnable {
  private int xCenter, yCenter;
  private int fanRadius, bladeLength;
  private int angle = 100;
  private int direction = 1;
  private int speed = 10;
  protected Thread thread = new Thread(this);
  protected boolean isSuspended = true;

  public FanUsingThread() {
    thread.start();
  }

  public void reverse() {
    direction = -direction;
  }

  public void setSpeed(int ms) {
    speed = ms;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Set clock radius, and center
    fanRadius = (int)(Math.min(getSize().width, getSize().height) * 0.9 * 0.5);
    xCenter = (getSize().width) / 2;
    yCenter = (getSize().height) / 2;
    bladeLength = (int)(fanRadius * 0.9);
    angle = (angle + direction) % 360;

    //draw circle
    g.setColor(Color.black);
    g.drawOval(xCenter - fanRadius, yCenter - fanRadius,
               2 * fanRadius, 2 * fanRadius);

    //draw four blades
    drawBlade(g, angle);
    drawBlade(g, angle + 90);
    drawBlade(g, angle + 180);
    drawBlade(g, angle + 270);
  }

  private void drawBlade(Graphics g, int angle) {
    g.setColor(Color.red);
    g.fillArc(xCenter - bladeLength, yCenter - bladeLength,
              2 * bladeLength, 2 * bladeLength, angle, 30);
  }

  Lock lock = new ReentrantLock();
  Condition suspended = lock.newCondition();

  public void run() {
    try {
      while (true) {
        repaint();
        Thread.sleep(speed);
        while (isSuspended) {
          lock.lock();
          suspended.await();
          lock.unlock();
        }
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void start() {
    lock.lock();
    isSuspended = false;
    suspended.signalAll();
    lock.unlock();
  }

  public void stop() {
    lock.lock();
    isSuspended = true;
    lock.unlock();
  }
}
