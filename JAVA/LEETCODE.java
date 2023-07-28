import java.util.ArrayList;
import java.util.Arrays;

public class LEETCODE {
  
    public static int majorityElement(int[] a) {
        int val=0,prevcount=0,recentcount=0,n=a.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                if(a[i]==a[j])
                recentcount++;
            }
            if(recentcount>prevcount)
           { val=a[i];
            prevcount=recentcount;
        }
            recentcount=0;
            
            }
            return val;
        }
        public static void rotate(int[] a, int k) {
          ArrayList <Integer>arr =new ArrayList<Integer>();
          for(int i=0;i<a.length;i++)
          arr.add(a[i]);
          while(k!=0)
          {
            arr.add(0,arr.get(a.length-1));
            k--;
          }
           for(int i=0;i<a.length;i++)
            a[i]=arr.get(i);
        }
        public static  int canCompleteCircuit(int[] gas, int[] cost) {
         int n=gas.length;
          for(int i=0;i<n;i++){
          int pos=i,Gas=gas[i];
          for(int j=0;j<n;j++){
            if(Gas-cost[pos]<0)
            break;
            if(pos==n-1){
              Gas+=gas[0]-cost[pos];
              pos=0;
            }
            else{
              Gas+=gas[pos+1]-cost[pos];
              pos++;}
              if(Gas<=0){
                break;
              }
              if(pos==i){
               
                 
                return i;
              }
              }
            }
            return -1;
          }
         
            public static  int romanToInt(String s) {
                int sum=0;int check=-1;char c=' ',d=' ';
                for(int i=0;i<s.length()-1;i++){
                    
                    c=s.charAt(i);d=s.charAt(i+1);
                    if(c=='I'&& d=='V')
                    { if(i==s.length()-2)check++;
                        sum+=4;i++;
                    }
                   else if(c=='I'&& d=='X')
                     { if(i==s.length()-2)check++;
                        sum+=9;i++;
                    }
                    else if(c=='X'&& d=='L')
                      { if(i==s.length()-2)check++;
                        sum+=40;i++;
                    }
                    else if(c=='X'&& d=='C')
                     { if(i==s.length()-2)check++;
                        sum+=90;i++;
                    }
                    else if(c=='C'&& d=='D')
                      { if(i==s.length()-2)check++;
                        sum+=400;i++;
                    }
                    else if(c=='C'&& d=='M')
                      { if(i==s.length()-2)check++;
                        sum+=900;i++;
                    }
                    else{
                        if(c=='I') sum+=1;
                        if(c=='V') sum+=5;
                        if(c=='X') sum+=10;
                        if(c=='L') sum+=50;
                        if(c=='C') sum+=100;
                        if(c=='D') sum+=500;
                        if(c=='M') sum+=1000;
        
                    }
        
                }
                if(check==-1)
               {
                   c=s.charAt(s.length()-1);
                   if(c=='I') sum+=1;
                        if(c=='V') sum+=5;
                        if(c=='X') sum+=10;
                        if(c=='L') sum+=50;
                        if(c=='C') sum+=100;
                        if(c=='D') sum+=500;
                        if(c=='M') sum+=1000;
        
        
               }
               return sum;
            }
        
          public static int[] twoSum(int[] a, int target) {
         int si=0,ei=a.length-1; int sum2[]=new int [2];
         
         for(int i=0;i<=ei;i++)
        { 
         { int c=BinarySearch(a,i,ei,target-a[i]);
          if(c!=-1)
          {
             sum2[0]=i+1;sum2[1]=c+1;
             return sum2;
          }
         }
        }
         return sum2;
      }
    public static int BinarySearch(int array[],int low,int high,int x){
      low++;
      while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == x)
        return mid;

      if (array[mid] < x)
        low = mid + 1;

      else
        high = mid - 1;
    }

    return -1;
    }
  
         public static  int minSpeedOnTime(int[] a, double hourlimit) {
      if(Math.round(hourlimit)<a.length-1) 
      return -1;
      int speed=1;

     while(speed<=Integer.MAX_VALUE)
     {
      double hour=0;
      for(int i=0;i<a.length;i++){
        if(a[i]%speed!=0 && i!=a.length-1)
        hour+=(int)(a[i]/speed)+1;
        else hour+=(double)(a[i])/(double)(speed);
      }
      if(hour<=hourlimit)
      break;
      speed ++;
      }
      return speed;

     }
   
        
    
        public static void main(String[] args) {
         int a[]={1,3,2};
         System.out.println(minSpeedOnTime(a, 2.70));
           
        }
      }
    
    
    

    

