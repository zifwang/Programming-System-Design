/*  Name: Zifan Wang
 *  USC NetID: 9505587296
 *  CS 455 Spring 2019
 *
 *  See ecListFuncs.h for specification of each function.
 */


// for NULL
#include <cstdlib>
#include <iostream>
#include "ecListFuncs.h"

using namespace std;


int lastIndexOf(ListType list, int val) {
   int position = 0;
   int lastIndex;
   while(list != NULL){
      if(list->data == val){
         lastIndex = position;
      }
      position++;
      list = list->next;
   }
   return lastIndex;
}


int longestNondecreasingSequence(ListType list) {
   if(list == NULL) return 0;
   int prev = list->data;
   int length = 1;
   int maxLenght = 0;
   while(list->next != NULL){
      list = list->next;
      if(prev > list->data){
         if(length > maxLenght){
            maxLenght = length;
         }
         length = 0;
      }
      prev = list->data;
      length++;
   }
   if(maxLenght < length) maxLenght = length;
   return maxLenght;  // stub code to get it to compile
}


void removeAdjacentEvens(ListType & list) {
   if(list == NULL) return;

   ListType oriList = list;
   Node * prevNode = oriList;

   while(oriList->next != NULL){
      oriList = oriList->next;
      Node *currentNode = oriList;
      if(prevNode->data%2 == 0){
         if(currentNode->data%2 == 0){
            if(currentNode->next != NULL){
               prevNode->next = currentNode->next;
               delete currentNode;
            }else{
               prevNode->next = NULL;
               delete currentNode;
            }
         }else{
            prevNode = currentNode;
         }
      }else{
         prevNode = currentNode;
      }
   }

}


void mirror(ListType & list) {
   if(list == NULL) return;
   ListType oriList = list;
   Node *tmp = new Node(oriList->data);
   Node *temp = oriList;
   oriList = oriList->next;
   while(oriList != NULL){
      temp = oriList;
      Node *insertNode = new Node(oriList->data);
      insertNode->next = tmp;
		tmp = insertNode;
		oriList = oriList->next;
   }
   temp->next = tmp;
}


void rotateLeft(ListType & list, int k) {
   if(list == NULL) return;            // when empty return
   // Get list length for case: k<=0 || k>=listlength
   ListType getListLength = list;
   Node * first = getListLength;
   Node * last = NULL;
   int listSize = 0;
   while(getListLength != NULL){
      listSize++;
      last = getListLength;
      getListLength = getListLength->next;
   }
   if(k <= 0 || k >= listSize) return;
   // Rotate for case: 0 < k < length
   int index = 0;
   Node * move2Last = first;
   while(index < k-1){
      move2Last = move2Last->next;
      index++;
   }
   last->next = first;
   list = move2Last->next;
	move2Last->next = NULL;
}
