import java.util.Stack;

public class StockSpan {
    public static void StockSpanFinder(int stock[],int span[]){
        int n=stock.length;Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty()&& stock[s.peek()]<stock[i]) {
                s.pop();
            }
                if(s.isEmpty())
                    span[i]+=i+1;
                else span[i]=i-s.peek();
                s.push(i);

        }
    }
    public static void main(String[] args) {
        int stock[]={100,80,60,70,60,85,100};
        int span[]= new int[stock.length];
        StockSpanFinder(stock,span);
        for(int i=0;i<stock.length;i++)
            System.out.print(span[i]+"  ");
    }
}
