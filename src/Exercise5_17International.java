public class Exercise5_17International {
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
      
    // Display the result
    System.out.println("The wind chill index is " + 
        getWindChillTemperature(celsius, speed));
  }
  
  public static double getWindChillTemperature(
      double outsideTemparature, double speed) {
    // Compute wind chill index
    double windChillIndex = 13.12 + 0.6215 * outsideTemparature 
      - 11.37 * Math.pow(speed, 0.16) + 
      0.3965 * outsideTemparature * Math.pow(speed, 0.16);
    
    return windChillIndex;
  }
}
