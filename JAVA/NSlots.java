public class NSlots {
    public static void main(String[] args) {
        int a[]={6};
        int slot[]=new int[a[a.length-1]];
        for(int i=0;i<a.length;i++){
            slot[a[i]-1]=a[i];
        }
        int time=0;
                for(int i = 0; i< slot.length; i++){
                   if(slot[i]!=0)
                    continue;
                    else{
                      for(int j = 0; j< slot.length; j++){
                        if(slot[j]==0){
                          if(j-1>=0&&slot[j-1]!=0) {
                              slot[j] = slot[j - 1] + 1;
                              j++;
                          }
                              else if(j+1<slot.length&&slot[j+1]!=0) {
                                  slot[j] = slot[j + 1] - 1;
                              }
                         }
                      }
                      time++;
                    }
                    i--;
                }
                if(time==0)
                    time++;
        System.out.println(time);
    }
}
