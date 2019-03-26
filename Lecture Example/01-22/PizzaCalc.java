import java.util.Scanner;

/**
   Calculate how big each slice of pizza is.
   NOTE: current version has errors.
*/
public class PizzaCalc {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int diameter;
      int numSlices = 1;

      System.out.print("What is the diameter of the pizza? ");
      diameter = in.nextInt();
	
      System.out.print("How many slices of pizza are there? ");
      numSlices = in.nextInt();
	
      if (numSlices == 0) {
         System.out.print("ERROR: can't have zero slices. Setting to 1.");
         numSlices = 1;
      }

      double radius = diameter / 2.0;
      System.out.println("DEBUG: radius, numSlices: " + radius + " " + numSlices);
      System.out.print("Area of a slice is ");
      System.out.print(Math.PI * radius * radius / numSlices);
      System.out.println(" square inches.");
   }
}
