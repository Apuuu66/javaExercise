import java.awt.*;
import javax.swing.*;

public class Exercise12_9 extends JFrame {
  public Exercise12_9() {
    int[] list = new int[54];
    for (int i = 0; i < list.length; i++)
      list[i] = i + 1;
    shuffle(list);
    
    setLayout(new GridLayout(1, 3));
    add(new JLabel(new ImageIcon("image/card/" + list[0] + ".png")));
    add(new JLabel(new ImageIcon("image/card/" + list[1] + ".png")));
    add(new JLabel(new ImageIcon("image/card/" + list[2] + ".png")));
  }

  public static void shuffle(int[] list) {
    for (int i = 0; i < list.length; i++) {
      // Generate an index randomly
      int index = (int)(Math.random() * list.length);
     
      // Swap myList[i] with myList[index]
      int temp =list[i];
      list[i] = list[index]; 
      list[index] = temp;
    }
  }
  
  public static void main(String[] args) {
    Exercise12_9 frame = new Exercise12_9();
    frame.setTitle("Exercise12_9");
    frame.setSize(300, 170);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
