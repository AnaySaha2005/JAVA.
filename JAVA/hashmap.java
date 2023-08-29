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
      private int  n;
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

    private Node getPair(k key, int bucketidx){
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
    public LinkedList<k> keySet() {
     LinkedList<k>keys=new LinkedList<>();
          for(int i=0;i<size;i++)
          {LinkedList<Node>ll=bucket[i];
              for(Node node:ll)
                  keys.add(node.key);
          }
          return keys;
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
         Node node= getPair(key,bucketidx);
         if(node!=null){
             node.value=value;
             return;
         }

         bucket[bucketidx].add(new Node(key,value));
       double lambda=(double)bucket[bucketidx].size()/size;
         if(lambda>2)
           rehash();
         n++;
      }
      public v remove(k key){
          int bucketidx=hashing(key);
          for(int i=0;i<bucket[bucketidx].size();i++){
              Node node=bucket[bucketidx].get(i);
              if(node.key==key){
                  bucket[bucketidx].remove(i);
                  n--;
                  return node.value;
              }
          }
          return null;
      }
      public boolean isEmpty(){
          return n==0;
      }
       public void print() {

    }
    public v get(k key) {
          int bucketidx=hashing(key);
          for(Node node:bucket[bucketidx])
              if(node.key==key)
                  return node.value;
          return null;

    }
    public static void main(String[] args) {
        hashmap<String,Integer>hm=new hashmap<>();
        hm.put("Anay",2);
        hm.put("Shrija",3);
        LinkedList<String>ll=hm.keySet();
        for (int i=0;i<ll.size();i++) {
            System.out.println(ll.get(i));
        }
        System.out.println(hm.get("Anay"));

    }




}


