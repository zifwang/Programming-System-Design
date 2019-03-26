
/**
   Example of a class that is overrides toString and equals and is Comparable.

   In this example compareTo is consistent with equals 
   (i.e., returns 0 exactly when equals returns true)
   Two objects are considered equal if they have the same first and last name.

   Note: this is a different version of a Student class than the one we did in the lecture on class
   implementation (~ 3rd week of the semester).

*/

public class Student implements Comparable<Student> {

   private String firstName;
   private String lastName;
   private int score;

   public Student(String firstName, String lastName, int score) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.score = score;
   }
    
   public String toString() {
      return "Student[firstName=" + firstName
         + ",lastName=" + lastName + ",score=" + score + "]";
   }

   public int getScore() {
      return score;
   }

   public String getName() {
      return firstName + " " + lastName;
   }

   // mutator
   public void setScore(int newScore) {
      score = newScore;
   }

   public boolean equals(Object otherObject) {
      if (otherObject == null) {
         return false;
      }
      if (getClass() != otherObject.getClass()) {  // make sure the other object is the same type
         return false;                            // see special topic 9.7 in textbook
      }
      Student other = (Student) otherObject;  // have to down-cast to student
      return lastName.equals(other.lastName) && firstName.equals(other.firstName);
   }

   /**
      Returns negative value if "this" is less than b
      Returns positive value if "this" is greater than b
      otherwise returns zero.
   */
   public int compareTo(Student b) {
      int lastDiff = lastName.compareTo(b.lastName);  // uses String compareTo
      if (lastDiff != 0) {
         return lastDiff;
      }
      else {
         return firstName.compareTo(b.firstName);  // uses String compareTo
      }
   }
    
    
}
