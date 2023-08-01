public class LinkedList {
    public static class Node{
        int data;
        Node link;
        public Node(int data){
            this.data=data;
            this.link=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data){
        Node newNode=new Node(data);
        newNode.link=head;
        newNode=head;

    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(tail==null){
          head=tail=newNode;
          return;
        }
        tail.link=newNode;
        tail=newNode;
        tail.link=null;
        
    }
    public void print(){
     Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+"  ");
            temp=temp.link;
        }
        System.out.println();
    }
    public void add(int data,int index){
        Node temp=head;
         Node temp2 =head;
       for(int i=0;i<index;i++){
        temp=temp2;
        temp2=temp2.link;
       }
      
       Node newNode = new Node(data);
       temp.link=newNode;
       newNode.link=temp2;
    }
    public int size(){
       Node temp=head;int ctr=0;
        while(temp!=null){
            ctr++;
            temp=temp.link;
        }
        return ctr;
    }
     public void removeFirst(){
     head=head.link;
    }
     public void removeLast(){
    Node temp=head;
    while(temp.link!=tail){
        temp=temp.link;
    }temp.link=null;
    tail=temp;
    }
    public int search(int data){
     Node temp=head;int ctr=0;
      return searchRecursive(data,temp,ctr);
    }
      public int searchRecursive(int data,Node temp,int ctr){
   if(temp==null){
    return -1;
   }
   if(temp.data==data)
   return ctr;
    return searchRecursive(data,temp.link,ctr+1);
    }
     public Node getNode(int index){
        Node temp=head;
      for(int i=0;i<size();i++){
        if(index==i)
        return temp;
        temp=temp.link;
      }
      return null;
      
    }
     public int get(int index){
        if(getNode(index)==null)
        return -1;
        return getNode(index).data;  
    }
    public void reverse(){
        int si=0,ei=size()-1;
        while(si<=ei)
        {
            int temp=getNode(ei).data;
            getNode(ei).data=getNode(si).data;
            getNode(si).data=temp;
            si++;
            ei--;
        }
    }
    public void reverseOptimized(){
      Node prevNode=null;Node currNode=tail=head;Node NextNode;

        while(currNode!=null)
        {
           NextNode=currNode.link;
           currNode.link=prevNode;
           prevNode=currNode;
           currNode=NextNode;
        }
       head=prevNode;
    }
     public void remove(int index){
     Node prev=head,curr=head.link.link;
     for(int i=0;i<index-1;i++)
     {
        prev=prev.link;
        curr=curr.link;
     }
     prev.link=curr;
     }
          public void removeNthLast(int index){
            remove(size()-index);
          }
    public static void main(String ags[]){
        LinkedList ll=new LinkedList();
          ll.addLast(1);
          ll.addLast(2);
          ll.addLast(3);
          ll.addLast(4);
          ll.addLast(5);
          ll.addLast(7);
          ll.add(6,5);
       ll.removeNthLast(4);
         ll.print();
     
        
    }
    
}
