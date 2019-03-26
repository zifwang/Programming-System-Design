/**
   Student class supports the following methods:

   Student stud = new Student("Joe");  // has name "Joe" and total of 0
   Student blank = new Student();     // has empty name and total of 0
   
   String name = stud.getName();

   int total = stud.getTotalScore();

   stud.addQuiz(score);    // adds quiz score to the total for this student
                                 
*/
public class Student {

   private String theName;
   private int totalScore;

   // Creates a student with given name and score of 0
   public Student(String name) {
      theName = name;
      totalScore = 0;
   }

   // Creates a student with an empty name and score of 0
   public Student() {
      theName = "";
      totalScore = 0;
   }

   // get the name of the student
   public String getName() {
      return theName;
   }

   // get the student's total score
   public int getTotalScore() {
      return totalScore;
   }

   // add this quiz score to the total for the student
   public void addQuiz(int score) {
      totalScore += score;
   }

}
