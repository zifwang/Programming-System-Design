# Makefile for CS 455 lab13
#
#     gmake pa5list
#	 Makes pa5list executable.  (This is a test driver for your list functions)
#
#

# compile options to be used in all compile commands
#     NOTE: $(CXXFLAGS) in the compile commands below will be replaced by the options after the =
CXXFLAGS = -ggdb -Wall -Wno-sign-compare -std=c++11

pa5list: pa5list.cpp listFuncs.o listFuncs.h
	g++ $(CXXFLAGS) pa5list.cpp listFuncs.o -o pa5list

listFuncs.o: listFuncs.cpp listFuncs.h
	g++ $(CXXFLAGS) -c listFuncs.cpp