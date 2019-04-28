#include <iostream>
#include <string>

using namespace std;

class Student {
public:
   Student();
   int getScore() const;
   void setScore(int aScore);
private:
   string name;
   int score;
};

Student::Student() {
   name = "joe blow";
   score = 0;
}

int Student::getScore() const {
   return score;
}

void Student::setScore(int aScore) {
   score = aScore;
}

int main() {

   Student *p;
   Student *r;

   p = new Student();

   p->setScore(10);

   r = new Student;

   r->setScore(50);

   //*********************************************

   *p = *r;    // ***** differs from sharedObj.cpp only in this line

   cout << "p: " << p->getScore() << endl;
   cout << "r: " << r->getScore() << endl;
   cout << endl;

   r->setScore(0);

   cout << "p: " << p->getScore() << endl;
   cout << "r: " << r->getScore() << endl;

   return 0;
}
