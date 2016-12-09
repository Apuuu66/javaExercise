import javax.swing.JOptionPane;

public class Exercise2_11a {
  public static void main(String args[]) {
    // Obtain input
    String name = JOptionPane.showInputDialog(null,
      "Enter employee's full name:",
      "Exercise2_12 Input", JOptionPane.QUESTION_MESSAGE);

    String hoursString = JOptionPane.showInputDialog(null,
      "Enter number of hours worked in a week:",
      "Exercise2_12 Input", JOptionPane.QUESTION_MESSAGE);
    double hours = Double.parseDouble(hoursString);

    String rateString = JOptionPane.showInputDialog(null,
      "Enter hourly pay rate:",
      "Exercise2_12 Input", JOptionPane.QUESTION_MESSAGE);
    double payRate = Double.parseDouble(rateString);

    String fedTaxWithholdingRateString = JOptionPane.showInputDialog(null,
      "Enter federal tax withholding rate:",
      "Exercise2_12 Input", JOptionPane.QUESTION_MESSAGE);
    double fedTaxWithholdingRate = Double.parseDouble(fedTaxWithholdingRateString);

    String stateTaxWithholdingRateString = JOptionPane.showInputDialog(null,
      "Enter state tax withholding rate:",
      "Exercise2_12 Input", JOptionPane.QUESTION_MESSAGE);
    double stateTaxWithholdingRate = Double.parseDouble(stateTaxWithholdingRateString);

    double grossPay = hours * payRate;
    double fedTaxWithholding = grossPay * fedTaxWithholdingRate;
    double stateTaxWithholding = grossPay * stateTaxWithholdingRate;
    double totalDeduction = fedTaxWithholding + stateTaxWithholding;
    double netPay = grossPay - totalDeduction;

    // Obtain output
    String out = "Employee Name: " + name + "\n\n";
    out += "Hours Worked:" + "  " + hoursString + '\n';
    out += "Pay Rate:" + "  $" + rateString + '\n';
    out += "Gross Pay:" + "  $" + grossPay + '\n';
    out += "Deductions:\n";
    out += "  Federal Withholding (" + fedTaxWithholdingRate * 100 + "%):" + "  $" + (int)(fedTaxWithholding * 100) / 100.0 + '\n';
    out += "  State Withholding (" + stateTaxWithholdingRate * 100 + "%):" + "  $" + (int)(stateTaxWithholding * 100) / 100.0 + '\n';
    out += "  Total Deduction:" + "  $" + (int)(totalDeduction * 100) / 100.0 + '\n';
    out += "Net Pay:" + "   $" + (int)(netPay * 100) / 100.0;

    System.out.print(out);
    JOptionPane.showMessageDialog(null, out,
      "Exercise2_12 Output", JOptionPane.INFORMATION_MESSAGE);
  }
}
