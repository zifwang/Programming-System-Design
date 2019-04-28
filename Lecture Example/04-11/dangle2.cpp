// dangling pointer by two pointers pointing to the same
// memory, and do delete via one, and later dereference 
// the other one.
#include <iostream>

using namespace std;


// once we reclaim memory for *n2,
// it can be used for other things
// not safe to have another pointer to it.
int* dangle() {
   int * n1 = new int;
   
   *n1 = 12;
   
   int * n2 = n1;
   
   delete n2;

   return n1;    // BAD--can cause weird results or crashes.
}


int *ok() {
   int *q = new int;
   *q = 12;           // dynamically allocated int with value 12
   return q;
}

int main() {

   int *p;

   int *p2;

   p = dangle();  // points to some memory that may have changed
   // and no longer necessarily even stores an int

   cout << "*p: " << *p << endl;    // try adding the following line
   cout << "print it again..." << endl;
   cout << "*p: " << *p << endl;

   p2 = ok();     // points to dynamic data: exists until we do delete

   cout << "changed only p2..." << endl;

   cout << "*p: " << *p << endl;

   cout << "*p2: " << *p2 << endl;

   return 0;
}

