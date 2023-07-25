public class MergesortString {
    public static void merge(String a[],int si,int ei){
        if(si==ei){
            return;
        }
        int mid=si+(ei-si)/2;
        merge(a,si,mid);
        merge(a,mid+1,ei);
        String tempo[]=new String[ei-si+1];
        int i=si,j=mid+1,k=0;
        while(i<=mid&&j<=ei){
            if(a[i].compareTo(a[j])<0)
            {
             tempo[k++]=a[i++];
            }
            else tempo[k++]=a[j++];
        }
        while(i<=mid)
               tempo[k++]=a[i++];
               while(j<=ei)
               tempo[k++]=a[j++];
               for(int l=0,m=si;l<k;l++,m++)
                a[m]=tempo[l];
    }
    public static void main(String[] args) {
        String a[]={"sun","earth","mercury","venus","mars"};
        merge(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+ "  ");
    }
}
