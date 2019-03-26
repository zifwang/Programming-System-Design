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
      
      System.out.println("Testing lookup...");      // TEST LOOKUP
      System.out.println("on empty Names object:");
      doOneLookup(empty, "Bob", false);
      System.out.println();
      
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
   

   public static void testRemove() {

      Names names = new Names();
      names.loadNames();


      // first test case
      System.out.println("Attempt remove: Scotty");

      boolean removed = names.remove("Scotty");

      if (!removed) {
         System.out.println("Scotty was not present");
      }

      System.out.println("Names in list [exp: Anne Bob Carol Don Ed]: ");
      names.printNames();
      System.out.println("Number of names in list [exp: 5]: "
                         + names.numNames());	
   }


}
