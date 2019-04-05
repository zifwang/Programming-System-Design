#include <iostream>
#include <vector>
#include <string>

std::vector<int> readVals();
void printVals(std::vector<int> v);

int main(){
    printVals(readVals());
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