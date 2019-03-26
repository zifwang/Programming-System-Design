import java.util.Scanner;
import java.util.GregorianCalendar;

/**
   Compute time to wake up from a nap
*/
public class NapCalc {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      // sets nap to the current time
      GregorianCalendar nap = new GregorianCalendar(); 

      System.out.print("How long of a nap do you want to take (min)? ");
      int elapsedMin = in.nextInt();
      
      while (elapsedMin < 0) {
         System.out.println("ERROR: time must be non-negative");
         System.out.print("How long of a nap do you want to take (min)? ");
         elapsedMin = in.nextInt();   
      }
	
      nap.add(GregorianCalendar.MINUTE, elapsedMin);

      System.out.print("You will have to wake up at ");
      System.out.print(nap.get(GregorianCalendar.HOUR) + ":");
      System.out.println(nap.get(GregorianCalendar.MINUTE));
   }
}
