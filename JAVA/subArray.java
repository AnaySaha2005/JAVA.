import java.util.Scanner;

public class subArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int sum = 0, tempo = 0, prefix[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                prefix[i] += a[j];
            }
        }
        System.out.println(" the subarrays are :");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                 System.out.print("* ");
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }
                  System.out.println();
            }
        }
           //using prefix sum concept
           for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tempo = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (tempo > sum) {
                    sum = tempo;
                }
                tempo = 0;
            }
        }
        //using brute force concept
         for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                  for(int k=1;k<=j;k++)
                  {
                    tempo+=a[k];
                  }
                if (tempo > sum) {
                    sum = tempo;
                }
                tempo = 0;
            }
        }
        //using kadan's algorithm
        for(int i=0;i<n;i++)
        {
           tempo+=a[i];
           if(tempo<0)
           tempo=0;
           if(tempo>sum)
           sum=tempo;

        }
        System.out.println("the max sum is :" + sum);
    }
}
