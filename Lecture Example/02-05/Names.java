import java.util.Arrays;

/**
   Stores a list of unique names in alphabetical order.  Allows
   look-up, insert, and removal of elements in the list.
*/
public class Names {

   private final static int NOT_FOUND = -1;
   private final static int DEFAULT_CAPACITY = 3;

   private String[] namesArr;     // the capacity is namesArr.length
   private int numNames;


   /**
      Creates an empty names object
   */
   public Names() {
      namesArr = new String[DEFAULT_CAPACITY];
      numNames = 0;
   }

   /**
      Returns the number of names in the list
   */
   public int numNames() {
      return numNames;
   }

   /**
      Prints the names in alpha order, one per line
   */
   public void printNames() {
      for (int i = 0; i < numNames(); i++) {
         System.out.println(namesArr[i]);
      }
   }

   /**
      Returns true iff target is present in names
   */
   public boolean lookup(String target) {

      int loc = lookupLoc(target);
      if (loc == NOT_FOUND) {
         return false;
      }
      return true;
   }

   /**
      Removes target from names, and returns true.
      If target wasn't present in names, returns false and no change
      made to names.
   */
   public boolean remove(String target) {

      int loc = lookupLoc(target);
      
      if (loc == NOT_FOUND) { return false; }
      
      for (int i = loc + 1; i < numNames; i++) {
         namesArr[i-1] = namesArr[i];
      }
      
      
      numNames--;
      
      return true;
   }

   /**
      Inserts newName into alphabetical names list.  
      Returns false and no change is made to names if newName is already
      present.
   */
   public boolean insert(String newName) {

      return false;  // stub version

   }

   /**
      NOTE: For testing purposes only.  

      Loads some of hardcoded names into the list in alphabetical
      order, without using Names insert method.  Only works on an
      empty names object.  If it is empty before, after the operation the
      names object contains: Anne, Bob, Carol, Don, Ed
   */
   public void loadNames() {
      if (numNames() == 0) {
         add(new String("Anne"));
         add(new String("Bob"));
         add(new String("Carol"));
         add(new String("Don"));
         add(new String("Ed"));
      }
   }


   //************************************************************
   // private method section 

   // doubles the capacity of namesArr
   // all the values are the same as before
   private void growArr() {
      System.out.println("DEBUG: Called growArr");

      namesArr = Arrays.copyOf(namesArr, namesArr.length * 2);

      System.out.println("DEBUG: new capacity: " + namesArr.length);
   }


   // adds a name to the end of the array
   private void add(String newName) {
      if (numNames == namesArr.length) { // if the array is full already
         growArr();
      }

      namesArr[numNames] = newName;
      numNames++;
   }

   public int lookupLoc(String target) {

      for (int i = 0; i < numNames; i++) {
         if (namesArr[i].equals(target)) {
            return i;
         }
      }
      return NOT_FOUND;  

   }




}
