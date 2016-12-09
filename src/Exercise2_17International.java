public class Exercise2_17International {
  // Main method
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    // Enter the temperature in Celsius
    System.out.print("Enter the temperature in Celsius " + 
      "(must be between -50°C and 5°C): ");
    double celsius = input.nextDouble();

    // Enter the wind speed kilometers per hour
    System.out.print("Enter the wind speed kilometers per hour " + 
      "(must be greater than or equal to 3) : ");
    double speed = input.nextDouble();
    
    // Compute wind chill index
    double windChillIndex = 13.12 + 0.6215 * celsius - 11.37 *
      Math.pow(speed, 0.16) + 0.3965 * celsius * 
      Math.pow(speed, 0.16);
      
    // Display the result
    System.out.println("The wind chill index is " + windChillIndex);
  }
}
