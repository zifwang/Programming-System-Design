import java.util.Scanner;

/**
   Read student score data from System.in and
   compute count of how many students got each score.
   Scores are in the range 0-10.
   Called "Hard" because we're doing it a painful way.
   Do NOT implement such a program this way.

   NOTE: this code will not compile
*/

public class ScoreCountsHard {

   public static void main(String[] args) {
      int num0s = 0;
      int num1s = 0;
      int num2s = 0;

      // . . .  many more assignment statements missing here

      int num10s = 0;

      Scanner in = new Scanner(System.in);
      int score;
	
      while (in.hasNextInt()) {
         score = in.nextInt();
	    
         if (score == 0) {
            num0s++;
         }
         else if (score == 1) {
            num1s++;
         }
         else if (score == 2) {
            num2s++;
         }

         // . . .  many more else-if's missing here

         else if (score == 9) {
            num3s++;
         }

         else {
            num10s++;
         }
      }

      System.out.println(num0s + "students got a score of 0");
      System.out.println(num1s + "students got a score of 1");

      // . . .  many more printlns missing here

      System.out.println(num10s + "students got a score of 10");

   }
}
