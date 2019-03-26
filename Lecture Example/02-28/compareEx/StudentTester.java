/**
   Test program for the student class.
   Mostly tests toString, equals, and compareTo
*/

public class StudentTester {

   public static void printCompareResult(Student stud1, Student stud2) {
      int result = stud1.compareTo(stud2);
      System.out.print(stud1.getName() + " is ");
      if (result < 0) {
         System.out.print("less than");
      }
      else if (result > 0) {
         System.out.print("greater than");
      }
      else {
         System.out.print("equal to");
      }
      System.out.println(" " + stud2.getName());
   }

   public static void main(String[] args) {

      Student stud = new Student("Joe", "Blow", 84);
      Student stud2 = new Student("Mary", "Jones", 96);
      Student stud3 = new Student("John", "Jones", 82);
      Student stud4 = new Student("Joe", "Blow", 56);

      System.out.println("Student 1: " + stud);
      System.out.println("Student 2: " + stud2);
      System.out.println("Student 3: " + stud3);
      System.out.println("Student 4: " + stud4);

      System.out.println("1 = 2? " + stud.equals(stud2));
      System.out.println("2 = 3? " + stud2.equals(stud3));
      System.out.println("1 = 4? " + stud.equals(stud4));

      printCompareResult(stud, stud2);
      printCompareResult(stud2, stud);
      printCompareResult(stud, stud4);
      printCompareResult(stud2, stud3);

   }
}
