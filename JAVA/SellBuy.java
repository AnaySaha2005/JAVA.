import java.util.Scanner;

public class SellBuy {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
            int profit=0;
          //approach 1
         /*   for(int i=0;i<n;i++)
            {
                for(int j=i;j<n;j++)
                {
                    if(a[j]-a[i]>profit)
                    profit=a[j]-a[i];
                }
            }
            */
            //approach 2
            int min =a[0],min_pos=0;profit =0;
             for(int i=0;i<n;i++)
            {if(a[i]<min)
              { min =a[i];
                min_pos=i;
              }
            }
              for(int i=min_pos+1;i<n;i++)
            {  if(profit<a[i]-min)
                      profit=a[i]-min; 

            }
            if(profit<0)
            profit=0;
            System.out.println("max profit :"+profit);
           
     }
    
}
