import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise18_7 extends JApplet {
  // Two text fields for taxable income and tax
  private JTextField jtfTaxableIncome = new JTextField(10);
  private JTextField jtfTax = new JTextField(10);

  // Compute button
  private JButton jbtComputeTax = new JButton("Compute Tax");

  // Radio buttons for tax status
  private JRadioButton jrbSingle = new JRadioButton("Single filers");
  private JRadioButton jrbMarriedJointly = new JRadioButton("Married filing jointly");
  private JRadioButton jrbMarriedSeparately = new JRadioButton("Married filing separately");
  private JRadioButton jrbHeadOfHousehold = new JRadioButton("Head of household");

  private Tax tax = new Tax();

  private String singleFilerScheme =
    "Single Filers\nTaxable Income\t\tRate\n" +
    "Up to $27,050\t\t15%\n"+
    "$27,051 - $65,550\t27.5%\n" +
    "$65,551 - $136,750\t30.5%\n" +
    "$136,751 - $297,350\t35.5%\n" +
    "$297,351 or more\t39.1%";

  private String marriedJointlyFilerScheme =
    "Married Jointly Fliers\nTaxable Income\t\tRate\n" +
    "Up to $45,200\t\t15%\n"+
    "$45,201 - $109,250\t27.5%\n" +
    "$109,251 - $166,500\t30.5%\n" +
    "$166,501 - $297,350\t35.5%\n" +
    "$297,351 or more\t39.1%";

  private String marriedSeparatelyFilerScheme =
    "Married Separately Fliers\nTaxable Income\t\tRate\n" +
    "Up to $22,600\t\t15%\n"+
    "$22,601 - $54,655\t27.5%\n" +
    "$54,656 - $83,250\t30.5%\n" +
    "$83,251 - $148,675\t35.5%\n" +
    "$148,676 or more\t39.1%";

  private String headOfHouseFilerScheme =
    "Head of Household Fliers\nTaxable Income\t\tRate\n" +
    "Up to $36,250\t\t15%\n"+
    "$36,251 - $93,650\t27.5%\n" +
    "$93,651 - $151,650\t30.5%\n" +
    "$151,651 - $297,350\t35.5%\n" +
    "$297,351 or more\t39.1%";

  // Tax scheme labels
  private JTextArea jtaTaxScheme = new JTextArea(singleFilerScheme);

  /** Initialize UI */
  public void init() {
    // Panel p1 to hold the labels for text fields
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(2, 1));
    p1.add(new JLabel("Taxable income"));
    p1.add(new JLabel("Tax"));

    // Panel p2 to hold the text fields
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(2, 1));
    p2.add(jtfTaxableIncome);
    p2.add(jtfTax);
    jtfTax.setEditable(false);

    // Panel p3 to hold the text fields and their labels
    JPanel p3 = new JPanel();
    p3.setLayout(new BorderLayout());
    p3.add(p1, BorderLayout.WEST);
    p3.add(p2, BorderLayout.CENTER);

    // Panel p4 to hold the button on the right corner
    JPanel p4 = new JPanel();
    p4.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p4.add(jbtComputeTax);

    // Panel p5 to hold the radio buttons
    JPanel p5 = new JPanel();
    p5.setLayout(new GridLayout(4, 1));
    p5.add(jrbSingle);
    p5.add(jrbMarriedJointly);
    p5.add(jrbMarriedSeparately);
    p5.add(jrbHeadOfHousehold);

    // Be default, tax status is single filer
    jrbSingle.setSelected(true);

    // Group radio buttons
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbSingle);
    btg.add(jrbMarriedJointly);
    btg.add(jrbMarriedSeparately);
    btg.add(jrbHeadOfHousehold);

    // Panel p6 to hold the compute tax button
    JPanel p6 = new JPanel();
    p6.setLayout(new BorderLayout());
    p6.add(jtaTaxScheme, BorderLayout.CENTER);
    p6.add(p5, BorderLayout.WEST);
    p6.setBorder(new TitledBorder("Select Tax Status"));

    add(p6, BorderLayout.NORTH);
    add(p3, BorderLayout.CENTER);
    add(p4, BorderLayout.SOUTH);

    // Register listeners
    jrbSingle.addActionListener(new Listener());
    jrbMarriedJointly.addActionListener(new Listener());
    jrbMarriedSeparately.addActionListener(new Listener());
    jrbHeadOfHousehold.addActionListener(new Listener());
    jbtComputeTax.addActionListener(new Listener());
  }

  class Listener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == jbtComputeTax) {
	      tax.setTaxableIncome(Double.parseDouble(jtfTaxableIncome.getText().trim()));
	      jtfTax.setText(tax.findTax() + "");
	    }
	    else if (e.getSource() == jrbSingle) {
	      jtaTaxScheme.setText(singleFilerScheme);
	      tax.setFilingStatus(Tax.SINGLE_FILER);
	    }
	    else if (e.getSource() == jrbMarriedJointly) {
	      jtaTaxScheme.setText(marriedJointlyFilerScheme);
	      tax.setFilingStatus(Tax.MARRIED_JOINTLY);
	    }
	    else if (e.getSource() == jrbMarriedSeparately) {
	      jtaTaxScheme.setText(marriedSeparatelyFilerScheme);
	      tax.setFilingStatus(Tax.MARRIED_SEPARATELY);
	    }
	    else if (e.getSource() == jrbHeadOfHousehold) {
	      jtaTaxScheme.setText(headOfHouseFilerScheme);
	      tax.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
	    }
	  }
  }

  /**This main method enables the applet to run as an application*/
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_7");

    // Create an instance of the applet
    Exercise18_7 applet = new Exercise18_7();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
