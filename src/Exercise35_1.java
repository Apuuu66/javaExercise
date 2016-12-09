import java.awt.*;
import javax.swing.*;

public class Exercise35_1 extends javax.swing.JApplet {
  private ChartModel chartModel1;
  private BarChart barChart1;
  private PieChart pieChart1;

  public Exercise35_1() {
    chartModel1 = new ChartModel();
    barChart1 = new BarChart();
    pieChart1 = new PieChart();

    setLayout(new java.awt.GridLayout(1, 2));

    barChart1.setModel(chartModel1);
    add(barChart1);

    pieChart1.setModel(chartModel1);
    add(pieChart1);
  }

  public static void main(String[] args) {
    Exercise35_1 applet = new Exercise35_1();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise35_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
