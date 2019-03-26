import java.util.Arrays;

/**
   Stores a list of unique names in alphabetical order.  Allows
   look-up, insert, and removal of elements in the list.

   Note: this class has examples of representation invariants, and 
   an isValidNames() private method to check repr. invars, that's used
   in assert statements at the end of every public method.

*/
public class Names {

   private String[] namesArr;     // the capacity is namesArr.length
   private int numNames;

   private final static int NOT_FOUND = -1;
   private final static int DEFAULT_CAPACITY = 3;

   /**
      Uses a partially-filled array representation.

      REPRESENTATION INVARIANT:
      * numNames is the number of names
      * 0 <= numNames <= namesArr.length
      * if numNames > 0, the names are in namesArr[0] through namesArr[numNames-1]
      * names are in alphabetical order (i.e., lexicographic String order)
      * names are unique
   */


   /**
      Creates an empty names object
   */
   public Names() {
      namesArr = new String[DEFAULT_CAPACITY];
      numNames = 0;

      assert isValidNames();
   }

   /**
      Returns the number of names in the list
   */
   public int numNames() {

      assert isValidNames();

      return numNames;
   }

   /**
      Returns true iff target is present in names
   */
   public boolean lookup(String target) {

      int loc = lookupLoc(target);

      assert isValidNames();

      return loc != NOT_FOUND;

   }

   /**
      Removes target from names, and returns true.
      If target wasn't present in names, returns false and no change
      made to names.
   */
   public boolean remove(String target) {
      int loc = lookupLoc(target);

      if (loc == NOT_FOUND) {
         assert isValidNames();
         return false;
      }

      for (int i = loc+1; i < numNames; i++) {
         namesArr[i-1] = namesArr[i];
      }
      numNames--;

      assert isValidNames();

      return true;

   }

   /**
      Inserts newName into alphabetical names list.  
      Returns false and no change is made to names if name is already
      present.
   */
   public boolean insert(String newName) {

      int loc = 0;

      // stop when we get to a name that is the same or greater than newName
      while ((loc < numNames) && (namesArr[loc].compareTo(newName) < 0)) {
         loc++;
      }
      // if the name is the same as newName, it's a duplicate
      if ((loc < numNames) && (namesArr[loc].compareTo(newName) == 0)) {
         assert isValidNames();
         return false; 
      }

      if (numNames == namesArr.length) {  // handle full array case
         growArr();
      }

      for (int i = numNames; i > loc; i--) { // make space for new one
         namesArr[i] = namesArr[i-1];
      }

      namesArr[loc] = newName;               // insert new one
      numNames++;

      assert isValidNames();

      return true;
   }


   /**
      Prints the names in alpha order, one per line
   */
   public void printNames() {
      for (int i = 0; i < numNames(); i++) {
         System.out.println(namesArr[i]);
      }

      assert isValidNames();
   }


   /**
      NOTE: For testing purposes only.  

      Loads some of hardcoded names into the list in alphabetical
      order, without using Names insert method.  Only works on an
      empty names object.  If it is empty before, after the operation the
      names object contains: Anne, Bob, Carol, Don, Ed

      Uses "new" to create Strings to ensure they will be distinct objects from
      any other strings they are compared with (exposes == vs. equals bugs).
   */
   public void loadNames() {
      if (numNames() == 0) {
         add(new String("Anne"));
         add(new String("Bob"));
         add(new String("Carol"));
         add(new String("Don"));
         add(new String("Ed"));
      }

      assert isValidNames();
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


   /**
      adds a name to the end of the partially-filled array, growing it if necessary
   */
   private void add(String newName) {
      if (numNames == namesArr.length) {
         growArr();
      }

      namesArr[numNames] = newName;
      numNames++;
   }


   /**
      lookupLoc returns index of target in namesArr or NOT_FOUND if it is not present
   */
   private int lookupLoc(String target) {

      int loc = 0;

      while (loc < numNames && !namesArr[loc].equals(target)) {
         loc++;
      }

      if (loc == numNames) {
         return NOT_FOUND;
      }

      return loc;
   }


   /**
      Sanity check that the object data is in a valid state according to our
      representation invariants.
   */
   private boolean isValidNames() {
      if (numNames < 0 || numNames > namesArr.length) {
         return false;
      }

      for (int i = 0; i < numNames - 1; i++) {

         if (namesArr[i] == null) {          // make sure actual String stored there
            return false;
         }
         if (namesArr[i].compareTo(namesArr[i+1])>= 0) { 
            // not alpha order, or has a duplicate
            return false;
         }
	    
      }
      // make sure there is a string in the last valid location 
      // NOTE: when numNames == 0 there is no last one
      if ((numNames > 0) && (namesArr[numNames-1] == null)) {   
         return false;           
      }
	
      return true;  // passed all the tests!

   }


}
