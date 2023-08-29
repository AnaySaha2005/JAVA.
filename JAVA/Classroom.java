import java.util.*;
public class Classroom {
    public static void main(String[] args) {
     int a[]={1,2,3};
     int total =0,k=3;

     HashMap<Integer,Integer>map=new HashMap<>();
     int s=0;
     for(int i = 0; i <a.length; i++){
         s+=a[i];
         if(s==k){
             total++;
             map.put(s, map.getOrDefault(s,0)+1);
         }

        else if(map.containsKey(s-k)){
            total=total+map.get(s-k);
         }
       else  map.put(s, map.getOrDefault(s,0)+1);
     }
        System.out.println(total);
    }


}
