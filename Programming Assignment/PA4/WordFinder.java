// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA4
// Spring 2019

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFinder{
    /**
     * The main function of PA4. When user provides the anagram dictionary, it will check whether the dictionary exists or not.
     * If yes, it will uses the dictionary provided by user. If not, the program will exit and return a file not found error.
     * If user does not provide any anagram dictionary, it will use the default dictionary: sowpods.txt
     * Then, the program will promote user to enter the rack string. Then, it will print the rank of all substring of input rack string.
     */
    public static void main(String[] args){
        // Default dictionary to be sowpods.txt
        String dictionary = "sowpods.txt";
        if(args.length > 0) dictionary = args[0];
        // Set anagramDictionary
        AnagramDictionary anagramDictionary = null;
        try{
            anagramDictionary = new AnagramDictionary(dictionary);
        } catch(FileNotFoundException e){
            System.out.println(dictionary+" does not exist");
        }
        Scanner sc = new Scanner(System.in);        // new scanner
        String input = ""; // input rack
        System.out.println("Type . to quit.");
        System.out.print("Rack?");
        while(sc.hasNext()){
            input = sc.next();
            if(input.equals(".")) return;
            ScoreTable st = new ScoreTable();
            st.scoreTablePrint(input, anagramDictionary);
            System.out.print("Rack?");
        }
    }
}