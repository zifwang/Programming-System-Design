import java.awt.Point;

/**
   Example of a class with toString overridden
   from Object superclass.
*/

public class Person {

   private String name;
   private int favoriteNumber;
   private Point geoCoord;    // mutable field

   public Person(String name, int favoriteNumber, 
                 int lat, int longitude) {
      this.name = name;
      this.favoriteNumber = favoriteNumber;
      this.geoCoord = new Point(lat, longitude);
   }

   public String toString() {
      return "Person[name=" + name
         +",favoriteNumber=" + favoriteNumber
         +",geocoord=" + geoCoord  // calls Point toString
         +"]";
   }


   // mutator
   public void setFavoriteNumber(int newFav) {
      favoriteNumber = newFav;
   }

   // mutator
   public void move(int changeInLat, int changeInLong) {
      geoCoord.translate(changeInLat, changeInLong);
   }

}
