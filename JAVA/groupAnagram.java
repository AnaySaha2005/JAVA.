import java.util.*;

public class groupAnagram {
    static class Node{
        public boolean eow;
        Node[] children =new Node[26];
        Node(){
            for(int i=0;i<26;i++)
                children[i]=null;
            eow=false;
        }

    }
    static Node root=new Node();
    public static void insert(String word){
        char ch[]=new char[word.length()];
        for(int i=0;i<word.length();i++)
            ch[i]=word.charAt(i);
        Arrays.sort(ch);
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(temp.children[ch[i]-'a']==null)
                temp.children[ch[i]-'a']=new Node();
            temp=temp.children[ch[i]-'a'];
        }
        temp.eow=true;
    }
    public static ArrayList<String> getgroups(String word){
        ArrayList<String>list=new ArrayList<>();int curr=0,prev=0;
        for(int i=0;i<word.length();i++){
            insert(word);

            for(int j=0;j<26;j++){
               if(root.children[i]!=null)
                   curr++;
            }


        }
        return list;
    }
}
