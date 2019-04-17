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


Table::Table() {
   hashSize = HASH_SIZE;                  // Init. to the default hashSize
   hashTable = new ListType[hashSize];    // Init. hash table with default hashSize
}


Table::Table(unsigned int hSize) {
   hashSize = hSize;                      // Init. to the input size
   hashTable = new ListType[hashSize];    // Init. hash table with input size
}


int * Table::lookup(const string &key) {
   return listGetValue(hashTable[hashCode(key)],key);
}

bool Table::remove(const string &key) {
   return listRemove(hashTable[hashCode(key)],key);
}

bool Table::insert(const string &key, int value) {
   return listAppend(hashTable[hashCode(key)],key,value);
}

int Table::numEntries() const {
   return 0;      // dummy return value for stub
}


void Table::printAll() const {

}

void Table::hashStats(ostream &out) const {
  
}


// add definitions for your private methods here
