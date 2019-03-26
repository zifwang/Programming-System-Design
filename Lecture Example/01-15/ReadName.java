// ReadName: practice with reading and writing
import java.util.Scanner;
// Warning: this version has a mistake

public class ReadName {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      System.out.print("Please enter your first name: ");
      String name = in.next();

      System.out.print("Please enter your age: ");
      int age = in.nextInt();

      System.out.println("You are awesome, " + name + "!");
      System.out.println("And so young.  Only " + age + "!");

   }
}
