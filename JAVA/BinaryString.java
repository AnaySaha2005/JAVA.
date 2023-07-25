public class BinaryString {
    public static void BinStr(int n,int LastPlace,String str){
        if(n==0)
          { System.out.println(str);
            return;
          }BinStr(n-1, 0, str+("0"));
           if(LastPlace==0)
          {
           BinStr(n-1, 1, str+("1"));
          }
         
        }
    public static void main(String[] args) {
      BinStr(3, 0, "");  
    }
}
