import java.util.*;
public class QueueProgram {
    public static void QueueInterleave(){
        Queue<Integer>q=new LinkedList<>();
        Queue<Integer>q1=new LinkedList<>();
        Queue<Integer>q2=new LinkedList<>();
        for(int i=0;i<10;i++)
            q.add(i+1);
        int n = q.size();
        for(int i=1;i<=n/2;i++)
            q1.add(q.remove());
        for(int i=1;i<=n/2;i++)
            q2.add(q.remove());
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                q.add(q1.remove());

            }
            else q.add(q2.remove());

        }



    }
    public static void print(Queue<Integer> q){
        int n = q.size();
        for(int i=0;i<n;i++)
            System.out.print(q.remove()+"  ");
    }
    public static void reverse(){
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<10;i++)
            q.add(i+1);
        System.out.println(q);
        Stack<Integer> s=new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){

            q.add(s.pop());
        }
        System.out.println(q);

    }
    public static void reverse(int k,Queue<Integer>q1){
        Queue<Integer>
    }
    public static void main(String[] args) {
      reverse();

    }
}
