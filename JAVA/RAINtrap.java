import java.util.Scanner;

public class RAINtrap {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();int water=0;
           
           
           //normal approach
      /*    for(int i=1;i<n-1;i++)
            {
                if(a[i-1]>a[i]&&a[i]<a[i+1])
                {
                    water+=a[i-1]>a[i+1]?a[i+1]-a[i]:a[i-1]-a[i];
                    a[i]=a[i-1]>a[i+1]?a[i+1]:a[i-1];
                    System.out.println(a[i]);
                }
            }
             for(int i=0;i<n;i++)
             {  for(int j=i;j>=0;j--)
                {
                    for(int k=i;k<n;k++)
                    {
                   if(a[j]>a[i]&&a[i]<a[k])
                {
                    water+=a[j]>a[k]?a[k]-a[i]:a[j]-a[i];
                     a[i]=a[j]>a[k]?a[k]:a[j];
                }
                    }
                }
                 
            } System.out.println( "The volume of water occupied : "+water);
    
         */      
            //auxillary array approaching
            int leftMax[]=new int[n]; int rightMax[]=new int[n],max=0;
            for(int i=0;i<n;i++)
            { for(int j=i;j>=0;j--)
                {   if(a[j]>max)
                    max=a[j];
            }
                  leftMax[i]=max;max=0;
            }
             for(int i=0;i<n;i++)
            { for(int j=i;j<n;j++)
                {   if(a[j]>max)
                    max=a[j];
            }
                  rightMax[i]=max;max=0;
            }
            for(int i=0;i<n;i++)
            { 
                water+=leftMax[i]>rightMax[i]?rightMax[i]-a[i]:leftMax[i]-a[i];
            }
            System.out.println( "The volume of water occupied : "+water);
    
}
}

