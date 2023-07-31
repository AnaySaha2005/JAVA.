public class MaxWater {
    public static int maxwatervolume(int[] a)// BRUTE FORCE
    {
        int maxwater = 0, tempwater = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tempwater = a[j] * (j - i);
                } else {
                    tempwater = a[i] * (j - i);
                }
                if (tempwater > maxwater)
                    maxwater = tempwater;
            }
        }
        return maxwater;
    }

    public static int maxwaterOptimum(int[] a)// OPTIMUN 2 POINTER APPROACH
    {
        int leftpointer = 0, rightpointer = a.length - 1, maxwater = 0, tempowater = 0;
        while (leftpointer < rightpointer) {
            if (a[rightpointer] > a[leftpointer]) {
                tempowater = a[leftpointer] * (rightpointer - leftpointer);
                leftpointer++;
            } else {
                tempowater = a[rightpointer] * (rightpointer - leftpointer);
                rightpointer--;
            }
            if (maxwater < tempowater)
                maxwater = tempowater;
        }

        return maxwater;
    }

    public static void main(String[] args) {
        int a[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxwatervolume(a));
    }
}
