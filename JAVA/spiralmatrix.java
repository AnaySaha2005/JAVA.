import java.util.Scanner;

public class spiralmatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
        for(int j=0;j<n;j++)
            a[i][j] = sc.nextInt();
          int i=0,j=0,c=n-1,r=n-1,count =0,check =0;
          if(n%2==0)
          check=n/2 -1;
          else check=(n+1)/2-1;
          while(c!=check)
          {
            j=i;
            count=i;
            while(j<=r)
            {
                System.out.print(a[i][j++]+"   ");
            }
            j=r;
            if(j==r){
                while(i!=c){
                System.out.print(a[++i][j]+"   ");
                }
            }
            if(i==c){
                while(j!=count){
                    
                System.out.print(a[i][--j]+"   ");
                }
            }
            if(j==count){
                while(i!=count+1){
                    
                System.out.print(a[--i][j]+"   ");
                }
            }
            c--;r--;
          }
    }

    
}
