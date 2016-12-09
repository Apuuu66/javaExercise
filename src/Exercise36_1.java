import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.text.*;

public class Exercise36_1 extends JApplet {
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();

  JSpinner jSpinnerLoanAmount =
  new JSpinner(new SpinnerNumberModel(100000.0, 10000, 10000000, 500)); ;
  JLabel jLabel2 = new JLabel();

  JSpinner jSpinnerNumOfYears = new JSpinner(
    new SpinnerNumberModel(15, 1, 30, 1));
  JLabel jLabel3 = new JLabel();
  JSpinner jSpinnerAnnualInterestRate =
    new JSpinner(new SpinnerNumberModel(0.05, 0.01, 0.15, 0.00125));
  JButton jbtLoanSchedule = new JButton();
  TitledBorder titledBorder1;
  JScrollPane jScrollPane1 = new JScrollPane();

  DefaultTableModel tableModel = new DefaultTableModel();

  JTable jtbLoanSchedule = new JTable(tableModel);
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();

  /**Construct the applet*/
  public Exercise36_1() {
    titledBorder1 = new TitledBorder("");
    this.setSize(new Dimension(705, 399));
    jLabel1.setText("Loan Amount");
    jLabel2.setText("Number of Years");
    jLabel3.setText("Annual Interest Rate");
    jbtLoanSchedule.setText("Display Loan Schedule");
    jbtLoanSchedule.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtLoanSchedule_actionPerformed(e);
      }
    });
    jPanel1.setLayout(gridLayout1);
    jPanel1.setBorder(titledBorder1);
    titledBorder1.setTitle("Enter Loan Amount, Number of Years, and Annual Interest Rate");
    jPanel2.setLayout(borderLayout1);
    gridLayout1.setRows(3);
    gridLayout1.setColumns(2);
    add(jScrollPane1, BorderLayout.CENTER);
    add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jbtLoanSchedule, BorderLayout.EAST);
    jPanel2.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jSpinnerLoanAmount, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jSpinnerNumOfYears, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jSpinnerAnnualInterestRate, null);
    jScrollPane1.getViewport().add(jtbLoanSchedule, null);

    tableModel.setColumnIdentifiers(new String[]{"Payment#",
      "Interest", "Principal", "Balance"});

    // Set editor for annual interest rate
    JSpinner.NumberEditor interestRateEditor =
      new JSpinner.NumberEditor(jSpinnerAnnualInterestRate, "%#.###");
    jSpinnerAnnualInterestRate.setEditor(interestRateEditor);

    // Set editor for loan amount
    JSpinner.NumberEditor loanAmountEditor =
      new JSpinner.NumberEditor(jSpinnerLoanAmount, "¤#,###,###");
    jSpinnerLoanAmount.setEditor(loanAmountEditor);

  }

  void jbtLoanSchedule_actionPerformed(ActionEvent e) {
    // Obtain loan amount, annual interest rate, and number of years
    double loanAmount =
        ((Double)(jSpinnerLoanAmount.getValue())).doubleValue();
    double annualInterestRate =
      ((Double)(jSpinnerAnnualInterestRate.getValue())).doubleValue();
    int numOfYears =
      ((Integer)(jSpinnerNumOfYears.getValue())).intValue();

    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate / 12;

    // Compute mortgage
    double monthlyPayment = loanAmount * monthlyInterestRate /
      (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));

    double balance = loanAmount;
    double interest;
    double principal;
    NumberFormat currencyForm = NumberFormat.getCurrencyInstance();

//    jtbLoanSchedule.setText("Monthly Payment: " +
//      currencyForm.format(monthlyPayment) + "\n");
//    jtbLoanSchedule.append(
//      "Total Payment: " +
//       currencyForm.format(monthlyPayment * 12 * numOfYears) + "\n\n");
//    jtbLoanSchedule.append(
//      "Payment#\tInterest\tPrincipal\tBalance\n");
    tableModel.setRowCount(0);

    int i;
    for (i = 1; i <= numOfYears * 12; i++) {
      interest = monthlyInterestRate * balance;
      principal = monthlyPayment - interest;
      balance -= principal;
      tableModel.addRow(new Object[]{new Integer(i),
        currencyForm.format(interest),
        currencyForm.format(principal),
        currencyForm.format(balance)});
    }
  }

  public static void main(String[] args) {
    Exercise36_1 applet = new Exercise36_1();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise36_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
