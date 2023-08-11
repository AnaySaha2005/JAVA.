import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingLetter {
    public static void main(String[] args) {
        Queue<Character>q=new LinkedList<>();
        String s="aabccxb";
              int a[]=new int[26];
        for(int i=0;i<s.length();i++) {
            q.add((s.charAt(i)));
            a[(int) (s.charAt(i)) - 97]++;
            while(!q.isEmpty()&& a[(int)q.peek()-97]>1){
                q.remove();
            }
            if(q.isEmpty())
                System.out.println(-1);
            else System.out.println(q.peek());
        }

        }
    }

