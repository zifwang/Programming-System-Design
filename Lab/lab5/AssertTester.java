/**
 * Program used to test Term.java
 * Aim to test assertion
*/

public class AssertTester{
    public static void main(String[] args){
        Term term_1 = new Term();   // init. empty term_1
        System.out.println(term_1.toString()); // print out coeff and expon

        Term term_2 = new Term(2,-2);   // init. term_2 with negative Exp
        System.out.println(term_2.toString()); // print out coeff and expon
    }
}