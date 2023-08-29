import java.util.Arrays;

public class Tries {
    static class Node{
        Node children[]=new Node[26];
        Boolean eow=false;
        Node(){
            Arrays.fill(children, null);
        }
    }
    static Node root=new Node();
    public static void insert(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.children[s.charAt(i)-'a']==null) {
                temp.children[s.charAt(i) - 'a'] = new Node();

            }
           temp= temp.children[s.charAt(i) - 'a'];

        }
        temp.eow=true;
    }
    public static char print (Node root,String s){
        for(int i=0;i<root.children.length;i++)
            if(root.children[i]!=null){
               if(root.children[i].eow) {
                   System.out.println(s+(char)(i+97));
               }
              print(root.children[i],s+(char)(i+97));
            }
        return ' ';
    }
    public static boolean search(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.children[s.charAt(i)-'a']==null)
                return false;
            temp=temp.children[s.charAt(i)-'a'];

        }
        return  true;
    }
    public static boolean isKeyPresent(String s){
        boolean b=false;
        Node temp=root;
        int i=0;
        while(i!=s.length()){
            if(temp==null)
                temp=root;
            if(temp.children[s.charAt(i)-'a']!=null){
                b= temp.children[s.charAt(i) - 'a'].eow;
                temp=temp.children[s.charAt(i)-'a'];
                i++;
            }
           else temp=temp.children[s.charAt(i)-'a'];

        }
        return b;
    }

    public static void main(String[] args) {
       String words[]={"i","like","sam","samsung","mobile","ice"};
       for(int i=0;i<words.length;i++)
           insert(words[i]);
        System.out.println(isKeyPresent("ilikesamsung"));
    }
}
