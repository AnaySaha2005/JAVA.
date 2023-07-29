public class Nqueen {
static int prevColumn=0;
    public static void  nQueenplacing(int a[][],int row){
 if(row==a.length)
  { 
    print(a);
  return;
  }
 for( int column=0;column<a.length;column++)
 if(isSafe(a,row,column)){
    a[row][column]+=1;
    nQueenplacing(a, row+1);
    a[row][column]=0;
 }

    }
    public static boolean isSafe(int a[][],int row,int column){
    //vertical up
        for(int i=row-1;i>=0;i--)
     if(a[i][column]==1)
     return false;
     //left diagonal
     for(int i=row-1, j=column-1;i>=0&&j>=0;i--,j--){
        if(a[i][j]==1)
        return false;
     }
     //right diagonal
         for(int i=row-1, j=column+1;i>=0&&j<a.length;i--,j++){
        if(a[i][j]==1)
        return false;
       
     }
     return true;
    }
    public static void print(int a[][]){
        System.out.println("-----CHESS BOARD-----");
         for(int i=0;i<a.length;i++)
         {for(int j=0;j<a.length;j++)
         System.out.print(a[i][j]+"  ");
         
          System.out.println();
         }
    }
    public static void main(String[] args) {
       int a[][]=new int[4][4];
        
        nQueenplacing(a, 0);
       
    }
}