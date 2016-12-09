import java.io.*;

public class Exercise19_3 {
  /** Main method */
  public static void main(String[] args) {
    // Declare data input and output streams
    DataInputStream dis = null;

    // Read data
    int count = 0;
    try {
      // Create data input stream
      dis = new DataInputStream(new FileInputStream("Exercise19_3.dat"));
      int total = 0;
      while (dis.available() > 0) {
        int temp = dis.readInt();
        total += temp;
        count++;
        System.out.print(temp + " ");
      }

      System.out.println("\nCount is " + count);
      System.out.println("\nTotal is " + total);
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        // Close files
        if (dis != null) dis.close();
      }
      catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }
}
