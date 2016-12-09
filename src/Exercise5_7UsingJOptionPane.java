import javax.swing.JOptionPane;

public class Exercise5_7UsingJOptionPane {
  public static void main(String[] args) {
    // Enter yearly interest rate
    String annualIntrestRateString = JOptionPane.showInputDialog(
      "Enter yearly interest rate, for example 8.25:");

    // Convert string to double
    double annualInterestRate =
    Double.parseDouble(annualIntrestRateString);

    // Enter loan amount
    String loanString = JOptionPane.showInputDialog(
      "Enter loan amount, for example 120000.95:");

    // Convert string to double
    double loanAmount =  Double.parseDouble(loanString);

    System.out.println("Years\tFuture Value");

    for (int i = 1; i <= 30; i++) {
      double futureValue =
      futureInvestmentValue(loanAmount, annualInterestRate / 1200, i);
      System.out.println("" + i + "\t" + (int)(futureValue * 100) / 100.0);
    }
  }

  public static double futureInvestmentValue(double investmentAmount,
      double monthlyInterestRate, int numOfYears) {
    return investmentAmount * Math.pow(1 + monthlyInterestRate,
    numOfYears * 12);
  }
}
