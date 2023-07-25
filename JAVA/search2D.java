import java.util.Scanner;

public class search2D {

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
        for(int j=0;j<n;j++)
            a[i][j] = sc.nextInt();
            int col=0;
            System.out.println("Enter the number to search");
            int num =sc.nextInt();
             for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
               {  if(a[i][j]==num)
                {
                    System.out.println("the number is present");
                    System.exit(0);
                  }
              }
          }
          System.out.println("the number is not present");
    
}
}

