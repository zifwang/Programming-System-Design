/**
   Test Person toString method

   Also check if we can use the Person object wherever a String is
   expected, and whether toString will automatcially get called:

   the answer is sometimes -- see below.

*/


public class ToStringTester {


   public static void main(String[] args) {

      Person me = new Person("Claire", 3, 27, 92);

      Person you = new Person("Joe", 7, 27, 95);

      System.out.println("Me: " + me);
      System.out.println();

      // yes -- CAN put object in a println statement (without +)
      System.out.println(me);


      // but CANNOT put it just *anywhere* a string is required
      // the following 2 lines do not compile;

      // String meString = me;   // can't assign to a String
      // test(me);               // can't pass Person --> String


      // but ok once you use append operation
      String bigString = "" + me;
      test(bigString);

      System.out.println("You: " + you);
      System.out.println();

   }

   // pass a string as a param
   public static void test(String arg) {
      System.out.println(arg);
   }

}
