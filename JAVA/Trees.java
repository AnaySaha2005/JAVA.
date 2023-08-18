import java.lang.reflect.Array;
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
        public static boolean isIdentical(Node root ,Node subroot){
          if(root==null||subroot==null) {
              return root == null && subroot == null;
          }
            if(root.data!=subroot.data) {
                return false;
            }
           else {
                boolean leftIdentical = isIdentical(root.left, subroot.left);
                boolean rightIdentical = isIdentical(root.right, subroot.right);
                return leftIdentical && rightIdentical;
            }
        }
        public static   boolean isSubTree(Node root,Node subroot){
            if(root==null)
                return false ;
            if(root.data==subroot.data){
                return isIdentical(root,subroot);
            }
            return isSubTree(root.left,subroot)||isSubTree(root.right,subroot);
        }

     static class Infohd{
            Node node;
            int hd;
            Infohd(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
     }
        public static void topView(Node root){
        Queue<Infohd>q=new LinkedList<>();
             HashMap<Integer,Node> map=new HashMap<>();
            int max=0;int min=0;
            q.add(new Infohd(root,0));
            q.add(null);
            while(!q.isEmpty()){
                Infohd curr=q.remove();
               if(curr==null)
               {
                   if( q.isEmpty()) {
                       break;
                   }
                   q.add(null);
               }
           else {
                   if (!map.containsKey(curr.hd)) {
                       map.put(curr.hd, curr.node);
                   }
                   if (curr.node.left != null) {
                       q.add(new Infohd(curr.node.left, curr.hd - 1));
                       min = Math.min(curr.hd - 1, min);
                   }
                   if (curr.node.right != null) {
                       q.add(new Infohd(curr.node.right, curr.hd + 1));
                       max = Math.max(curr.hd + 1, max);
                   }
               }
            }
            for(int i=min;i<=max;i++) {
                System.out.print(map.get(i).data+"  ");
            }
        }
    public  static void Kthlevel(Node temp,int level) {
        Queue<Node> q = new LinkedList<>();
        int k=1;
        q.add(temp);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                if(k==level-1)
                    System.out.println();
                k++;
                if (q.isEmpty()) break;
                else q.add(null);
            }
            else {
                if(k==level) {
                    System.out.print(currNode.data + "  ");
                }

                if (currNode.left != null)
                    q.add(currNode.left);

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    public static boolean getPath(Node root, int data, ArrayList<Integer>a){
            if(root==null)
                return false;

           if(root.data==data) {
               a.add(root.data);
               return true;
           }
            if(getPath(root.left,data,a)){
                a.add(root.data);
                return true;
            }
           if(getPath(root.right,data,a)){

               a.add(root.data);
               return true;
           }
           return false;
    }
    public static void getLowestCommonAncestor(Node root,int n1,int n2){
            ArrayList<Integer>a1=new ArrayList<>();
            ArrayList<Integer>a2=new ArrayList<>();
            getPath(root,n1,a1);
            getPath(root,n2,a2);
            int lca=-1;
        System.out.println(a1);
        System.out.println(a2);
           while(!a1.isEmpty()&&!a2.isEmpty()){
               n1=a1.remove(a1.size()-1);
               n2=a2.remove(a2.size()-1);
               if(n1==n2){
                   lca=n1;
                }
            }
          System.out.println(lca);
    }
    public static Node getLowestCommonAncestor2(Node root,int n1,int n2){
       if(root==null||root.data==n1||root.data==n2){
           return root;
       }
       Node leftRoot=getLowestCommonAncestor2(root.left,n1,n2);
       Node rightRoot=getLowestCommonAncestor2(root.right,n1,n2);
       if(leftRoot==null){
           return rightRoot;
       }
       if(rightRoot==null){
           return leftRoot;
       }
       return root;
    }
    public static void main(String[] args) {
      Node root=new Node(1);
      root.left=new Node(2);

        root.left.left=new Node(4);

        root.left.right=new Node(5);

        root.right=new Node(3);
        root.right.right=new Node(7);
        root.right.left=new Node(6);
        System.out.println(getLowestCommonAncestor2(root,4,7).data);

    }

}



