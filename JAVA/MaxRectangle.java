import java.util.Stack;

public class MaxRectangle {
    public static void maxRecOptimum(int a[]){
        int nsl[]= new int[a.length];
        int nsr[]= new int[a.length];
        getnsr(a,nsr);
        getnsl(a,nsl);int max=0;
        for(int i=0;i<a.length;i++)
        {
            if(max<a[i]*(nsr[i]-nsl[i]-1))
                max=a[i]*(nsr[i]-nsl[i]-1);

        }
    
      System.out.println(max);
    }

    public static void getnsr( int[] a, int[] nsr) {
        Stack<Integer> s = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()] > a[i]) {
                s.pop();

            }
            if(s.isEmpty())
                nsr[i]=6;
           else    nsr[i]=s.peek();

            s.push(i);
        }
    }
    public static void getnsl( int[] a, int[] nsl) {
        Stack<Integer> s = new Stack<>();
        for (int i =0 ; i <a.length; i++) {
            while (!s.isEmpty() && a[s.peek()] > a[i]) {
                s.pop();

            }
            if(s.isEmpty())
                nsl[i]=-1;
            else    nsl[i]=s.peek();

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int a[]={2,1,5,6,2,3},maxAFinal=0,maxATemp=0;
      /*  for(int i=0;i<a.length;i++){
            int pointer1=i,pointer2=i;
            for(int j=i-1;j>=0;j--){
                if(a[j]<a[i])
                    break;
                else pointer1--;

            }
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i])
                    break;
                else pointer2++;

            }
            maxATemp=a[i]*(pointer2-pointer1+1);
            if(maxATemp>maxAFinal)
                maxAFinal=maxATemp;
        }
        System.out.println(maxAFinal);
        */

       maxRecOptimum(a);
    }
}
