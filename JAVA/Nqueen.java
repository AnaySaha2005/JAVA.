import java.util.Scanner;

public class Nqueen {
   static  int ar[][]; static int n;
    Nqueen(int n){
        this.n=n;
        ar=new int[n][n];

    }
    public boolean placeQUEEN(int r,int c)
    { int a=0,b=0;
if(r==n)
return true;
if(c>=n)
{
    ar[a][b]=0;
    return placeQUEEN(r-1,b++);
}
if(check(r,c)==true)
{a=r;b=c;ar[r][c]=1;
return(placeQUEEN(r+1,0));
    }
    else return placeQUEEN(r,c+1);

    }
 
  
    public  boolean check(int r,int c)
{     for(int i=0;i<n;i++)
    {
        if(ar[r][i]==1||ar[i][c]==1)
        return false;
    }//the error is here i dont know how to find the diagonal of any position of a array :(
    for(int i=0;i<n;i++)
    {    for(int j=0;j<n;j++)
      {  if(i+j==c)
        if(ar[i][j]==1)
        return false; }
       
    } for(int i=r+1,j=c+1;i<n && j<n;i++,j++)
    {
        if(ar[i][j]==1)
        return false;
    }
    
    return true;
}
public static  void main(String[] args) {
    Scanner sc=new Scanner (System.in);
     n=sc.nextInt();
     Nqueen ob =new Nqueen(n);
    System.out.println(ob.placeQUEEN(0,0));
    for(int i=0;i<n;i++)
    {for(int j=0;j<n;j++)
    System.out.print(ar[i][j]+"  ");
    System.out.println();
    }
}
}