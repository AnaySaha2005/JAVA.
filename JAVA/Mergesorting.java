public class Mergesorting {
    public static void mergesort(int a[],int s,int e)
    {
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        mergesort(a, s, mid);
        mergesort(a,  mid+1,e);
        merge(a,s,mid,e);
    }
    public static void merge(int a[],int s,int mid,int e){
        int tempo[]=new int[e-s+1];
        int i=s,j=mid+1,k=0;
        while( i<=mid&&j<=e){
            if(a[i]<a[j]){
                tempo[k]=a[i];
                i++;
            }
            else
           
           { tempo[k]=a[j];
            j++;
           }
           k++;
        }
        while(i<=mid){
             tempo[k++]=a[i++];
        }
             while(j<=e){
            tempo[k++]=a[j++];
        } 
        for(k=0,i=s;k<tempo.length;k++,i++)
        a[i]=tempo[k];
    }
    public static void main(String[] args) {
        int a[]={6,3,9,5,2,8};
        mergesort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
        System.out.println(a[i]);
    }
}
