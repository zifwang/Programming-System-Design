/**
   Program to illustrate using Arrays.sort on an array of objects:
   First calls it to sort array using the natural ordering of the element objects 
        (requires element object type to be Comparable).
   Second calls it to sort using a different ordering 
        (ordering specified by a Comparator passed in separately).
*/

import java.util.Arrays;

public class StudentSortTester {

   public static void printArr(Student[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.println(arr[i].getName() + " " + arr[i].getScore());
      }
   }
   
   public static void main(String[] args) {

      Student stud = new Student("Joe", "Blow", 84);
      Student stud2 = new Student("Mary", "Jones", 96);
      Student stud3 = new Student("John", "Jones", 82);
      Student stud4 = new Student("Joe", "Blow", 56);

      Student[] studArr = {stud, stud2, stud3, stud4};

      System.out.println("Array before sorting: ");
      printArr(studArr);
      System.out.println();

      Arrays.sort(studArr);

      System.out.println("Array after sorting using natural ordering (i.e., s1.compareTo(s2): ");
      System.out.println("(Students should appear in increasing order by name)");
      printArr(studArr);
      System.out.println();


      // make an instance of the comparator object and pass it into the 2-arg version of Arrays.sort
      Arrays.sort(studArr, new StudentScoreComparator());

      System.out.println("Array after sorting using comparator: ");
      System.out.println("(Students should appear in dereasing order by score)");
      printArr(studArr);
      System.out.println();



   }
}
