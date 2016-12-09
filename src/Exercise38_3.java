import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Exercise38_3 extends JApplet {
  private JTable jTable1 = new JTable();

  /** Creates new form TestTableEditor */
  public Exercise38_3() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection(
        "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
        "scott", "tiger");

      // Create a statement
      Statement statement = connection.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_UPDATABLE);

      // Execute a statement
      ResultSet resultSet = statement.executeQuery
        ("select * from Course");

      ResultSetTableModel model = new ResultSetTableModel(resultSet);
      jTable1.setModel(model);

      // Enable auto sort on columns
      TableRowSorter<TableModel> sorter =
        new TableRowSorter<TableModel>(model);
      jTable1.setRowSorter(sorter);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    add(new JScrollPane(jTable1), BorderLayout.CENTER);
  }

  /** Main method */
  public static void main(String[] args) {
    Exercise38_3 applet = new Exercise38_3();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Exercise38_3");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

class ResultSetTableModel extends AbstractTableModel {
  // RowSet for the result set
  private ResultSet resultSet;

  /** Return the ResultSet */
  public ResultSet getResultSet() {

    return resultSet;
  }

  public ResultSetTableModel(ResultSet resultSet) {
    setResultSet(resultSet);
  }

  /** Set a new ResultSet */
  public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
    fireTableStructureChanged();
  }

  /** Return the number of rows in the row set */
  public int getRowCount() {
    try {
      resultSet.last();
      return resultSet.getRow();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    return 0;
  }

  /** Return the number of columns in the row set */
  public int getColumnCount() {
    try {
      if (resultSet != null) {
        return resultSet.getMetaData().getColumnCount();
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }

    return 0;
  }

  /** Return value at the specified row and column */
  public Object getValueAt(int row, int column) {
    try {
      resultSet.absolute(row + 1);
      return resultSet.getObject(column + 1);
    }
    catch (SQLException sqlex) {
      sqlex.printStackTrace();
    }

    return null;
  }

  /** Return the column name at a specified column */
  public String getColumnName(int column) {
    try {
      return resultSet.getMetaData().getColumnLabel(column + 1);
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }

    return "";
  }
}
