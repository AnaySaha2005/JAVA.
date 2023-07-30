public class SudokuSolver {
    public static boolean SudokuSolve(int a[][], int row, int column) {
        if (row == a.length )
            return true;
          

        

        int nextRow = row, nextColmun = column + 1;
        if (column+1 ==9) {
            nextRow = row + 1;
            nextColmun = 0;
        }
        if (a[row][column] != 0)
            return SudokuSolve(a, nextRow, nextColmun);

        for (int i = 1; i < 10; i++) {
            if (isSafe(a, row, column, i)) {
                a[row][column] = i;
                if (SudokuSolve(a, nextRow, nextColmun))
                return true;
              a[row][column] = 0;
            }
       
        }
        return false;
    }

    public static boolean isSafe(int a[][], int row, int column, int num) {
        // vertical upward checking
        for (int i = a.length - 1; i >= 0; i--)
            if (a[i][column] == num)
                return false;
        // horizontal back checking
        for (int j = a.length - 1; j >= 0; j--)
            if (a[row][j] == num)
                return false;
        int sr = (row / 3) * 3;
        int sc = (column / 3) * 3;
        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (a[i][j] == num)
                    return false;

        return true;
    }

    public static void main(String[] args) {
        int a[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        if (SudokuSolve(a, 0, 0)) {
            System.out.println("SOLUTION EXISTS");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++)
                    System.out.print(a[i][j] + "  ");
                System.out.println();
            }
        } else
            System.out.println("SOLUTION DOESNOT EXISTS");
    }
}
