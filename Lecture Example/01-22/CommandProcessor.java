import java.util.Scanner;

/**
   (Example of a multi-way test)
   Processes a sequence of commands until "quit" is entered.
   To "process" a command just echoes out the command entered,
   or gives an error message if it's an invalid command.
   A real program like this would take a different action based
   on the command entered, thus necessitating the multi-way test.

   Note: the current version of the program is incomplete.

*/
public class CommandProcessor {

   private static final String QUIT_CMD = "quit";
   private static final String ADD_CMD = "add";
   private static final String REMOVE_CMD = "remove";
   private static final String LOOKUP_CMD = "lookup";

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);


      System.out.print("Please enter command: ");
      String command = in.next();

      while (   ) {
         System.out.print("Command entered was ");
	    
         // add code to do the rest of it here
      }
   }
}
