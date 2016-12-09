import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Exercise35_9 extends javax.swing.JApplet {
  // Create an array of strings for figure names
  String[] figures = {"Line", "Rectangle", "Round rectangle", "Oval"};

  // Create a list cell renderer
  Exercise35_9CellRenderer myListCellRenderer =
    new Exercise35_9CellRenderer();

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList jList1;
  private FigurePanel figurePanel;
  // End of variables declaration//GEN-END:variables

  /** Creates new form Exercise35_9 */
  public Exercise35_9() {
    initComponents();

    //
    jList1.setListData(figures);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {//GEN-BEGIN:initComponents
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    figurePanel = new FigurePanel();

    jList1.setCellRenderer(myListCellRenderer);
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jList1ValueChanged(evt);
      }
    });

    jScrollPane1.setViewportView(jList1);

    add(jScrollPane1, java.awt.BorderLayout.WEST);
    add(figurePanel, java.awt.BorderLayout.CENTER);
  }//GEN-END:initComponents

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
    String figure = (String)(jList1.getSelectedValue());

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
    Exercise35_9 applet = new Exercise35_9();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise35_9");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}