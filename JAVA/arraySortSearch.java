import java.util.Scanner;

public class arraySortSearch {
    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of array");
        int n=sc.nextInt();
        int a[]=new int[n];int temp=0;
        System.out.println("enter the elements of array");
             for(int i=0;i<n;i++)
             a[i]=sc.nextInt();
              
              for(int i=0;i<n;i++)
              {for (int j=0;j<n-1;j++)
                {
                    if(a[j]>a[j+1])
                   { temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }

                }
            }
            System.out.println("THE ARRAGED ELEMENTS ARE ");
             for(int i=0;i<n;i++)
             System.out.print(a[i]+" ");
             System.out.println();
             System.out.println("enter the element to search");
             int s=sc.nextInt();

             //USING LINEAR SEARCH CONCEPT
         /*    for(int i=0;i<n;i++)
               if(a[i]==s)
                {
               System.out.println("element present at "+(i+1)+"position");
               System.exit(0);
              }
              System.out.println("element not present");
              */
              
              // USING BINARY SEARCH CONCEPT 

              int pos=-1,finall =n,initial=0;
              for(int i=0;i<n;i++)
              {
                if(a[(finall+initial)/2]<s)
                 initial =(finall+initial)/2;
                    if(a[(finall+initial)/2]>s)
                 finall  =(finall+initial)/2;
                 if(a[(finall+initial)/2]==s)
                 {
                    pos=(finall+initial)/2;
                    
                 }
              }  System.out.println( "ELEMENT IS PRESENT AT Hereeee"+pos);
              
    }
    
}
