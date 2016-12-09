import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Exercise35_11 extends javax.swing.JApplet {
  // Create an array of strings for figure names
  String[] figures = {"Line", "Rectangle", "Round rectangle", "Oval"};

  // Create a list cell renderer
  Exercise35_9CellRenderer myListCellRenderer =
    new Exercise35_9CellRenderer();

  private javax.swing.JComboBox jComboBox1;
  private FigurePanel figurePanel;

  /** Creates new form Exercise35_11 */
  public Exercise35_11() {
    initComponents();

    jComboBox1.addItem("Line");
    jComboBox1.addItem("Rectangle");
    jComboBox1.addItem("Round rectangle");
    jComboBox1.addItem("Oval");
    jComboBox1.setRenderer(myListCellRenderer);

  }

  private void initComponents() {
    jComboBox1 = new javax.swing.JComboBox();
    figurePanel = new FigurePanel();

    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    add(jComboBox1, java.awt.BorderLayout.NORTH);
    add(figurePanel, java.awt.BorderLayout.CENTER);
  }

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    String figure = (String)(jComboBox1.getSelectedItem());

    if (figure.equals("Line"))
      figurePanel.setType(1);
    else if (figure.equals("Rectangle"))
      figurePanel.setType(2);
    else if (figure.equals("Round rectangle"))
      figurePanel.setType(3);
    else if (figure.equals("Oval"))
      figurePanel.setType(4);

    figurePanel.repaint();
  }

  public static void main(String[] args) {
    Exercise35_11 applet = new Exercise35_11();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise35_11");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
