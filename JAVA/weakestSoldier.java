import java.util.PriorityQueue;

public class weakestSoldier {
    public static void main(String[] args) {
        int a[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;
       int i=0;int j=0,soldiers=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        while(i<a.length){
          if(a[i][j]==1)
              soldiers++;
            j++;
           if(j>a[0].length-1){
              pq.add(soldiers*10+i);
               j=0;
               i++;
               soldiers=0;
           }
        }
        for(i=0;i<k; i++){
            System.out.println("row"+pq.remove()%10);
        }
    }
}
