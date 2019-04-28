/* Read a bunch of numbers until eof and compute the max, min, and average */

#include <iostream>
#include <climits>

using namespace std;

int main() {

   // INCOMPLETE -- need initial values
   int min = INT_MAX;
   int max = INT_MIN;
   int sum = 0;
   int tot = 0;

   int val;

   while (cin >> val) {
      if (val > max) {
         max = val;
      }
      if (val < min) {
         min = val;
      }

      sum += val;
      tot++;

   }

   if (tot > 0) {
      cout << "Minimum value: " << min << endl;
      cout << "Maximum value: " << max << endl;
      cout << "Average of values: " << sum / (double) tot << endl;
   }
   else {
      cout << "No values in input." << endl;
   }

   return 0;
}
