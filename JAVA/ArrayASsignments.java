import java.util.Scanner;

 public class ArrayASsignments {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the elements of array");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();int ctr=0;
          /*  for(int i=0;i<n;i++)
            {
                for(int j=i;j<n;j++)
                if(a[i]==a[j])
                {
                ctr++;
                }
                if (ctr>1)
                {
                    System.out.println("true");
                    break;
                } ctr=0;
            }
            System.out.println("false");
            */
            
          /*System.out.print("Target :");
            int target =sc.nextInt();
            for(int i=0;i<n;i++){
                if(target==a[i]){
                System.out.println("present at position "+1+i);
                System.exit(0);
                }
            }
            System.out.println(-1);
            */
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(a[i]+a[j]+a[k]==0&& i!=j && k!=j && k!=i){
                          System.out.println("["+a[i]+", "+a[j]+", "+a[k]+"] hi");
                        }

                    }
                }
            }
    }


}
