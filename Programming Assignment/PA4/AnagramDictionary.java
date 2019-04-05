// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA4
// Spring 2019

import java.io.*;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   // private variable
   private static Map<String,ArrayList<String>> mapAnagram;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      mapAnagram = new HashMap<String,ArrayList<String>>();
      fileReader(fileName);         // read file
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
    public ArrayList<String> getAnagramsOf(String s) {
      // sort the string s to get key
      String sKey = stringSort(s);
      // Get word by provided key
      if(mapAnagram.get(sKey) != null) return new ArrayList<>(mapAnagram.get(sKey));
      // Case when no key found in the map
      return new ArrayList<String>(); 
   }
   

   /**
    * Function used to read file of given filename and store to private variable mapAnagram
    * @param filename the name of file to read from
    * @return no return value.
    */
   private void fileReader(String fileName) throws FileNotFoundException {
      File readInFile = new File(fileName);
      try(Scanner sc = new Scanner(readInFile);){
         while(sc.hasNext()){                       // test end file
            String word = sc.next();                // Read in string
            String sortedWord = stringSort(word);   // Sort string
            if (mapAnagram.containsKey(sortedWord)) {     
               mapAnagram.get(sortedWord).add(word);
            } else {
               mapAnagram.put(sortedWord,new ArrayList<String>());
               mapAnagram.get(sortedWord).add(word);
           }
         }
      }
      
   }


   /**
    * Function used to sort input word in the order of ASCII number
    * @param word: a original unsorted word string
    * @return sortedWord: a sorted word string
    */

   private String stringSort(String word){
      char[] chars = word.toCharArray();
      // Sort Input Word
      Arrays.sort(chars);
      String sortedWord = String.valueOf(chars);
      return sortedWord;
   }

   
}
