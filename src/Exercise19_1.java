import java.io.*;
import java.util.*;

public class Exercise19_1 {
  public static void main(String[] args) throws IOException {
    Formatter output =
      new Formatter(new FileOutputStream("Exercise19_1.txt", true));

    for (int i = 0; i < 100; i++)
      output.format("%d", (int)(Math.random() * 100000));

    output.close();
  }
}
