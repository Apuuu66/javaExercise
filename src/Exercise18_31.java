import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise18_31 extends JApplet {
  private int numberOfSlots = 9; // Default number of slots
  private int numberOfRows = numberOfSlots - 2;
  private int numberOfBalls = 4; // Total number of balls
  private int numberOfBallsDropped = 0; // Number of the balls dropped
  private JTextField jtfNumberOfSlots = new JTextField(2);
  private JButton jbtStart = new JButton("Start");
  private JButton jbtStop = new JButton("Stop");

  public void setNumberOfBallsDropped(int numberOfBallsDropped) {
    this.numberOfBallsDropped = numberOfBallsDropped;
  }
  
  private int shift = 0;
  int[] slots = new int[numberOfSlots];
  int moveCount = 0;
  int position = 0;
  
  private BeanMachinePanel paintPanel = new BeanMachinePanel();
  private Timer timer = new Timer(200, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      moveCount++;
      if (moveCount <= numberOfRows) {
        if (Math.random() < 0.5) 
          paintPanel.moveRedBallLeft();
        else {
          paintPanel.moveRedBallRight();
          position++;
        }
      }
      else {
        slots[position]++;
        paintPanel.startRedBall();
        shift = 0;
        moveCount = 0;
        position = 0;
        /*
        numberOfBallsDropped++;
        if (numberOfBallsDropped >= numberOfBalls) {
          timer.stop();
          paintPanel.hideRedBall();
        }
        */
      }
    }
  });
  
  public Exercise18_31() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Number of slots:"));
    panel.add(jtfNumberOfSlots);
    panel.add(jbtStart);
    panel.add(jbtStop);
    
    add(paintPanel, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);
    
    jtfNumberOfSlots.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateNumberOfSlots();
      }
    });

    // Start or restart animation
    jbtStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateNumberOfSlots();
        numberOfBallsDropped = 0;
        shift = 0;
        slots = new int[numberOfSlots];
        moveCount = 0;
        position = 0;
        timer.start();
        paintPanel.startRedBall();
      }
    });
    
    // Stop animation
    jbtStop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        timer.stop();
      }
    });
  }
  
  private void updateNumberOfSlots() {
    numberOfSlots = Integer.parseInt(jtfNumberOfSlots.getText().trim());
    numberOfRows = numberOfSlots - 2;
    slots = new int[numberOfSlots];
    paintPanel.repaint();
  }
  
  class BeanMachinePanel extends JPanel {
    final static int HGAP = 20;
    final static int VGAP = 20;
    final static int RADIUS = 5;
    final static int LENGTH_OF_SLOTS = 40;
    final static int LENGTH_OF_OPENNING = 15;
    final static int Y_FOR_FIRST_NAIL = 50;
    final static int RED_BALL_START_Y = Y_FOR_FIRST_NAIL - RADIUS;

    private int yRed = RED_BALL_START_Y;
    private boolean hideRedBall = true;
    
    public BeanMachinePanel() {    
      
    }
    
    /** Move the red ball down left */
    public void moveRedBallLeft() {
      shift -= HGAP / 2;
      yRed += VGAP;
      repaint();
    }

    /** Move the red ball down right */
    public void moveRedBallRight() {
      shift += HGAP / 2;
      yRed += VGAP;
      repaint();
    }
    
    /** Move the red ball down right */
    public void startRedBall() {
      yRed = RED_BALL_START_Y;
      hideRedBall = false;
      repaint();
    }
    
    /** Move the red ball down right */
    public void hideRedBall() {
      hideRedBall = true;
      repaint();
    }
    
    /** Paint message */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      int y = Y_FOR_FIRST_NAIL;
      int xCenter = getWidth() / 2;

      // Draw the red ball
      if (!hideRedBall) {
        g.setColor(Color.RED);
        int xRed = xCenter + shift;
        g.fillOval(xRed - RADIUS, yRed - RADIUS, 2 * RADIUS, 2 * RADIUS);
      }
      
      // Draw pegs in multiple lines
      g.setColor(Color.GREEN);
      for (int i = 0; i < numberOfRows; i++) {
        y += VGAP;
        for (int k = 0; k <= i; k++) {
          g.fillOval(xCenter - i * HGAP / 2 + k * HGAP - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        }
      }
      
      // Draw vertical lines for slots
      g.setColor(Color.BLACK);
      y = y + RADIUS;
      for (int i = 0; i < numberOfSlots; i++) {
        int x = xCenter - (numberOfRows - 1) * HGAP / 2 + (i - 1) * HGAP;
        g.drawLine(x, y, x, y + LENGTH_OF_SLOTS);
      }
      
      // Draw a horizontal line for bottom
      g.drawLine(xCenter - (numberOfRows - 1) * HGAP / 2 - HGAP, y + LENGTH_OF_SLOTS, 
        xCenter - (numberOfRows - 1) * HGAP / 2 + numberOfRows * HGAP, y + LENGTH_OF_SLOTS);
      // Draw two side lines
      g.drawLine(xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - (numberOfRows - 1) * HGAP / 2 + numberOfRows * HGAP, y);
      g.drawLine(xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - (numberOfRows - 1) * HGAP / 2 - HGAP, y);
      // Draw two vertical lines for the openning
      g.drawLine(xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - HGAP / 2, Y_FOR_FIRST_NAIL - LENGTH_OF_OPENNING);
      g.drawLine(xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter + HGAP / 2, Y_FOR_FIRST_NAIL - LENGTH_OF_OPENNING);
      
      // Paint the balls in the slots
      g.setColor(Color.RED);      
      for (int i = 0; i < slots.length; i++) {
        int x = xCenter - (numberOfRows) * HGAP / 2 + i * HGAP;
        for (int j = 0; j < slots[i]; j++) {
          g.fillOval(x - RADIUS, y + LENGTH_OF_SLOTS - 2 * RADIUS - j * 2 * RADIUS, 2 * RADIUS, 2 * RADIUS);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise18_31");
    JApplet applet = new Exercise18_31();
    frame.add(applet);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
