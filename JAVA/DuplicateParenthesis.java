import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean getDup(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=')')
                s.push(str.charAt(i));
            else {
                boolean b = removeBracket(s);
                if (b)
                    return true;
            }
        }
        return false;
        }
        public static boolean removeBracket(Stack<Character> s){
        int ctr=0;
        while ((s.peek()!='(')&&!s.isEmpty()) {
            ctr++;
            s.pop();
        }
        if(ctr==0){
            s.pop();
            return true;
        }
            s.pop();
        return false;

        }

    public static void main(String[] args) {
        String str="(((a+b)+(c)))";
        System.out.println(getDup(str));
    }
    }

