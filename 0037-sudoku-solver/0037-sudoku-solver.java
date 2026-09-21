class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
    //empty cell find
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j]=='.'){

                //try no 1-9
                for(char c='1';c<='9';c++){
                    if(isValid(board,i,j,c)){
                        board[i][j]=c;

                        if(solve(board)){
                            return true;
                        } board[i][j]='.';

                    }
                }return false;//no not worked

                }
            }
        }return true;//no empty cells left sudoku solved
    }
    public boolean isValid(char[][] board,int row,int col,char c){
        //check row
        for(int j=0;j<9;j++){
            if(board[row][j]==c){
                return false;
            }
        }
        //check col
        for(int i=0;i<9;i++){
            if(board[i][col]==c){
                return false;
            }
        }
        int boxRow=3*(row/3);
        int boxCol=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[boxRow+i][boxCol+j]==c){
                    return false;
                }

            }
        }return true;
    }
}