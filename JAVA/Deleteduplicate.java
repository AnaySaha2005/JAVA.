public class Deleteduplicate {
    public static void  Delete(StringBuilder str,int a[],int i){
      if(i<str.length()){
        a[(int)(str.charAt(i))-97]++;
        Delete(str, a, i+1);
      }
      
  
    }
    public static void main(String[] args) {
        int a[]=new int[26]; StringBuilder str =new StringBuilder("annnayyy");
       Delete(str, a,0);
       for(int i=0;i<26;i++){
        if( a[i]>0)
        System.out.print((char)(97+i));
       }
    }
}
