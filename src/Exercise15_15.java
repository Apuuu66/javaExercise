import java.awt.*;
import javax.swing.*;

public class Exercise15_15 extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new Exercise15_15();
    frame.setSize(300, 300);
    frame.setTitle("Exercise15_15");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise15_15() {
    add(new PieChart1());
  }
}

class PieChart1 extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int w = getWidth();
    int h = getHeight();
    int xCenter = w / 2;
    int yCenter = h / 2;
    int radius = (int)(Math.min(w, h) * 0.8 / 2);
    int x = xCenter - radius;
    int y = yCenter - radius;

    // Draw the arc for projects
    g.setColor(Color.red);
    g.fillArc(x, y, 2 * radius, 2 * radius, 0, (int)(20 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Projects -- 20%",
    (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.1)),
    (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.1)));

    // Draw the arc for quizzes
    g.setColor(Color.blue);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(20 * 360 / 100),
    (int)(10 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Quizzes -- 10%",
    (int)(xCenter + radius * Math.cos(2 * Math.PI * 0.25)),
    (int)(yCenter - radius * Math.sin(2 * Math.PI * 0.25)));

    // Draw the arc for midterm exams
    g.setColor(Color.green);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(30*360/100),
      (int)(30 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Midterms -- 30%",
      (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.45)) - 40,
      (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.45)));

    // Draw the arc for the final exam
    g.setColor(Color.white);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(60 * 360 / 100),
      (int)(40 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Final -- 40%",
      (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.8)),
      (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.8)));
  }
}

