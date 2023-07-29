// Time complexity-->O(2^(n+m))
public class GridWays {
    static int ctr;
    public static void Grid(int i,int j,int a[][]){
        if(i==a.length-1&&j==a[0].length-1){
            ctr++;
            return;
        }
        if(j<a[0].length-1){
            Grid(i,j+1,a);
        }
            if(i<a.length-1){
                Grid(i+1, j, a);
            }
        }
        public static void main(String[] args) {
            int a[][]=new int [3][3];
            Grid(0, 0, a);
            System.out.println(ctr);
        }
    }
    

