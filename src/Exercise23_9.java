import java.io.*;

public class Exercise23_9 {
  public static void main(String[] args) throws Exception {
    DataInputStream input =
      new DataInputStream(new BufferedInputStream(
      new FileInputStream("Exercise23_8.dat")));

    input.skip(input.available() - 8 * 100);
    while (input.available() > 0) {
      System.out.println(input.readLong() + " ");
    }

    input.close();
  }
}
