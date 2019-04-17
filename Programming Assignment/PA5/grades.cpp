// Name: Zifan Wang 
// USC NetID: 9505587296
// CSCI 455 PA5
// Spring 2019

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>
#include <string.h>

using namespace std;

// print help fucntion
void printHelper();
// Function to change input command into corresponding number
int getCorrespondingNum(string command); 
// Function to run the program in one iter
void runCommand(Table* & hashTable,string command, bool & contFlag);


int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   string command;
   bool contFlag = true;
   while(contFlag){
      cout << "cmd>";
      cin >> command;
      runCommand(grades,command,contFlag);
   }


   return 0;
}



// Function to run the program in one iter
void runCommand(Table* & hashTable,string command, bool & contFlag){
   string name;
   int score;
   switch (getCorrespondingNum(command))
   {
   case 0:
      cin >> name;
      cin >> score;
      if (!cin.fail()){
         if(!hashTable->insert(name,score)){
            cout << "Insert Failed: input name was already in the table." << endl;
         }
      }else{
         cout << "Insert Failed: invalid input number." << endl;
      }
      contFlag = true;
      break;
   case 1:
      cin >> name;
      cin >> score;
      if (!cin.fail()){
         if(hashTable->lookup(name) == NULL) cout << "Change Score Failed: input name is not in the table." << endl;
         else *hashTable->lookup(name) = score;
      }
      else{
         cout << "Change Score Failed: invalid input number." << endl;
      }
      contFlag = true;
      break;
   case 2:
      cin >> name;
      if(hashTable->lookup(name) == NULL) cout << "Lookup Failed: input name is not in the table." << endl;
      else cout << name << "'s score is " << *(hashTable->lookup(name)) << endl;
      contFlag = true;
      break;
   case 3:
      cin >> name;
      if(!hashTable->remove(name)) cout << "Remove Failed: input name is not in the table." << endl;
      contFlag = true;
      break;
   case 4:
      hashTable->printAll();
      contFlag = true;
      break;
   case 5:
      cout << hashTable->numEntries() << " entries in the table." << endl;
      contFlag = true;
      break;
   case 6:
      hashTable->hashStats(cout);
      contFlag = true;
      break;
   case 7:
      printHelper();
      contFlag = true;
      break;
   case 8:
      contFlag = false;
      break;
   case 9:
      cout << "Error: command not found." << endl;
      printHelper();
      break;
   default:
      printHelper();
      break;
   }
}

/**
 * Print helper function 
 */
void printHelper(){
   cout << "The following list contains valid commands of this program:" << endl;
   cout << "1. insert name score: insert this name and score in the grade table." << endl;
   cout << "2. change name newscore: Change the score for name." << endl;
   cout << "3. lookup name: Lookup the name, and print out his or her score." << endl;
   cout << "4. remove name: Remove this student." << endl;
   cout << "5. print: Prints out all names and scores in the table." << endl;
   cout << "6. size: Prints out the number of entries in the table." << endl;
   cout << "7. stats: Prints out statistics about the hash table at this point." << endl;
   cout << "8. help: Prints out a brief command summary." << endl;
   cout << "9. quit: Exits the program." << endl;
}

/**
 * Function to change input command into corresponding number
 * Argument: command: input command
 * Return: num: corresponding number
 */
int getCorrespondingNum(string command){
   int num;
   if(strcmp(command.c_str(),"insert") == 0){
      num = 0;
   }
   else if(strcmp(command.c_str(),"change") == 0){
      num = 1;
   }
   else if(strcmp(command.c_str(),"lookup") == 0){
      num = 2;
   }
   else if(strcmp(command.c_str(),"remove") == 0){
      num = 3;
   }
   else if(strcmp(command.c_str(),"print") == 0){
      num = 4;
   }
   else if(strcmp(command.c_str(),"size") == 0){
      num = 5;
   }
   else if(strcmp(command.c_str(),"stats") == 0){
      num = 6;
   }
   else if(strcmp(command.c_str(),"help") == 0){
      num = 7;
   }
   else if(strcmp(command.c_str(),"quit") == 0){
      num = 8;
   }
   else{
      num = 9;
   }

   return num;
}