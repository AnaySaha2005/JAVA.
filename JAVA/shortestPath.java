import java.util.*;
public class shortestPath {
    public static void main (String args[])
    {
        System.out.println("enter the directions");
        Scanner sc=new Scanner (System.in);
        String dir=sc.next();int x=0,y=0;
        for(int i=0;i<dir.length();i++)
        {
            if(dir.charAt(i)=='W')
            y--;
            
            if(dir.charAt(i)=='E')
            y++;
            else if(dir.charAt(i)=='N')
            x++;
            else if(dir.charAt(i)=='S')
            x--;
            else{
                 System.out.println("INVALID INPUT");
                 x=0;y=0;
                 break;
        }
        }
        double shortest=Math.pow(x*x+y*y,0.5);
        System.out.println(shortest);
    }
}
