// example of substrings and assignment on strings

public class StringEx {
   public static void main(String[] args) {
      String name = "Claire";
      String name2 = name;
      // substring args are: startLoc, onePast
      String bearHouse = name.substring(1,5);
      // update name2
      name2 = name2.substring(2,5);
      System.out.println(name + " " + bearHouse + " " + name2 );
   }

}
