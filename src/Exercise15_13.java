import java.awt.*;
import javax.swing.*;

public class Exercise15_13 extends JFrame {
  public Exercise15_13() {
    setLayout(new GridLayout(1, 2, 5, 5));
    add(new DrawSine());
    add(new DrawCosine());
  }

  public static void main(String[] args) {
    Exercise15_13 frame = new Exercise15_13();
    frame.setSize(400, 400);
    frame.setTitle("Exercise15_13");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class DrawXSquare extends AbstractDrawFunction {
  /**Implement the fuction*/
  public double f(double x) {
    // scaleFactor for adjusting y coordinates
    double scaleFactor = 0.01;

    return scaleFactor * x * x;
  }
}

class DrawSine extends AbstractDrawFunction {
  public double f(double x) {
    return 50 * Math.sin((x / 100.0) * 2 * Math.PI);
  }
}

class DrawCosine extends AbstractDrawFunction {
  public double f(double x) {
    return 50 * Math.cos((x / 100.0) * 2 * Math.PI);
  }
}

abstract class AbstractDrawFunction extends JPanel {
  /**Polygon to hold the points*/
  private Polygon p = new Polygon();
  final int TO_X_AXIS = 125;
  final int TO_Y_AXIS = 125;
  final int END_OF_X_AXIS = 275;
  final int END_OF_Y_AXIS = 200;

  /**Default constructor*/
  protected AbstractDrawFunction() {
    drawFunction();
    setBackground(Color.white);
  }

  /**Draw the function*/
  public abstract double f(double x);

  /**Obtain points for x coordinates 100, 101, ..., 300*/
  public void drawFunction() {
    for (int x = -100; x <= 100; x++) {
      p.addPoint(x + TO_Y_AXIS, TO_X_AXIS - (int)f(x));
    }
  }

  /**Paint the function diagram*/
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw x axis
    g.drawLine(10, TO_X_AXIS, END_OF_X_AXIS, TO_X_AXIS);

    // Draw y axis
    g.drawLine(TO_Y_AXIS, 30, TO_Y_AXIS, END_OF_Y_AXIS);

    // Draw arrows on x axis
    g.drawLine(END_OF_X_AXIS, TO_X_AXIS, END_OF_X_AXIS - 20, TO_X_AXIS - 10);
    g.drawLine(END_OF_X_AXIS, TO_X_AXIS, END_OF_X_AXIS - 20, TO_X_AXIS + 10);

    // Draw arrows on y axis
    g.drawLine(TO_Y_AXIS, 30, TO_Y_AXIS - 10, 50);
    g.drawLine(TO_Y_AXIS, 30, TO_Y_AXIS + 10, 50);

    // Draw x, y
    g.drawString("X", END_OF_X_AXIS - 20, TO_X_AXIS - 30);
    g.drawString("Y", TO_Y_AXIS + 20, 40);

    // Draw a polygon line by connecting the points in the polygon
    g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
  }
}

