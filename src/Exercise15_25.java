import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise15_25 extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new Exercise15_25();
    frame.setSize(300, 300);
    frame.setTitle("Exercise15_25");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise15_25() {
    RegularPolygonPanel pentagon = new RegularPolygonPanel(5);
    RegularPolygonPanel hexagon = new RegularPolygonPanel(6);
    RegularPolygonPanel heptagon = new RegularPolygonPanel(7);
    RegularPolygonPanel octagon = new RegularPolygonPanel(8);
    RegularPolygonPanel nonagon = new RegularPolygonPanel(9);
    RegularPolygonPanel decagon = new RegularPolygonPanel(10);
      
    setLayout(new GridLayout(1, 4));
    add(pentagon);
    add(hexagon);
    add(heptagon);
    add(octagon);
    add(nonagon);
    add(decagon);
  }
}

class RegularPolygonPanel extends JPanel {
  private int numberOfSides = 3;
  
  public RegularPolygonPanel() {
  }
  
  public RegularPolygonPanel(int numberOfSides) {
    setNumberOfSides(numberOfSides);
  }
  
  public int getNumberOfSides() {
    return numberOfSides;
  }
  
  public void setNumberOfSides(int numberOfSides) {
    this.numberOfSides = numberOfSides;
    repaint();
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius =
      (int) (Math.min(getWidth(), getHeight()) * 0.4);

    double angle = 2 * Math.PI / numberOfSides;
    
    // Create a Polygon object
    Polygon polygon = new Polygon();

    // Add points to the polygon
    for (int i = 0; i < numberOfSides; i++) {
      polygon.addPoint((int)(xCenter + radius * Math.cos(i * angle)),
          (int)(yCenter - radius * Math.sin(i * angle)));      
    }
    
    /**
    polygon.addPoint(xCenter + radius, yCenter);
    polygon.addPoint((int)(xCenter + radius * Math.cos(1 * angle)),
      (int)(yCenter - radius * Math.sin(angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(2 * angle)),
      (int)(yCenter - radius * Math.sin(2 * angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(3 * angle)),
      (int)(yCenter - radius * Math.sin(3 * angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(4 * angle)),
      (int)(yCenter - radius * Math.sin(4 * angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(5 * angle)),
      (int)(yCenter - radius * Math.sin(5 * angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(6 * angle)),
      (int)(yCenter - radius * Math.sin(6 * angle)));
    polygon.addPoint((int)(xCenter + radius * Math.cos(7 * angle)),
      (int)(yCenter - radius * Math.sin(7 * angle)));
*/
    // Draw the polygon
    g.drawPolygon(polygon);
  }

  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }
}