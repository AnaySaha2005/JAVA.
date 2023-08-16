import java.util.*;
public class Trees {
        public static  class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                right = null;
                left = null;
            }
        }

        static Node root = null;
        static int idx = -1;

        public static  Node TreeBuild(int[] a) {
            idx++;
            if (a[idx] == -1) {
                return null;
            }
            Node newNode = new Node(a[idx]);
            newNode.left = TreeBuild(a);
            newNode.right = TreeBuild(a);
            root = newNode;
            return newNode;
        }

        public  static void binaryTreePrintPreOrder(Node temp) {
            if (temp == null)
                return;
            System.out.print(temp.data + "  ");
            binaryTreePrintPreOrder(temp.left);
            binaryTreePrintPreOrder(temp.right);


        }

        public static  void binaryTreePrintInOrder(Node temp) {
            if (temp == null)
                return;

            binaryTreePrintInOrder(temp.left);
            System.out.print(temp.data + "  ");
            binaryTreePrintInOrder(temp.right);


        }

        public  static void binaryTreePrintPostOrder(Node temp) {
            if (temp == null)
                return;
            binaryTreePrintPostOrder(temp.left);
            binaryTreePrintPostOrder(temp.right);
            System.out.print(temp.data + "  ");
        }

        public  static void binaryTreePrintLevelOrder(Node temp) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) break;
                    else q.add(null);
                }
                else {
                    System.out.print(currNode.data + "  ");

                    if (currNode.left != null)
                        q.add(currNode.left);

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    static  int   height=0;

        public static  int getHeight(Node temp, int tempheight){
            if(temp==null){
                return tempheight;
            }
            if(temp.left==null&&temp.right==null){
                if(height<tempheight)
                    height=tempheight;
                return tempheight;
            }
            getHeight(temp.left,tempheight+1);
            getHeight(temp.right,tempheight+1);
            return height+1;
        }

        public  static int CountNodes(Node temp){
            if(temp==null){
                return 0;
            }
            return CountNodes(temp.left)+CountNodes(temp.right)+1;
        }
        public  static int SumNodes(Node temp){
            if(temp==null){
                return 0;
            }
            return temp.data+SumNodes(temp.left)+SumNodes(temp.right);
        }
        public static  int getDiameter(Node newNode){
            if(newNode==null){
                return 0;
            }
            int ld=getDiameter(newNode.left);
            int rd=getDiameter(newNode.right);
            int lh=getHeight(newNode.left,0);
            int rh=getHeight(newNode.right,0);
            int self=lh+rh+1;
            return rd>ld? Math.max(rd, self) : Math.max(ld, self);
        }
        static class Info{
            int d;
            int h;
            Info(int d,int h){
           this.d=d;
           this.h=h;
            }
        }
        public static Info getDiameterOptimum(Node newNode){
            if(newNode==null){
                return new Info(0,0);
            }

            Info leftInfo=getDiameterOptimum(newNode.left);
            Info rightInfo=getDiameterOptimum(newNode.right);
            int dia=Math.max(Math.max(leftInfo.d,rightInfo.d),leftInfo.h+rightInfo.h+1);
          int ht=Math.max(leftInfo.h,rightInfo.h)+1;
          return new Info(dia,ht);
        }
        public static   boolean checkSubTree(Node root1,Node root2){

            if(root1==null||root2==null){
                return root1 == null && root2 == null;
            }
         if(root1.data!=root2.data){
             checkSubTree(root1.left,root2);
             checkSubTree(root1.right,root2);
             return false;
         }
         else{
           boolean b1=  checkSubTree(root1.left,root2.left);
           boolean b2=  checkSubTree(root1.right,root2.right);
             return b1&&b2;
         }

        }


    public static void main(String[] args) {
      Node root=new Node(1);
      root.left=new Node(2);

        root.left.left=new Node(4);

        root.left.right=new Node(5);

        root.right=new Node(3);
        root.right.right=new Node(6);
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        System.out.println(checkSubTree(root,subroot));


    }

}



