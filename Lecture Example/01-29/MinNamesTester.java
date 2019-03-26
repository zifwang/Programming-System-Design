/**
   Test Names class with hard-coded data.  

   After in-class work, "Partial" version tests constructor, numNames,
   printNames, lookup and remove.
*/
public class MinNamesTester {


   public static void main(String[] args) {

      Names empty = new Names();

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

   }

}
