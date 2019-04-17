// Name: Zifan Wang 
// USC NetID: 9505587296  
// CSCI 455 PA5
// Spring 2019

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// Default hash table constructor
Table::Table() {
   numberOfEntries = 0;                   // Init. to the 0
   hashSize = HASH_SIZE;                  // Init. to the default hashSize
   hashTable = new ListType[hashSize];    // Init. hash table with default hashSize
}

// hash table constructor with given size
Table::Table(unsigned int hSize) {
   numberOfEntries = 0;                   // Init. to the 0
   hashSize = hSize;                      // Init. to the input size
   hashTable = new ListType[hSize];       // Init. hash table with input size
}

// returns the address of the value that goes with this key
int * Table::lookup(const string &key) {
   return listGetValue(hashTable[hashCode(key)],key);
}

// remove a pair given its key
bool Table::remove(const string &key) {
   bool removeFlag = listRemove(hashTable[hashCode(key)],key); // try to remove entries with key
   if(removeFlag) numberOfEntries--;                           // If remove, then numberOfEntries -=1;
   return removeFlag;
}

bool Table::insert(const string &key, int value) {
   ListType node = listGetNode(hashTable[hashCode(key)],key);
   if(node != NULL) return false;                              // Check whether node in the list
   listInsertFront(hashTable[hashCode(key)],key,value);        // Insert
   numberOfEntries++;                                          // Update numberOfEntries
   return true;
}

int Table::numEntries() const {
   return numberOfEntries;      // dummy return value for stub
}


void Table::printAll() const {
   for(size_t i = 0; i < hashSize; i++){
      if(listIsEmpty(hashTable[i])) listPrint(hashTable[i]);
   }
}

void Table::hashStats(ostream &out) const {
   int longest = 0;
   int numNonEmpty = 0;
   for(size_t i = 0; i < hashSize; i++){
      if(listIsEmpty(hashTable[i])){
         numNonEmpty++;
         if(listGetSize(hashTable[i]) > longest){
            longest = listGetSize(hashTable[i]);
         }
      }
   }
   out << "number of buckets: " << hashSize << endl;
   out << "number of entries: " << numberOfEntries << endl;
   out << "number of non-empty buckets: " << numNonEmpty << endl;
   out << "longest chain: " << longest << endl;
}


// add definitions for your private methods here
