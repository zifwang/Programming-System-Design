// Name: Zifan Wang  
// USC NetID: 9505587296
// CS 455 PA1
// Spring 2019

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator {

   private Random generator_1;
   private Random generator_2;
   private int numTrials;
   private int twoHeads;
   private int twoTails;
   private int headTail;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      generator_1 = new Random();
      generator_2 = new Random();
      numTrials = 0;
      twoHeads = 0;
      twoTails = 0;
      headTail = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      this.numTrials = this.numTrials + numTrials;
      int firstCoin = 0;
      int secondCoin = 0;
      for(int i = 1; i < numTrials+1; i++){

         firstCoin = generator_1.nextInt(2);
         secondCoin = generator_2.nextInt(2);

         if(firstCoin == 1 && secondCoin == 1){
            // Define the case: two heads
            twoHeads++;
         }
         if(firstCoin == 0 && secondCoin == 0){
            // Define the case: two tails
            twoTails++;
         }
         if(firstCoin == 1 && secondCoin == 0){
            // Define the case: one tail and one head
            headTail++;
         }
         if(firstCoin == 0 && secondCoin == 1){
            // Define the case: one tail and one head
            headTail++;
         }
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return numTrials; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      numTrials = 0;
      twoHeads = 0;
      twoTails = 0;
      headTail = 0;
   }

}
