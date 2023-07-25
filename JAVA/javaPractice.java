import java.util.Scanner;
/**
 * This is JavaDoc Test
 * @author Anay Saha
 * @version 3.0
 * @since 200523
 *
 */ 
 public class javaPractice  {
  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float a,b,c;
        System.out.print("enter price of pen :");
        a=(float) sc.nextDouble();
         System.out.print("\nenter price of pencil :");
         b=(float) sc.nextDouble();
          System.out.print(" \nenter price of eraser :");
          c=(float) sc.nextDouble();
          float s=a+b+c;
          s=(float)(s+s*0.18);
          System.out.println("\nThe total bill amount is including GST :"+s);

    }
    }
     
    
    
    

