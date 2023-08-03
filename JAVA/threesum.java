import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesum {
    public static void main(String[] args) {
        int a[] = { -1, 0, 2, 1, -1, -4 };
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> mainlist = new ArrayList<>();
        int si = 0, ei = a.length - 1, slider = si + 1,ctr=0;
        while (si < ei) {
            if (slider == ei) {
                if (a[si] + a[ei] < 0) {
                    si++;
                } else
                    ei--;
                slider = si;
            } else if (a[si] + a[slider] + a[ei] == 0) {
                list.add( a[si]);
                list.add( a[slider]);
                list.add( a[ei]);
                mainlist.add(list);

            }

            slider++;
        }
        System.out.println(mainlist);

    }
}
