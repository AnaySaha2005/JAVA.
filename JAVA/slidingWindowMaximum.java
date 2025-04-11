
import java.util.*;
public class slidingWindowMaximum {
    static class info implements Comparable<info>{
        int idx;
        int data;
        info(int data,int idx){
            this.data=data;
            this.idx=idx;
        }

        @Override
        public int compareTo(info a) {
            return this.data-a.data;
        }
    }
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7},k=3;

        PriorityQueue<info>pq=new PriorityQueue<>(Comparator.reverseOrder());
        int window[]=new int[a.length-k+1];
        for(int i=0;i<k;i++){
            pq.add(new info(a[i],i));
        }
        window[0]=pq.peek().data;
        for(int i = k; i< a.length; i++){
            while(pq.size()!=0&&pq.peek().idx<=i-k)
                pq.remove();
            pq.add(new info(a[i],i));
            window[i-k+1]=pq.peek().data;

        }
        for(int i = 0; i< window.length; i++)
            System.out.println(window[i]);

    }
}
