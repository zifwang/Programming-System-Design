// Name: Zifan Wang
// USC NetID: 9505587296
// CSCI 455 lab13
// Spring 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

// Print given linkedList
void listPrint(ListType list){
   ListType node = list;            // Assign input list which is the first node of given linkedList to node

   while(node != NULL){
      cout << "key = " << node->key << ", value = " << node->value << endl;
      node = node->next;            // Update node to the next node in the linkedList
   }
}

// Get the size of linkedList
int listGetSize(ListType list){
   ListType node = list;            // Assign input list which is the first node of given linkedList to node
   int length = 0;

   while(node != NULL){
      length++;
      node = node->next;            // Update node to the next node in the linkedList
   }

   return length;
}

// Check whether linkedList is empty
bool listIsEmpty(ListType list){
   return list==NULL;
}

// Get node in a given linkedList with key = target
ListType listGetNode(ListType list, string target){
   ListType node = list;            // Assign input list which is the first node of given linkedList to node
   
   while(node != NULL){
      if(node->key == target) return node;         // Check whether target == key
      node = node->next;
   }

   return NULL;
}

// Get value with target key in the given linkedlist
int listGetValue(ListType list, string target){
   ListType node = listGetNode(list, target);         // Call listGetNode method here

   if(node == NULL) return NULL;                      // Check whether target != key

   return node->value;
}

// Insert new node in front of target strign
bool listInsertBefore(ListType & list, string key, int value, string target){
   // list does not contains any node
   if(list == NULL){
      listInsertFront(list, key, value);
      return true;
   }

   ListType node = listGetNode(list,target);
   // Case when list is not empty && node given target key does not found in the linkedList
   if(node == NULL){
      return false;
   }

   while(list->next != NULL){
      if(list->next->key == target){
         ListType newNode = new Node(key, value, list->next);
         list->next = newNode;
      }
      else list = list->next;
   }
}

// Insert new node after target string
bool listInsertAfter(ListType & list, string key, int value, string target){
   // list does not contains any node
   if(list == NULL){
      listInsertFront(list, key, value);
      return true;
   }

   ListType node = listGetNode(list,target);
   // Case when list is not empty && node given target key does not found in the linkedList
   if(node == NULL){
      return false;
   }

   // Insert
   ListType newNode = new Node(key, value, node->next);
   node->next = newNode;
   return true;
}

// Insert new node at front of linkedList
void listInsertFront(ListType & list, string key, int value){
   list = new Node(key, value, list);
}

// Insert new node at the end of linkedList
void listAppend(ListType & list, string key, int value){
   // Check whether list is empty
   if(list == NULL){
      listInsertFront(list, key, value);
      return;
   }

   ListType node = list;
   // loop to the last node
   while(node->next != NULL){
      node = node->next;
   }

   // Append to the last node
   node->next = new Node(key, value);
}

// Delete node with target string
bool listRemove(ListType & list, string target){
   ListType node = list;
   
   // Check whether the first node's key == target
   if(node->key == target){
      list = list->next;
      delete node;
      return true;
   }

   // Loop through nodes in the linked list
   while(node->next != NULL){
      if(node->next->key == target){
         node->next = node->next->next;      // Update the node->next 
         delete node->next;                  // Remove node
   
         return true;
      }
      node = node->next;                     // move to next node
   }
   
   return false;
}

// Delete the front node of given linkedList
bool listRemoveFront(ListType & list){
   // Case when no node in the list
   if(list == NULL) return false;

   // Case then more nodes in the list
   ListType node = list;
   list = list->next;
   delete node;

   return true;
}

// Delete the end node of given linkedList
bool listRemoveLast(ListType & list){
   // case when no node in the linkedList
   if(list == NULL) return false;
   
   bool removeFlag;                          // removeFlage set to true when remove the last element.
   // case only one node in the linkedList
   if(list->next == NULL){
      delete list;
      removeFlag = true;
   }

   // case when more nodes in the linkedList
   ListType node = list;
   // loop to the end node
   while(node->next != NULL){
      if(node->next->next == NULL){
         node->next = NULL;
         delete node->next->next;
         removeFlag = true;
      }else{
         node = node->next;
      }
   }

   return removeFlag;
}