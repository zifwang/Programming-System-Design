// Read From Console
import java.util.Scanner;
import java.util.Calendar;

public class Birthday{
	public static void main(String[] args){
    
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your birth month [1..12]: ");
    int month = in.nextInt();
    in.nextLine();
    System.out.print("Enter your birth day of month: ");
    int day = in.nextInt();
    in.nextLine();
    System.out.print("Enter your birth year [4-digit year]: ");
    int year = in.nextInt();
        
    Calendar today = Calendar.getInstance();
    
    int todayMonth = today.get(Calendar.MONTH)+1;
    int todayDay = today.get(Calendar.DAY_OF_MONTH);
    int todayYear = today.get(Calendar.YEAR);
        
    if(todayMonth < month){
        System.out.println("Your birthday has not yet happened this year.");
    }
    if(todayMonth == month){
        if(todayDay < day){
            System.out.println("Your birthday has not yet happened this year.");
        }
        else{
            System.out.println("Your birthday has already happened this year.");
        }
	}
    if(todayMonth>month){
        System.out.println("Your birthday has already happened this year.");
    }
        
  }
}