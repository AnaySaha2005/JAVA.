import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class printAllBinaryNums {
    public static void main(String[] args) {
        int n=5;
        getBinNum(n);
    }

    public static void getBinNum(int n) {
        Stack<Integer>s=new Stack<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);

        }
        while(!q.isEmpty()){
            int temp=q.remove();
            while(temp!=0){
                if(temp%2==0){
                    s.push(0);
                }
                else s.push(1);
                temp/=2;
            }
            int num=0;
            while(!s.isEmpty()) {
                num = num * 10 + s.pop();
            }
            System.out.print(num+"  ");
            }
        }
    }

