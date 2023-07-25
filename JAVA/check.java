public class check  {
    public static void main(String[] args) {
        check ob =new check();int a[]={0,0,1,1,1,1,2,3,3};
        int k=ob.removeDuplicates(a);
        for(int i=0;i<k;i++)
        System.out.println(a[i]);
    }
    


    public int removeDuplicates(int[] a) {
        int k=a.length;int c=0,i=0;
        for(int j=i;j<a.length;j++){
          
            if(a[i]==a[j])
            c++;
               if(a[i]!=a[j]&&c<3)
           { i=j;j--;
            c=0;
           }
           
            if(c>2)
            {
                a[j]=Integer.MAX_VALUE;
                k--;
                c--;
            }
          
        }

      int tempo=0;
        for(i=0;i<a.length;i++){
           for(int j=0;j<a.length-i-1;j++){
               if(a[j]>a[j+1])
               {
                   tempo=a[j];
                   a[j]=a[j+1];
                   a[j+1]=tempo;
               }
           }
        }
           return k;
     }
}