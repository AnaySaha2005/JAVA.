import java.util.Scanner;

public class selectionSort { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
          selectionsort(a, n);
      
           System.out.println("the arranged array:");
        for (int  i = 0; i < n; i++)
           System.out.print(a[i]+"   ");
    
      }
    public static void selectionsort(int a[],int n)
{
          int min=a[0],i,j,pos=0,tempo;
           for( i=0;i<n;i++)
           {
            min=a[i];
            for(j=i;j<n;j++)
            {
                if(min>a[j])
                {
                    min=a[j];
                    pos=j;
                }
            }
            tempo=a[i];
            a[i]=min;
            a[pos]=tempo;
           }
           
        }
}

