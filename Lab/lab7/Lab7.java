import java.util.*;

public class Lab7{

	// String1UpToN
	public static String string1UpToN(int n) {
  		return RAppendUpTo("",1,n);
	}
	// Helper function RAppendUpto for string1UpToN
	private static String RAppendUpTo(String strSoFar, int i, int n){
  		if(i > n){
    		return strSoFar.substring(0,strSoFar.length()-1);
  		}
  		else{
    		strSoFar = strSoFar + i + " ";
    		return RAppendUpTo(strSoFar,i+1,n);
  		}
	}

	// fastExpon function use idea: x^(n) = (x^(n/2))^2
	public static int fastExpon(int x, int n) {
  		if(n%2 == 0){
    		return exponSqrt(x,n/2)*exponSqrt(x,n/2);
  		}else{
    		return exponSqrt(x,n/2)*exponSqrt(x,n/2)*exponSqrt(x,1);
  		}
  
	}
	// Helper function for fastExpon
	private static int exponSqrt(int x, int m){
  		if(m == 0){
    		return 1;
  		}else{
    		return x*exponSqrt(x,m-1);
  		}
	}

	public static int longestWordLen(String words) {
  		Scanner sc = new Scanner(words);
  		return findLongest(sc,0);
	}
	private static int findLongest(Scanner sc, int longest){
  		if(!sc.hasNext()){
    		return longest;
  		}	
  		else{
  			String subWord = sc.next();
  			// System.out.println(subWord);
    		if(longest < subWord.length()){
      			longest = subWord.length();
      			return findLongest(sc, longest);
    		}
    		else{
      			return findLongest(sc, longest);
    		}
  		}
	}
	// Main
	public static void main(String[] args){
		
		if(args[0].equals("longestWordLen")){
			System.out.println(longestWordLen("a"));
		}
	}
}