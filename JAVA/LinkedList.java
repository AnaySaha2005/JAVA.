public class LinkedList {
  public static class Node {
    int data;
    Node link;

    public Node(int data) {
      this.data = data;
      this.link = null;
    }
  }

  public static Node head;
  public static Node tail;

  public void addFirst(int data) {
    Node newNode = new Node(data);
    newNode.link = head;
    newNode = head;

  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    if (tail == null) {
      head = tail = newNode;
      return;
    }
    tail.link = newNode;
    tail = newNode;
    tail.link = null;

  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "  ");
      temp = temp.link;
    }
    System.out.println();
  }

  public void add(int data, int index) {
    Node temp = head;
    Node temp2 = head;
    for (int i = 0; i < index; i++) {
      temp = temp2;
      temp2 = temp2.link;
    }

    Node newNode = new Node(data);
    temp.link = newNode;
    newNode.link = temp2;
  }

  public int size() {
    Node temp = head;
    int ctr = 0;
    while (temp != null) {
      ctr++;
      temp = temp.link;
    }
    return ctr;
  }

  public void removeFirst() {
    head = head.link;
  }

  public void removeLast() {
    Node temp = head;
    while (temp.link != tail) {
      temp = temp.link;
    }
    temp.link = null;
    tail = temp;
  }

  public int search(int data) {
    Node temp = head;
    int ctr = 0;
    return searchRecursive(data, temp, ctr);
  }

  public int searchRecursive(int data, Node temp, int ctr) {
    if (temp == null) {
      return -1;
    }
    if (temp.data == data)
      return ctr;
    return searchRecursive(data, temp.link, ctr + 1);
  }

  public Node getNode(int index) {
    Node temp = head;
    for (int i = 0; i < size(); i++) {
      if (index == i)
        return temp;
      temp = temp.link;
    }
    return null;

  }

  public int get(int index) {
    if (getNode(index) == null)
      return -1;
    return getNode(index).data;
  }

  public void reverse() {
    int si = 0, ei = size() - 1;
    while (si <= ei) {
      int temp = getNode(ei).data;
      getNode(ei).data = getNode(si).data;
      getNode(si).data = temp;
      si++;
      ei--;
    }
  }

  public void reverseOptimized() {
    Node prevNode = null;
    Node currNode = tail = head;
    Node NextNode;

    while (currNode != null) {
      NextNode = currNode.link;
      currNode.link = prevNode;
      prevNode = currNode;
      currNode = NextNode;
    }
    head = prevNode;
  }

  public void remove(int index) {
    Node prev = head;
    if (index == 0)
      head = prev.link;
    if (index == size() - 1)
      tail = getNode(index);
    for (int i = 0; i < index - 1; i++) {
      prev = prev.link;

    }
    prev.link = prev.link.link;
  }

  public void removeNthLast(int index) {
    remove(size() - index);
  }

  public boolean checkPallindrome() {
    int sz = size(), n = sz / 2;
    Node prev = null, curr = head, next;
    while (n > 0) {
      next = curr.link;
      curr.link = prev;
      prev = curr;
      curr = next;
      n--;
    }
    n = sz / 2;
    Node p1 = getNode(n - 1);
    Node p2 = getNode(sz - n);
    int ctr = 0;
    while (p1 != null && p2 != null) {
      if (p1.data == p2.data) {
        ctr++;
      }
      p1 = p1.link;
      p2 = p2.link;
    }
    if (ctr == n)
      return true;
    else
      return false;
  }

  public void checkLoop() {

    Node slow = head, fast = head;

    for (int i = 0;; i++) {
      if (fast == null) {
        System.out.println("LOOP   DOESN'T EXISTS");
        System.exit(0);
      }
      slow = slow.link;
      fast = fast.link.link;
      if (slow == fast) {
        System.out.println("LOOP EXISTS");
        System.exit(0);
      }
      slow = slow.link;
      fast = fast.link;

    }
  }

  public void removeLoop() {

    Node slow = head, fast = head;
    while (fast != null || fast.link != null) {

      slow = slow.link;
      fast = fast.link.link;
      if (slow == fast) {
        break;
      }
    }
    slow = head;
    Node temp = null;
    while (fast != slow) {
      temp = fast;
      fast = fast.link;
      slow = slow.link;
    }
    temp.link = null;
  }

  public Node getMid(Node head) {
    Node slow = head, fast = head;
    while ( fast != null) {
     
      slow = slow.link;
      fast = fast.link.link;
    }
    return slow;
  }

  public Node mergelist(Node left, Node right) {
    Node mergedll = new Node(-1);
    Node temp = mergedll;
    while (left != null && right != null) {
      if (left.data < right.data) {
        temp.link = left;
        left = left.link;
        temp = temp.link;
      } else {
        temp.link = right;
        right = right.link;
        temp = temp.link;
      }

    }
    while (left != null) {
      temp.link = left;
      left = left.link;
      temp = temp.link;
    }
    while (right != null) {
      temp.link = right;
      right = right.link;
      temp = temp.link;
    }
    return mergedll.link;
  }

  public Node mergeSort(Node head) {
    if (head.link == null || head == null) {
      return head;
    }
    Node mid = getMid(head);
    Node rightHead = mid.link;
    mid.link = null;
    Node right = mergeSort(rightHead);

    Node left = mergeSort(head);
    return mergelist(left, right);

  }

  public void ZigZag() {
    int n = size();
    Node p1 = head, p2 = getNode(n/2), prev = null;
   
    while (p2 != null) {
      Node next = p2.link;
      p2.link = prev;
      prev = p2;
      p2 = next;
    }
    p2 = tail;
    if (n % 2 != 0) {
      while (p1 != p2) {
        Node firstnext = p1.link, lastnext = p2.link;
        p1.link = p2;

        p2.link = firstnext;
        p1 = firstnext;

        p2 = lastnext;

      }
      p1.link = null;
    } else {
      while (p1.link != p2) {
     Node firstnext=p1.link,lastnext=p2.link;
     p1.link=p2;
     p2.link=firstnext;
     p1=firstnext;
     p2=lastnext;
      }
      p1.link = p2;
      p2.link = null;
    }

  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    ll.addLast(6);
  
    ll.ZigZag();
    ll.print();

  }

}
