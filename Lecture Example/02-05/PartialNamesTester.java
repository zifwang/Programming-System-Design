/**
   Test Names class with hard-coded data.  

   After in-class work, "Partial" version tests constructor, numNames,
   printNames, lookup and remove.
*/
public class PartialNamesTester {


   public static void main(String[] args) {

      Names empty = new Names();           // TEST CONSTRUCTORS / ACCESSORS

      System.out.println("Names in empty list [exp: <empty>]: ");
      empty.printNames();
      System.out.println("Length of empty list [exp: 0]: "
                         + empty.numNames());	
      System.out.println();
      
      Names names = new Names();

      names.loadNames();
      System.out.println("Names in pre-loaded list [exp: Ann Bob Carol Don Ed]: ");
      names.printNames();
      System.out.println("Length of pre-loaded list [exp: 5]: "
                         + names.numNames());	
      System.out.println();
      
      testLookup();
      
      testRemove();

   }
   
   private static void testLookup() {
      
      Names empty = new Names();
      System.out.println("Testing lookup...");      // TEST LOOKUP
      System.out.println("on empty Names object:");
      doOneLookup(empty, "Bob", false);
      System.out.println();
      
      Names names = new Names();
      names.loadNames();
      System.out.println("on ABCDE object:");
      doOneLookup(names, "Anne", true);
      doOneLookup(names, "", false);
      doOneLookup(names, "Sam", false);
      doOneLookup(names, "Ed", true);
      doOneLookup(names, "Edison", false);
      doOneLookup(names, "Carol", true);
      doOneLookup(names, "bob", false);
      System.out.println();
   }


   /**
      Calls lookup and prints results.
   */
   private static void doOneLookup(Names names, String target, boolean expectedResult) {
      System.out.print("Is " + target + " in the list? . . . ");
      if (names.lookup(target) != expectedResult) {
         System.out.println("FAILED: expected lookup to return " + expectedResult);
      }
      else {
         System.out.println(expectedResult);
      }
   }
   
   
   private static void testRemove() {

      System.out.println("Testing remove method...");

      System.out.println("Testing on empty list: ");
      doOneRemove(new Names(), "Scotty", "<empty>", 0);
      
      Names names = new Names();
      names.loadNames();       // uses the hardcoded names

      System.out.println("Testing on non-empty list: ");
      System.out.println("Original list: ");
      names.printNames();

      doOneRemove(names, "Anne", "Bob Carol Don Ed", 4);
      doOneRemove(names, "Anne", "Bob Carol Don Ed", 4);
      doOneRemove(names, "Weitong", "Bob Carol Don Ed", 4);
      doOneRemove(names, "Ed", "Bob Carol Don", 3);
      doOneRemove(names, "Ed", "Bob Carol Don", 3);
      doOneRemove(names, "Carol", "Bob Don", 2);
      doOneRemove(names, "Bob", "Don", 1);
      doOneRemove(names, "Don", "<empty>", 0);
      doOneRemove(names, "Zhou", "<empty>", 0);

      System.out.println();

   }


   public static void doOneRemove(Names names, 
                                  String goner, 
                                  String expectedResult,
                                  int expectedSize) {
      System.out.println("Attempt remove: " + goner);

      boolean removed = names.remove(goner);

      if (!removed) {
         System.out.println(goner + " was not present");
      }

      System.out.println("Names in list [exp: " + expectedResult + "]: ");
      names.printNames();
      System.out.println("Number of names in list [exp: "
                         + expectedSize + "]: " +
                         names.numNames());	
   }






}
