Name: Zifan Wang, Ziran Shi
Assignment: Lab10
Date: 03/21/2019

Short Answer Problem:
Question 1.1 The TreeMap inside Concord keeps the entries in order. Why can't we just use its iterator or a for-each loop to visit the values in order? (Hint: there's iterator code like this in the print method of Concord.)
The TreeMap is ordered by the keyvalue. 

Question 2.1 Report to the TA five of the most frequently occurring words in the English language based on what you find in the results. (It doesn't have to be the absolute top five words.)
melville.txt: the -> 603 occurances. i -> 519. to -> 432. and -> 376. of -> 359
poe.txt: the -> 168 occurances. i ->109. of -> 75. a -> 62.and -> 62.
Top five occurances: the, i, to, of, and

Question 2.2 For each file report to the TA the most frequently occurring word in that file that is not one of the most frequently occurring words in the English language. For each of your answers, tell why it occurs so frequently in this file.
poe.txt: a. there are lots of descriptions about thing.

Question 2.3 In what order do words that have the same frequency appear in your output? (Look at the last part of your output file to see many examples of this.) Why? (Hint: look at the documentation of the sort method you called.) Would they be in a different order if we had used a HashMap?
They are in the alphabet order. The reason is that the map we used is the TreeMap it in the order of key. As a result, the small alphabet will be ordered before the large alphabet.
No. Since the Map is not in the order.s

Question 3.1 Why don't we need to save the LargeWordPred object in a variable (second call above)?
Because the testLarge is a class to implement interface to threshold word in length. We do not want to access or modify any data in the Predicate class. The only thing we want is the return true or false.

Question 3.2 Using your results from your code and experiments above, answer the following questions: What are the longest non-hyphenated words occurring in each of melville.txt and poe.txt, how long are they, and how many times did each of them occur in the original file?
melville.txt: length 20. cause-indigestion-the 1
poe.txt: length 18. fortunato-although 1 or unneccessarily-but 1
