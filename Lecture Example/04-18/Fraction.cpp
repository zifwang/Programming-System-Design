#include <cassert>
#include <iostream>
// stdlib for abs
#include <cstdlib>
#include "Fraction.h"

using namespace std;

// invariant: maintains reduced fractions; denominator is always positive
// (i.e., the sign will be part of the numerator)


// note: static means that it's only visible in this file
static int gcd(int, int);   // utility function -- defined later in this file

int Fraction::getNum() const
{
   return num;
}

int Fraction::getDenom() const
{
   return denom;
}

Fraction::Fraction ()
{
   num = 0;
   denom = 1;
}

Fraction::Fraction (int n)
{
   num = n;
   denom = 1;
}

Fraction::Fraction (int n, int d)
{
   const int POS = 1;
   const int NEG = -1;

   int divisor;

   assert (d != 0);
  

   if (n == 0) {
      num = 0;
      denom = 1;
   }
   else {
      // figure out sign of the fraction
      int sign = POS;
      if ((n<0 && d>0) || (n>0 && d<0)) {
         sign = NEG;       // if num and denom are different signs, it's negative
      }

      n = abs(n);
      d = abs(d);

      divisor = gcd (n, d);
      num = n / divisor;
      denom = d / divisor;

      if (sign == NEG) {   // give the sign to resulting fraction
         num = -num;
      }
   }
}

     
void Fraction::print (ostream &out) const
{

   if (denom == 1) {
      out << getNum();
   }
   else {
      out << getNum() << "/" << getDenom();
   }
}


Fraction add (const Fraction &a, const Fraction &b)
{
   int newdenom = a.getDenom() * b.getDenom();
   int newnum = a.getNum() * b.getDenom() + b.getNum() * a.getDenom();
  
   return Fraction (newnum, newdenom);
}


Fraction mult (const Fraction &a, const Fraction &b)
{
   return Fraction (a.getNum() * b.getNum(), a.getDenom() * b.getDenom());
}



// pre: (a > 0) && (b > 0);
// post: return value is greatest common divisor of a and b
static int gcd (int a, int b)
{
   int low = (a < b) ? a : b;
   int high = (low == a) ? b : a;
   int rem;

   while ((rem = high % low) != 0) {
      high = low;
      low = rem;
   }
   return (low);
}
