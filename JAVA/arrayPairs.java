import java.util.Scanner;

public class arrayPairs {
     public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of array");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("enter the elements of array");
             for(int i=0;i<n;i++)
             a[i]=sc.nextInt();
              System.out.println("the pairs are :");
              for(int i=0;i<n;i++)
              {
                for(int j=i+1;j<n;j++)
                {
                 System.out.print("("+a[i]+","+a[j]+")\t");
                }
              }

    
}
}
