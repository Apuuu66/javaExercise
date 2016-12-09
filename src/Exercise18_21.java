import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;

public class Exercise18_21 extends JApplet {
  private Timer timer = new Timer(1000, new TimerListener());
  private DisplayPanel hourPanel, minutePanel, secondPanel;
  private JButton jbtSetAlarm;
  private JCheckBox jchkAlarm;
  private int hourAlarm, minuteAlarm, secondAlarm;
  private AudioClip alarmSound;

  public void init() {
    // Panel p to hold the digital clock
    JPanel p = new JPanel();
    hourPanel = new DisplayPanel();
    hourPanel.setTitle("Hour");
    minutePanel = new DisplayPanel();
    minutePanel.setTitle("Minute");
    secondPanel = new DisplayPanel();
    secondPanel.setTitle("Second");
    p.setBorder(new LineBorder(Color.red, 1));

    p.setLayout(new GridLayout(1, 3, 5, 5));
    p.add(hourPanel);
    p.add(minutePanel);
    p.add(secondPanel);

    Panel p1 = new Panel();
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    p1.add(jchkAlarm = new JCheckBox("Alarm"));
    p1.add(jbtSetAlarm = new JButton("Set alarm"));

    setLayout(new BorderLayout());
    add(p, BorderLayout.CENTER);
    add(p1, BorderLayout.SOUTH);

    // Play a sound
    URL url = this.getClass().getResource("Ticker.au");
    alarmSound = Applet.newAudioClip(url);

    jbtSetAlarm.addActionListener(new ActionListener() {
      // Handle the button action
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new SetAlarmFrame();
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
      }
    });
    timer.start();
  }

  class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      GregorianCalendar cal = new GregorianCalendar();
      int hour = cal.get(Calendar.HOUR);
      int minute = cal.get(Calendar.MINUTE);
      int second = cal.get(Calendar.SECOND);
      hourPanel.setContent(hour+"");
      minutePanel.setContent(minute+"");
      secondPanel.setContent(second+"");
      checkAlarm(hour, minute, second);
    }
  }

  public void checkAlarm(int h, int m, int s) {
    if (jchkAlarm.isSelected() && (h == hourAlarm) && (m == minuteAlarm)
      && (s == secondAlarm)) {
      alarmSound.play();
      timer.stop();
    }
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_21: Alarm Clock");

    // Create an instance of the applet
    Exercise18_21 applet = new Exercise18_21();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(500, 200);
    frame.setVisible(true);
  }

  // Inner class
  class DisplayPanel extends JPanel {
    private String title = "default";
    private String content = "default";
    private JLabel jlblTitle;
    private DisplayCenteredOnPanel panel;

    DisplayPanel() {
      setLayout(new BorderLayout());
      add(jlblTitle = new JLabel(title, JLabel.CENTER),
        BorderLayout.NORTH);
      add(panel = new DisplayCenteredOnPanel(),
        BorderLayout.CENTER);
      jlblTitle.setBackground(Color.white);
      panel.setBackground(Color.white);
    }

    public void setTitle(String s) {
      jlblTitle.setText(s);
    }

    public void setContent(String s) {
      panel.setMessage(s);
    }
  }

	// Inner class
	class SetAlarmFrame extends JFrame {
	  private JTextField jtfHour, jtfMinute, jtfSecond;
	  private JButton jbtOK, jbtCancel;
	
	  public SetAlarmFrame() {
	    setTitle("Set alarm");
	
	    JPanel p = new JPanel();
	    p.setLayout(new GridLayout(3, 2));
	    p.add(new JLabel("Hour"));
	    p.add(jtfHour = new JTextField());
	    p.add(new JLabel("Minute"));
	    p.add(jtfMinute = new JTextField());
	    p.add(new JLabel("Second"));
	    p.add(jtfSecond = new JTextField());
	    p.setBorder(new TitledBorder("Enter Hour, Minute, and Second"));
	
	    JPanel p1 = new JPanel();
	    p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    p1.add(jbtOK = new JButton("OK"));
	    p1.add(jbtCancel = new JButton("Cancel"));
	
	    add(p, BorderLayout.CENTER);
	    add(p1, BorderLayout.SOUTH);
	
	    jbtOK.addActionListener(new Listener());
	    jbtCancel.addActionListener(new Listener());
	  }
	
	  class Listener implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
		    String actionCommand = e.getActionCommand();
		    if (actionCommand.equals("OK")) {
		      hourAlarm =
		        Integer.parseInt(jtfHour.getText().trim());
		      minuteAlarm =
		        Integer.parseInt(jtfMinute.getText().trim());
		      secondAlarm =
		        Integer.parseInt(jtfSecond.getText().trim());
		    }
		
		    setVisible(false);
		    dispose();
		  }
	  }
	}
}

class DisplayCenteredOnPanel extends JPanel {
  private String message = " ";

  public void setMessage(String message) {
    this.message = message;
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    //create and set font
    Font f = new Font("Helvetica", Font.BOLD, 26);
    g.setFont(f);

    //get font metrics for the font
    FontMetrics fm = g.getFontMetrics(f);

    //find the center location to display
    int w = fm.stringWidth(message);  //get the string width
    int h = fm.getAscent();
    int x = (getSize().width-w)/2;
    int y = (getSize().height+h)/2;

    g.drawString(message, x, y);
  }

  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }
}
