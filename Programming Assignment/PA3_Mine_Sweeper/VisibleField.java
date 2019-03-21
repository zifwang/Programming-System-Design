// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA3
// Spring 2019


/**
  VisibleField class
  This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
  user can see about the minefield), Client can call getStatus(row, col) for any square.
  It actually has data about the whole current state of the game, including  
  the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
  It also has mutators related to actions the player could do (resetGameDisplay(), cycleGuess(), uncover()),
  and changes the game state accordingly.
  
  It, along with the MineField (accessible in mineField instance variable), forms
  the Model for the game application, whereas GameBoardPanel is the View and Controller, in the MVC design pattern.
  It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from 
  outside this class via the getMineField accessor.  
 */
public class VisibleField {
   // ----------------------------------------------------------   
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method 
   // getStatus(row, col)).
   
   // Covered states (all negative values):
   public static final int COVERED = -1;        // initial value of all squares
   public static final int MINE_GUESS = -2;     // number of Yellow square displayed in the game board
   public static final int QUESTION = -3;       // number of question marks displayed in the game board

   // Uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------   
  
   // <put instance variables here>
   private MineField mineField;
   private int[][] mineFieldState;             // this is used to keep track the square states: COVERED, MINE_GUESS, QUESTION, UNCOVERED.
   private int numofGuess;                     // number of guess. When user place a Yellow Square (mine flag), numofGuess++;
   private boolean gameOverFlag;

   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.gameOverFlag = false;
      this.mineField = mineField;
      this.numofGuess = 0;
      this.mineFieldState = new int[this.mineField.numRows()][this.mineField.numCols()];  // Init. state mineField.
      for(int i = 0; i < this.mineField.numRows(); i++){
         for(int j = 0; j < this.mineField.numCols(); j++){
            mineFieldState[i][j] = COVERED;        // Init. all square is in the COVERED state.
         }
      }
   }
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying
      MineField. 
   */     
   public void resetGameDisplay() {
      mineField.resetEmpty();    // Reset mineField
      numofGuess = 0;            // Reset numMineLeft to 0 in mineField;
      // Reset mineFieldState to COVERED State;
      for(int i = 0; i < this.mineField.numRows(); i++){
         for(int j = 0; j < this.mineField.numCols(); j++){
            mineFieldState[i][j] = COVERED;        // Init. all square is in the COVERED state.
         }
      }
      gameOverFlag = false;
   }
  
   
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      return mineField;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      assert getMineField().inRange(row, col);
      return mineFieldState[row][col];
   }

   
   /**
      Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  So the value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      return getMineField().numMines()-numofGuess;       // DUMMY CODE so skeleton compiles
   }
 
   
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      assert getMineField().inRange(row,col);
      // System.out.println(mineFieldState[row][col]);
      if(mineFieldState[row][col] == COVERED) {
         mineFieldState[row][col] = MINE_GUESS;      // COVERED state to MINE_GUESS state
         numofGuess++;                               // Update number of Guess
         // printMineFieldState();
         // System.out.println();
      } 
      else if(mineFieldState[row][col] == MINE_GUESS) {
         mineFieldState[row][col] = QUESTION;         // MINE_GUESS state to QUESTION state
         numofGuess--;                                // Update number of Guess
         if(numofGuess < 0){
            numofGuess = 0;
         }
         // printMineFieldState();
         // System.out.println();
      }
      else if(mineFieldState[row][col] == QUESTION){ 
         mineFieldState[row][col] = COVERED;        // QUESTION state to COVERED state
         // printMineFieldState();
         // System.out.println();
      }
   }

   
   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      assert mineField.inRange(row,col);

      if(mineField.hasMine(row,col) == false){
         floodFill(row,col);
      }
      else{
         mineFieldState[row][col] = EXPLODED_MINE;
         gameOverFlag = true;
      }
      return !mineField.hasMine(row,col);       
   }
 
   
   /**
      Returns whether the game is over.
      (Note: This is not a mutator.)
      @return whether game over
    */
   public boolean isGameOver() {
      boolean flag = false;
      int counter = 0;
      boolean flag_all_uncover_is_true = false;
      if(!gameOverFlag){
         for(int i = 0; i < mineField.numRows(); i++){
            for(int j = 0; j < mineField.numCols(); j++){
               if(mineField.hasMine(i,j) == false && mineFieldState[i][j] >= 0){
                  counter++;
               }
            }
         }
         if(counter == (mineField.numRows()*mineField.numCols()-mineField.numMines())) flag_all_uncover_is_true = true;
      }

      if(gameOverFlag){
         for(int i = 0; i < mineField.numRows(); i++){
            for(int j = 0; j < mineField.numCols(); j++){
               // Find unLabeled mine and assign MINE;
               if(mineField.hasMine(i,j) == true && mineFieldState[i][j] != MINE_GUESS && mineFieldState[i][j] != EXPLODED_MINE) mineFieldState[i][j] = MINE;
               // Find incorrected label mine and assign INCORRECT_GUESS;
               if(mineField.hasMine(i,j) == false && mineFieldState[i][j] == MINE_GUESS) mineFieldState[i][j] = INCORRECT_GUESS;
            }
         }
         flag = true;
      }

      if(flag_all_uncover_is_true){
         for(int i = 0; i < mineField.numRows(); i++){
            for(int j = 0; j < mineField.numCols(); j++){
               // Find unLabeled mine and assign MINE;
               if(mineField.hasMine(i,j) == true) mineFieldState[i][j] = MINE_GUESS;
            }
         }
         flag = true;
      }

      return flag;     // DUMMY CODE so skeleton compiles
   }
 
   
   /**
      Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      if(mineFieldState[row][col] >= 0) return true;
      return false;
   }
   
 
   // <put private methods here>
   // Flood-fill method to open empty square as much as possible
   private void floodFill(int row, int col){
      assert mineField.inRange(row,col);
      if(row < 0 || col < 0 || row >= mineField.numRows() || col >= mineField.numRows()) return;
      // if(mineFieldState[row][col] == MINE_GUESS) return;
      // if(mineFieldState[row][col] == mineField.numAdjacentMines(row,col)) return;
      // System.out.println(row+" "+col);
      if(mineField.numAdjacentMines(row,col) != 0 && mineFieldState[row][col] == COVERED){
         mineFieldState[row][col] = mineField.numAdjacentMines(row,col);
         return;
      }
      if(mineField.numAdjacentMines(row,col) == 0 && mineFieldState[row][col] == COVERED){
         mineFieldState[row][col] = mineField.numAdjacentMines(row,col);     
         // Recursive call
         floodFill(row-1,col-1);
         floodFill(row-1,col);
         floodFill(row-1,col+1);
         floodFill(row,col-1);
         floodFill(row,col+1);
         floodFill(row+1,col-1);
         floodFill(row+1,col);
         floodFill(row+1,col+1);
         // return floodFill(row-1,col-1)+floodFill(row-1,col)+floodFill(row-1,col+1)+floodFill(row,col-1)+floodFill(row,col+1)+floodFill(row+1,col-1)+floodFill(row+1,col)+floodFill(row+1,col+1);
      }
      return;
   }

   /**
    * My Helper function to visualize the state of mineField
    */
   private void printMineFieldState(){
      for(int i = 0; i < this.mineField.numRows(); i++){
         for(int j = 0; j < this.mineField.numCols(); j++){
            System.out.print(mineFieldState[i][j] + " ");
         }
         System.out.println();
      }
   }
   
}
