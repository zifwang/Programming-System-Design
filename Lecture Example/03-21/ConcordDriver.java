import java.util.Scanner;

/**
 * Finds frequency of each word in a file.
 * A "word" in this case is just seq of non whitespace characters, 
 *        e.g., "Won't!!!"
 *
 */

public class ConcordDriver {

   public static void main(String[] args) {

      Concord concord = new Concord();
		
      Scanner in = new Scanner(System.in);
		
      concord.addData(in);
		
      /*
       	concord.print(System.out);
      */

      System.out.println("DEBUG:");
      System.out.println(concord);   // using toString
   }

}
