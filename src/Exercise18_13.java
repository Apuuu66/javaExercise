import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise18_13 extends JApplet {
  private JLabel jlblStatue = new JLabel("Status");
  private Elevator elevator = new Elevator(this);

  public void init() {
    // Create left buttons and right buttons
    ButtonPanel lb = new ButtonPanel(elevator, true);
    ButtonPanel rb = new ButtonPanel(elevator, false);

    // Place status label on the north, left buttons on the west
    // right buttons on the east and the elevator on the center
    // Set applet layout
    setLayout(new BorderLayout());
    add(jlblStatue, BorderLayout.NORTH);
    add(lb, BorderLayout.WEST);
    add(elevator, BorderLayout.CENTER);
    add(rb, BorderLayout.EAST);
  }

  // Set status on the status label to indicate left or right buttons are at work
  public void setStatus(String status, Color color) {
    jlblStatue.setForeground(color);
    jlblStatue.setText(status);
  }

  // Enable the applet to run standalone
  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_13: Elevator Simulation");

    // Create an instance of the applet
    Exercise18_13 applet = new Exercise18_13();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

// The elevator class encapsulates elevator operations
class Elevator extends JPanel {
  private Exercise18_13 app;		// The applet
  private boolean left;			// Left or right button
  private boolean isUp;			// Moving up or down?
  private int destinationFloor = 6;	// Elevator destination floor
  private int width = 30;  // Elevator width
  private int height = 30; // Elevator height
  private int x = 50;	// The x coordinator of the elevator's upper left corner
  private int currentY = height * 4; // Elevator current location
  private int dy = 4; // Moving interval
  private Timer timer = new Timer(200, new Listener()); // Run the while loop on a separate thread

  int newY;
  
  public Elevator(Exercise18_13 app) {
    this.app = app;	// Passed from applet
    setBackground(Color.yellow); // Set elevator background color
  }

  // Set elevator color
  public void setColor(Color color) {
    setForeground(color);
  }

  // Move the elevator to destination
  public void move(int toFloor, boolean left) {
    destinationFloor = toFloor;
    this.left = left;
    move();
  }

  private void move() {
	    //set status and set elevator color
	    if (left) {
	      app.setStatus("getting passengers", Color.black);
	      setColor(Color.green);
	    }
	    else {
	      app.setStatus("sending passengers", Color.red);
	      setColor(Color.red);
	    }
	
	    //newY is the destination floor's y
	    newY = (8 - destinationFloor) * height;
	
	    if (newY < currentY) // Moving up
        isUp = true;
      else  // Moving down
      	isUp = false;
        
	    timer.start();   
	  }
  
  class Listener implements ActionListener {
  	public void actionPerformed(ActionEvent e) {
	    if (isUp) { // Moving up
	      if (currentY > newY) {
		      currentY = currentY - dy;
		      repaint();
	      }
	      else 
	      	timer.stop();
	    }
	    else  {  // Moving down
	      if (currentY < newY) {
		      currentY = currentY + dy;
		      repaint();
	      }
	      else
	      	timer.stop();
	    }
  	}
  }

  // Paint elevator
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    height = getHeight() / 8;

    for (int i = 0; i < 9; i++) {
      g.drawLine(0, i*height, this.getSize().width, i*height);
    }

    g.fillRect(x, currentY, width, height);
  }
}

//The ButtonPanel encapsulates buttons
class ButtonPanel extends JPanel {
  private Elevator elevator;	// The elevator
  private boolean left;		// Indicate left or right button
  private JButton b[] = new JButton[8];  // Buttons

  ButtonPanel(Elevator elevator, boolean left) {
    // Pass the elevator, frame, status to the button panel
    this.elevator = elevator;
    this.left = left;

    // Set panel layout
    setLayout(new GridLayout(8, 1, 0, 0));
    // Set panel background color
    setBackground(Color.blue);
    // Add buttons to the panel
    for (int i = 8; i > 0; i--)
      add(b[i-1] = new JButton("F" + (char)('0' + i)));

    // Register listeners
    for (int i = 0; i < 8; i++)
      b[i].addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
	  // Handle button actions
	  public void actionPerformed(ActionEvent e) {
	    String arg = e.getActionCommand(); // A label like "F8"
	    if (e.getSource() instanceof JButton)
	      elevator.move((int)arg.charAt(1)-48, left); // Ascii '0' is 48
	  }
  }
}

