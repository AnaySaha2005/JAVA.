import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinEffort {
    static class info implements Comparable<info>{
        int data;
        int i;
        int j;
        info(int data,int i,int j){
            this.data=data;
            this.i=i;
            this .j=j;
        }

        @Override
        public int compareTo(info a) {
            if(this.data==a.data){
                return this.j-a.j;
            }
            return a.data-this.data;
        }
    }
    public static void main(String[] args) {
       int a[][]= { { 31, 100, 65, 12, 18 },{ 10, 13, 47, 157, 6 },{ 100, 113, 174, 11, 33 },{ 88, 124, 41, 20, 140 },{ 99, 32, 111, 41, 20 } };
     int p1=0,p2=0;
     int min=a[0][0];
     int n=a.length-1;
     int m=a[0].length-1;
     info prev=new info(min,0,0);
     while(p1!=n||p2!=m){
         PriorityQueue<info>pq=new PriorityQueue<>(Comparator.reverseOrder());
         if(p1-1>=0&&p1-1!=prev.i)
             pq.add(new info(a[p1-1][p2],p1-1,p2));
         if(p2-1>=0&&p2-1!=prev.j)
             pq.add(new info(a[p1][p2-1],p1,p2-1));
         if(p1+1<=n&&p1+1!=prev.i)
             pq.add(new info(a[p1+1][p2],p1+1,p2));
         if(p2+1<=m&&p2+1!=prev.j)
             pq.add(new info(a[p1][p2+1],p1,p2+1));
         prev=new info(a[p1][p2],p1,p2);
         p1=pq.peek().i;
         p2=pq.peek().j;
         min+=pq.peek().data;

     }
        System.out.println(min);
    }
}
