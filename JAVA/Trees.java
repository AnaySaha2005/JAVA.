
import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.util.*;

public class Trees {
    class BinaryTree {
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

        public static Node TreeBuild(int[] a) {
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

        public static void binaryTreePrintPreOrder(Node temp) {
            if (temp == null)
                return;
            System.out.print(temp.data + "  ");
            binaryTreePrintPreOrder(temp.left);
            binaryTreePrintPreOrder(temp.right);


        }

        public static void binaryTreePrintInOrder(Node temp) {
            if (temp == null)
                return;

            binaryTreePrintInOrder(temp.left);
            System.out.print(temp.data + "  ");
            binaryTreePrintInOrder(temp.right);


        }

        public static void binaryTreePrintPostOrder(Node temp) {
            if (temp == null)
                return;
            binaryTreePrintPostOrder(temp.left);
            binaryTreePrintPostOrder(temp.right);
            System.out.print(temp.data + "  ");
        }

        public static void binaryTreePrintLevelOrder(Node temp) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) break;
                    else q.add(null);
                } else {
                    System.out.print(currNode.data + "  ");

                    if (currNode.left != null)
                        q.add(currNode.left);

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        static int height = 0;

        public static int getHeight(Node temp, int tempheight) {
            if (temp == null) {
                return tempheight;
            }
            if (temp.left == null && temp.right == null) {
                if (height < tempheight)
                    height = tempheight;
                return tempheight;
            }
            getHeight(temp.left, tempheight + 1);
            getHeight(temp.right, tempheight + 1);
            return height + 1;
        }

        public static int CountNodes(Node temp) {
            if (temp == null) {
                return 0;
            }
            return CountNodes(temp.left) + CountNodes(temp.right) + 1;
        }

        public static int SumNodes(Node temp) {
            if (temp == null) {
                return 0;
            }
            return temp.data + SumNodes(temp.left) + SumNodes(temp.right);
        }

        public static int getDiameter(Node newNode) {
            if (newNode == null) {
                return 0;
            }
            int ld = getDiameter(newNode.left);
            int rd = getDiameter(newNode.right);
            int lh = getHeight(newNode.left, 0);
            int rh = getHeight(newNode.right, 0);
            int self = lh + rh + 1;
            return rd > ld ? Math.max(rd, self) : Math.max(ld, self);
        }

        static class Info {
            int d;
            int h;

            Info(int d, int h) {
                this.d = d;
                this.h = h;
            }
        }

        public static Info getDiameterOptimum(Node newNode) {
            if (newNode == null) {
                return new Info(0, 0);
            }

            Info leftInfo = getDiameterOptimum(newNode.left);
            Info rightInfo = getDiameterOptimum(newNode.right);
            int dia = Math.max(Math.max(leftInfo.d, rightInfo.d), leftInfo.h + rightInfo.h + 1);
            int ht = Math.max(leftInfo.h, rightInfo.h) + 1;
            return new Info(dia, ht);
        }

        public static boolean isIdentical(Node root, Node subroot) {
            if (root == null || subroot == null) {
                return root == null && subroot == null;
            }
            if (root.data != subroot.data) {
                return false;
            } else {
                boolean leftIdentical = isIdentical(root.left, subroot.left);
                boolean rightIdentical = isIdentical(root.right, subroot.right);
                return leftIdentical && rightIdentical;
            }
        }

        public static boolean isSubTree(Node root, Node subroot) {
            if (root == null)
                return false;
            if (root.data == subroot.data) {
                return isIdentical(root, subroot);
            }
            return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
        }

        static class Infohd {
            Node node;
            int hd;

            Infohd(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root) {
            Queue<Infohd> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int max = 0;
            int min = 0;
            q.add(new Infohd(root, 0));
            q.add(null);
            while (!q.isEmpty()) {
                Infohd curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    }
                    q.add(null);
                } else {
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
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + "  ");
            }
        }

        public static void Kthlevel(Node temp, int level) {
            Queue<Node> q = new LinkedList<>();
            int k = 1;
            q.add(temp);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    if (k == level - 1)
                        System.out.println();
                    k++;
                    if (q.isEmpty()) break;
                    else q.add(null);
                } else {
                    if (k == level) {
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

        public static boolean getPath(Node root, int data, ArrayList<Integer> a) {
            if (root == null)
                return false;

            if (root.data == data) {
                a.add(root.data);
                return true;
            }
            if (getPath(root.left, data, a)) {
                a.add(root.data);
                return true;
            }
            if (getPath(root.right, data, a)) {

                a.add(root.data);
                return true;
            }
            return false;
        }

        public static void getLowestCommonAncestor(Node root, int n1, int n2) {
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            getPath(root, n1, a1);
            getPath(root, n2, a2);
            int lca = -1;
            System.out.println(a1);
            System.out.println(a2);
            while (!a1.isEmpty() && !a2.isEmpty()) {
                n1 = a1.remove(a1.size() - 1);
                n2 = a2.remove(a2.size() - 1);
                if (n1 == n2) {
                    lca = n1;
                }
            }
            System.out.println(lca);
        }

        public static Node getLowestCommonAncestor2(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftRoot = getLowestCommonAncestor2(root.left, n1, n2);
            Node rightRoot = getLowestCommonAncestor2(root.right, n1, n2);
            if (leftRoot == null) {
                return rightRoot;
            }
            if (rightRoot == null) {
                return leftRoot;
            }
            return root;
        }

        public static int getdistace(Node root, int n) {
            if (root == null)
                return 0;
            if (root.data == n)
                return 1;
            int leftdist = getdistace(root.left, n);
            int rightdist = getdistace(root.right, n);

            if (leftdist > 0 || rightdist > 0) {
                return leftdist + rightdist + 1;
            }
            return leftdist + rightdist;


        }


        public static int shortestDistance2(Node root, int n1, int n2) {
            Node lcaroot = getLowestCommonAncestor2(root, n1, n2);
            int dist1 = getdistace(lcaroot, n1) - 1;
            int dist2 = getdistace(lcaroot, n2) - 1;
            if (lcaroot.data == n1)
                dist1 = 0;
            if (lcaroot.data == n2)
                dist2 = 0;
            return dist1 + dist2;

        }

        public static int KthAncestor(Node root, int n, int k) {
            if (root == null)
                return -1;
            if (root.data == n)
                return 0;
            int leftdist = KthAncestor(root.left, n, k);
            int rightdist = KthAncestor(root.right, n, k);
            if (leftdist == -1 && rightdist == -1)
                return -1;
            if (leftdist == -1) {
                if (rightdist + 1 == k)
                    System.out.println(root.data);
                return rightdist + 1;
            } else {
                if (leftdist + 1 == k)
                    System.out.println(root.data);
                return leftdist + 1;
            }
        }

        public static void sumTree(Node root) {
            if (root == null)
                return;
            root.data = sumNode(root) - root.data;
            sumTree(root.left);
            sumTree(root.right);
        }

        public static int sumNode(Node root) {
            if (root == null)
                return 0;
            return sumNode(root.right) + sumNode(root.left) + root.data;


        }

        public static int sumTree2(Node root) {
            if (root == null)
                return 0;

            int leftsum = sumTree2(root.left);
            int rightsum = sumTree2(root.right);
            int rootdata = root.data;
            if (leftsum + rightsum == 0) {
                root.data = 0;
                return rootdata;
            }
            root.data = leftsum + rightsum;
            return rootdata + root.data;
        }

        public static Node treeInterchange(Node root) {
            if (root == null)
                return null;
            Node leftNode = treeInterchange(root.left);
            Node rightNode = treeInterchange(root.right);
            if (leftNode != null && rightNode != null) {
                root.left = rightNode;
                root.right = leftNode;
            }
            if (leftNode != null) {
                root.right = leftNode;
                root.left = null;
            }
            if (rightNode != null) {
                root.left = rightNode;
                root.right = null;
            }
            return root;
        }

        public static Node deleteLeafNodeX(int x, Node root) {
            if (root == null)
                return null;

            if (root.left == null && root.right == null) {
                if (root.data == x) {
                    System.out.println("deleted");
                    return root;
                }
            }
            Node leftNode = deleteLeafNodeX(x, root.left);
            Node rightNode = deleteLeafNodeX(x, root.right);
            if (leftNode != null)
                root.left = null;
            if (rightNode != null)
                root.right = null;
            return null;
        }

        public static int maxSum(Node root) {
            if (root == null)
                return 0;

            int leftsum = maxSum(root.left);
            int rightsum = maxSum(root.right);
            return Math.max(leftsum, rightsum) + root.data;

        }


    }
}
   class BinarySearchTrees {
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

       static int idx = -1;

       public static Node TreeBuild(int[] a,Node root) {
           root = new Node(a[0]);
           for (int i = 1; i < a.length; i++) {
               Node temp = root, temp2 = null;
               while (temp != null) {
                   temp2 = temp;
                   if (temp.data < a[i])
                       temp = temp.right;
                   else
                       temp = temp.left;
               }
               if (temp2.data < a[i])
                   temp2.right = new Node(a[i]);
               else temp2.left = new Node(a[i]);

           }
             return root;
       }


       public static void binarySearchTreePrintPreOrder(Node temp) {
           if (temp == null)
               return;
           System.out.print(temp.data + "  ");
           binarySearchTreePrintPreOrder(temp.left);
           binarySearchTreePrintPreOrder(temp.right);


       }

       public static void binarySearchTreePrintInOrder(Node temp) {
           if (temp == null)
               return;

           binarySearchTreePrintInOrder(temp.left);
           System.out.print(temp.data + "  ");
           binarySearchTreePrintInOrder(temp.right);


       }

       public static void binarySearchTreePrintPostOrder(Node temp) {
           if (temp == null)
               return;
           binarySearchTreePrintPostOrder(temp.left);
           binarySearchTreePrintInOrder(temp.right);
           System.out.print(temp.data + "  ");
       }

       public static void binarySearchTreePrintLevelOrder(Node root) {
           Queue<Node> q = new LinkedList<>();
           q.add(root);
           q.add(null);
           while (!q.isEmpty()) {
               Node currNode = q.remove();
               if (currNode == null) {
                   System.out.println();
                   if (q.isEmpty()) break;
                   else q.add(null);
               } else {
                   System.out.print(currNode.data + "  ");

                   if (currNode.left != null)
                       q.add(currNode.left);

                   if (currNode.right != null) {
                       q.add(currNode.right);
                   }
               }
           }
       }

       public static Node search(Node root, int n) {
           if (root == null)
               return null;
           if (root.data == n)
               return root;
           if (root.data < n) {
               return search(root.right, n);
           }
           return search(root.left, n);
       }
 public static Node delete(Node root,int data){
           Node universalroot=root;
           Node node=search(root,data);
           if(node==root)
           {   Node temp=root.right;
               Node temp2=null;
               while(temp.left!=null) {
               temp2=temp;
               temp = temp.left;
           }
               if(temp==root.right){
                   root.right.left=root.left;
                   root=root.right;
               }
               else{
                   root.data=temp.data;
                   temp2.left=null;
               }
               return root;
           }
           else{
           Node prevnode=root;
           while(root.data!=node.data){
               prevnode=root;
               if(root.data<node.data)
                   root=root.right;
               else root=root.left;
           }
     //case 1
       if(node.right==null&&node.left==null)
         {
             if(prevnode.data<node.data){
                 prevnode.right=null;
             }
            else prevnode.left=null;
         }
       // case 2
        else if(node.left==null){
           if(prevnode.data>node.data){
               prevnode.left=node.right;
           }
         else  prevnode.right=node.right;
       }
       else if(node.right==null){
           if(prevnode.data>node.data){
               prevnode.left=node.left;
           }
          else prevnode.right=node.left;
       }
       else {
           Node temp2 = root;
           root = node.right;
           while (root.left != null) {
               temp2 = root;
               root = root.left;
           }
           if (root.data != node.right.data) {
               node.data = root.data;
               temp2.left = null;
           } else {
               if (prevnode.data > node.data) {
                   Node temp3 = node;
                   prevnode.left = temp3.right;
                   temp3.right.left = temp3.left;

               } else {
                   Node temp3 = node;
                   prevnode.right = temp3.right;
                   temp3.left = temp3.right.left;
               }

           }

       }

       }
     return universalroot;
 }
 public static void printRange(Node root,int k1,int k2){
           if(root==null)
               return;
           if(root.data>=k1&&root.data<=k2) {
               System.out.println(root.data);
               printRange(root.left,k1,k2);
               printRange(root.right,k1,k2);
           }
         else  if(root.data<k1){
               printRange(root.right,k1,k2);
           }
         else  if(root.data>k2){
               printRange(root.left,k1,k2);
           }
 }

   public static void rootToLeafPaths(Node root,String path){
           if(root==null)
               return;
           if(root.left==null&&root.right==null) {
             path=path+root.data;
               System.out.println(path);
               return;
           }
            path=path+root.data+"-";
           rootToLeafPaths(root.left,path);
           rootToLeafPaths(root.right,path);

   }
   public static boolean isValidBST(Node root,Node min,Node max){
          if(root==null)
              return true;
          if(max!=null&min!=null){
            if(min.data<root.data&&root.data<max.data)
                return true;
                return false;
          }

          return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);

   }
       public static Node treeInterchange(Node root) {
           if (root == null)
               return null;
           Node leftNode = treeInterchange(root.left);
           Node rightNode = treeInterchange(root.right);
           if (leftNode != null && rightNode != null) {
               root.left = rightNode;
               root.right = leftNode;
               return root;
           }
           if (leftNode != null) {
               root.right = leftNode;
               root.left = null;
           }
           if (rightNode != null) {
               root.left = rightNode;
               root.right = null;
           }
           return root;
       }
       public static Node generateBalancedBST(int[]a,int p1,int p2){
           if(p1==p2)
               return new Node(a[p1]);
           if(p1>p2)
               return null;
           Node newNode=new Node(a[(p1+p2)/2]);
           newNode.left=generateBalancedBST(a,p1,(p1+p2)/2-1);
           newNode.right=generateBalancedBST(a,(p1+p2)/2+1,p2);
           return newNode;
       }
       public static Node getBalancedBST(Node root){
            ArrayList <Integer>list=getInOrder(root,new ArrayList<>());
           int[] a = list.stream().mapToInt(i -> i).toArray();

           root=generateBalancedBST(a,0,a.length-1);
           return root;
       }

     public static ArrayList<Integer> getInOrder(Node root,ArrayList<Integer>list){
           if(root==null)
               return null;
           getInOrder(root.left,list);
           list.add(root.data);
           getInOrder(root.right,list);
           return list;

     }
     public static int getlargestBST(Node root,int max){
           if(root==null)
               return 0 ;
           if(!isValidBST(root,null,null)){
              int m1= getlargestBST(root.left,max);
              int m2=getlargestBST(root.right,max);
              if(m1!=0)
                  return m1;
              if(m2!=0)
                  return m2;
           }
           else{
               int a=getSize(root);
               if(a>max)
                   max=a;
               return max;


           }
           return 0;
     }

       public static int getSize(Node root) {
           if(root==null)
               return 0;
           return getSize(root.left)+getSize(root.right)+1;
       }


       public static void main(String[] args) {
      Node root=new Node(50);
      root.left=new Node(30);
      root.left.left=new Node(5);
      root.left.left.right=new Node(20);
      root.right=new Node(60);
      root.right.right=new Node(70);
      root.right.left=new Node(45);
      root.right.right.right=new Node(80);
      root.right.right.left=new Node(65);
      System.out.println(getlargestBST(root,0));



       }

   }




