// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA4
// Spring 2019
/**
 * This class has information about how much each scrabble letter is worth. 
 * This class has information about Scrabble scores for scrabble letters and words. 
 * In scrabble not every letter has the same value. 
 * Letters that occur more often in the English language are worth less and letters that occur less often are worth more.
 * This class should work for both upper and lower case versions of the letters, e.g., 'a' and 'A' will have the same score.
 */
import java.io.*;
import java.util.*;

public class ScoreTable {
    // Private Variable here
    private static final int NUM_LETTERS = 26;
    // private String string;
    // private AnagramDictionary anagramDictionary;
    // private Map<Integer,String> scoreMap;
    // private int[] scoreTable; 

    /**
     * Constructor of score table
     * @param string input string need to calculate score table
     * @param anagramDictionary anagram dictionary
     */
    public void scoreTablePrint(String string, AnagramDictionary anagramDictionary){
        int[] scoreTable = creatScoreTable();     // Create score table
        Map<String,Integer> scoreMap = new HashMap<String,Integer>(); // score map

        // Create a reack
        Rack rack = new Rack();
        //get all the subsets of unique
        ArrayList<String> subUniques = rack.findAllSubsets(string);

        // if anagramMap has this anagram put into scoreMap
        for(String subUnique : subUniques){
            ArrayList<String> anagramList = anagramDictionary.getAnagramsOf(subUnique);
            for(int i = 0; i < anagramList.size(); i++){
                int score = getScore(anagramList.get(i),scoreTable);
                scoreMap.put(anagramList.get(i), score);
            }
        }

        // Sort the map
        // Set up a comparator
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry1.getValue() == entry2.getValue()) {
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                return entry2.getValue() - entry1.getValue();
            }
        };
        // set up a ArrayList contains map.entry()
        ArrayList<Map.Entry<String, Integer>> sortedArray = new ArrayList<Map.Entry<String, Integer>>();
        for(Map.Entry<String,Integer> entry : scoreMap.entrySet()){
            sortedArray.add(entry);
        }
        Collections.sort(sortedArray, comparator);

        // Print in order of occurance
        System.out.println("we can make " + sortedArray.size()+" words from " + "\""+string+"\"");
        if(sortedArray.size() > 0) {
            System.out.println("All of the words with their scores (sorted by score):");
            for(Map.Entry<String,Integer> entry : sortedArray){
                System.out.println(entry.getValue() + ": " + entry.getKey());
            } 
        }
    }


    /**
     * Get score of each string
     * @param string input string
     * @param scoreTable table of each letter
     * @return total score of input string
     */
    private int getScore(String string, int[] scoreTable){
        int score = 0;
        for (Character c : string.toCharArray()){
            c = Character.toLowerCase(c);
            int charNumber = getCharNum(c);
            score += scoreTable[charNumber];
        }
        return score;
    }
    


    // Private functions:
    /**
     * Function to create a score table
     * Here is the score of each letter:
       (1 point)-A, E, I, O, U, L, N, S, T, R
       (2 points)-D, G
       (3 points)-B, C, M, P
       (4 points)-F, H, V, W, Y
       (5 points)-K
       (8 points)- J, X
       (10 points)-Q, Z
     */
    private int[] creatScoreTable(){
        int[] scoreTable = new int[NUM_LETTERS];
        scoreTable[getCharNum('a')] = 1;
        scoreTable[getCharNum('b')] = 3;
        scoreTable[getCharNum('c')] = 3;
        scoreTable[getCharNum('d')] = 2;
        scoreTable[getCharNum('e')] = 1;
        scoreTable[getCharNum('f')] = 4;
        scoreTable[getCharNum('g')] = 2;
        scoreTable[getCharNum('h')] = 4;
        scoreTable[getCharNum('i')] = 1;
        scoreTable[getCharNum('j')] = 8;
        scoreTable[getCharNum('k')] = 5;
        scoreTable[getCharNum('l')] = 1;
        scoreTable[getCharNum('m')] = 3;
        scoreTable[getCharNum('n')] = 1;
        scoreTable[getCharNum('o')] = 1;
        scoreTable[getCharNum('p')] = 3;
        scoreTable[getCharNum('q')] = 10;
        scoreTable[getCharNum('r')] = 1;
        scoreTable[getCharNum('s')] = 1;
        scoreTable[getCharNum('t')] = 1;
        scoreTable[getCharNum('u')] = 1;
        scoreTable[getCharNum('v')] = 4;
        scoreTable[getCharNum('w')] = 4;
        scoreTable[getCharNum('x')] = 8;
        scoreTable[getCharNum('y')] = 4;
        scoreTable[getCharNum('z')] = 10;
        return scoreTable;
    }

    /**
     * Index an array with a char that is a letter by treating it as an int and subtracting 'a' from it. 
     * E.g., If your letter is 'd', ('d' - 'a') = 3 and if it's 'e', ('e' - 'a') = 4.
      @param c character
      @return c-'a' difference between c and 'a'
     */
    private int getCharNum(char c){
        return c-'a';
    }


}