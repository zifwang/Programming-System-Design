#include <iostream>
#include <vector>
#include <string>

std::vector<int> readVals();
std::vector<int> filt(std::vector<int> v);
void printVals(std::vector<int> v);

int main(){
    std::vector<int> vec;
    vec = readVals();
    std::cout << "Vector: ";
    printVals(vec);
    std::cout << "Filtered vector: ";
    std::vector<int> vecMoreThan0;
    vecMoreThan0 = filt(vec);
    printVals(vecMoreThan0);
    std::cout << "Original vector: ";
    printVals(vec);
    return 0;
}

std::vector<int> readVals(){
    std::vector<int> myVec;
    std::string line;
    while(std::getline(std::cin,line,' ')){
        myVec.push_back(std::stoi(line));
    }
    return myVec;
}

void printVals(std::vector<int> v){
    for(size_t i = 0; i < v.size(); i++){
        std::cout << v[i] << " ";
    }
    std::cout << std::endl;
}

// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
std::vector<int> filt(std::vector<int> v){
    std::vector<int> returnVec;
    for(size_t i = 0; i < v.size(); i++){
        if(v[i] > 0) returnVec.push_back(v[i]);
    }
    return returnVec;
}