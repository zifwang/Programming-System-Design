// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA4
// Spring 2019

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFinder{
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