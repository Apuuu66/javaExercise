import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

import java.sql.*;
import javax.swing.border.*;

public class Exercise37_1 extends JApplet {
  private boolean isStandalone = false;
  private JPanel jpDisplay = new JPanel();
  private JLabel jlblStatus = new JLabel();
  private JPanel jpButtons = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel jpStaff = new JPanel();
  private JButton jbtView = new JButton();
  private JButton jbtInsert = new JButton();
  private JButton jbtUpdate = new JButton();
  private JButton jbtClear = new JButton();
  private JPanel jPanel1 = new JPanel();
  private JPanel jPanel2 = new JPanel();
  private JPanel jPanel3 = new JPanel();
  private JPanel jPanel4 = new JPanel();
  private JPanel jPanel5 = new JPanel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private FlowLayout flowLayout1 = new FlowLayout();
  private FlowLayout flowLayout2 = new FlowLayout();
  private FlowLayout flowLayout3 = new FlowLayout();
  private JTextField jtfID = new JTextField();
  private JTextField jtfLastName = new JTextField();
  private JLabel jLabel5 = new JLabel();
  private JTextField jtfFirstName = new JTextField();
  private JLabel jLabel6 = new JLabel();
  private JTextField jtfmi = new JTextField();
  private JTextField jtfAddress = new JTextField();
  private JLabel jLabel7 = new JLabel();
  private JTextField jtfCity = new JTextField();
  private JLabel jLabel8 = new JLabel();
  private JTextField jtfState = new JTextField();
  private FlowLayout flowLayout4 = new FlowLayout();
  private JLabel jLabel9 = new JLabel();
  private JTextField jtfTelephone = new JTextField();
  private FlowLayout flowLayout5 = new FlowLayout();

  // The Statement for processing queries
  private Statement stmt;
  private TitledBorder titledBorder1;
  private GridLayout gridLayout1 = new GridLayout();

  /**Initialize the applet*/
  public void init() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setSize(400,300);
    jpDisplay.setLayout(borderLayout1);
    jpStaff.setLayout(gridLayout1);
    jbtView.setText("View");
    jbtView.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtView_actionPerformed(e);
      }
    });
    jbtInsert.setText("Insert");
    jbtInsert.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(ActionEvent e) {
        jbtInsert_actionPerformed(e);
      }
    });
    jbtUpdate.setText("Update");
    jbtUpdate.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(ActionEvent e) {
        jbtUpdate_actionPerformed(e);
      }
    });
    jbtClear.setText("Clear");
    jbtClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtClear_actionPerformed(e);
      }
    });
    jPanel5.setLayout(flowLayout5);
    jPanel4.setLayout(flowLayout4);
    jPanel3.setLayout(flowLayout3);
    jPanel2.setLayout(flowLayout2);
    jPanel1.setLayout(flowLayout1);
    jLabel2.setText("ID");
    jLabel3.setText("Last Name");
    jLabel4.setText("Address");
    flowLayout1.setAlignment(0);
    flowLayout2.setAlignment(0);
    flowLayout3.setAlignment(0);
    jtfID.setColumns(11);
    jtfID.setBackground(Color.yellow);
    jtfLastName.setColumns(10);
    jLabel5.setText("First Name");
    jtfFirstName.setColumns(10);
    jLabel6.setText("mi");
    jtfmi.setColumns(2);
    jtfAddress.setColumns(15);
    jLabel7.setText("City");
    jtfCity.setColumns(15);
    jLabel8.setText("State");
    jtfState.setColumns(2);
    flowLayout4.setAlignment(0);
    jLabel9.setText("Telephone");
    jtfTelephone.setColumns(12);
    flowLayout5.setAlignment(0);
    jlblStatus.setBackground(Color.pink);
    jlblStatus.setText("Connecting ...");
    jpStaff.setBorder(titledBorder1);
    titledBorder1.setTitle("Staff Information");
    gridLayout1.setColumns(1);
    gridLayout1.setRows(5);
    add(jpDisplay, BorderLayout.CENTER);
    jpDisplay.add(jpButtons, BorderLayout.SOUTH);
    jpButtons.add(jbtView, null);
    jpButtons.add(jbtInsert, null);
    jpButtons.add(jbtUpdate, null);
    jpButtons.add(jbtClear, null);
    jpDisplay.add(jpStaff, BorderLayout.CENTER);
    jpStaff.add(jPanel1, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jtfID, null);
    jpStaff.add(jPanel2, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jtfLastName, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jtfFirstName, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(jtfmi, null);
    jpStaff.add(jPanel3, null);
    jpStaff.add(jPanel4, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(jtfCity, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jtfState, null);
    jpStaff.add(jPanel5, null);
    jPanel5.add(jLabel9, null);
    jPanel5.add(jtfTelephone, null);
    jPanel3.add(jLabel4, null);
    jPanel3.add(jtfAddress, null);
    add(jlblStatus, BorderLayout.SOUTH);

    // Connect to the database
    initializeDB();
  }

  private void initializeDB() {
    try {
      // Load the driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded\n");

      // Connect to the local InterBase database
      Connection conn = DriverManager.getConnection
//        ("jdbc:odbc:exampleMDBDataSource", "", "" );
        ("jdbc:mysql://localhost/test", "scott", "tiger");
      System.out.println("Database connected\n");

      jlblStatus.setText("Database connected");

      // Create a statement
      stmt = conn.createStatement();
    }
    catch (Exception ex) {
      jlblStatus.setText("Connection failed: " + ex);
    }
  }

  void jbtInsert_actionPerformed(ActionEvent e) {
    insert();
  }

  void jbtView_actionPerformed(ActionEvent e) {
    view();
  }

  void jbtUpdate_actionPerformed(ActionEvent e) {
    update();
  }

  void jbtClear_actionPerformed(ActionEvent e) {
    clear();
  }

  /**View record by ID*/
  private void view() {
    // Build a SQL SELECT statement
    String query = "SELECT * FROM Staff WHERE ID = "
      + "'" + jtfID.getText().trim() + "'";

    try {
      // Execute query
      ResultSet rs = stmt.executeQuery(query);
      loadToTextField(rs);
    }
    catch(SQLException ex) {
      jlblStatus.setText("Select failed: " + ex);
    }
  }

  /**Load the record into text fields*/
  private void loadToTextField(ResultSet rs) throws SQLException {
    if (rs.next()) {
      jtfLastName.setText(rs.getString(2));
      jtfFirstName.setText(rs.getString(3));
      jtfmi.setText(rs.getString(4));
      jtfAddress.setText(rs.getString(5));
      jtfCity.setText(rs.getString(6));
      jtfState.setText(rs.getString(7));
      jtfTelephone.setText(rs.getString(8));
      jlblStatus.setText("Record found");
    }
    else
      jlblStatus.setText("Record not found");
  }

  /**Insert a new record*/
  private void insert() {
    // Build a SQL INSERT statement
    String insertStmt =
      "INSERT INTO Staff(ID, LastName, FirstName, mi, Address, " +
      " City, State, Telephone) VALUES('" +
      jtfID.getText().trim() + "','" +
      jtfLastName.getText().trim() + "','" +
      jtfFirstName.getText().trim() + "','" +
      jtfmi.getText().trim() + "','" +
      jtfAddress.getText().trim() + "','" +
      jtfCity.getText().trim() + "','" +
      jtfState.getText().trim() + "','" +
      jtfTelephone.getText().trim() + "');";

    try {
      stmt.executeUpdate(insertStmt);
    }
    catch (SQLException ex) {
      jlblStatus.setText("Insertion failed: " + ex);
    }

    jlblStatus.setText("record inserted");
  }

  /**Update a record*/
  private void update() {
    // Build a SQL UPDATE statement
    String updateStmt = "UPDATE Staff " +
      "SET LastName = '" + jtfLastName.getText().trim() + "'," +
      "FirstName = '" + jtfFirstName.getText().trim() + "'," +
      "mi = '" + jtfmi.getText().trim() + "'," +
      "Address = '" + jtfAddress.getText().trim() + "'," +
      "City = '" + jtfCity.getText().trim() + "'," +
      "State = '" + jtfState.getText().trim() + "'," +
      "Telephone = '" + jtfTelephone.getText().trim() + "' " +
      "WHERE ID = '" + jtfID.getText().trim() + "'";

    try {
      stmt.executeUpdate(updateStmt);
      jlblStatus.setText("Record updated");
    }
    catch(SQLException ex) {
      jlblStatus.setText("Update failed: " + ex);
    }
  }

  /**Clear text fields*/
  private void clear() {
    jtfID.setText(null);
    jtfLastName.setText(null);
    jtfFirstName.setText(null);
    jtfmi.setText(null);
    jtfAddress.setText(null);
    jtfCity.setText(null);
    jtfState.setText(null);
    jtfTelephone.setText(null);
  }

  /**Get Applet information*/
  public String getAppletInfo() {
    return "Applet Information";
  }
  /**Get parameter info*/
  public String[][] getParameterInfo() {
    return null;
  }
  /**Main method*/
  public static void main(String[] args) {
    Exercise37_1 applet = new Exercise37_1();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Exercise37_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
