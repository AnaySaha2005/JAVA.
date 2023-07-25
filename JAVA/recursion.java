import java.util.Scanner;

public class recursion {

    public static void fibonnaci(int a,int b,int n)
{ 
     if(n==0)
    return;
    System.out.print(a+" ");
    int sum =a+b;
    fibonnaci(b,sum,n-1);

}    

    public static int factorial(int n){
    if(n==0){
        return 1;

    }
    return n*factorial(n-1);
}

    public static int NaturalSum(int n){
    if(n==0){
        return 0;

    }
    return n+NaturalSum(n-1);
}

    public static int NthFibonnaciNum(int a,int b,int n)
{  
     if(n==1)
     return a;
     int sum =a+b;
    return NthFibonnaciNum(b,sum,n-1);
}   

public static boolean CheckSortedArray(int i,int a[]){
 if(i==a.length-1)
 return true;
 if(a[i]>a[i+1])
 return false;
 return CheckSortedArray(i+1, a);

 }
 
 public static int FirstOccurence(int i,int a[],int num){
 if (a[i]==num)
 return i+1;
 if(i>=a.length)
 return -1;
 return FirstOccurence(i+1, a, num);
 }

 public static int LastOccurence(int i,int a[],int num){
 if (a[i]==num)
 return i+1;
 if(i<0)
 return -1;
 return LastOccurence(i-1, a, num);
 }
 public static int  powerCalcOptimum(int num,int n){
   if (n==0)
   return 1;
   if( n%2==0)
   return powerCalcOptimum(num, n/2)*powerCalcOptimum(num, n/2);
   else 
   return num* powerCalcOptimum(num, n/2)*powerCalcOptimum(num, n/2);
 }

 public static void FindSubStr(int i,int j,String str)
 { 
     if(i==str.length())
    System.exit(0);
    if (j==str.length()+1){     
        return;
    }
  
    if(str.substring(i, j).charAt(0)==str.substring(i, j).charAt(str.substring(i, j).length()-1))
    System.out.println(str.substring(i, j));
    FindSubStr(i, j+1, str);
     j=i+1;
     FindSubStr(i+1, j+1, str);
 }
 
public static void main(String[] args) {
    FindSubStr(0, 1, "abcab");

}
}
