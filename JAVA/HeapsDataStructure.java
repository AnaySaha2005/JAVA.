import java.util.ArrayList;
public class HeapsDataStructure{
static class Heaps {
    ArrayList<Integer> heap;

    Heaps() {
        heap = new ArrayList<>();
    }

    public void add(int data) {
        heap.add(data);
        if (heap.size() <= 1)
            return;
        int idx = heap.indexOf(data);
        int pidx = (idx - 1) / 2;
        while (heap.get(idx) < heap.get(pidx)) {
            int temp = heap.get(idx);
            heap.set(idx, heap.get(pidx));
            heap.set(pidx, temp);
            idx = pidx;
            pidx = (idx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public void print() {
        System.out.println(heap);
    }

    public void remove() {
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);

    }

    private void heapify(int root) {
        int rootleft = root * 2 + 1, rootright = root * 2 + 2, minidx = root;
        if (rootleft < heap.size() && heap.get(minidx) > heap.get(rootleft)) {
            minidx = rootleft;
        }
        if (rootright < heap.size() && heap.get(minidx) > heap.get(rootright)) {
            minidx = rootright;
        }
        if (minidx != root) {
            int temp = heap.get(root);
            heap.set(root, heap.get(minidx));
            heap.set(minidx, temp);
            heapify(minidx);
        }

    }
}

    public static void main(String[] args) {
        Heaps hp=new Heaps();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        hp.add(6);
        hp.print();
        hp.remove();
        hp.print();
    }
}
