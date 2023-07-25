import java.util.Scanner;

public class bitManupulation {
    
  //MAIN  
    public static void main(String[] args) {
      //  updateBit();
      //clearRangeBits(10,2,4);
      //checkPower(14);
     // setBitsNumbers(14);
     fastExpo(5, 3);
       }
   
   
 //1
       public static void getBit (int n,int i){
        System.out.println((n & (1<<i))==(1<<i)?1:0);
           //here 1<<i is the bitmask....
    }
   
   
  //2 
    public static void setBit(int n,int i){
        System.out.println(n|(1<<i));
    }
   
   
  //3 
    public static int clearBit(int n,int i){
        int c=~(1<<i);
        return(c&n);
    }
   
   
   //4
    public static void clearLastBits(int n ,int i){ 
        i--;
        for(;i>-1;i--){
        n= clearBit(n, i);
     }
     System.out.println(n);
    }
   
//5
    public static void clearRangeBits(int n,int i,int j){
    

        for(;i<=j;i++){
        n= clearBit(n, i);
     }
     System.out.println(n);
    }
   
//6

    public static void checkPower(int n){
        int ctr=0;
        for(int i=0;i<=32;i++)
        {
            if((n&(1<<i))==(1<<i))
                ctr++;
        }
        if(ctr==1)
        System.out.println("power of 2");
        else System.out.println("not a power of 2");
    }
  //7

    public static void updateBit()
    {
      Scanner sc=new Scanner (System.in);
      System.out.println("Enter  the number and the value  and the position respectively");
       int n=sc.nextInt(); int bit=sc.nextInt();      int pos=sc.nextInt();     
      if(bit==1)
      setBit(n,pos);
      if(bit==0)
      clearBit(n, pos);
    }
    //8

    public static void setBitsNumbers(int n){
        int c=0;
        for(int i=0;i<=32;i++)
        {
            if((n&(1<<i))==(1<<i))
            c++;
        }
        System.out.println("The number of one's is "+ c);
    }
    //9
    public static void fastExpo(int n,int a){
        int ans=1;
        while(n>0)
        {
            if((n&1)==1)
           ans=ans*a;
            a=a*a;
            n=n>>1;
        }
        System.out.println(ans);
    }
}
