import java.util.Scanner;

public class PrimeRange {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       System.out.println("Enter the range of numbers");
        int n=sc.nextInt();
   
        System.out.print("The prime numbers in the Range are :");
        for(int i=2;i<=n;i++)
        if(findPrime(i)==true)
        System.out.print(i+"  ");
        
    }
    public static boolean findPrime(int n)
    {
        for(int i =2;i<Math.pow(n,0.5);i++)
        {
            if (n%i==0)
            return false;
        }
        return true;
    }

    
}
