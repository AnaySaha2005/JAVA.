import java.util.Arrays;
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