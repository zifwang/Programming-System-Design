/*

  CSCI 455 C String lab

  See lab description for what it should do.  
  C++ tools allowed: cout, call by reference

*/


// for C input functions (e.g., fgets used here)
#include <cstdio>

// C string functions
#include <cstring>

#include <iostream>


using namespace std;

const char NAME_DELIM = ':';
const int AREA_CODE_SIZE = 3;
const int PREFIX_SIZE = 3;
const int LINE_NO_SIZE = 4;
const int MAX_LINE_SIZE = 1024;  // including newline and terminating null char

string readField(char* buffer, int start, int end);      // Function read by field

int main() {

   char buffer[MAX_LINE_SIZE];


   // fgets reads a line of input and puts it in a C string.  If the line of input
   // is longer than the buffer array only gets enough chars that fit (and ignores the
   // rest); this prevents it from overwriting the end of the array.
   // Unlike Java Scanner nextLine(), fgets also saves the newline in the buffer.
   // So after call, buffer will have 0 or more chars, 
   // then a newline char ('\n'), and then the null char ('\0')
   // note: the sizeof function below does not work with dynamic arrays..
   // fgets returns 0 (false) when it hits EOF
   // Note: stdin (third paremeter below) is the C version of cin or System.in

   // cout << "Please enter the phone number (in the format of xxx-xxx-xxxx): ";
   while (fgets(buffer, sizeof(buffer), stdin)) {
      
      cout << "LINE READ: " << buffer;

      string areaCode, prefix, lineNumber;
      // for(size_t i = 0; i < (unsigned)strlen(buffer); i++){
      //    if(buffer[i] == '-') continue;
      //    if(i < 3) areaCode += buffer[i];
      //    else if(i < 7) prefix += buffer[i];
      //    else if(i <= 11)lineNumber += buffer[i];
      // }
      areaCode = readField(buffer,0,3);
      prefix = readField(buffer,4,3);
      lineNumber = readField(buffer,8,4);

      // cout << "Your phone contains: " << endl;
      cout << "area code: '"  << areaCode << "' " << endl;
      cout << "prefix: '"  << prefix << "' " << endl;
      cout << "line number: '"  << lineNumber << "' " << endl;

   }

  

}

string readField(char* buffer, int start, int length){
   string field = "";
   for(int i = start; i < start+length; i++){
      field += *(buffer+i);
   }
   return field;
}