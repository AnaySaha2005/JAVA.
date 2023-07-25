import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortCountingSort {
  public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       // System.out.println("enter the length of array");
        //int n = sc.nextInt();
        int a[] = {1,4,1,3,2,4,3,7};
        int n=a.length;
       // System.out.println("enter the elements of array");
       // for (int i = 0; i < n; i++)
         //   a[i] = sc.nextInt();
          
         /*  int val=0;
          for(int i=0;i<n-1;i++)
           { val=a[i+1];
            int j=i;
                while( j!=-1 && a[j]>val)
                {
                    a[j+1]=a[j];
                    j--;
                }
                 j++;
                 a[j]=val;
            
        }
        */
      count(a,n);
           System.out.println("the Arranged array :");
        for (int i = 0; i < n; i++)
          System.out.print(a[i]+"  ");
              
}
public static void count(int a[],int n)
{ 
  int max=a[0];
  for(int i=0;i<n;i++)
  {
      if(max<a[i])
      max=a[i];
  }
  int freq[]=new int[max+1];
  for(int i=0;i<n;i++)
  {
     ++freq[a[i]];
  }
int ctr=0;

for(int i=0;i<=max;i++)
  {     while(freq[i]!=0)
     {
      a[ctr]=i;
      ctr++;
      freq[i]--;
     }
  }
}
}
