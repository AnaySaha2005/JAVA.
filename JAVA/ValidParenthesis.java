import java.util.Stack;

public class ValidParenthesis {
    public static boolean validparenthesis(String str){
        Stack<Character>s=new Stack<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                s.push(str.charAt(i));
            }
            else {
                if(s.isEmpty())
                    return false;
                if(isPair(s,str.charAt(i))){

                    s.pop();
                }
                else return false;
            }

        }
        if(s.isEmpty())
            return true;
        return false;
    }
    public static boolean isPair(Stack <Character>s,char c){
        if(s.peek()=='('&&c==')')
            return true;
        if(s.peek()=='{'&&c=='}')
            return true;
        if(s.peek()=='['&&c==']')
            return true;
        return false;
    }
    public static void main(String[] args) {
        String str="{[()]}";
        System.out.println(   validparenthesis(str));
    }
}
