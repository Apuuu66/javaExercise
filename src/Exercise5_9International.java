public class Exercise5_9International {
	public static void main(String[] args) {
		System.out.println("Miles\t\tKilometers\t|\tKilometers\tMiles");
		System.out.println("---------------------------------------------");

		double mile = 1; double kilometer = 20;
		for (int i = 1; i <= 10; mile++, kilometer+=5, i++) {
			System.out.println(mile + "\t\t" + mileToKilometer(mile) + "\t|\t" + kilometer + "\t\t" + kilometerToMile(kilometer));
		}
	}

	/* Converts from miles to kilokilometers */
	static double mileToKilometer(double mile) {
		return mile * (1 / 1.609);
	}

	/* Converts from kilokilometers to mile */
	static double kilometerToMile(double kilometer) {
		return 1.609 * kilometer;
	}
}
