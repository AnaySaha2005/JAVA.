import java.util.*;
public class ConnectNRopes {
    public static void main(String[] args) {
        int arr[]={2,3,4,6};
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }
        int sum=0;
        while(!pq.isEmpty()){
            int a=pq.remove();
            if(pq.isEmpty()){
                sum+=a;
                break;
            }
            int b=pq.remove();
            sum+=a+b;
            if(pq.isEmpty()){
                break;
            }
            pq.add(a+b);

        }
        System.out.println(sum);
    }
}
