public class TilingRecursion {
    public static int tileup(int n){
      
        if(n==0||n==1)
        return 1;
         int a=tileup(n-1);
         int b=tileup(n-2);
        return a + b;
    }
public static void main(String[] args) {
    System.out.println(tileup(3));
}
}
