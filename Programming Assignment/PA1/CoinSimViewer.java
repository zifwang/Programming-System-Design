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
    public static void main(String[] args)
    {
        /**
         * Define import variable here
         */
        Scanner sc = new Scanner(System.in);                        // User input 
        int i = 0;                                                  // number of trails 

        // Promote user input
        System.out.print("Enter number of trails: ");
        i = sc.nextInt();
        while(i <= 0){
                    System.out.println("ERROR: Number entered must be greater than 0.");
                    System.out.print("Enter number of trails: ");
                    i = sc.nextInt();
        }

        // Summary graph display
        JFrame frame = new JFrame();     // Create a new window to hold graph

        frame.setSize(800,500);              // Height 500 pixels, width 800 pixels;
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Get windows size;
        CoinSimComponent component = new CoinSimComponent(i);
        frame.add(component);

        frame.setVisible(true);


    }
}