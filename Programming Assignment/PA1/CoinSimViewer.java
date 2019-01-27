// Author: Zifan Wang
// ID: 9505587296
// CSCI455

/**
 * This class is the main function
 * Contains the main method. 
 * Prompts for the number of trials, 
 * and creates the JFrame containing the CoinSimComponent.
 */

import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer
{
    // private static void display_helper(CoinTossSimulator coinToss){
    //     System.out.print("Total number of trials: ");
    //     System.out.println(coinToss.getNumTrials());
    //     System.out.print("Two-head tosses: ");
    //     System.out.println(coinToss.getTwoHeads());
    //     System.out.print("Two-tail tosses: ");
    //     System.out.println(coinToss.getTwoTails());
    //     System.out.print("One-head one-tail tosses: ");
    //     System.out.println(coinToss.getHeadTails());
    //     String correction;
    //     if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
    //         correction = "True";
    //     }else{
    //         correction = "False";
    //     }
    //     System.out.print("Tosses add up correctly? ");
    //     System.out.println(correction);
    //     System.out.println();
    // }
    public static void main(String[] args)
    {
        /**
         * Define import variable here
         */
        Scanner sc = new Scanner(System.in);                        // User input 
        int i = 0;                                                  // number of trails 
        // CoinTossSimulator coinToss = new CoinTossSimulator();       // Coin toss simulator
        boolean isLastTrail = false;                                // The boolean use to detect whether is the last trail.
        String moreTrails;                                          // yes or no

        // Promote user input
        System.out.print("Enter number of trails: ");
        i = sc.nextInt();
        while(i <= 0){
                    System.out.println("ERROR: Number entered must be greater than 0.");
                    System.out.print("Enter number of trails: ");
                    i = sc.nextInt();
        }
        // while(!isLastTrail){
        //     System.out.print("Enter number of trails: ");
        //     i = sc.nextInt();
            
        //     // Case to check whether input is correct
        //     while(i <= 0){
        //         System.out.println("ERROR: Number entered must be greater than 0.");
        //         System.out.print("Enter number of trails: ");
        //         i = sc.nextInt();
        //     }
            
        //     // coinToss.run(i);
        //     // display_helper(coinToss);

        //     sc.nextLine();

        //     // Promote more trails 
        //     System.out.print("Do you want to add more trails [yes or no]: ");
        //     moreTrails = sc.next();
        //     // boolean isYesNo = false;
        //     // if(moreTrails.equals("yes")){
        //     //     isYesNo = true;
        //     // }
        //     // if(moreTrails.equals("yes")){
        //     //     isYesNo = true;
        //     // }
        //     // while(!isYesNo){
        //     //     System.out.println("ERROR: please enter yes or no.");
        //     //     System.out.print("Do you want to add more trails [yes or no]: ");
        //     //     moreTrails = sc.next();
        //     //     if(moreTrails.equals("yes")){
        //     //         isYesNo = true;
        //     //     }
        //     //     if(moreTrails.equals("yes")){
        //     //         isYesNo = true;
        //     //     }
        //     // }
        //     if(moreTrails.equals("yes")){
        //         isLastTrail = false;
        //     }
        //     else{
        //         isLastTrail = true;
        //     }
        // }


        // Summary graph display
        JFrame frame = new JFrame();     // Create a new window to hold graph

        frame.setSize(800,500);              // Height 400 pixels, width 300 pixels;
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        // Get windows size;
        CoinSimComponent component = new CoinSimComponent(i,frame.getBounds().width,frame.getBounds().height);
        frame.add(component);
        

        frame.setVisible(true);


    }
}