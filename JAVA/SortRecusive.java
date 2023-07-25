public class SortRecusive {
    public static void Search(int a[],int si,int ei,int target){
         
        int mid=(si+ei)/2;
         if(si>ei)
          {
            System.out.println("Not present");
            System.exit(0);
          }
  if(a[si]<=target&&target <=a[mid])
  {
    if(si==ei)
      {
        System.out.println("Present at "+si);
        System.exit(0);
      } else Search(a, si, mid, target);
      
    }
    else Search(a, mid+1, ei, target);
    }
    
    public static void main(String[] args) {
        int a[]={4,5,6,7,0,1,2};
        Search(a, 0, a.length-1, 0);
    }
}
