import java.util.ArrayList;

public class LEETCODE {
  
    public static int majorityElement(int[] a) {
        int val=0,prevcount=0,recentcount=0,n=a.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                if(a[i]==a[j])
                recentcount++;
            }
            if(recentcount>prevcount)
           { val=a[i];
            prevcount=recentcount;
        }
            recentcount=0;
            
            }
            return val;
        }
        public static void rotate(int[] a, int k) {
          ArrayList <Integer>arr =new ArrayList<Integer>();
          for(int i=0;i<a.length;i++)
          arr.add(a[i]);
          while(k!=0)
          {
            arr.add(0,arr.get(a.length-1));
            k--;
          }
           for(int i=0;i<a.length;i++)
            a[i]=arr.get(i);
        }
        public static  int canCompleteCircuit(int[] gas, int[] cost) {
         int n=gas.length;
          for(int i=0;i<n;i++){
          int pos=i,Gas=gas[i];
          for(int j=0;j<n;j++){
            if(Gas-cost[pos]<0)
            break;
            if(pos==n-1){
              Gas+=gas[0]-cost[pos];
              pos=0;
            }
            else{
              Gas+=gas[pos+1]-cost[pos];
              pos++;}
              if(Gas<=0){
                break;
              }
              if(pos==i){
               
                 
                return i;
              }
              }
            }
            return -1;
          }

         
        
    
        public static void main(String[] args) {
            int gas1[]={2,3,4};int cost1[]={3,4,3};
             int gas2[]={1,2,3,4,5};int cost2[]={3,4,5,2,1};
                   int i= canCompleteCircuit(gas1, cost1);
              System.out.println(i);
            
        }
      }
    
    
    

    

