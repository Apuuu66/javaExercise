import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise17_11 extends JFrame {
  private JPanel jPanel1 = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JTextField jtf = new JTextField();
  private JPanel jPanel2 = new JPanel();
  private JPanel jPanel3 = new JPanel();
  private JRadioButton jrbLeft = new JRadioButton();
  private JRadioButton jrbCenter = new JRadioButton();
  private JRadioButton jrbRight = new JRadioButton();
  private TitledBorder titledBorder1;
  private JLabel jLabel2 = new JLabel();
  private JTextField jtfColumns = new JTextField();
  private JPanel jPanel4 = new JPanel();
  private FlowLayout flowLayout1 = new FlowLayout();

  public Exercise17_11() {
    titledBorder1 = new TitledBorder("");
    this.setSize(new Dimension(663, 223));
    jLabel1.setText("Text field");
    jrbLeft.setText("Left");
    jrbLeft.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jrbLeft_actionPerformed(e);
      }
    });
    jrbCenter.setText("Center");
    jrbCenter.addActionListener(new java.awt.event.ActionListener() {

    public void actionPerformed(ActionEvent e) {
        jrbCenter_actionPerformed(e);
      }
    });
    jrbRight.setText("Right");
    jrbRight.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jrbRight_actionPerformed(e);
      }
    });
    jPanel2.setBorder(titledBorder1);
    titledBorder1.setTitle("Horizontal Alignment");
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jLabel2.setText("Column Size");
    jtfColumns.setFont(new java.awt.Font("Monospaced", 1, 16));
    jtfColumns.setForeground(Color.red);
    jtfColumns.setColumns(10);
    jtfColumns.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jtfColumns_actionPerformed(e);
      }
    });
    jtf.setFont(new java.awt.Font("Monospaced", 1, 16));
    jtf.setForeground(Color.red);
    jtf.setToolTipText("Demonstrate JTextField");
    jtf.setText("Type any thing");
    jtf.setColumns(10);
    jPanel1.setLayout(flowLayout1);
    add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jtf, null);
    jPanel2.add(jrbLeft, null);
    jPanel2.add(jrbCenter, null);
    jPanel2.add(jrbRight, null);
    jPanel3.add(jLabel2, null);
    jPanel3.add(jtfColumns, null);
    add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(jPanel2, null);
    jPanel4.add(jPanel3, null);

    // Group radio buttons
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbLeft);
    btg.add(jrbCenter);
    btg.add(jrbRight);
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //Main method
  public static void main(String[] args) {
    Exercise17_11 frame = new Exercise17_11();
    frame.setTitle("Exercise17_11");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,320);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  void jrbLeft_actionPerformed(ActionEvent e) {
    if (jrbLeft.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.LEFT);
    }
  }

  void jrbCenter_actionPerformed(ActionEvent e) {
    if (jrbCenter.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.CENTER);
    }
  }

  void jrbRight_actionPerformed(ActionEvent e) {
    if (jrbRight.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.RIGHT);
    }
  }

  void jtfColumns_actionPerformed(ActionEvent e) {
    jtf.setColumns(
      (new Integer(jtfColumns.getText().trim()).intValue()));
    validate();
  }
}

