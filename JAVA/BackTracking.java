public class BackTracking {
    public static void subset(String str,String s){
        if(str.length()==0)
        {
            System.out.println(s);
            return;
        }
        subset(str.length()==1?"":str.substring(1), s+str.charAt(0));
         subset(str.length()==1?"":str.substring(1), s);
    }
       public static void permutation(String str,String ans){
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
      for(int i=0;i<str.length();i++)
       permutation(str.replace(Character.toString(str.charAt(i)),""), ans+str.charAt(i));
    }
    public static void main(String[] args) {
    permutation("123", "");
    }
}
