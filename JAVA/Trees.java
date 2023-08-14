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
    public static class Node{
      int data;
      Node left;
      Node right;
      Node(int data){
          this.data=data;
          right=null;
          left=null;
      }
      static int idx=-1;
      public Node TreeBuild(int a[]){
          idx++;
          if(a[idx]==-1){
              return null;
          }
          Node newNode= new Node(a[idx]);
          newNode.left= TreeBuild(a);
          newNode.right= TreeBuild(a);
          return newNode;
      }
    }
}
class treeBuildCheck{
    public static void main(String[] args) {
        TreeBuild t=new TreeBuild();
        t.add(1);
        t.add(2);
        t.add(4);
        t.add(-1);
        t.add(-1);
        t.add(5);
        t.add(-1);
        t.add(-1);
        t.add(3);
        t.add(-1);
        t.add(6);
        t.add(-1);
        t.add(-1);



    }
}