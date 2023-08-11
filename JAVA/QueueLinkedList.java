import java.util.*;
public class QueueLinkedList {
   static public class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            link = null;
        }

    }

    public static Node head = null;

    public static Node tail = null;

    public void add(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        tail.link = temp;
        tail = temp;
        tail.link=null;
    }

    public void remove() {
        if (head == tail && tail == null)
            System.out.println("Empty");
        else
            head = head.link;
    }

    public int peek() {
        return head.data;
    }
 public void print(){
    Node temp=head;
    while(temp!=null){
    System.out.print(temp.data+"  ");
    temp=temp.link;
    }
    System.out.println();
 }
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        Queue<Integer> q1=new LinkedList<>();
        q1.add(0000000000000);
        System.out.println(q1.isEmpty());
        q.add(2);
        q.add(3);
        q.add(6);
        q.add(9);
        q.print();
        q.remove();
        q.print();

    }
}
