/**
 * Here we're going to write a little test program to test out the technique. 
 * Call this program ReadTester.java. 
 * Structure it as an infinite loop (so you'll have to exit the program with ctrl-c). 
 * For each loop iteration, print a prompt for the user, and then read all the data from the line into an ArrayList, 
 * and then print out the whole ArrayList. 
 * Running it might look something like this (user input shown in bold):
 *  Enter a space separated list of numbers: 1 3 5
 *  The numbers were: [1, 3, 5]
 *  Enter a space separated list of numbers: 
 *  The numbers were: []
 *  Enter a space separated list of numbers:  
 *  The numbers were: [7]
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester{
    public static void main(String[] args){
        ArrayList<Integer> myArrList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter a space separated list of numbers: ");
            String string = "";
            if(sc.hasNextLine()){
                string = sc.nextLine();
            }

            Scanner in = new Scanner(string);

            while(in.hasNextInt()){
                myArrList.add(in.nextInt());
            }
            
            System.out.println(myArrList);
            myArrList.clear(); // clear arraylist
        }
    }
}