import java.util.*;

public class Trees {
   static  class TreeBuild {
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

        static Node root = null;
        static int idx = -1;

        public Node TreeBuild(int[] a) {
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

        public void binaryTreePrintPreOrder(Node temp) {
            if (temp == null)
                return;
            System.out.print(temp.data + "  ");
            binaryTreePrintPreOrder(temp.left);
            binaryTreePrintPreOrder(temp.right);


        }

        public void binaryTreePrintInOrder(Node temp) {
            if (temp == null)
                return;

            binaryTreePrintInOrder(temp.left);
            System.out.print(temp.data + "  ");
            binaryTreePrintInOrder(temp.right);


        }

        public void binaryTreePrintPostOrder(Node temp) {
            if (temp == null)
                return;
            binaryTreePrintPostOrder(temp.left);
            binaryTreePrintPostOrder(temp.right);
            System.out.print(temp.data + "  ");
        }

        public void binaryTreePrintLevelOrder(Node temp) {
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
        int height=0;

        public int getHeight(Node temp, int tempheight){
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

        public int CountNodes(Node temp){
            if(temp==null){
                return 0;
            }
            return CountNodes(temp.left)+CountNodes(temp.right)+1;
        }
        public int SumNodes(Node temp){
            if(temp==null){
                return 0;
            }
            return temp.data+SumNodes(temp.left)+SumNodes(temp.right);
        }
        public int getDiameter(Node newNode){
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
    }


}
class treeBuildCheck{
    public static void main(String[] args) {
        Trees.TreeBuild t=new Trees.TreeBuild();
        int[] a ={1,2,4,-1,-1,5,-1,6,-1,-1,3,-1,-1};
        Trees.TreeBuild.Node root= t.TreeBuild(a);
        System.out.println(t.getDiameter(root));

    }
}