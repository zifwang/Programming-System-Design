// calculate area of a slice of pizza

// like Java: at least one of the args to a floating point division must be 
//  double/float, o.w. does integer division.

// See how to declare a named constant.
// What happens if we give it non-numeric input?
// What happens if we use = in the if condition?


#include <iostream>

using namespace std;

const double PI = 3.14159;

int main() {

   int diameter;
   int numSlices;

   cout << "What is the diameter of the pizza in inches? ";
   cin >> diameter;
   
   if (cin.fail()) {
      cout << "ERROR: entered non-numeric value" << endl;
      return 1;
   }

   cout << "How many slices of pizza are there? ";
   cin >> numSlices;

   if (numSlices == 0) {
      cout << "ERROR: can't have zero slices.  Will change to 1" << endl;
      numSlices = 1;
   }

  
   double radius = diameter/2.0;


   cout << "Area of a slice is " << PI*radius*radius/numSlices 
        << " square inches." << endl;

   return 0;
}
