import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise18_19 extends JApplet {
  public Exercise18_19() {
    add(new BallControl());
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JApplet applet = new Exercise18_19();
    frame.add(applet);
    frame.setTitle("Exercise18_19");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class BallControl extends JPanel {
  private BallPanel ballPanel = new BallPanel();
  private JButton jbtSuspend = new JButton("Suspend");
  private JButton jbtResume = new JButton("Resume");
  private JButton jbtAdd = new JButton("+1");
  private JButton jbtSubtract = new JButton("-1");
  private JScrollBar jsbDelay = new JScrollBar();

  public BallControl() {
    // Group buttons in a panel
    JPanel panel = new JPanel();
    panel.add(jbtSuspend);
    panel.add(jbtResume);
    panel.add(jbtAdd);
    panel.add(jbtSubtract);

    // Add ball and buttons to the panel
    ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
    jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
    ballPanel.setDelay(jsbDelay.getMaximum());
    setLayout(new BorderLayout());
    add(jsbDelay, BorderLayout.NORTH);
    add(ballPanel, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);

    // Register listeners
    jbtSuspend.addActionListener(new Listener());
    jbtResume.addActionListener(new Listener());
    jbtAdd.addActionListener(new Listener());
    jbtSubtract.addActionListener(new Listener());
    jsbDelay.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        ballPanel.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
    });
  }
  
  class Listener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == jbtSuspend) {
	      ballPanel.suspend();
	    }
	    else if (e.getSource() == jbtResume) {
	      ballPanel.resume();
	    }
	    else if (e.getSource() == jbtAdd) {
	      ballPanel.add();
	    }
	    else if (e.getSource() == jbtSubtract) {
	      ballPanel.subtract();
	    }
	  }
  }
}

class BallPanel extends JPanel implements ActionListener {
  private int delay = 10;

  // Create a timer with delay 1000 ms
  protected Timer timer = new Timer(delay, this);

  private ArrayList list = new ArrayList();

  private int radius = 5; // Ball radius
 
  public BallPanel() {
    timer.start();
  }

  public void add() {
    list.add(new SingleBall());
  }

  public void subtract() {
    if (list.size() > 0)
      list.remove(list.size() -1); // Remove the last one
  }

  /** Handle the action event */
  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < list.size(); i++) {
      SingleBall ball = (SingleBall)list.get(i);
      g.setColor(ball.color);

      // Check boundaries
      if (ball.x < radius) {
        ball.dx = Math.abs(ball.dx);
      }
      if (ball.x > getWidth() - radius) {
        ball.dx = -Math.abs(ball.dx);
      }
      if (ball.y < radius) {
        ball.dy = Math.abs(ball.dy);
      }
      if (ball.y > getHeight() - radius) {
        ball.dy = -Math.abs(ball.dy);
      }

      // Adjust ball position
      ball.x += ball.dx;
      ball.y += ball.dy;
      g.fillOval(ball.x - radius, ball.y - radius, radius * 2, radius * 2);
    }
  }

  public void suspend() {
    timer.stop(); // Suspend clock
  }

  public void resume() {
    timer.start(); // Resume clock
  }

  public void setDelay(int delay) {
    this.delay = delay;
    timer.setDelay(delay);
  }
}

class SingleBall {
  int x = 0;
  int y = 0; // Current ball position
  int dx = 2; // Increment on ball's x-coordinate
  int dy = 2; // Increment on ball's y-coordinate
  Color color = new Color(
      (int)(Math.random() * 256), (int)(Math.random() * 256),
      (int)(Math.random() * 256));
}
