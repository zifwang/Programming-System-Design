// C++ list functions we did in lecture on pencil and paper.
// This code shows a few different versions of some of the functions.
// (some that we didn't get to in lecture)

#include <iostream>
#include <cassert>

using namespace std;

struct Node {
   int data;
   Node *next;

   Node(int item);
   Node(int item, Node *n);

};

Node::Node(int item) {
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}


typedef Node* ListType;


void initList(ListType &list) {
   list = NULL;
}


// PRECONDITION: for all list functions except initList
//   param list must be a well-formed list.
// Well-formed list means list itself is NULL, or points to a chain
//   of linked nodes such that the last one has NULL in its next field.

// two different versions of printList

// two different versions of the code to insert a node on the front of a list

// three different versions of the code to remove an element from the end of a list

// first param is: reference to a Node*
void insertFront(ListType &list, int num) {

   Node *newguy = new Node(num);
 
   newguy->next = list;
 
   list = newguy;

}

void insertFront2(ListType &list, int num) {

   Node *newguy = new Node(num, list);

   list = newguy;

}



void printList(ListType list) {

   if (list == NULL) {
      cout << "<empty>";
   }

   Node *p = list;
   while (p != NULL) {
      cout << p->data << " ";
      p = p->next;
   }
   cout << endl;
}


// uses for instead of while
void printList2(ListType list) {
  
   if (list == NULL) {
      cout << "<empty>";
   }


   for (Node *p = list; p != NULL; p=p->next) {
      cout << p->data << " ";
   }
   cout << endl;
}


void printLast(ListType list) {

   if (list == NULL) {
      cout << "<empty>" << endl;
      return;
   }

   Node *p = list;
   while (p->next != NULL) {  // stop when p points to the last element in the list
      p = p->next;
   }

   cout << p->data << endl;
}


void removeFront(ListType &list) {
   if (list != NULL) {
      Node *save = list->next;
      delete list;
      list = save;
   }
}


// this version uses only one pointer for traversal
void removeLast(ListType &list) {

   if (list == NULL) {  // no elements in list
      return;
   }

   if (list->next == NULL) {   // one element in list
      delete list;
      list = NULL;
      return;
   }
  
   // we know here that the list has at least 2 elements

   Node *p = list;
   while (p->next->next != NULL) {
      p = p->next;
   }

   // p currently points to second to last element

   Node *deadGuy = p->next;
   p->next = NULL;  // p becomes the last element in the list
   delete deadGuy;

}



// this version uses two pointers for traversal
void removeLast2(ListType &list) {

   if (list == NULL) {  // no elements in list
      return;
   }

   if (list->next == NULL) {   // one element in list
      delete list;
      list = NULL;
      return;
   }
  
   // we know here that the list has at least 2 elements

   Node * prev = list;  // points to first element
   Node *curr = list ->next;    // points to second element

   while (curr->next != NULL) {  // while curr is not the last element
      prev = curr;
      curr = curr->next;
   }

   // prev currently points to second to last element
   // and curr currenlty points to the last element

   prev->next = NULL;  // prev becomes the last element in the list
   delete curr;

}


// this one has a different header (passes by value, and returns the updated version)

// removeLast removes the last element in the linked list and returns the
// updated version.
// Note: after the call, the old value of list is invalid (may be a dangling pointer).
ListType removeLast3(ListType list) {

   if (list == NULL) {  // no elements in list
      return NULL;
   }

   if (list->next == NULL) {   // one element in list
      delete list; // the "list" in caller will be a dangling pointer
      // list = NULL;  would only update the local version (unnecessary statement)
      return NULL;
   }
  
   // we know here that the list has at least 2 elements

   Node *p = list;
   while (p->next->next != NULL) {
      p = p->next;
   }

   // p currently points to second to last element

   Node *deadGuy = p->next;
   p->next = NULL;  // p becomes the last element in the list
   delete deadGuy;

   return list;
}



void testEmpty() {
   ListType empty;
   initList(empty);
   cout << "an empty list: ";
   printList(empty);

   cout << "printLast of empty list: ";
   printLast(empty);
   cout << endl;
}

void testRemoveFront(ListType & list) {
   removeFront(list);
   cout << "after remove front from first list: ";
   printList(list);
   removeFront(list);
   cout << "after remove front from first list: ";
   printList(list);
   removeFront(list);
   cout << "after remove front from first list: ";
   printList(list);
   cout << endl;
}

void testRemoveLast(ListType & list) {
   removeLast(list);
   cout << "after remove last from second list: ";
   printList2(list);

   removeLast(list);
   cout << "after remove last from second list: ";
   printList2(list);
   cout << endl;
}

void testRemoveLast2() {
   Node *list3;
   initList(list3);
   insertFront2(list3, 12);
   insertFront2(list3, 17);
   insertFront2(list3, 5);

   cout << "test second version of code, removeLast2:" << endl;
   cout << "yet another list: ";
   printList2(list3);

   removeLast2(list3);
   cout << "after remove last from this list: ";
   printList2(list3);

   removeLast2(list3);
   cout << "after remove last from this list: ";
   printList2(list3);

   removeLast2(list3);
   cout << "after remove last from this list: ";
   printList2(list3);
   cout << endl;

}

void testRemoveLast3() {

   Node *list4;
   initList(list4);
   insertFront2(list4, 1);
   insertFront2(list4, 2);
   insertFront2(list4, 3);

   cout << "test third version of code, removeLast3:" << endl;
   cout << "yet another list: ";
   printList2(list4);

   list4 = removeLast3(list4);  // NOTE: we call this one differently.
   cout << "after remove last from this list: ";
   printList2(list4);

   list4 = removeLast3(list4);
   cout << "after remove last from this list: ";
   printList2(list4);

   list4 = removeLast3(list4);
   cout << "after remove last from this list: ";
   printList2(list4);

}



int main() {

   testEmpty();

   ListType list;
   initList(list);

   insertFront(list, 32);
   insertFront(list, 50);
   insertFront(list, 25);
   cout << "a list: ";
   printList(list);

   Node *list2;
   initList(list2);
   insertFront2(list2, 12);
   insertFront2(list2, 17);

   cout << "another list: ";
   printList2(list2);

   cout << "printLast of list: ";
   printLast(list);

   cout << "printLast of the other list: ";
   printLast(list2);
   cout << endl;

   testRemoveFront(list);
   testRemoveLast(list2);
   testRemoveLast2();
   testRemoveLast3();

   return 0;
}
