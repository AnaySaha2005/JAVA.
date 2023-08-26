import java.util.*;
public class hashmap <k,v>{
    private  class Node {
        k key;
        v value;

        Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }
       private LinkedList<Node>[] bucket ;
       private int size;
      public hashmap(){
          size=4;
          bucket=new LinkedList[4];
          for(int i=0;i<size;i++)
              bucket[i]=new LinkedList<>();
      }
    private int hashing(k key){
        return Math.abs(key.hashCode())%size;
      }

    private Node getKey(k key,int bucketidx){
        for(int i=0;i<bucket[bucketidx].size();i++){
            Node node=bucket[bucketidx].get(i);
            if(node.key==key)
                return node;
        }
        return null;
    }
    private void rehash() {
     LinkedList<Node>[] tempbucket =bucket;
     bucket=new LinkedList[size*2];
        for(int i=0;i<size*2;i++){
            bucket[i]=new LinkedList<>();
        }

     for(int i=0;i<size;i++){
         bucket[i]=tempbucket[i];
     }
         size*=2;
    }
    //ACCESSIBLE FUNCTIONS BY THE USER
    public void print() {
          for(int i=0;i<size;i++)
          {
             for(int j=0;j<bucket[i].size();j++)
             {
                 Node node=bucket[i].get(j);
                 System.out.print(node.key+","+node.value+"  ");
             }
          }
    }
    public boolean containsKey(k key){
        int bucketidx=hashing(key);
        for(int i=0;i<bucket[bucketidx].size();i++){
            Node node=bucket[bucketidx].get(i);
            if(node.key==key)
                return true;
        }
        return false;
    }
    public void put(k key,v value){
        int bucketidx=hashing(key);
         Node node=getKey(key,bucketidx);
         if(node!=null){
             node.value=value;
             return;
         }

         bucket[bucketidx].add(new Node(key,value));
       double lambda=(double)bucket[bucketidx].size()/size;
         if(lambda>2)
           rehash();
      }
    public static void main(String[] args) {
        hashmap<String,Integer>hm=new hashmap<>();
        hm.put("Anay",2);
        hm.put("Shrija",3);
        hm.put("ABC",4);
        hm.put("XYZ",5);
        hm.put("XYQ",6);
        hm.print();

    }
}


