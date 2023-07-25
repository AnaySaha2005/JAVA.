import java.util.*;
class Leap{
    public static void main(String[] args) {
          Scanner sc=new Scanner (System.in);
        System.out.println("Enter the year for checking");
        int n=sc.nextInt();
        if(n%4==0)
        {
            if(n%100!=0)
            System.out.println("Leap Year");
            else if (n%400==0)
            System.out.println(" Leap year");
            else System.out.println("not a leap year");
        }
        else  System.out.println("not a leap year");
    }
}