// Read From Console
import java.util.Scanner;
import java.util.Calendar;

public class Birthday3{
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
    
    int age = 0;
    
    if(todayMonth < month){
        System.out.println("Your birthday has not yet happened this year.");
        age = todayYear - year -1;
        System.out.printf("You're %d years old. \n",age);
        
    }
    if(todayMonth == month){
        if(todayDay < day){
            System.out.println("Your birthday has not yet happened this year.");
            age = todayYear - year -1;
            System.out.printf("You're %d years old. \n",age);
        }
        if(todayDay == day){
            System.out.println("Your birthday is today!");
            age = todayYear - year;
            System.out.printf("You're %d years old. \n",age);
        }
        if(todayDay > day){
            System.out.println("Your birthday has already happened this year.");
            age = todayYear - year;
            System.out.printf("You're %d years old. \n",age);
        }
	}
    if(todayMonth>month){
        System.out.println("Your birthday has already happened this year.");
        age = todayYear - year;
        System.out.printf("You're %d years old. \n",age);
    }
        
  }
}