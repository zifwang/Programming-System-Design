// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 lab13
// Spring 2019

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for lab13.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The lab13 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string.h>
#include <stdio.h>
#include <cassert>

using namespace std;

#include "listFuncs.h"

void printHelper();
void test_addNode2EmptyList(ListType list);
void test_addNode2NonEmptyList(ListType list);
void test_listGetSize(ListType list, int sizeList);
void test_listGetValue(ListType list);
void test_listIsEmpty();
void test_listChangeValue(ListType list);
void test_removeNodeInEmptyList(ListType list);
void test_removeNodeInNonEmptyList(ListType list);
void test_listInsertFront(ListType list);
void test_listAppend(ListType List);
void test_listInsertBefore(ListType list);
void test_listInsertAfter(ListType list);

int main(int argc, char* argv[]) {
   if(argc != 2){
      std::cout << "Error in input keys: " << endl;
      printHelper();
      return 0;
   }
   string argument = *(argv+1);
   if(strcmp(argument.c_str(),"help") == 0){
         printHelper();
   }
   else if(strcmp(argument.c_str(),"AddInEmptyList")==0){
      ListType node = NULL;
      // Test insert function to an empty list
      test_addNode2EmptyList(node);
   }
   else if(strcmp(argument.c_str(),"AddInNonEmptyList")==0){
      ListType node = NULL;
      // Test insert function to an non empty list
      listInsertFront(node,"insane",3);
      listInsertFront(node,"xua",1);
      listInsertFront(node,"Eric",4);
      listInsertFront(node,"gigina",6);
      test_addNode2NonEmptyList(node);
   }
   else if(strcmp(argument.c_str(),"ListGetSize")==0){
      ListType list = NULL;
      listInsertFront(list,"insane",3);
      listInsertFront(list,"xua",1);
      listInsertFront(list,"gigina",6);
      listInsertFront(list,"Eric",10);
      listAppend(list,"Tom",2);
      // Test listGetSize function
      test_listGetSize(list,5);
   }
   else if(strcmp(argument.c_str(),"ListGetValue")==0){
      ListType list = NULL;
      listInsertFront(list,"insane",3);
      listInsertFront(list,"xua",1);
      listInsertFront(list,"gigina",6);
      listInsertFront(list,"Eric",10);
      listAppend(list,"Tom",2);
      // Test listGetValue function
      test_listGetValue(list);
   }
   else if(strcmp(argument.c_str(),"IsEmpty")==0){
      // Test listIsEmpty function
      test_listIsEmpty();
   }
   else if(strcmp(argument.c_str(),"ChangeValue")==0){
      ListType list = NULL;
      listInsertFront(list,"insane",3);
      listInsertFront(list,"xua",1);
      listInsertFront(list,"gigina",6);
      listInsertFront(list,"Eric",10);
      listAppend(list,"Tom",2);
      // Test Change Value function
      test_listChangeValue(list);
   }
   else if(strcmp(argument.c_str(),"RemoveInEmptyList")==0){
      // Test remove in the empty list
      ListType emptyList = NULL;
      test_removeNodeInEmptyList(emptyList);
   }
   else if(strcmp(argument.c_str(),"RemoveInNonEmptyList")==0){
      ListType list = NULL;
      listInsertFront(list,"insane",3);
      listInsertFront(list,"xua",1);
      listInsertFront(list,"gigina",6);
      listInsertFront(list,"Eric",10);
      listAppend(list,"Tom",2);
      listInsertFront(list,"Li",1);
      listInsertFront(list,"feifei",6);
      listInsertFront(list,"fei",10);
      listAppend(list,"Jon",2);
      listInsertFront(list,"Alex",1);
      listInsertFront(list,"Jason",6);
      listInsertFront(list,"Panda",10);
      // Test remove in the non empty list
      test_removeNodeInNonEmptyList(list);
   }
   else if(strcmp(argument.c_str(),"All")==0){
      ListType node = NULL;
      // Test insert function to an empty list
      test_addNode2EmptyList(node);

      // Test insert function to an non empty list
      listInsertFront(node,"insane",3);
      listInsertFront(node,"xua",1);
      listInsertFront(node,"Eric",4);
      listInsertFront(node,"gigina",6);
      test_addNode2NonEmptyList(node);

      // Assign new list
      ListType list = NULL;
      listInsertFront(list,"insane",3);
      listInsertFront(list,"xua",1);
      listInsertFront(list,"gigina",6);
      listInsertFront(list,"Eric",10);
      listAppend(list,"Tom",2);
      // Test listGetSize function
      test_listGetSize(list,5);
   
      // Test listGetValue function
      test_listGetValue(list);

      // Test listIsEmpty function
      test_listIsEmpty();

      // Test Change Value function
      test_listChangeValue(list);

      // Test remove in the empty list
      ListType emptyList = NULL;
      test_removeNodeInEmptyList(emptyList);

      // Test remove in the non empty list
      listInsertFront(list,"Li",1);
      listInsertFront(list,"feifei",6);
      listInsertFront(list,"fei",10);
      listAppend(list,"Jon",2);
      listInsertFront(list,"Alex",1);
      listInsertFront(list,"Jason",6);
      listInsertFront(list,"Panda",10);
      test_removeNodeInNonEmptyList(list);
   }
   else{
      std::cout << "key not found" << endl;
      printHelper();
   }
   return 0;
}


void test_addNode2EmptyList(ListType list){
   std::cout << "Test insert function to an empty list:" << endl;
   std::cout << "Test listInsertFront(ListType & list, string key, int value) function: " << endl;
   test_listInsertFront(list);
   std::cout << endl;
   std::cout << "Test listAppend(ListType & list, string key, int value) function: " << endl;
   test_listAppend(list);
   std::cout << endl;
   std::cout << "Test listInsertBefore(ListType & list, string key, int value, string target) function: " << endl;
   test_listInsertBefore(list);
   std::cout << endl;
   std::cout << "Test listInsertAfter(ListType & list, string key, int value, string target) function: " << endl;
   test_listInsertAfter(list);
   std::cout << endl;
}

void test_addNode2NonEmptyList(ListType list){
   std::cout << "Test insert function to an non-empty list: " << endl;
   std::cout << "Test listInsertFront(ListType & list, string key, int value) function: " << endl;
   test_listInsertFront(list);
   std::cout << endl;
   std::cout << "Test listAppend(ListType & list, string key, int value) function: " << endl;
   test_listAppend(list);
   std::cout << endl;
   std::cout << "Test listInsertBefore(ListType & list, string key, int value, string target) function: " << endl;
   test_listInsertBefore(list);
   std::cout << endl;
   std::cout << "Test listInsertAfter(ListType & list, string key, int value, string target) function: " << endl;
   test_listInsertAfter(list);
   std::cout << endl;
}

void test_listGetSize(ListType list, int sizeList){
   std::cout << "Test listGetSize function: " << endl;
   std::cout << "Input List: " << endl;
   listPrint(list); 
   std::cout << "Expect return " << sizeList << endl;
   int length = listGetSize(list);
   if(length == sizeList){
      std::cout << "Success: listGetSize() function works." << endl;
   }else{
      std::cout << "Fail: Wrong return lenght" << endl;
   }
}

void test_listGetValue(ListType list){
   std::cout << "Test listGetValue(ListType list, string target) function:" << endl;
   std::cout << "Input List: " << endl;
   listPrint(list); 
   // Case 1: target is in the list
   int* p = listGetValue(list,"Tom");
   std::cout << "Target = Tom, expect return 2" << endl;
   if(*p == 2){
      std::cout << "Success: target string, Tom, is in the list with value 2" << endl;
   }else{
      std::cout << "Fail. Wrong value" << endl;
   }

   // Case 2: target is not in the list
   int *p1 = listGetValue(list,"Wang");
   std::cout << "Target = Wang is not in the list. Expect return NULL" << endl;
   if(p1 == NULL){
      std::cout << "Success: target, Wang, is not in the list" << endl;
   }else{
      std::cout << "Fail" << endl;
   }

}

void test_listIsEmpty(){
   std::cout << "Test listIsEmpty(ListType list) function:" << endl;
   ListType node = NULL;
   listInsertAfter(node,"Tom",10,"I");
   listAppend(node,"Eric",5);
   std::cout << "Input list: " << endl;
   listPrint(node);
   bool testFlag = listIsEmpty(node);
   // Case when non-empty list
   if(testFlag == true){
      std::cout << "Success: listIsEmpty function works" << endl;
   }else{
      std::cout << "Fail" << endl;
   }

   // Case when empty list
   ListType list = NULL;
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listIsEmpty(list);
   if(testFlag == false){
      std::cout << "Success: listIsEmpty function works" << endl;
   }else{
      std::cout << "Fail" << endl;
   }

}

void test_listChangeValue(ListType list){
   // Test when target in the list
   std::cout << "Input list: " << endl;
   listPrint(list);
   bool testFlag;
   std::cout << "Test when target in the list: " << endl;
   std::cout << "Change gigina's value to 3: " << endl;
   std::cout << "Ori value: " << listGetNode(list,"gigina")->value << endl;
   std::cout << "Expect new value = 3" << endl;
   testFlag = listChangeValue(list,"gigina",3);
   if(testFlag == true && listGetNode(list,"gigina")->value == 3){
      std::cout << "Success: listChangeValue() function works." << endl;
      std::cout << "Now value: " << listGetNode(list,"gigina")->value << endl;
   }else{
      std::cout << "Fail" << endl;
   }

   // Test when target not in the list
   std::cout << "Input list: " << endl;
   listPrint(list);
   std::cout << "Test when target not in the list: " << endl;
   testFlag = listChangeValue(list,"Wang",10);
   if(testFlag == false){
      std::cout << "Success: listChangeValue() function works." << endl;
      std::cout << "Wang is not in the list" << endl;
   }else{
      std::cout << "Fail" << endl;
   }
}

void test_removeNodeInEmptyList(ListType list){
   bool testFlag;
   // test listRemove function
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemove(list,"lasdf");
   if(testFlag == false){
      std::cout << "Success: listRemove works." << endl;
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemoveFront
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemoveFront(list);
   if(testFlag == false){
      std::cout << "Success: listRemoveFront works." << endl;
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemoveLast
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemoveLast(list);
   if(testFlag == false){
      std::cout << "Success: listRemoveLast works." << endl;
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;
}

void test_removeNodeInNonEmptyList(ListType list){
   // All method should return true and compare with the length before
   bool testFlag;
   // test listRemove Corner case
   std::cout << "Test listRemove function when target string at first location: "<< endl;
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemove(list,"Panda");
   if(testFlag == true){
      std::cout << "Success: listRemove corner case works" << endl;
      std::cout << "List now: " << endl;
      listPrint(list);
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemove
   std::cout << "Test listRemove function when target string not at first location: "<< endl;
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemove(list,"Jon");
   if(testFlag == true){
      std::cout << "Success: listRemove works" << endl;
      std::cout << "List now: " << endl;
      listPrint(list);
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemoveFront
   std::cout << "Test listRemoveFront function: "<< endl;
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemoveFront(list);
   if(testFlag == true){
      std::cout << "Success: listRemoveFront works" << endl;
      std::cout << "List now: " << endl;
      listPrint(list);
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemoveLast corner case
   std::cout << "Test listRemoveLast function when there is only one element in the list: "<< endl;
   ListType node = NULL;
   listAppend(node,"zsaf",10);
   std::cout << "Input list: " << endl;
   listPrint(node);
   testFlag = listRemoveLast(node);
   if(testFlag == true){
      std::cout << "Success: listRemoveLast corner case works" << endl;
      std::cout << "List now: " << endl;
      listPrint(node);
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

   // test listRemoveLast
   std::cout << "Test listRemoveLast function: "<< endl;
   std::cout << "Input list: " << endl;
   listPrint(list);
   testFlag = listRemoveLast(list);
   if(testFlag == true){
      std::cout << "Success: listRemoveLast works" << endl;
      std::cout << "List now: " << endl;
      listPrint(list);
   }else{
      std::cout << "Fail" << endl;
   }
   std::cout << endl;

}

void test_listInsertFront(ListType list){
   if(list == NULL){
      std::cout << "List is currently Empty." << endl;
      listInsertFront(list,"Eric", 10);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = Eric and value = 10 is successfully added to the empty list." << endl;
   }
   else{
      listInsertFront(list,"Alex",5);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = Alex and value = 5 is successfully added to the front of list." << endl;
      listInsertFront(list,"James",3);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = James and value = 3 is successfully added to the front of list." << endl;
   }
}

void test_listAppend(ListType list){
   if(list == NULL){
      std::cout << "List is currently Empty." << endl;
      listAppend(list,"Eric", 10);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = Eric and value = 10 is successfully added to the empty list." << endl;
   }
   else{
      listAppend(list,"Alex",5);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = Alex and value = 5 is successfully added to the end of list." << endl;
      listAppend(list,"James",3);
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
      std::cout << "Success: a node with key = James and value = 3 is successfully added to the end of list." << endl;
   }
}

void test_listInsertBefore(ListType list){
   std::cout << "Input linkedList: " << endl;
   listPrint(list);
   // Case when no node in the list
   if(list == NULL){
      if(listInsertBefore(list, "Eric", 10, "")){
         std::cout << "Success: a node with key = Eric and value = 10 is successfully added to the empty list." << endl;
      }
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
   }

   // Case when there are node in the element
   else{
      if(listInsertBefore(list,"Tom",1,"Alex")){
         std::cout << "Sucess: a node with key = Tom and value = 1 is successfully added before Alex node." << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }
      if(listInsertBefore(list,"Brid",2,"Eric")){
         std::cout << "Sucess: a node with key = Brid and value = 2 is successfully added before Eric node." << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }
      // Case when target is not in the list
      if(!listInsertBefore(list,"James",2,"Adams")){
         std::cout << "Sucess: Adams not found" << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }

   }
}

void test_listInsertAfter(ListType list){
   std::cout << "Input linkedList: " << endl;
   listPrint(list);
   // Case when no node in the list
   if(list == NULL){
      if(listInsertAfter(list, "Eric", 10, "")){
         std::cout << "Success: a node with key = Eric and value = 10 is successfully added to the empty list." << endl;
      }
      std::cout << "Node in the linkedList: " << endl;
      listPrint(list);
   }

   // Case when there are node in the element
   else{
      if(listInsertAfter(list,"Keith",5,"Eric")){
         std::cout << "Sucess: a node with key = Keith and value = 5 is successfully added after Eric node." << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }
      if(listInsertAfter(list,"Brando",2,"Alex")){
         std::cout << "Sucess: a node with key = Brando and value = 2 is successfully added after Alex node." << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }
      // Case when target is not in the list
      if(!listInsertAfter(list,"James",2,"Adams")){
         std::cout << "Sucess: Adams not found" << endl;
         std::cout << "Node in the linkedList: " << endl;
         listPrint(list);
      }
   }

}

void printHelper(){
   std::cout << "Run program with following format: ./pa5list test" << endl;
   std::cout << "test argument can be assigned in the following list: " << endl;
   std::cout << "     1. help: print helper function" << endl;
   std::cout << "     2. AddInEmptyList: Test insert function to an empty list" << endl;
   std::cout << "     3. AddInNonEmptyList: Test insert function to an non empty list" << endl;
   std::cout << "     4. ListGetSize: Test listGetSize function" << endl;
   std::cout << "     5. ListGetValue: Test listGetValue function" << endl;
   std::cout << "     6. IsEmpty: Test listIsEmpty function" << endl;
   std::cout << "     7. ChangeValue: Test Change Value function" << endl;
   std::cout << "     8. RemoveInEmptyList: Test remove in the empty list" << endl;
   std::cout << "     9. RemoveInNonEmptyList: Test remove in the non empty list" << endl;
   std::cout << "     10. All: Perform all tests" << endl;
}