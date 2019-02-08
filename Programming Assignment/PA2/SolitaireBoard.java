// Name:
// USC NetID:
// CSCI455 PA2
// Spring 2019

import java.util.ArrayList;
import java.util.Random;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
   * Invariant:
   * 1. number of card in each empty pile should be == 0 and stored in position >= numElement and < NUM_FINAL_PILES
   * 2. number of elemments in the array should be 0 < num of piles <= NUM_FINAL_PILES
   * 3. number of cards in each non-empty pile should be > 0 <= 45
   * 4. sum of elements in the array should be == CARD_TOTAL
   */
   
   // <add instance variables here>
   private int[] numberArray;
   private int numberOfElements;
 
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
      This function is never used in the program
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      // Init. numberArray
      numberArray = new int[CARD_TOTAL];
      // Init. number of elements will in the numberArray
      numberOfElements = piles.size();
      
      // Init. numberArray
      for(int i = 0; i < piles.size(); i++){
         numberArray[i] = piles.get(i);
      }
   
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
 
   /**
    * This function is used to set up SolitaireBoard 
    * @param piles: input user enter SolitaireBoard
   */
   public void initSolitaireBoard(ArrayList<Integer> piles){
      // Init. numberArray
      numberArray = new int[CARD_TOTAL];
      // Init. number of elements will in the numberArray
      numberOfElements = piles.size();

      // Init. numberArray
      for(int i = 0; i < piles.size(); i++){
         numberArray[i] = piles.get(i);
      }

      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }

   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      // Init. numberArray
      numberArray = new int[CARD_TOTAL];
      // Random number init. 
      Random random = new Random();     
      // Init. remain number of cards can be used to card_total <- keep track
      int numRemain = CARD_TOTAL;
      // Init. a tracking number
      int i = 0;

      while(numRemain != 0){
         int num = random.nextInt(numRemain)+1;
         numRemain = numRemain - num;
         numberArray[i] = num;
         i++;
      }

      // Init. numberofElements
      numberOfElements = i;

      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {
      // Add element in the numberOfElements - 1 position and numberOfElements++;
      numberArray[numberOfElements] = numberOfElements+1;
      numberOfElements = numberOfElements + 1;
      int tmp = numberOfElements;
      // update array
      int j = 0;
      for(int i = 0; i < tmp; i++){
         if(numberArray[j] > 1){
            // if ith term > 1, numberArray[i] = numberArray[i] - 1;
            numberArray[j] = numberArray[j] - 1;
            j++;
         }else{
            if(j == numberOfElements){
               break;
            }
            // if ith term = 1, numberArray[i] = the last element in the array -1;
            int numm = numberArray[numberOfElements-1];
            numberArray[j] = numm - 1;
            
            if(numberArray[j] > 0){
               j++;
            }
            
            if(numberArray[j] == -1){
               numberArray[j] = 0;
               numberOfElements = numberOfElements - 1;
               break;
            }

            numberArray[numberOfElements-1] = 0;
            // Update numberOfElements
            numberOfElements = numberOfElements - 1;
         }


      }

      // System.out.println(configString());
      // helper();
      // Check is playround valid
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }

   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
   */
   
   public boolean isDone() {
      if(numberOfElements != NUM_FINAL_PILES){
         return false;
      }
      boolean[] numberChecker = new boolean[numberOfElements];
      for(int i = 0; i < numberOfElements; i++){
         if(numberArray[i] > NUM_FINAL_PILES || numberChecker[numberArray[i]-1] == true){
            // Check if numberArray[i] > NUM_FINAL_PILES and numberArray[i] is already shown
            return false;
         }
         numberChecker[numberArray[i]-1] = true;
      }
      return true;  // dummy code to get stub to compile
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {

      String string = "";
      for(int i = 0; i < numberOfElements; i++){
         string = string + numberArray[i] + " ";
      }

      return string;  
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      int sum = 0;
      for(int i = 0; i < numberOfElements; i++){
         // Check number of cards in each non-empty pile should be > 0 <= 45
         if(numberArray[i] <= 0 || numberArray[i] > 45){
            System.out.println("Error: numberArray[" + i + "] == 0"  );
            return false;
         }
         sum = sum + numberArray[i];
      }
      // Check sum: sum of elements in the array should be == CARD_TOTAL
      if(sum != CARD_TOTAL){
         System.out.println("Error: sum != " + CARD_TOTAL);
         return false;
      }
      // Check number of elemments in the array should be 0 < num of piles <= CARD_TOTAL
      if(numberOfElements <= 0 || numberOfElements > CARD_TOTAL){
         System.out.println("Error: numberofElements wrong");
         return false;
      }
      // Check number of card in each empty pile should be == 0 and stored in position >= numElement and < NUM_FINAL_PILES
      for(int i = numberOfElements; i < numberArray.length; i++){
         if(numberArray[i] != 0){
            System.out.println("Error: numberArray[" + i + "] != 0" );
            return false;
         }
      }

      return true;  // dummy code to get stub to compile

   }
   

   // <add any additional private methods here>
   // helper function used to debug.
   private void helper(){
      String string = "";
      for(int i = 0; i < numberArray.length; i++){
         string = string + numberArray[i] + " ";
      }
      System.out.println(string);
   }


}
