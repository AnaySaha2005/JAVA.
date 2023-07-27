import java.util.ArrayList;

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
         
            public int romanToInt(String s) {
                int sum=0;int check=-1;char c=' ',d=' ';
                for(int i=0;i<s.length()-1,i++){
                    
                    c=s.charAt(i);d=s.charAt(i+1);
                    if(c=='I'&& d=='V')
                    { if(i==s.length()-2)check++;
                        sum+=4;
                    }
                   else if(c=='I'&& d=='X')
                     { if(i==s.length()-2)check++;
                        sum+=9;
                    }
                    else if(c=='X'&& d=='L')
                      { if(i==s.length()-2)check++;
                        sum+=40;
                    }
                    else if(c=='X'&& d=='C')
                     { if(i==s.length()-2)check++;
                        sum+=90;
                    }
                    else if(c=='C'&& d=='D')
                      { if(i==s.length()-2)check++;
                        sum+=400;
                    }
                    else if(c=='C'&& d=='D')
                      { if(i==s.length()-2)check++;
                        sum+=900;
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
        
         
        
    
        public static void main(String[] args) {
            int gas1[]={2,3,4};int cost1[]={3,4,3};
             int gas2[]={1,2,3,4,5};int cost2[]={3,4,5,2,1};
                   int i= canCompleteCircuit(gas1, cost1);
              System.out.println(i);
            
        }
      }
    
    
    

    

