public class majorElement {
     public static void element(int a[],int track[],int s,int e)
    {
        if(s==e){
            track[a[s]]++;
            return;
        }
        int mid=s+(e-s)/2;
        element(a, track,s, mid);
        element(a, track, mid+1,e);
      
    }
    public static void main(String[] args) {
        int a[]={2,4,1,3,5};
        int track[]=new int[110];
        element(a, track, 0, a.length-1);
        for(int i=0;i<track.length;i++)
        { if(track[i]>a.length/2)
             {System.out.println(i);break;
            }
            }
    }
    }

