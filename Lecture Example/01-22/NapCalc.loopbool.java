import java.util.Scanner;
import java.util.GregorianCalendar;

/**
   Compute time to wake up from a nap
   Version showing boolean variable solution to loop-and-a-half problem.
   See Section 6.5 and Special topic 6.3 in text for more information.

   NOTE: This code will not compile unless the file name is changed to
   match the class name (for lecture we have a different version of
   the code called NapCalc.java)
*/
public class NapCalc {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      // sets nap to the current time
      GregorianCalendar nap = new GregorianCalendar(); 

      int elapsedMin = 0;

      boolean validated = false;

      while (!validated) {
         System.out.print("How long of a nap do you want to take (min)? ");
         elapsedMin = in.nextInt();

         if (elapsedMin >= 0) {
            validated = true;
         }
         else {
            System.out.println("ERROR: minutes must be non-negative.");
         }

      }
	
      nap.add(GregorianCalendar.MINUTE, elapsedMin);

      System.out.print("You will have to wake up at ");
      System.out.print(nap.get(GregorianCalendar.HOUR) + ":");
      System.out.println(nap.get(GregorianCalendar.MINUTE));
   }
}
