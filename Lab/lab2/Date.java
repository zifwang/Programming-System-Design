// Read From Console
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Date{
	public static void main(String[] args){

	GregorianCalendar someDay = new GregorianCalendar(1995,0, 20);
    
    String Month = String.valueOf(someDay.get(GregorianCalendar.MONTH)+1);
    
    String Day =  String.valueOf(someDay.get(GregorianCalendar.DAY_OF_MONTH));
    String Year =  String.valueOf(someDay.get(GregorianCalendar.YEAR));
    
    System.out.println(Month + "/" + Day + "/" + Year);
    
    someDay.add(GregorianCalendar.DAY_OF_MONTH, 20);
    
    String Month1 = String.valueOf(someDay.get(GregorianCalendar.MONTH)+1);
    
    String Day1 =  String.valueOf(someDay.get(GregorianCalendar.DAY_OF_MONTH));
    String Year1 =  String.valueOf(someDay.get(GregorianCalendar.YEAR));
    
    System.out.println(Month1 + "/" + Day1 + "/" + Year1);
        
	}
}