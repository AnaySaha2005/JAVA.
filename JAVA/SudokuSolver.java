public class SudokuSolver {
    public static void SudokuSolve(int a[][],int row)
    {
        if(row==a.length){
           System.out.println("solvable");
            return;

        }
        boolean safe=false;;
        for(int j=0;j<a.length;j++){
            for(int i=1;i<10;i++){
                if(a[row][j]!=0)
                break;
               safe=isSafe(a,row,j,i);
                if(safe){
                    a[row][j]=i;
                    break;
                }
            } if(safe==false)
           {System.out.println("NO SOLUTION POSSIBLE");
            System.exit(0);
            }

        }
        SudokuSolve(a, row+1);
    }
    public static boolean isSafe(int a[][],int row,int column,int num){
        //vertical upward checking
        for(int i=a.length-1;i>=0;i--)
        if(a[i][column]==num)
        return false;
        //horizontal back checking
        for(int j=a.length-1;j>=0;j--)
        if(a[row][j]==num)
        return false;
        //SubGrid checking
        {
            
            if(row<=2)
            {   //Grid 1
                if(column<=2)
                {
                for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                if(a[i][j]==num)
                return false;
                }
                  //Grid 2
                  if(column >2&&column<6)
                  { for(int i=0;i<3;i++)
                    for(int j=3;j<6;j++)
                   if(a[i][j]==num)
                   return false;
                    
                  //Grid 3
                  if(column >5&&column<9)
                  { for(int i=0;i<3;i++)
                    for(int j=6;j<9;j++)
                   if(a[i][j]==num)
                   return false;
            }

            }
          
        }
          if(row>2&&row<6)
            {   //Grid 4
                if(column<=2)
                {
                for(int i=3;i<6;i++)
                for(int j=0;j<3;j++)
                if(a[i][j]==num)
                return false;
                }
                  //Grid 5
                  if(column >2&&column<6)
                  { for(int i=3;i<63;i++)
                    for(int j=3;j<6;j++)
                   if(a[i][j]==num)
                   return false;
                    
                  //Grid 6
                  if(column >5&&column<9)
                  { for(int i=3;i<63;i++)
                    for(int j=6;j<9;j++)
                   if(a[i][j]==num)
                   return false;
            }

            }
          
        }
        if(row>5&&row<9)
            {   //Grid 7
                if(column<=2)
                {
                for(int i=6;i<9;i++)
                for(int j=0;j<3;j++)
                if(a[i][j]==num)
                return false;
                }
                  //Grid 8
                  { for(int i=6;i<9;i++)
                    for(int j=3;j<6;j++)
                   if(a[i][j]==num)
                   return false;
                    
                  //Grid 9
                  if(column >5&&column<9)
                  { for(int i=6;i<9;i++)
                    for(int j=6;j<9;j++)
                   if(a[i][j]==num)
                   return false;
            }

            }
          
        }
      }
      return true;
   }
   public static void main(String[] args) {
    int a[][]={{0,0,8,0,0,0,0,0,0},{4,9,0,1,5,7,0,0,2},{0,0,3,0,0,4,1,9,0},{1,8,5,0,6,0,0,2,0},{9,6,0,4,0,5,3,0,0},{0,3,0,0,7,2,0,0,4},{0,4,9,0,3,0,0,5,7},{8,2,7,0,0,9,0,1,3}};
     SudokuSolve(a, 0);
   }
}
