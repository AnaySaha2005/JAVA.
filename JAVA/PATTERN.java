public class PATTERN {
    public static void main(String[] args) {
     /**
        //pattern 1
        int c=6;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<=i;j++)
            System.out.print("*");
           for(int k=0;k<c;k++)
            System.out.print(" ");
            c-=2;
            for(int j=0;j<=i;j++)
            System.out.print("*");
            System.out.println();
        }
        
         for(int i=3;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            System.out.print("*");
           c+=2;
            for(int k=0;k<c;k++)
            System.out.print(" ");
           
            for(int j=0;j<=i;j++)
            System.out.print("*");
            System.out.println();
        }
        */
        int c=1;
           for(int i=0;i<5;i++)
        {
              if(i%2==0){
               c=1;
            }
            for(int j=0;j<=i;j++)
            { 
                    System.out.print(c);
                  if(c==1){
                  c=0;
                  }
                 else c=1;
                 }
                 System.out.println();
        }
    
    }
} 
