import java.util.TreeSet;

public class Trees {
}
 class TreeBuild{
    public static class Node {
        public int data;
        public  Node leftlink;
        public   Node rightlink;
        public  Node prelink;
        public int count;
        Node(int data) {
            this.data = data;
           leftlink = null;
            rightlink = null;
            prelink=null;
            count=0;
        }
    }

     public static Node pointer;
     public  static Node root;

        public void add(int data){
            if(root==null) {
                root=new Node(data);
                pointer=root;
            }
            else if(data==-1){
               if(pointer.count==0){
                   pointer.leftlink=null;
                   pointer.count++;
               }
               else if(pointer.count==1){
                   pointer.rightlink=null;
                   pointer.count++;
               }
            }
           else if(pointer.count==0)
            {
                pointer.count++;
                Node temp =new Node(data);
                pointer.leftlink=temp;
                temp.prelink=pointer;
                pointer=temp;

            }
           else if(pointer.count==1)
            {
                pointer.count++;
                Node temp =new Node(data);
                pointer.rightlink=temp;
                temp.prelink=pointer;
                pointer=temp;

            }
            else
            {
                pointer=pointer.prelink;
                add(data);

            }


        }

    }

 class TreeBuildRecursive{
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }
    static Node root=null;
      static int idx=-1;
      public Node TreeBuild(int[] a){
          idx++;
          if(a[idx]==-1){
              return null;
          }
          Node newNode= new Node(a[idx]);
          newNode.left= TreeBuild(a);
          newNode.right= TreeBuild(a);
          root=newNode;
          return newNode;
      }

      public void binaryTreePrintPreOrder(Node temp){
          if(temp==null)
              return;
          System.out.print(temp.data+"  ");
          binaryTreePrintPreOrder(temp.left);
          binaryTreePrintPreOrder(temp.right);


      }
     public void binaryTreePrintInOrder(Node temp){
         if(temp==null)
             return;

         binaryTreePrintInOrder(temp.left);
         System.out.print(temp.data+"  ");
         binaryTreePrintInOrder(temp.right);


     }
     public void binaryTreePrintPostOrder(Node temp){
         if(temp==null)
             return;
         binaryTreePrintPostOrder(temp.left);
         binaryTreePrintPostOrder(temp.right);
         System.out.print(temp.data+"  ");
     }
     public void binaryTreePrintLevelOrder(Node temp){
          if(temp==root){
              System.out.println(root.data+"  ");}
          if(temp==null){
              return;}
         if(temp.left!=null){
             System.out.print(temp.left.data+"  ");}
         if(temp.right!=null) {
             System.out.print(temp.right.data+"  ");}

         binaryTreePrintLevelOrder(temp.left);
         binaryTreePrintLevelOrder(temp.right);

     }


 }

class treeBuildCheck{
    public static void main(String[] args) {
        TreeBuildRecursive t=new TreeBuildRecursive();
    int[] a ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
   TreeBuildRecursive.Node root= t.TreeBuild(a);
        t.binaryTreePrintLevelOrder(root);


    }
}