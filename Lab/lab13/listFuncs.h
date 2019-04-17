// Name: Zifan Wang
// USC NetID: 9505587296
// CSCI 455 lab13
// Spring 2019


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
/**
 * Linkedlist Node Struct: 
 *    Three Variables: 
 *       1. key: string
 *       2. value: node value
 *       3. next: connection to the next node
 * 
 *    Two Functions:
 *       1. Node(const std::string &theKey, int theValue): Constructor given hashkey and first node value.
 *       2. Node(const std::string &theKey, int theValue, Node *n): Constructor given haskey, first node value and next node.
 */

struct Node {
   std::string key;                                            // string
   int value;                                                  // store value for each node

   Node *next;                                                 // connect to the next node

   Node(const std::string &theKey, int theValue);              // Constructor 1.

   Node(const std::string &theKey, int theValue, Node *n);     // Constructor 2/
};

// def listType tyoe
typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/**
 * Print the given list
 * Arguments:
 *    list: a linkedList
 */
void listPrint(ListType list);

/**
 * Get size of a given linkedList
 * Arguments:
 *    list: linkedList
 * Return:
 *    length: the size of linkedList
 */
int listGetSize(ListType list);

/**
 * Check whether given linkedList is empty
 * Arguments:
 *    list: linkedList
 * Return:
 *    bool type: empty -> true. not empty -> false
 */
bool listIsEmpty(ListType list);

/**
 * Get node of a given target key
 * Arguments:
 *    list: linkedList
 *    target: a string
 * Return:
 *    Node
 */
ListType listGetNode(ListType list, std::string target);

/**
 * Get value of node in a given linkedList with key = target 
 * Arguments:
 *    list: linkedList
 *    target: a string can be matched to key in the node
 * Return:
 *    value: int type. The value at given key in the list
 */
int* listGetValue(ListType list, std::string target);

/**
 * Insert new node before target string
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    key: string
 *    value: value of insert node
 *    target: location to insert
 * Return:
 *    bool: true (if target found) or false (if target not found)
 */ 
bool listInsertBefore(ListType & list, std::string key, int value, std::string target);

/**
 * Insert new node after target string
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    key: string
 *    value: value of insert node
 *    target: location to insert
 * Return:
 *    bool: true (if target found) or false (if target not found)
 */ 
bool listInsertAfter(ListType & list, std::string key, int value, std::string target);

/**
 * Insert new node in the first position of a given linkedList
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    key: string
 *    value: value of insert node
 */ 
void listInsertFront(ListType & list, std::string key, int value);

/**
 * Insert new node in the last position of a given linkedList
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    key: string
 *    value: value of insert node
 */ 
void listAppend(ListType & list, std::string key, int value);

/**
 * Delete node at specific index
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    target: string.
 * If key = match, remove this node and return true
 * If key != match, return false
 * If list is empty, return false
 * Return:
 *    bool: true or false
 */ 
bool listRemove(ListType & list, std::string target);

/**
 * Delete node in the first position of a given linkedList
 * Arguments:
 *    list: a passed-by-reference linkedList
 * Return:
 *    bool: true or false (when list is empty)
 */ 
bool listRemoveFront(ListType & list);

/**
 * Delete node in the last position of a given linkedList
 * Arguments:
 *    list: a passed-by-reference linkedList
 * Return:
 *    bool: true or false (when list is empty)
 */ 
bool listRemoveLast(ListType & list);

/**
 * Change the value in the linkedList by given target string
 * Arguments:
 *    list: a passed-by-reference linkedList
 *    target: string
 *    value: value change to 
 * Return:
 *    true (found target and update value) or false (target not found)
 */
bool listChangeValue(ListType & list, std::string target, int value);


// keep the following line at the end of the file
#endif
