// illustrates dangling pointer by returning a pointer to a local variable
// that went out of scope, and then subsequently dereferencing that pointer

#include <iostream>

using namespace std;


// once n goes out of scope 
// its memory location can be used for other things
int* dangle() {
   int n = 12;   // local int with value 12

   return &n;    // BAD--can cause weird results or crashes.
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
