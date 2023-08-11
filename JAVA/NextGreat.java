import java.util.Stack;

public class NextGreat {
    public static void NextGreaterElement(int arr[],int ge[]){
        Stack<Integer> s=new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
           while(!s.isEmpty()&&arr[s.peek()]<arr[i])
           {
               s.pop();
           }
               if(s.isEmpty()){
                   ge[i]--;
               }
           else ge[i]=arr[s.peek()];
           s.push(i);
        }

    }
    public static void main(String[] args) {
        int a[]={6,8,0,1,3};int ge[]=new int[a.length];
        NextGreaterElement(a,ge);
        for(int i=0;i<a.length;i++)
            System.out.print(ge[i]+"  ");
    }
}
