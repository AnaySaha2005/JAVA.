import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
         Scanner sc = new Scanner (System.in);
         System.out.println("Enter the string");
         String s=sc.next();
         int c=0;
         String s1="";
        while(s!="")
          { int i=0;
            for(int j=0;j<s.length();j++)
            {
              if(s.charAt(i)!=s.charAt(j))
              break;
              else c++;
            } 
             if(c>1)
            s1=s1+Character.toString(s.charAt(i))+Integer.toString(c);
            else  s1=s1+Character.toString(s.charAt(i));
              s=s.substring(c);
              c=0;
          }
          System.out.println(s1);
       }
    }
    

