import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise16_5 extends JFrame {
  private JTextField jtfInvestmentAmount;
  private JTextField jtfYears;
  private JTextField jtfInterestRate;
  private JTextField jtfFutureValue;
  private JButton jbtCalculate;

  public static void main(String[] args) {
    JFrame frame = new Exercise16_5();
    frame.pack();
    frame.setTitle("Exercise16_5");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise16_5() {
    // Create a new panel with GridLayout to hold labels and text boxes
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(4, 2, 5, 0));
    p.setBorder(new EmptyBorder(5, 5, 5, 5));
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

    // Add a button to a panel
    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p1.add(jbtCalculate = new JButton("Calculate"));
    add(p1, BorderLayout.SOUTH);

    jbtCalculate.setMnemonic('C');
    jtfInvestmentAmount.setHorizontalAlignment(JTextField.RIGHT);
    jtfYears.setHorizontalAlignment(JTextField.RIGHT);
    jtfInterestRate.setHorizontalAlignment(JTextField.RIGHT);
    jtfFutureValue.setHorizontalAlignment(JTextField.RIGHT);

    // Register listener
    jbtCalculate.addActionListener(new ActionListener() {
      // Handle ActionEvent
      public void actionPerformed(ActionEvent e) {
        calculate();
      }
    });
  }

  // Calculate future value
  public void calculate() {
    double investmentAmount =
      Double.valueOf(jtfInvestmentAmount.getText().trim()).
      doubleValue();
    int years =
      Integer.valueOf(jtfYears.getText().trim()).intValue();
    double interestRate = Double.valueOf(jtfInterestRate.getText().
      trim()).doubleValue();
    double futureValue = investmentAmount * Math.pow((1 +
      interestRate / (12 * 100)), 12 * years);
//    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
//    jtfFutureValue.setText(nf.format(futureValue));
    jtfFutureValue.setText((int)(futureValue * 100) / 100.0 + "");
  }
}
