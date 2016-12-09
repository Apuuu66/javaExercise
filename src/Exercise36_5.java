import java.awt.*;
import javax.swing.*;

public class Exercise36_5 extends javax.swing.JApplet {
  PieChart pieChart1 = new PieChart();
  BarChart barChart1 = new BarChart();
  ChartModel chartModel1 = new ChartModel();

  /** Creates new form Exercise36_5 */
  public Exercise36_5() {
    initComponents();
    chartController1.setChartModel(chartModel1);
    pieChart1.setModel(chartModel1);
    barChart1.setModel(chartModel1);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {//GEN-BEGIN:initComponents
    jPanel1 = new javax.swing.JPanel();
    jbtPieChart = new javax.swing.JButton();
    jbtBarChart = new javax.swing.JButton();
    chartController1 = new ChartController();

    jbtPieChart.setText("View Pie Chart");
    jbtPieChart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtPieChartActionPerformed(evt);
      }
    });

    jPanel1.add(jbtPieChart);

    jbtBarChart.setText("View Bar Chart");
    jbtBarChart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtBarChartActionPerformed(evt);
      }
    });

    jPanel1.add(jbtBarChart);
    add(jPanel1, java.awt.BorderLayout.SOUTH);
    add(chartController1, java.awt.BorderLayout.CENTER);
  }//GEN-END:initComponents

  private void jbtBarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBarChartActionPerformed
    JFrame barChartFrame = new JFrame("View Bar Chart");
    barChartFrame.add(barChart1);
    barChartFrame.setSize(200, 200);
    barChartFrame.setVisible(true);
  }//GEN-LAST:event_jbtBarChartActionPerformed

  private void jbtPieChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPieChartActionPerformed
    JFrame pieChartFrame = new JFrame("View Pie Chart");
    pieChartFrame.add(pieChart1);
    pieChartFrame.setSize(200, 200);
    pieChartFrame.setVisible(true);
  }//GEN-LAST:event_jbtPieChartActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel jPanel1;
  private javax.swing.JButton jbtBarChart;
  private ChartController chartController1;
  private javax.swing.JButton jbtPieChart;
  // End of variables declaration//GEN-END:variables

  public static void main(String[] args) {
    Exercise36_5 applet = new Exercise36_5();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Exercise36_5");
    frame.add(applet, java.awt.BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
