/*
  What is your name?   Joe
  Hello, Joe, how's it going?
 */


// needed to do IO
#include <iostream>
#include <string>

using namespace std;

int main() {
   
   string name;

   cout << "What is your name? ";
   cin >> name;
   cout << "Hello, " << name << ", how's it going?" << endl;

   return 0;
}
