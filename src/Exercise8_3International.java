
public class Exercise8_3International {

}

class FixedInvestment {
  private double depositAmount = 1000;
  private double annualInterestRate = 5.0;
  private int numberOfYears = 1;

  /** No-arg constructor */
  public FixedInvestment() {
  }

  public FixedInvestment(double depositAmount,
      double annualInterestRate, int numberOfYears) {
    this.depositAmount = depositAmount;
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;    
  }

  public double getDepositAmount() {
    return depositAmount;
  }
  
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public double getNumberOfYears() {
    return numberOfYears;
  }

  public double getTotalReturn() {
    return numberOfYears;
  }

  /** Override the toString method */
  public String toString() {
    return "deposit amount: " + depositAmount + "\n" +
      "annualInterestRate: " + annualInterestRate + "\n" +
      "numberOfYears: " + numberOfYears;
  }
}