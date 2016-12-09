public class Exercise3_15 {
  public static void main(String[] args) {
    // Generate a lottery
    int lottery = (int)(Math.random() * 1000);

    // Prompt the user to enter a guess
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter your lottery pick (three digits): ");
    int guess = input.nextInt();

    // Get digits
    int lottery1 = lottery / 100;
    int lottery2 = (lottery % 100) / 10;
    int lottery3 = lottery % 10;

    int guess1 = guess / 100;
    int guess2 = (guess % 100) / 10;
    int guess3 = guess % 10;

    System.out.println("Lottery is " + lottery);
    
    // Check the guess
    if (guess == lottery)
      System.out.println("Exact match: you win $10,000");
    else if (guess1 == lottery1 && guess3 == lottery2 && guess2 == lottery3 ||
        guess2 == lottery1 && guess1 == lottery2 && guess3 == lottery3 ||
        guess2 == lottery1 && guess3 == lottery2 && guess1 == lottery3 ||
        guess3 == lottery1 && guess1 == lottery2 && guess2 == lottery3 ||
        guess3 == lottery1 && guess2 == lottery2 && guess1 == lottery3)
      System.out.println("Match all digits: you win $3,000");
    else if (guess1 == lottery1 || guess1 == lottery2 || guess1 == lottery3 ||
        guess2 == lottery1 || guess2 == lottery2 || guess2 == lottery3 ||
        guess3 == lottery1 || guess3 == lottery2 || guess3 == lottery3)
      System.out.println("Match one digit: you win $1,000");
    else
      System.out.println("Sorry, no match");
  }
}
