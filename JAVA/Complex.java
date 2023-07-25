import java.util.*;
class Complex
{ int a,ai,b,bi;
    public static void main(String[] args) {
       Complex ob =new Complex();
       
       ob.input();
       ob.sum();
       ob.diff();
       ob.mult();
    }
   public void input()
    {
         Scanner sc=new Scanner (System.in);
         System.out.println("Enter the first number :");
         a=sc.nextInt();ai=sc.nextInt();
         System.out.println("Enter the second number :");
         b=sc.nextInt();bi=sc.nextInt();
    }
    public void sum()
    {
        System.out.println("The sum of the complex numbers is "+(a+b)+"+"+(ai+bi)+"i");
    }
     public void diff()
    {
        System.out.println("The difference of the complex numbers is "+(a-b)+" "+(ai-bi)+"i");
    }
     public void mult()
    {
        System.out.println("The product of the complex numbers is "+(a*b+ai*bi)+"+"+(ai*b+bi*a)+"i");
    }
}