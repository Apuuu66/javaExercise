// Exercise34_1.java: Compute future value
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Exercise34_1 extends JApplet implements ActionListener {
  private JTextField jtfInvestmentAmount;
  private JTextField jtfYears;
  private JTextField jtfInterestRate;
  private JTextField jtfFutureValue;
  private JButton jbtCalculate;

  private JMenuItem jmiCalculate = new JMenuItem("Calculate");
  private JMenuItem jmiExit = new JMenuItem("Exit");
  private JMenuItem jmiAbout = new JMenuItem("About");

  public Exercise34_1() {
    // Create the menu bar
    JMenuBar jmb = new JMenuBar();
    this.setJMenuBar(jmb);

    // Create menus
    JMenu operationMenu = new JMenu("Operation");
    jmb.add(operationMenu);
    JMenu helpMenu = new JMenu("Help");
    jmb.add(helpMenu);

    // Add menu items
    operationMenu.add(jmiCalculate);
    operationMenu.addSeparator();
    operationMenu.add(jmiExit);
    helpMenu.add(jmiAbout);

    // Create a new panel with GridLayout to hold labels and text boxes
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(4, 2));
    p.add(new JLabel("Investment Amount"));
    p.add(jtfInvestmentAmount = new JTextField(8));
    p.add(new JLabel("Years"));
    p.add(jtfYears = new JTextField(8));
    p.add(new JLabel("Annual Interest Rate"));
    p.add(jtfInterestRate = new JTextField(8));
    p.add(new JLabel("Future value"));
    p.add(jtfFutureValue = new JTextField(8));
    jtfFutureValue.setEditable(false);

    // Add the panel and a button to the frame
    setLayout(new BorderLayout());
    add(p, BorderLayout.CENTER);
    add(jbtCalculate = new JButton("Calculate"), BorderLayout.SOUTH);

    // Register listener
    jbtCalculate.addActionListener(this);
    jmiCalculate.addActionListener(this);
    jmiExit.addActionListener(this);
    jmiAbout.addActionListener(this);
  }

  // Handle ActionEvent
  public void actionPerformed(ActionEvent e) {
    if ((e.getSource() == jbtCalculate) ||
      (e.getSource() == jmiCalculate)) {
      calculate();
    }
    else if (e.getSource() == jmiExit) {
      System.exit(0);
    }
    else if (e.getSource() == jmiAbout) {
      JOptionPane.showMessageDialog(this,
        "Compute Future Investment Value",
        "About This Program", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  // Calculate future value
  public void calculate() {
    double investmentAmount =
    Double.valueOf(jtfInvestmentAmount.getText().trim()).doubleValue();
    int years =
      Integer.valueOf(jtfYears.getText().trim()).intValue();
    double interestRate = Double.valueOf(jtfInterestRate.getText().trim()).doubleValue();
    double futureValue = investmentAmount * Math.pow((1 + interestRate / (12 * 100)), 12 * years);
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
    jtfFutureValue.setText(nf.format(futureValue));
//    jtfFutureValue.setText((int)(futureValue * 100) / 100.0 + "");
  }

  public static void main(String[] args) {
    Exercise34_1 applet = new Exercise34_1();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise34_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
