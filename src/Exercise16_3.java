import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_3 extends JFrame {
  private JButton jbtMoveLeft = new JButton("Left");
  private JButton jbtMoveRight = new JButton("Right");
  private JButton jbtMoveUp = new JButton("Up");
  private JButton jbtMoveDown = new JButton("Down");
  private BallCanvas canvas = new BallCanvas();
  
  public Exercise16_3() {
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(jbtMoveLeft);
    panel.add(jbtMoveRight);
    panel.add(jbtMoveUp);
    panel.add(jbtMoveDown);
    
    this.add(canvas, BorderLayout.CENTER); // Add canvas to center
    this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame
    
    jbtMoveLeft.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.moveLeft();
      }
    });

    jbtMoveRight.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.moveRight();
      }
    });
    
    jbtMoveUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.moveUp();
      }
    });
    
    jbtMoveDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        canvas.moveDown();
      }
    });
  }
  
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new Exercise16_3();
    frame.setTitle("Exercise16_3");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  
  public static class BallCanvas extends JPanel {
    // The center of the ball at (x, y) and the radius of the ball
    private int x = 100;
    private int y = 100; 
    private int radius = 5;
    
    /** Move the ball left */
    public void moveLeft() {
      if (x > 0) x -= 5; 
      repaint();
    }
    
    /** Move the ball right */
    public void moveRight() {
      if (x < getWidth()) x += 5; 
      repaint();
    }

    /** Move the ball up */
    public void moveUp() {
      if (y > 0) y -= 5; 
      repaint();
    }
    
    /** Move the ball down */
    public void moveDown() {
      if (y < getHeight()) y += 5; 
      repaint();
    }
    
    /** Repaint the ball */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
  }
}
