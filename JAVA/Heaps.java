import java.util.ArrayList;

public class Heaps {
    ArrayList<Integer> heap;
    Heaps(){
        heap=new ArrayList<>();
    }
    public void addminHeap(int data){
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
    public void addmaxHeap(int data){
        heap.add(data);
        if(heap.size()<=1)
            return;
        int idx=heap.indexOf(data);
        int pidx=(idx-1)/2;
        while(heap.get(idx)>heap.get(pidx)){
            int temp=heap.get(idx);
            heap.set(idx,heap.get(pidx));
            heap.set(pidx,temp);
            idx=pidx;
            pidx=(idx-1)/2;
        }
    }
    public int peek(){
        return heap.get(0);
    }
    public void print(){
        System.out.println(heap);
    }
    public int remove(){
        int a=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
       heapifymin(0);
          return a;
        }

    public void heapifymin(int root) {
        int rootleft=root*2+1,rootright=root*2+2,minidx=root;
        if(rootleft<heap.size()&&heap.get(minidx)>heap.get(rootleft)){
            minidx=rootleft;
        }
        if(rootright<heap.size()&&heap.get(minidx)>heap.get(rootright)){
            minidx=rootright;
        }
        if(minidx!=root){
            int temp=heap.get(root);
            heap.set(root,heap.get(minidx));
            heap.set(minidx,temp);
            heapifymin(minidx);
        }

    }
    public void heapifymax(int root) {
        int rootleft=root*2+1,rootright=root*2+2, maxidx =root;
        if(rootleft<heap.size()&&heap.get(maxidx)<heap.get(rootleft)){
            maxidx=rootleft;
        }
        if(rootright<heap.size()&&heap.get(maxidx)<heap.get(rootright)){
            maxidx =rootright;
        }
        if(maxidx !=root){
            int temp=heap.get(root);
            heap.set(root,heap.get(maxidx));
            heap.set(maxidx,temp);
            heapifymin(maxidx);
        }

    }
    public void heapSort(){
        int a[]=new int[heap.size()],ctr=heap.size()-1;
        for(int i=heap.size()/2;i>=0;i--){
            heapifymaxInRange(ctr--,0);
            heap.add(heap.get(0));
            heap.remove(0);
        }

    }

    public void heapifymaxInRange(int i,int root) {
        int rootleft=root*2+1,rootright=root*2+2, maxidx =root;
        if(rootleft<i &&heap.get(maxidx)<heap.get(rootleft)){
            maxidx=rootleft;
        }
        if(rootright<i&&heap.get(maxidx)<heap.get(rootright)){
            maxidx =rootright;
        }
        if(maxidx !=root){
            int temp=heap.get(root);
            heap.set(root,heap.get(maxidx));
            heap.set(maxidx,temp);
            heapifymin(maxidx);
        }

    }

    public boolean isEmpty(){
        return heap.size()==0;
    }


    public static void main(String[] args) {
        Heaps hp=new Heaps();


        hp.addmaxHeap(4);
        hp.addmaxHeap(5);
        hp.addmaxHeap(6);
        hp.addmaxHeap(10);
        hp.addmaxHeap(2);
        hp.addmaxHeap(3);
        hp.print();
        hp.heapSort();
        while (!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
