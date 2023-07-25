import java.util.Scanner;

public class DecBin {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
       /** TO COVERT BINARY TO DECIMAL
        System.out.println("Enter the Binary digit for conversion");
        int bin=sc.nextInt();
        double num=0,pow=0;
        while(bin!=0)
        {
           num+=Math.pow(2,pow)*(bin%10);
           bin/=10;
           ++pow;
        }
        System.out.println("The number is "+num);

    
    */
    /** TO CONVERT DECIMAL TO BINARY
    System.out.println("Enter the number for convertion ");
    int num=sc.nextInt();String bin="";
    while(num!=0)
    {    bin=Integer.toString(num%2)+bin;
        num=num/2;

    }
    System.out.println(bin);
    */
}
}