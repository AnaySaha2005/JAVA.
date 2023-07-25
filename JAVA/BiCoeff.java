import java.util.*;
class BiCoeff

{
    static int n,r;
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("Enter the prefix and sufix respectively");
         n=sc.nextInt(); r=sc.nextInt();
         System.out.println("The Binomial Coeffcient is : "+ fact(n)/(fact(r)*fact(n-r)));
           System.out.println(fact (n));
    }
    public static int fact(int a)
    {
        if(a==0)
        return 1;
        else  return(fact(a-1)*a);

    }
}
