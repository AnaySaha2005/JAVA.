import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class GreedyAlgorithmsQuestions {
}
class ActivitySelectionGreedy{
    public static void main(String[] args) {
        int[] start ={1,3,5,8,5,0};
        int[] end ={2,4,7,9,9,6};
        int[][]activities=new int[start.length][3];
        for(int i=0;i<start.length;i++){
        activities[i][0]=i;
        activities[i][1]=start[i];
        activities[i][2]=end[i];

        }
        Arrays.sort(activities, Comparator.comparingDouble(o ->o[2]));
        int n=start.length,max=1,lastend=end[0];
        for(int i=1;i<n;i++){
            if (activities[i][1] >= lastend) {
                max++;
                lastend=activities[i][2];
            }



        }
        System.out.println(max);
    }
}
class KractionalKnapsack{
    public static void main(String[] args) {
        int[]value={120,100,60};
        int[]weight={30,20,10};
        int[][]chart=new int [value.length][3];
        int w=50,totalwt=0,totalvalue=0;
        int n=value.length;
        for(int i=0;i<n;i++){
            chart[i][0]=value[i];
            chart[i][1]=weight[i];
            chart[i][2]=value[i]/weight[i];
        }
        Arrays.sort(chart,Comparator.comparingDouble(o->o[2]));
        for(int i=n-1;i>=0;i--){
            if(totalwt+chart[i][1]>w){

                totalvalue+=chart[i][2]*(w-totalwt);
                totalwt+=chart[i][1];
            }
            else{
                totalvalue+=chart[i][0];
                totalwt+=chart[i][1];
            }
        }
        System.out.println(totalvalue);
    }
}
class maxChain{
    public static void main(String[] args) {
        int[][]list=new int[5][5];
        list[0][0]=5;list[0][1]=24;
        list[1][0]=39;list[1][1]=60;
        list[2][0]=5;list[2][1]=28;
        list[3][0]=27;list[3][1]=40;
        list[4][0]=50;list[4][1]=90;
        int max=1,end=list[0][1];
        Arrays.sort(list,Comparator.comparingDouble(o->o[1]));
        for(int i=1;i<5;i++){
            if(list[i][0]>=end){
                max++;
                end=list[i][1];
            }

        }
        System.out.println(max);
    }
}

class IndianCoins{
    public static void main(String[] args) {
        int coin[]={1,5,10,20,50,100,500,2000};
    int n=coin.length;
        int value=121,num=0;
        for(int i=n-1;i>=0;i--){
            if(coin[i]>value){
                continue;
            }
            value-=coin[i];
            num++;
            if(value==0)
                break;
            i++;

        }
        System.out.println(num);
    }
}
class JobSlection {
    public static void main(String[] args) {


        int[] profit = {20, 10, 40, 30};
        int[] time = {4, 1, 1, 1};
        int job[][] = new int[profit.length][3], n = profit.length,ctr=0;

        for (int i = 0; i < n; i++) {
            job[i][0] = i;
            job[i][1] = time[i];
            job[i][2] = profit[i];
        }
        Arrays.sort(job, Comparator.comparingDouble(o->o[2]));

        for (int i = 0; i < n; i++) {
            System.out.println(job[i][0] +"  "+job[i][1] +"  "+job[i][2] );
        }
        for(int i=n-1;i>=0;i--){
            if(ctr<job[i][1]){
                System.out.print((char)(job[i][0]+65)+"  ");
                ctr=job[i][1];
            }
        }
    }
}
class chocolaProblem {
    public static void main(String[] args) {
        int[] cuth = {2, 1, 3, 1, 4};
        int[] cutv = {4, 1, 2};
        Arrays.sort(cutv);
        Arrays.sort(cuth);
        int v = cutv.length - 1;
        int h = cuth.length - 1, cost = 0;
        while (v >= 0 && h >= 0) {
            if (cutv[v] < cuth[h]) {
                cost+=cuth[h];
                for (int i = v; i >= 0; i--) {
                    cost += cutv[i];

                }
                h--;
            } else {
                cost+=cutv[v];
                for (int i = h; i >= 0; i--) {
                    cost += cuth[i];

                }
                v--;
            }
        }
                if(v<0) {
                    for (int i = h; i >= 0; i--) {
                        cost += cuth[i];
                    }
                }
                    if(h<0){
                        for (int i = v; i >= 0; i--) {
                            cost += cutv[i];
                        }
                    }

        System.out.println(cost);
                }
            }
