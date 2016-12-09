import javax.swing.JOptionPane;
import java.util.*;

public class Exercise22_11 {
  public static void main(String[] args) {
    String[][] statecapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Maryland", "Annapolis"},
      {"Minnesota", "Saint Paul"},
      {"Iowa", "Des Moines"},
      {"Maine", "Augusta"},
      {"Kentucky", "Frankfort"},
      {"Indiana", "Indianapolis"},
      {"Kansas", "Topeka"},
      {"Louisiana", "Baton Rouge"},
      {"Oregon", "Salem"},
      {"Oklahoma", "Oklahoma City"},
      {"Ohio", "Columbus"},
      {"North Dakota", "Bismark"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"New Jersey", "Trenton"},
      {"New Hampshire", "Concord"},
      {"Nevada", "Carson City"},
      {"Nebraska", "Lincoln"},
      {"Montana", "Helena"},
      {"Missouri", "Jefferson City"},
      {"Mississippi", "Jackson"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Pennslyvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };

    List list = Arrays.asList(statecapital);
    Collections.shuffle(list);

    int correctCount = 0;

    for (int i = 0; i < list.size(); i++) {
      // Prompt the user with a question
      String capital =
        JOptionPane.showInputDialog("What is the capital of " +
          ((String[])(list.get(i)))[0] + "?");

      if (capital.equals(((String[])(list.get(i)))[1])) {
        JOptionPane.showMessageDialog(null, "Your anwswer is correct");
        correctCount++;
      }
      else
        JOptionPane.showMessageDialog(null,
          "The correct answer should be " + ((String[])(list.get(i)))[1]);
    }

    JOptionPane.showMessageDialog(null,
      "The correct count is " + correctCount);
  }
}
