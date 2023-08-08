import java.util.*;
public class StackB {
    public static  void pushBottom(Stack<Integer>s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushBottom(s,data);
        s.push(top);

    }
 public static void reverse(Stack<Integer>s){
  if(s.isEmpty())
  return;
    int top=s.pop();
    reverse(s);
    pushBottom(s, top);
 }
 public static void print(Stack<Integer>s){
    while(!s.isEmpty()){
        System.out.println(s.pop());
    }
 }
    public static void main(String[] args) {
      Stack<Integer> s=new Stack<>();
      s.push(1);
      s.push(2);
      s.push (3);
      print(s);
      pushBottom(s,4);
      print(s);
      reverse(s);
     print(s);


    }
}