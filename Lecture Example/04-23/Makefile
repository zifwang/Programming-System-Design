# first version of a Makefile to compile Fraction module separately
# from testFract program.
#
# Executable created is called testFract
#

#1
testFract: Fraction.o testFract.o
	g++ -Wall -ggdb Fraction.o testFract.o -o testFract

#2
Fraction.o: Fraction.cpp Fraction.h
	g++ -Wall -ggdb -c Fraction.cpp

#3
testFract.o: testFract.cpp Fraction.h
	g++ -Wall -ggdb -c testFract.cpp
