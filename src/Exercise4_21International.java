import javax.swing.JOptionPane;

public class Exercise4_21International {
	// Main method
	public static void main(String[] args) {
		int numOfYears;
		double loanAmount;

		// Enter number of years
		String numOfYearsString = JOptionPane.showInputDialog(
			"Enter number of years as an integer, \nfor example 5:");

		// Convert string to int
		numOfYears = Integer.parseInt(numOfYearsString);

		// Enter loan amount
		String loanString = JOptionPane.showInputDialog(
			"Enter loan amount, for example 120000.95:");

		// Convert string to double
		loanAmount =  Double.parseDouble(loanString);

		// Display the header
		System.out.print("Interest Rate");
		System.out.print("\t" + "Monthly Payment");
		System.out.println("\t\t" + "Total Payment");

		double monthlyInterestRate;
		double monthlyPayment;
		double totalPayment;

		for (double annualInterestRate = 3.5; annualInterestRate <= 8.0;
			annualInterestRate += 1.0 / 4) {
			// Obtain monthly interest rate
			monthlyInterestRate = annualInterestRate / 1200;

			// Compute mortgage
			monthlyPayment = loanAmount*monthlyInterestRate/
				(1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
			totalPayment = monthlyPayment * numOfYears * 12;

			// Display results
			System.out.print(annualInterestRate + "%");
			System.out.print("\t\t" + (int)(monthlyPayment * 100) / 100.0);
			System.out.println("\t\t\t" + (int)(totalPayment * 100) / 100.0);
		}
	}
}
