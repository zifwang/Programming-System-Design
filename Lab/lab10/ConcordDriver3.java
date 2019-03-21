import java.util.Scanner;
import java.util.Map;
import java.util.HashSet;

/**
 * Finds frequency of each word in a file.  
 * (Version for Exercise 3.)
 *
 * Optional command line argument is the threshold for the number of
 * letters a word must have to be printed with its number of occurrences.
 *
 * If argument isn't given, prints all words and number of occurrences.
 *
 */

public class ConcordDriver3 {


   public static void main(String[] args) {

      int threshold = 0;

      if (args.length > 0) {
         threshold = Integer.parseInt(args[0]);
      }

      Concord concord = new Concord();
		
      Scanner in = new Scanner(System.in);
		
      concord.addData(in);		
		

      // add code here to print out the selected entries
		concord.printSatisfying(System.out, new largeThreshold(threshold));
   }

}


// // add new class here
// // Test whether the lenght is less than input threshold
// class lengthTest implements Predicate{
//    private int threshold;     // instance variable

//    /**
//     * Constructor: Take in threshold input
//     */
//    public lengthTest(int threshold){
//       this.threshold = threshold;
//    }

//    /**
//     * predicate function
//     */
//    public boolean predicate(Map.Entry<String,Integer> entry){
//       String word = entry.getKey();
//       Map<String,Integer> numCharOccur = new Map<String,Integer>();
//       for(int i = 0; i < word.lenght(); i++){
//          char c = word.charAt(i);

//       }
//    }


// }

// add new class here
// Test whether the lenght is more than input threshold
class largeThreshold implements Predicate{
   private int threshold;     // instance variable

   /**
    * Constructor: Take in threshold input
    */
   public largeThreshold(int threshold){
      this.threshold = threshold;
   }

   /**
    * predicate function
    */
   public boolean predicate(Map.Entry<String,Integer> entry){
      if(entry.getKey().length() >= threshold) return true;
      return false;
   }
}