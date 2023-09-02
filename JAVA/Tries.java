import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Tries {
    static class Node{
        Node children[]=new Node[26];
        Boolean eow=false;
        Node(){
            Arrays.fill(children, null);
        }
    }
    static Node root=new Node();
    static int size=0;
    public static void insert(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.children[s.charAt(i)-'a']==null) {
                temp.children[s.charAt(i) - 'a'] = new Node();
                 size++;
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
    public static char getUnique(Node root,String s){
        int ctr=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                ctr++;
            }
        }
        if(ctr>1) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    getUnique(root.children[i], s + (char) (i + 'a'));
                    ctr--;
                }
            }
        }
        else {
            System.out.print(s+"  ");
        }
        return ' ';

    }
    public static boolean startsWith(String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.children[s.charAt(i)-'a']!=null){
                temp=temp.children[s.charAt(i)-'a'];
            }
           else return false;
        }
        return true;
    }
    public static int uniqueSubString(Node root, String s){
     for(int i=0;i<s.length();i++){
         String str=s.substring(i);
        insert(str);
     }
     return size+1;
    }
    static String ans="";
    public static void getLongestPrefix(Node root,String str){
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null&&root.children[i].eow){
                ;
                getLongestPrefix(root.children[i],str+(char)(i+'a'));
            }
        }
        if(ans.length()== str.length())
            ans=ans.compareTo(str)>0?str:ans;
        if(ans.length()< str.length())
            ans=str;

    }
    public static int minExtraChar(String s, String[] dictionary) {
        for(int i=0;i<dictionary.length;i++)
            insert(dictionary[i]);
        int ctr=0;
        Node temp=root;
        Stack<Node>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(temp.children[s.charAt(i)-'a']==null){
                ctr++;
               while(st.size()>0){
                   temp=st.pop();
                   if(temp.children[s.charAt(i)-'a']!=null)
                       break;
               }
               if(st.size()==0)
                   continue;
            }
             {
                st.push(temp);
                temp=temp.children[s.charAt(i)-'a'];
                if(temp.eow)
                    temp=root;

            }
        }
        return ctr;

    }


    public static void main(String[] args) {
       String w1[]={"flbri","uaaz","numy","laper","ioqyt","tkvz","ndjb","gmg","gdpbo","x","collo","vuh","qhozp","iwk","paqgn","m","mhx","jgren","qqshd","qr","qpdau","oeeuq","c","qkot","uxqvx","lhgid","vchsk","drqx","keaua","yaru","mla","shz","lby","vdxlv","xyai","lxtgl","inz","brhi","iukt","f","lbjou","vb","sz","ilkra","izwk","muqgs","gom","je"};
        System.out.println(minExtraChar("ecolloycollotkvzqpdaumuqgs",w1));
        //String w2[]={"leet","code","leetcode"};
       // System.out.println(minExtraChar("leetscode",w2));

    }
}
