// Name: Zifan Wang
// USC NetID: 9505587296
// CSCI455 PA2
// Spring 2019


/**
* BulgarianSolitaireSimulator class
* This is the main function to run the Bulgarian Solitaire Simulator:
* Bulgarian Solitaire Simulator has two modes:
*     1. no arguments mode: randomly divides cards into some numbers of piles in the random size
*     2. arguments mode: let users set up the initial config.
*        It contains two posible flags:
*        1. -u: stands for user configuration: this allows users to initialize Solitaire Board configuration
*        2. -s: stands for single step: user must press enter to play next round
* Run the Program:
*     1. no arguments mode: javac *.java
*                           java -ea BulgarianSolitaireSimulator (-ea is used to set up assert in java)
*     2. arguments mode: javac *.java
*                       1. java -ea BulgarianSolitaireSimulator -u (promote users to initialize solitaire board by themselves)
*                       2. java -ea BulgarianSolitaireSimulator -s (let users to press enter to play next round)
*                       3. java -ea BulgarianSolitaireSimulator -u -s (apply the two methods together)
* Private methods:
*  void setupSimulator(boolean userConfig, SolitaireBoard sb):  read users' initialization and set up SolitaireBoard. If userConfig is true: use user configuration mode.
*  void runGame(boolean singleStep, SolitaireBoard sb):         run the SolitaireBoard game. If singleStep is true, then use single step mode
*/
import java.util.Scanner;
import java.util.ArrayList;

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
      // main function
      boolean singleStep = false;
      boolean userConfig = false;
      
      // Set up two input flags
      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      SolitaireBoard sb = new SolitaireBoard(); //init. the empty SolitaireBoard object
      setupSimulator(userConfig, sb);     // set up. the SolitaireBoard object 
      runGame(singleStep, sb);            // Run the SolitaireBoard game.
      
   }
   
   // <aprivate static methods here>
   /**
    * This function is used to set up or init. the SolitaireBoard
    * @param userConfig: user input option. If true: prompt user to enter the array 
    * @param sb: SolitaireBoard class object
    */
   private static void setupSimulator(boolean userConfig, SolitaireBoard sb){
      if(userConfig){
         Scanner sc = new Scanner(System.in);    // Init. input Scanner
         String string = "";
         boolean isInputValid = false;
         int inputNumber = 0;
         int inputSum = 0;
         ArrayList<Integer> myArrList = new ArrayList<Integer>();       // Arraylist to store the input integersss

         System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline:");

         while(!isInputValid){
            if(sc.hasNext()){
               string = sc.nextLine();
            }
            Scanner in = new Scanner(string);

            while(in.hasNext()){
               // Check whether is digit
               if(!in.hasNextInt()){
                  isInputValid = false;
                  break;
               }

               // get input number
               inputNumber = in.nextInt(); 
            
               // Check whether the input number is between 0 to card_total
               if(inputNumber <= 0 || inputNumber > SolitaireBoard.CARD_TOTAL){
                  isInputValid = false;
                  break;
               }

               inputSum = inputSum + inputNumber;   // update inputSum
               
               myArrList.add(inputNumber);          // update myArrList
               isInputValid = true;                 // update the flag
            }
            // Check the sum whether is equal to CARD_TOTAL and the isInputValid flag.
            if(inputSum != SolitaireBoard.CARD_TOTAL || !isInputValid){
               System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL + ".");
               System.out.println("Please enter a space-separated list of positive integers followed by newline:");
               isInputValid = false;             // set flag to false
               inputSum = 0;                     // Set input sum == 0
               myArrList.clear();                // clear myArrList
            }else{
               isInputValid = true;
               sb.initSolitaireBoard(myArrList);        // Init. with user config
            }
         }
      }
   }

   /**
    * This function is used to run game
    * @param singleStep: if true, user must enter return in the keyboard to cont. the game
    * @param sb: the initialized SolitaireBoard object.
    */

   private static void runGame(boolean singleStep, SolitaireBoard sb){
      System.out.print("Initial configuration: ");
      System.out.println(sb.configString());
      int tracker = 1;

      if(singleStep){
         // the single step mode 
         Scanner sc = new Scanner(System.in);
         sb.playRound();
         System.out.print("[" + tracker + "] Current configuration: ");
         System.out.println(sb.configString());
         tracker++;
         while(!sb.isDone()){                                  // check whether the process is completed
            System.out.print("<Type return to continue>");     // promote user to hit enter to play next round
            sc.nextLine();                         
            sb.playRound();                                    // next round 
            System.out.print("[" + tracker + "] Current configuration: ");    // print out number array
            System.out.println(sb.configString());
            tracker++;
         }

      }
      else{
         // the auto-mode
         while(!sb.isDone()){
            sb.playRound();
            System.out.print("[" + tracker + "] Current configuration: ");
            System.out.println(sb.configString());
            tracker++;
         }
      }
      System.out.println("Done!");

   }

  
}
