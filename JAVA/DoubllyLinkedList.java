public class DoubllyLinkedList {
    public class Node {
        int data;
        Node link;
        Node prevLink;

        public Node(int data) {
            this.data = data;
            link = null;
            prevLink = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // addminHeap functions
    public void addLast(int data) {
        size++;
        Node node = new Node(data);
        if (head == null) {

            head = tail = node;
            head.prevLink = null;
            tail.link = null;

        } else {
            node.prevLink = tail;
            tail.link = node;
            tail = node;
            tail.link = null;
        }
    }

    public void addFirst(int data) {

        Node node = new Node(data);
        if (head == null) {
            tail = node;
            tail.link = null;
        } else {
            node.link = head;
            head.prevLink = node;
        }
        head = node;
        head.prevLink = null;
    }

    // size function
    public int size() {
        return size;
    }

    // print function
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.link;
        }
        System.out.println();
    }

    public void reversePrint() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.prevLink;
        }
    }

    // revome function
    public void removeFirst() {
        Node temp = head.link;
        head = null;
        head = temp;
        head.prevLink = null;
    }

    public void removeLast() {
        Node temp = tail.prevLink;
        tail = null;
        tail = temp;
        tail.link = null;

    }
//reverse
public void reverse(){
    Node curr=head,prev=null,next;
    while(curr!=null){
      next=curr.link;
      curr.link=prev;
      curr.prevLink=next;
      prev=curr;
      curr=next;
    }
    head=prev;
    head.prevLink=null;
}
    public static void main(String[] args) {
        DoubllyLinkedList dll = new DoubllyLinkedList();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addFirst(0);
        dll.addLast(9);
     
        dll.removeFirst();
        dll.removeLast();
        dll.print();
        dll.reverse();
        dll.print();

    }

}
