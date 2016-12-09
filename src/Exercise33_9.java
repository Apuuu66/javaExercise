import javax.swing.*;

import java.awt.*;

public class Exercise33_9 extends javax.swing.JApplet {
  /** Creates new form Exercise33_9 */
  public Exercise33_9() {
    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jrbHorizontal = new javax.swing.JRadioButton();
    jrbVertical = new javax.swing.JRadioButton();
    jPanel3 = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jtfDividerSize = new javax.swing.JTextField();
    jchkContinuousLayout = new javax.swing.JCheckBox();
    jSplitPane1 = new javax.swing.JSplitPane();

    jPanel1.setLayout(new java.awt.BorderLayout());

    jPanel2.setLayout(new java.awt.GridLayout(2, 0));

    jPanel2.setBorder(new javax.swing.border.TitledBorder("Orientation"));
    jrbHorizontal.setText("Horizontal");
    buttonGroup1.add(jrbHorizontal);
    jrbHorizontal.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbHorizontalActionPerformed(evt);
      }
    });

    jPanel2.add(jrbHorizontal);

    jrbVertical.setText("Vertical");
    buttonGroup1.add(jrbVertical);
    jrbVertical.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbVerticalActionPerformed(evt);
      }
    });

    jPanel2.add(jrbVertical);

    jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

    jPanel3.setLayout(new java.awt.BorderLayout());

    jPanel4.setLayout(new java.awt.BorderLayout(5, 0));

    jLabel1.setText("Divider SIze");
    jPanel4.add(jLabel1, java.awt.BorderLayout.WEST);

    jtfDividerSize.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfDividerSizeActionPerformed(evt);
      }
    });

    jPanel4.add(jtfDividerSize, java.awt.BorderLayout.CENTER);

    jchkContinuousLayout.setText("Continous Layout");
    jchkContinuousLayout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jchkContinuousLayoutActionPerformed(evt);
      }
    });

    jPanel4.add(jchkContinuousLayout, java.awt.BorderLayout.NORTH);
    jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);
    jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);
    add(jPanel1, java.awt.BorderLayout.SOUTH);
    add(jSplitPane1, java.awt.BorderLayout.CENTER);
  }

  private void jtfDividerSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDividerSizeActionPerformed
    jSplitPane1.setDividerSize(
      new Integer(jtfDividerSize.getText().trim()).intValue());
  }//GEN-LAST:event_jtfDividerSizeActionPerformed

  private void jchkContinuousLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkContinuousLayoutActionPerformed
    if (jchkContinuousLayout.isSelected())
      jSplitPane1.setContinuousLayout(true);
    else
      jSplitPane1.setContinuousLayout(false);
  }//GEN-LAST:event_jchkContinuousLayoutActionPerformed

  private void jrbVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbVerticalActionPerformed
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
  }//GEN-LAST:event_jrbVerticalActionPerformed

  private void jrbHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHorizontalActionPerformed
    jSplitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
  }//GEN-LAST:event_jrbHorizontalActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField jtfDividerSize;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JCheckBox jchkContinuousLayout;
  private javax.swing.JRadioButton jrbVertical;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JRadioButton jrbHorizontal;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables

  public static void main(String[] args) {
    Exercise33_9 applet = new Exercise33_9();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise33_9");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
