import java.io.*;

public class Exercise19_5 {
  public static void main(String[] args) throws IOException {
    ObjectOutputStream output = new ObjectOutputStream(
      new FileOutputStream("Exercise19_12.dat"));

    output.writeObject(new int[]{1, 2, 3, 4, 5});
    output.writeObject(new java.util.Date());
    output.writeDouble(5.5);

    output.close();
  }
}
