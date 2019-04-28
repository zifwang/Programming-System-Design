#include <iostream>

using namespace std;

int main() {

   int *c;
   
   cout << c << endl;

   cout << "\"" << *c << "\"" << endl;  // surround value with "

   c = new int;

   cout << *c << endl;

   *c = 327;

   cout << *c << endl;

   c = NULL;

   cout << *c << endl;

   if (c != NULL) {
      cout << *c << endl;
   }
   else {
      cout << "c is NULL: can't dereference" << endl;
   }

   return 0;

}
