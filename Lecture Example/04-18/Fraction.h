#ifndef FRACTION_H
#define FRACTION_H

// Fraction: a class for rational numbers
// by Claire Bono; CSCI 455

// fractions are kept in reduced form.
// getDenom() is always positive, i.e., the sign of the fraction is
// part of getNum()

#include <iostream>

class Fraction {

 public:
   // constructors

   Fraction ();              // creates fraction 0
   Fraction (int n);         // creates fraction n
   Fraction (int n, int d);  // creates reduced version of fraction n/d
   // precondition: d is not zero

   // prints to "out" in the following form: "3/5" (no spaces printed)
   //   x/1 printed as x
   void print (std::ostream &out) const;

   // accessors
   int getNum() const;          // numerator
   int getDenom() const;        // denominator

 private:
   int num, denom;
};


// Arithmetic functions
// these are non-member functions since they don't need access
// to Fraction internals

Fraction add (const Fraction &a, const Fraction & b);
Fraction mult (const Fraction &a, const Fraction &b);

#endif
