import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_35 extends JFrame {
  private HangmanPanel canvas = new HangmanPanel();

  public Exercise16_35() {
    this.add(canvas, BorderLayout.CENTER); // Add canvas to center
  }

  public static void main(String[] args) {
    JFrame frame = new Exercise16_35();
    frame.setTitle("Exercise16_35");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(450, 280);
    frame.setVisible(true);
  }

  class HangmanPanel extends JPanel {
    int ballRadius = 10;
    int leftAngle = 120;
    int rightAngle = 60;
    int angle = 90; // Start from the middle
    int angleDelta = 1; // Swing interval
    int delay = 100;

    Timer timer = new Timer(delay, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        repaint();
      }
    });

    HangmanPanel() {
      setNewHiddenWord();
      
      this.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          char letter = e.getKeyChar();
          if (letter == KeyEvent.VK_ENTER) {
            // Start a new game
            setNewHiddenWord();
          } else if (Character.isLowerCase(letter)) {
            processAGuessedLetter(letter);

            if (numberOfMisses == 7)
              timer.start();
            else
              timer.stop();
          }

          repaint();
        }
      });

      // Set focus
      setFocusable(true);
    }

    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setFont(new Font("TimesRoman", Font.BOLD, 20));
      
      if (isFinished) {
        // Display the guessed word
        g.drawString("The word is: " + guessedWord.toString(), 120,
                210);
        g.drawString("To continue the game, press ENTER", 120, 230);
      } else {
        // Display the guessed word
        g.drawString("Guess a word: " + guessedWord.toString(), 120,
            210);

        if (numberOfMisses > 0)
          g.drawString("Missed letters: " + missedLetters.toString(),
              120, 230);
      }

      g.drawArc(20, 200, 80, 40, 0, 180); // Draw the base
      g.drawLine(20 + 40, 200, 20 + 40, 20); // Draw the pole
      g.drawLine(20 + 40, 20, 20 + 40 + 100, 20); // Draw the hanger

      if (numberOfMisses == 7) {
        if (angle < rightAngle)
          angleDelta = 1; // Swing to the left
        else if (angle > leftAngle)
          angleDelta = -1; // Swing to the right

        angle += angleDelta;
      }

      if (numberOfMisses < 1)
        return;

      int x1 = 20 + 40 + 100;
      int y1 = 20;
      int radius = 20;
      int x = x1 + (int) (radius * Math.cos(Math.toRadians(angle)));
      int y = y1 + (int) (radius * Math.sin(Math.toRadians(angle)));
      g.drawLine(20 + 40 + 100, 20, x, y); // Draw the hanger

      if (numberOfMisses < 2)
        return;
      // Draw the circle
      double length = 20 + 20;
      x = x1 + (int) (length * Math.cos(Math.toRadians(angle)));
      y = y1 + (int) (length * Math.sin(Math.toRadians(angle)));
      g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius); // Draw the
      // hanger

      if (numberOfMisses < 3)
        return;
      // Draw the left arm
      length = distance(x1, y1, 20 + 40 + 100 - (int) (radius * Math.cos(Math
          .toRadians(45))), 40 + radius
          + (int) (radius * Math.sin(Math.toRadians(45))));
      double angle1 = Math.toDegrees(Math.asin(radius
          * Math.cos(Math.toRadians(45)) / length));
      int x2 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      int y2 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));

      length = (int) distance(x1, y1, 20 + 40 + 100 - 60, 40 + radius + 60);
      angle1 = Math.toDegrees(Math.asin(60 / length));
      int x3 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      int y3 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));

      g.drawLine(x2, y2, x3, y3);

      if (numberOfMisses < 4)
        return;
      // Draw the right arm
      length = distance(x1, y1, 20 + 40 + 100 + (int) (radius * Math.cos(Math
          .toRadians(45))), 40 + radius
          + (int) (radius * Math.sin(Math.toRadians(45))));
      angle1 = -Math.toDegrees(Math.asin(radius * Math.cos(Math.toRadians(45))
          / length));
      x2 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      y2 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));

      length = (int) distance(x1, y1, 20 + 40 + 100 + 60, 40 + radius + 60);
      angle1 = -Math.toDegrees(Math.asin(60 / length));
      x3 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      y3 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));

      g.drawLine(x2, y2, x3, y3);

      if (numberOfMisses < 5)
        return;
      // Draw the body
      length = 40 + 20;
      x2 = x1 + (int) (length * Math.cos(Math.toRadians(angle)));
      y2 = y1 + (int) (length * Math.sin(Math.toRadians(angle)));

      length = 40 + 20 + 60;
      x3 = x1 + (int) (length * Math.cos(Math.toRadians(angle)));
      y3 = y1 + (int) (length * Math.sin(Math.toRadians(angle)));

      g.drawLine(x2, y2, x3, y3);

      if (numberOfMisses < 6)
        return;
      // Draw the left leg
      length = distance(x1, y1, 20 + 40 + 100 - 40, 40 + radius + 80 + 40);
      angle1 = Math.toDegrees(Math.asin(40.0 / length));
      int x4 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      int y4 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));
      g.drawLine(x3, y3, x4, y4);

      if (numberOfMisses < 7)
        return;
      // Draw the right leg
      angle1 = -Math.toDegrees(Math.asin(40.0 / length));
      x4 = x1 + (int) (length * Math.cos(Math.toRadians(angle + angle1)));
      y4 = y1 + (int) (length * Math.sin(Math.toRadians(angle + angle1)));
      g.drawLine(x3, y3, x4, y4);
    }

    String[] words = { "write", "program", "that", "receive", "positive",
        "supercalifragilisticexpialidocious", "linger", "violin", "strange", "holiday", "twilight",
        "disney", "school", "teacher", "tutor", "mother", "daughter", "stupidson", "michaelisageek" };
    String hiddenWord;
    StringBuilder guessedWord = new StringBuilder();
    int numberOfCorrectLettersGuessed = 0, numberOfMisses = 0;
    StringBuilder missedLetters = new StringBuilder();
    boolean isFinished = false;

    void setNewHiddenWord() {
      angle = 90; // Start from the middle

      int index = (int) (Math.random() * words.length);
      hiddenWord = words[index];

      guessedWord.setLength(0);
      for (int i = 0; i < hiddenWord.length(); i++)
        guessedWord.append('*');

      missedLetters.setLength(0);
      numberOfCorrectLettersGuessed = 0;
      numberOfMisses = 0;
      isFinished = false;
    }

    void processAGuessedLetter(char letter) {
      if (guessedWord.indexOf(letter + "") >= 0) {
        // System.out.println("\t" + letter + " is already in the word");
      } else if (hiddenWord.indexOf(letter) < 0) {
        // System.out.println("\t" + letter + " is not in the word");

        if (missedLetters.indexOf(letter + "") < 0) {
          numberOfMisses++;
          missedLetters.append(letter);

          if (numberOfMisses == 7) {
            isFinished = true;
            guessedWord = new StringBuilder(hiddenWord);
          }
        }
      } else {
        int k = hiddenWord.indexOf(letter);
        while (k >= 0) {
          guessedWord.setCharAt(k, letter);
          numberOfCorrectLettersGuessed++;
          k = hiddenWord.indexOf(letter, k + 1);

          if (numberOfCorrectLettersGuessed == hiddenWord.length()) {
            isFinished = true;
            repaint();
          }
        }
      }
    }
  }
  
  /** Compute the distance between two points (x1, y1) and (x2, y2) */
  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }
}