// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA3
// Spring 2019

import java.util.Random;
/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   // number of rows & columns & mines this minefield will have
   private int numRows;
   private int numCols;
   private int numMines; 
   // MineField -> 2D boolean array: false -> no mine. true -> mine.
   private boolean[][] mineField;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
      numRows = mineData.length;
      numCols = mineData[0].length;
      numMines = 0;
      mineField = new boolean[mineData.length][mineData[0].length];        // Create mineField with the same size as mineData
      // Assign mineField with mineData
      for(int i = 0; i < mineData.length; i++){
         for(int j = 0; j < mineData[0].length; j++){
            mineField[i][j] = mineData[i][j];
            if(mineData[i][j] == true) numMines++;
         }
      }
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      this.numRows = numRows;       // init. number of rows in the minefield
      this.numCols = numCols;       // init. number of cols in the minefield
      this.numMines = numMines;     // inti. number of mines in the minefield
      mineField = new boolean[numRows][numCols];   // declare a mine Field
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
      assert inRange(row, col);
      resetEmpty();                       // rest the mines field.
      boolean isEnd = false;              // Set a check flag to see whether init. is ends
      Random rand = new Random();         // declare a random number to generate mines
      int x = 0;                          // Declare a x location mine
      int y = 0;                          // Declare a y location mine
      int tracker = 0;                    // track number of generated mine

      while(!isEnd){
         x = rand.nextInt(numRows);       // Random location x
         y = rand.nextInt(numCols);       // Random location y
         if(x != row || y != col){
            if(mineField[x][y] != true){
               mineField[x][y] = true;
               tracker++;
            }
         }
         if(tracker == numMines) isEnd = true;  // If tracker == totoal number of mines, ->isEnd = true;
      }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
      // for(int i = 0; i < mineField.length; i++){
      //    for(int j = 0; j < mineField[0].length; j++){
      //       mineField[i][j] = false;      // set to all false which means does not contain mines.
      //    }
      // }
      mineField = new boolean[numRows][numCols];  // create a new mineField
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      assert inRange(row, col);
      int numberofMines = 0;
      for(int i = row-1; i <= row+1; i++){
         for(int j = col-1; j <= col+1; j++){
            if(i < 0 || j < 0 || i >= numRows || j >= numCols) continue;
            if(mineField[i][j] == true){
               numberofMines++;
            }
         }
      }
      if(mineField[row][col] == true){
         numberofMines = numberofMines - 1;
      }
      // System.out.println(numberofMines);
      return numberofMines;
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      if(row >= 0 && row < numRows && col >= 0 && col < numCols){
         return true;
      }
      return false;
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return numRows;      
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return numCols;
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      assert inRange(row,col);
      return mineField[row][col];
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      // System.out.println(numMines);
      return numMines;
   }

   
   // <put private methods here>
   
         
}

