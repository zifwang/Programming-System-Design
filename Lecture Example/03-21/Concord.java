/**
 *  Concord class
 *     a concordance built from Scanner data
 *
 *  Used in CS 455 lecture.
 *
 */

import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;


public class Concord {
	
   Map<String, Integer> concordMap;
	
    /**
     * Creates empty concordance
     */
    public Concord() {
       concordMap = new HashMap<>();
    }
	
    /**
     * Add data from Scanner to concordance.
     * @param in data to scan.  "in" will be at the end of its data after this
     * operation.
     */
    public void addData(Scanner in) {
       while (in.hasNext()) {
          String word = in.next();
          Integer numOccur = concordMap.get(word); 
          if (numOccur == null) {
             concordMap.put(word, 1);
          }
          else {
             concordMap.put(word, numOccur + 1);
          }                 
       }     	
    }
	

    public String toString() {
	   return concordMap.toString(); // dummy return statement 
    }
	

    /**
     * Write concordance data to out.
     * Format is one entry per line: word number
     * where "number" is the number of occurrrences of that word.
     * @param out where to write the results.
     */
    public void print(PrintStream out) {

    }

}
