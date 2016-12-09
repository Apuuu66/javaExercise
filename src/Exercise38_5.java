import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.sql.RowSet;
import com.sun.rowset.CachedRowSetImpl;

public class Exercise38_5 extends JApplet {

  private JComboBox jcboDriver = new JComboBox(new String[] {
    "sun.jdbc.odbc.JdbcOdbcDriver",
    "com.mysql.jdbc.Driver",
    "oracle.jdbc.driver.OracleDriver"
  });
  private JComboBox jcboURL = new JComboBox(new String[] {
    "jdbc:odbc:exampleMDBDataSource",
    "jdbc:mysql://localhost/root",
    "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl"
  });

  private JButton jbtConnect =
    new JButton("Connect to DB & Get Table");
  private JTextField jtfUserName = new JTextField(new String("russellsmith"));
  private JPasswordField jpfPassword = new JPasswordField(new String("csci5520"));
  private JTextField jtfTableName = new JTextField(new String("russell"));
  private TableEditor tableEditor1 = new TableEditor();
  private JLabel jlblStatus = new JLabel();

  /** Creates new form Exercise38_5 */
  public Exercise38_5() {
    JPanel jPane1 = new JPanel(new GridLayout(5, 0));
    jPane1.add(jcboDriver);
    jPane1.add(jcboURL);
    jPane1.add(jtfUserName);
    jPane1.add(jpfPassword);
    jPane1.add(jtfTableName);

    JPanel jPanel2 = new JPanel(new GridLayout(5, 0));
    jPanel2.add(new JLabel("JDBC Driver"));
    jPanel2.add(new JLabel("Database URL"));
    jPanel2.add(new JLabel("Username"));
    jPanel2.add(new JLabel("Password"));
    jPanel2.add(new JLabel("Table Name"));

    JPanel jPane3 = new JPanel(new BorderLayout());
    jPane3.add(jbtConnect, BorderLayout.SOUTH);
    jPane3.add(jPanel2, BorderLayout.WEST);
    jPane3.add(jPane1, BorderLayout.CENTER);
    tableEditor1.setPreferredSize(new Dimension(600, 200));

    jcboURL.setEditable(true);
    jcboDriver.setEditable(true);

    add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
      jPane3, tableEditor1), BorderLayout.CENTER);
    add(jlblStatus, BorderLayout.SOUTH);

    jbtConnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        try {
          // Connect to the database and create a rowset
          Class.forName(((String)jcboDriver.getSelectedItem()).trim());
          CachedRowSetImpl rowSet = new CachedRowSetImpl();
          rowSet.setUrl(((String)jcboURL.getSelectedItem()).trim());
          rowSet.setUsername(jtfUserName.getText().trim());
          rowSet.setPassword(new String(jpfPassword.getPassword()));
          rowSet.setCommand("select * from " +
            jtfTableName.getText().trim());
          rowSet.execute();
          rowSet.beforeFirst();
          tableEditor1.setRowSet(rowSet);
        }
        catch (Exception ex) {
          jlblStatus.setText(ex.toString());
        }
      }
    });
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise38_5 applet = new Exercise38_5();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise38_5");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
