public class quicksorting {
    public static void QuickSort(int a[],int si,int ei)
    {
        int pivot =ei,j=si,i=j-1;
        if(si>=ei)
        return;
        while(j<=ei){
            if(a[j]<=a[pivot]){
                i++;
                int temp =a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            j++;
        }
        QuickSort(a, si, i-1);
        QuickSort(a, i+1, ei);
            }
            public static void main(String[] args) {
                int a[]={6,3,9,8,2,5};
                QuickSort(a, 0, a.length-1);
                for(int i=0;i<a.length;i++)
                System.out.print(a[i]+"  ");
            }
        }
 
    
    

