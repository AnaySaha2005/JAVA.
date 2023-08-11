import java.util.Deque;
import java.util.LinkedList;
public class DequeImplementaion {
    public static class QueueDeque {
        public Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            if(dq.isEmpty()) {
                System.out.println("empty");
                System.exit(0);

            }
            return dq.removeFirst();
        }

        public int peek() {
            if(dq.isEmpty()) {
                System.out.println("empty");
                System.exit(0);

            }
            return dq.getFirst();
        }

    }

    public static class StackDeque{
        public Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addFirst(data);
        }

        public int pop() {
            if(dq.isEmpty()) {
                System.out.println("empty");
                System.exit(0);

            }
            return dq.removeFirst();
        }

        public int peek() {
            if(dq.isEmpty()) {
                System.out.println("empty");
                System.exit(0);

            }
            return dq.getFirst();
        }

    }

}

class QueueUsingDQ  {
    public static void main(String[] args) {
        DequeImplementaion.QueueDeque q = new DequeImplementaion.QueueDeque();
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.peek());

    }
}
class StackUsingDeque{
    public static void main(String[] args) {
        DequeImplementaion.StackDeque s= new DequeImplementaion.StackDeque();
        s.push(1);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
