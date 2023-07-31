import java.util.ArrayList;

public class PairSum {
    public static boolean check(ArrayList<Integer> list,int target){
        int pivot=0;
        while(list.get(pivot)<list.get(pivot+1)){
            pivot++;
        }
   for(int i=0;i<=pivot;i++){
       list.add(list.get(i));
       }
     for(int i=pivot;i>=0;i--){
       list.remove(i);
      
   }
    
   int lp=0,rp=list.size()-1;
   while(lp<rp)
   {
    if(list.get(lp)+list.get(rp)==target)
    return true;
     if(list.get(lp)+list.get(rp)<target)
    lp++;
    else rp--;

    }
    return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        
        System.out.println(check(list, 16));
      
    }
    
}
