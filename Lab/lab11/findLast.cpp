#include <iostream>
#include <vector>
#include <string>

std::vector<int> readVals();
std::vector<int> filt(std::vector<int> v);
int findLast(std::vector<int> v, int target);
void printVals(std::vector<int> v);

int main(){
    std::vector<int> vec;
    vec = readVals();
    std::cout << "Vector: ";
    printVals(vec);
    // Last position of 7
    int target = 7;
    std::cout << "The last instance of " << target << " is at position " << findLast(vec,target) << std::endl;
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

/**
 * returns location of last instance of target in v or -1 if not found
 */ 
int findLast(std::vector<int> v, int target){
    int lastPosition = -1;
    for(size_t i = v.size()-1; i > 0; i--){
        if(v[i] == target) {
            lastPosition = i;
            break;
        }
    }
    return lastPosition;
}