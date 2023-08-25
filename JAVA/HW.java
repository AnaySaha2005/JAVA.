import java.util.*;
public class HW {
    public static void monotone(ArrayList <Integer> list){
        int inc=0,dec=0;
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)>list.get(i+1)){
                dec++;
            }
            else inc++;
            if(dec!=0&inc!=0)
            {
                System.out.println(false);
                      System.exit(0);
            }
        }
        System.out.println(true);

    }
    public static ArrayList<Integer> lonelynumber(ArrayList <Integer> list){
          Collections.sort(list);
        ArrayList <Integer> lonelyGuys=new ArrayList<>();
        if(list.get(1)!=list.get(0)+1)
                lonelyGuys.add(list.get(0));
        if(list.get(list.size()-2)+1!=list.get(list.size()-1))
                lonelyGuys.add(list.get(list.size()-1));
        for(int i=1;i<list.size()-1;i++){
           if(list.get(i)!=list.get(i+1)-1 &&list.get(i)!=list.get(i-1)+1&&list.get(i)!=list.get(i-1)&&list.get(i)!=list.get(i+1))
              lonelyGuys.add(list.get(i));
                }
         return lonelyGuys;
    }
    public static void freq(ArrayList <Integer> list){
        Collections.sort(list);
        int currfreq=0,actualfreq=0,num=0;
        for(int i=0;i<list.size();i++){
          for(int j=0;j<list.size();j++){
          if(list.get(i)==list.get(j)){
            currfreq++;
          }}
           if(currfreq>actualfreq){
            actualfreq=currfreq;
            num=list.get(i);
           }
           currfreq=0;
    }
       System.out.println(num);
    }
    public static void beautifulArrayList(int n){
        ArrayList <Integer> list=new ArrayList<>();
        int p1=0,p2=n-1,a[]=new int[n];
        for(int i=0;i<n;i++){
         a[i]=i+1;
        }
         while(p1<=p2){
            list.add(a[p1]);
            list.add(a[p2]);
            p1++;p2--;
         }
      if(n%2!=0)
      list.remove(list.size()-1);
        System.out.println(list);
    }

    public static void main(String[] args) {
        {
          beautifulArrayList(7);
     
        }
    }
}
