
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/

import java.util.ArrayList;
public class Nums {

   private ArrayList<Integer> intArr;               // Create a reference of integer Array

   /**
      Create an empty sequence of nums.
   */
   public Nums () {
      this.intArr = new ArrayList<Integer>();       // Create an empty integer array list
   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
      // int[] temp = new int[intArr.length+1]; // Create a temp array which size is one more than intArr
      // // Copy all the element from intArr to temp array
      // for(int i = 0; i < intArr.length; i++){
      //    temp[i] = intArr[i];
      // }
      // // Add value to the last position of temp array
      // temp[temp.length] = value;
      // // Assign intArr to the temp array
      // intArr = temp;
      intArr.add(value);      // adds a new value to the end of array
   }


   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
      if(intArr.size() > 0){
         int minValue = intArr.get(0);
         for(int i = 0; i < intArr.size(); i++){
            if(minValue >= intArr.get(i)){
               minValue = intArr.get(i);
            }
         }
         return minValue;    // stub code to get it to compile
      }
      else{
         return Integer.MAX_VALUE;
      }
   }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
      System.out.print("(");
      for(int i = 0; i < intArr.size(); i++){
         System.out.print(intArr.get(i));
         System.out.print(" ");
      }
      System.out.print(")");

   }

   /**
      Returns a new Nums object with all the values from this Nums
      object that are above the given threshold.  The values in the
      new object are in the same order as in this one.
      E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
      returns      (19 21 19)
      myNums after call:  (3 7 19 4 21 19 10)
      The method does not modify the object the method is called on.
   */
   public Nums valuesGT(int threshold) {
      Nums valueGT = new Nums();
      for(int i = 0; i < intArr.size(); i++){
         if(intArr.get(i) > threshold){
            valueGT.add(intArr.get(i));
         }
      }
      return valueGT;  // stub code to get it to compile
   }

    
}
