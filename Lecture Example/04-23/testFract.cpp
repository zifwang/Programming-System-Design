// Fraction: a class for rational numbers
// and a main program to test it

// by Claire Bono; CSCI 455

// fractions are kept in reduced form

#include <iostream>

#include "Fraction.h"

using namespace std;

int main ()
{
   Fraction f (15, 10);
   Fraction g (10, 15);
   Fraction h (0);

   f.print(cout);
   cout << endl;

   g.print(cout);
   cout << endl;

   h.print(cout);
   cout << endl;

   h = add(f, Fraction(1, 3));

   h.print(cout);
   cout << endl;

   f = add (f, 1);

   f.print(cout);
   cout << endl;

   mult(f, g).print(cout);
   cout << endl;

   return 0;
}
