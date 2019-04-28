/* Read a bunch of quiz scores [0..10] until eof and compute the max,
 * min, average, and print a histogram (bar graph).
 *
 *
 * Some stuff in here:
 *   how to pass parameters by value and by reference
 *   using arrays
 *   passing arrays as parameters
 *   global named constant
 *   order of definition of functions
 */


#include <iostream>

// for setw
#include <iomanip>

// for MAX and MIN int values
#include <climits>

const int MAX_SCORE = 10;

using namespace std;


void initCounts(int counts[], int numCounts) {
  for (int i = 0; i < numCounts; i++) {
    counts[i] = 0;
  }
}


void printTicks(int numTicks) {
  for (int i = 0; i < numTicks; i++) {
    cout << "|";
  }
}

void printHist(int counts[], int numCounts) {
  cout << "Score Frequency" << endl;
  for (int i = 0; i < numCounts; i++) {
    cout << setw(2) << i << " ";
    printTicks(counts[i]);
    cout << endl;
  }

}



int main() {

  int min = INT_MAX;
  int max = INT_MIN;
  int sum = 0;
  int tot = 0;

  int counts[MAX_SCORE+1];

  initCounts(counts, MAX_SCORE+1);


  int val;

  while (cin >> val) {

    if (0 <= val && val <= MAX_SCORE) {

      if (val > max) {
	max = val;
      }
      if (val < min) {
	min = val;
      }

      sum += val;
 
      tot++;

      counts[val]++;

    }
    else {
      cout << "ERROR: value out of range: " << val << ".  Ignoring" << endl;
    }
  }

  if (!cin.eof()) {
    cout << "ERROR: failed because input value was non-numeric" << endl;
    return 1;
  }

  if (tot > 0) {
    cout << "Minimum value: " << min << endl;
    cout << "Maximum value: " << max << endl;
    cout << "Average of values: " << sum / (double) tot << endl;
    printHist(counts, MAX_SCORE+1);

  }
  else {
    cout << "No values in input." << endl;
  }

  return 0;
}
