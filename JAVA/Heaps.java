import java.util.ArrayList;

public class Heaps {
    ArrayList<Integer> heap;
    Heaps(){
        heap=new ArrayList<>();
    }
    public void add(int data){
        heap.add(data);
        if(heap.size()<=1)
            return;
        int idx=heap.indexOf(data);
        int pidx=(idx-1)/2;
        while(heap.get(idx)<heap.get(pidx)){
            int temp=heap.get(idx);
            heap.set(idx,heap.get(pidx));
            heap.set(pidx,temp);
            idx=pidx;
            pidx=(idx-1)/2;
        }
    }
    public void print(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        Heaps hp=new Heaps();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        hp.add(1);
        hp.print();
    }
}
