// Exercise33_1.java: Demonstrate FlowLayout properties
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise33_1 extends JApplet {
  boolean isStandalone = false;
  JPanel jpComponents = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JPanel jpGaps = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JTextField jtfHGap = new JTextField();
  JTextField jtfVGap = new JTextField();
  GridLayout gridLayout4 = new GridLayout();
  GridLayout gridLayout5 = new GridLayout();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JComboBox jcboAlignment = new JComboBox();
  BorderLayout borderLayout1 = new BorderLayout();
  FlowLayout flowLayout = new FlowLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  /**Construct the applet*/
  public Exercise33_1() {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setSize(new Dimension(400,300));
    jPanel2.setLayout(borderLayout1);
    jLabel3.setText("HGap");
    jLabel4.setText("VGap");
    jpGaps.setLayout(borderLayout2);
    gridLayout4.setRows(3);
    gridLayout5.setRows(3);
    jPanel5.setLayout(gridLayout4);
    jPanel6.setLayout(gridLayout5);
    jpComponents.setLayout(flowLayout);
    jtfHGap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jtfHGap_actionPerformed(e);
      }
    });
    jtfVGap.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jtfVGap_actionPerformed(e);
      }
    });
    jLabel1.setText("Alignment");
    jcboAlignment.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jcboAlignment_actionPerformed(e);
      }
    });
    jpComponents.setBorder(titledBorder1);
    titledBorder1.setTitle("A Container of FlowLayout");
    jPanel2.setBorder(titledBorder2);
    titledBorder2.setTitle("FlowLayout Properties");
    add(jpComponents, BorderLayout.CENTER);
    add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(jpGaps, BorderLayout.CENTER);
    jpGaps.add(jPanel5, BorderLayout.WEST);
    jPanel5.add(jLabel1, null);
    jPanel5.add(jLabel3, null);
    jPanel5.add(jLabel4, null);
    jpGaps.add(jPanel6, BorderLayout.CENTER);
    jPanel6.add(jcboAlignment, null);
    jPanel6.add(jtfHGap, null);
    jPanel6.add(jtfVGap, null);

    // Add 15 buttons to jpComponents
    for (int i = 0; i < 15; i++)
      jpComponents.add(new JButton("Component " + i));

    // Add items to the combo box
    jcboAlignment.addItem("LEFT");
    jcboAlignment.addItem("CENTER");
    jcboAlignment.addItem("RIGHT");
  }

  void jtfHGap_actionPerformed(ActionEvent e) {
    int hgap = new Integer(jtfHGap.getText()).intValue();
    flowLayout.setHgap(hgap);
    jpComponents.revalidate();
  }

  void jtfVGap_actionPerformed(ActionEvent e) {
    int vgap = new Integer(jtfVGap.getText()).intValue();
    flowLayout.setVgap(vgap);
    jpComponents.revalidate();
  }

  void jcboAlignment_actionPerformed(ActionEvent e) {
    if (jcboAlignment.getSelectedItem().equals("LEFT"))
      flowLayout.setAlignment(FlowLayout.LEFT);
    else if (jcboAlignment.getSelectedItem().equals("CENTER"))
      flowLayout.setAlignment(FlowLayout.CENTER);
    else if (jcboAlignment.getSelectedItem().equals("RIGHT"))
      flowLayout.setAlignment(FlowLayout.RIGHT);

    jpComponents.revalidate();
  }

  public static void main(String[] args) {
    Exercise33_1 applet = new Exercise33_1();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setTitle("Exercise33_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
