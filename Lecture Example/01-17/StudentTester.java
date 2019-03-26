// test the Student class

public class StudentTester {
   public static void main(String[] args) {

      // test that one-arg constructor correctly creates student
      Student stud1 = new Student("Joe");
      System.out.print("Student name and total score: ");
      System.out.println(stud1.getName() + " " + stud1.getTotalScore());

      // test that default constructor correctly creates student
      Student stud2 = new Student();
      System.out.print("Second student name and total score: ");
      System.out.println(stud2.getName() + " " + stud2.getTotalScore());

      // test adding one quiz score
      System.out.println("Adding 10 to " + stud1.getName() + "'s total score");
      stud1.addQuiz(10);
      System.out.println("Expected results for total: 10");
      System.out.print("Student name and total score: ");
      System.out.println(stud1.getName() + " " + stud1.getTotalScore());

      // test adding multiple quiz scores
      stud1.addQuiz(8);
      stud1.addQuiz(9);
      stud1.addQuiz(7);
      stud1.addQuiz(10);
      System.out.println("Adding some more quiz scores to " +
                         stud1.getName() + "'s score");
      System.out.println("Expected results for total: 44");
      System.out.print("Student name and total score: ");	
      System.out.println(stud1.getName() + " " + stud1.getTotalScore());
   }
}
