import java.util.Comparator;

/**
   A class that compares two students based on their score.  Students with a higher score
   come earlier in the ordering.
*/

public class StudentScoreComparator implements Comparator<Student> {

   /**
      a comes before b in the ordering if a's score is bigger:
      Returns negative value if a's score is bigger than b's score
      Returns positive value if a's score is smaller than b's score
      otherwise returns zero.
   */
   public int compare(Student a, Student b) {
      return b.getScore() - a.getScore();
   }  
}
