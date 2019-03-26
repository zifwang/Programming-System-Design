// TestReadLine: what happens when we combine next/nextInt, etc. with
// nextLine?
// -- Does nextLine read the next line of input, or the rest of the current
// line of input?


import java.util.Scanner;

public class TestReadLine {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      System.out.print("Please enter your age: ");
      int age = in.nextInt();
       
      in.nextLine();

      System.out.print("Please enter your whole name: ");
      String name = in.nextLine();

      System.out.println("You are awesome, " + name + "!");
      System.out.println("And so young.  Only " + age + "!");

   }
}
