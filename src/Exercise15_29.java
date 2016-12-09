import java.awt.*;
import javax.swing.*;

public class Exercise15_29 extends JFrame {
  public Exercise15_29() {
    add(new TwoCirclesWithDistance());
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise15_29 frame = new Exercise15_29();
    frame.setTitle("Exercise15_29");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class TwoCirclesWithDistance extends JPanel {
	TwoCirclesWithDistance() {
	}
	
	protected void paintComponent(Graphics g) {  	
		super.paintComponent(g);
		
    int x1 = (int)(Math.random() * (getWidth() - 12));
    int y1 = (int)(Math.random() * (getHeight() - 12));
    int x2 = (int)(Math.random() * (getWidth() - 12));
    int y2 = (int)(Math.random() * (getHeight() - 12));
    
		int RADIUS = 15;
		
		g.setColor(Color.RED);
		g.fillOval(x1 - RADIUS, y1 - RADIUS, 2 * RADIUS, 2 * RADIUS);
		g.fillOval(x2 - RADIUS, y2 - RADIUS, 2 * RADIUS, 2 * RADIUS);  		
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
		int distance = (int)getDistance(x1, y1, x2, y2);
		g.drawString(distance + "", (x1 + x2) / 2, (y1 + y2) / 2);
	}

	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}

