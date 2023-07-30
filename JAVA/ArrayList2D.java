import java.util.*;
public class ArrayList2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
         ArrayList<Integer> list1=new ArrayList<>();
         list1.add(2);
         list1.add(4);
         list1.add(6);
         list1.add(8);
    
          ArrayList<Integer> list2=new ArrayList<>();
         list2.add(1);
         list2.add(2);
         list2.add(3);
         list2.add(4);
     
         ArrayList<Integer> list3=new ArrayList<>();
         list3.add(3);
         list3.add(6);
         list3.add(9);
         list3.add(12);
              mainList.add( list2);
              mainList.add( list1);
              mainList.add( list3);
             
              for(int i=0;i<mainList.size();i++)
            {  ArrayList <Integer>currList=new ArrayList<>(mainList.get(i)) ;
              for(int j=0;j<currList.size();j++)
              System.out.print(currList.get(j)+"    ");
                  System.out.println();
              }
              System.out.println(mainList);
    }
}
