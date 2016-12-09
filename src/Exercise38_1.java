import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Exercise38_1 extends javax.swing.JApplet {
  // Connection to the database
  private Connection connection;

  // Statement to execute SQL commands
  private Statement statement;

  /** Creates new form Exercise38_1 */
  public Exercise38_1() {
    dBConnectionDialog = new DBConnectionDialog();
    jPanel1 = new javax.swing.JPanel();
    jlblConnectionStatus = new javax.swing.JLabel();
    jbtConnectDB = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jbtBatchUpdate = new javax.swing.JButton();
    jbtNonBatchUpdate = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtaDisplay = new javax.swing.JTextArea();

    jPanel1.setLayout(new java.awt.BorderLayout());

    jlblConnectionStatus.setText("No connection now");
    jPanel1.add(jlblConnectionStatus, java.awt.BorderLayout.CENTER);

    jbtConnectDB.setText("Connect to Database");
    jbtConnectDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtConnectDBActionPerformed(evt);
      }
    });

    jPanel1.add(jbtConnectDB, java.awt.BorderLayout.EAST);

    add(jPanel1, java.awt.BorderLayout.NORTH);

    jbtBatchUpdate.setText("Batch Update");
    jbtBatchUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtBatchUpdateActionPerformed(evt);
      }
    });

    jPanel2.add(jbtBatchUpdate);

    jbtNonBatchUpdate.setText("Non-Batch Update");
    jbtNonBatchUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtNonBatchUpdateActionPerformed(evt);
      }
    });

    jPanel2.add(jbtNonBatchUpdate);

    add(jPanel2, java.awt.BorderLayout.SOUTH);

    jScrollPane1.setViewportView(jtaDisplay);

    add(jScrollPane1, java.awt.BorderLayout.CENTER);

  }//GEN-END:initComponents

  private void jbtNonBatchUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNonBatchUpdateActionPerformed
    if (statement != null) {
      try {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 5000; i++) {
          statement.executeUpdate("INSERT INTO TEMP VALUES(" +
            Math.random() * 1000 + ", " + Math.random() * 1000 + ", " +
            Math.random() + ")");
        }

        long endTime = System.currentTimeMillis();

        jtaDisplay.append("Non-batch update completed\n");
        jtaDisplay.append("The elapsed time is " +
          (endTime - startTime) + "\n");

        jlblConnectionStatus.setText("Non-batch update succeeded");
      }
      catch (Exception ex) {
        jtaDisplay.setText(ex.toString());
      }
    }
    else {
      jtaDisplay.setText("Please connect to the database first");
    }
  }//GEN-LAST:event_jbtNonBatchUpdateActionPerformed

  private void jbtBatchUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBatchUpdateActionPerformed
    if (statement != null) {
      try {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 5000; i++) {
          statement.addBatch("INSERT INTO TEMP VALUES(" +
            Math.random()*1000 + ", " + Math.random()*1000 + ", " +
            Math.random() + ")");
        }

        statement.executeBatch();

        long endTime = System.currentTimeMillis();

        jtaDisplay.append("Batch update completed\n");
        jtaDisplay.append("The elapsed time is " +
          (endTime - startTime) + "\n");

        jlblConnectionStatus.setText("Batch update succeeded");
      }
      catch (Exception ex) {
        jtaDisplay.append(ex.toString());
      }
    }
  }//GEN-LAST:event_jbtBatchUpdateActionPerformed

  private void jbtConnectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConnectDBActionPerformed
    dBConnectionDialog.setModal(true);
    dBConnectionDialog.setVisible(true);

    connection = dBConnectionDialog.getConnection();
    if (connection != null) {
      try {
        jlblConnectionStatus.setText("Connected to " +
          connection.getMetaData().getURL() + " " +
          connection.getMetaData().getUserName());

        // Create the table
        statement = connection.createStatement();

        statement.executeUpdate(
          "drop table Temp");
        statement.executeUpdate(
          "CREATE TABLE TEMP(NUM1 double, NUM2 double, NUM3 double)");
      }
      catch (SQLException ex) {
        jlblConnectionStatus.setText(ex.toString());
      }
    }
  }//GEN-LAST:event_jbtConnectDBActionPerformed

  // Main method
  public static void main(String[] args) {
    Exercise38_1 applet = new Exercise38_1();
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Exercise38_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2,
      (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton jbtNonBatchUpdate;
  private javax.swing.JTextArea jtaDisplay;
  private DBConnectionDialog dBConnectionDialog;
  private javax.swing.JLabel jlblConnectionStatus;
  private javax.swing.JButton jbtConnectDB;
  private javax.swing.JButton jbtBatchUpdate;
  // End of variables declaration//GEN-END:variables
}

class DBConnectionDialog extends JDialog {
  private JButton jbtCloseDialog = new JButton("Close Dialog");
  private DBConnectionPanel dBConnectionPanel1 =
    new DBConnectionPanel();

  public DBConnectionDialog() {
    setSize(200, 200);
    setTitle("Connect to Database");
    setLayout(new BorderLayout());
    add(dBConnectionPanel1, BorderLayout.CENTER);
    add(jbtCloseDialog, BorderLayout.SOUTH);

    jbtCloseDialog.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
      }
    });
  }

  /** Return connection */
  public Connection getConnection() {
    return dBConnectionPanel1.getConnection();
  }
}
