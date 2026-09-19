class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board,ans,n);//bcktrcng ,col=0 ohle col se queen rkhna strt
        return ans;
        }
        //back func
    public void solve(int col,char[][] board,List<List<String>> ans,int n){
        if(col==n){//base case
        List<String> temp=new ArrayList<>();//current board ko ans mei save krna h
        for(int i=0;i<n;i++){
            temp.add(new String(board[i]));//board ki har row ko stroing bnakr temp mei daalo
        }
        ans.add(temp);//comp sol ko ans mei add

        return;
        }
        //current col mei har row try krna h ab

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';//baktrack agr osol ni mila toh hatana h
            }
        }
    }
    public boolean isSafe(int row,int col,char[][]board,int n){
        //check1:current row mei left side
        for(int j=0;j<col;j++){
            if(board[row][j]=='Q'){//Same row mein j wale column ka box check karo
                return false;
            }
        }
        //check2:upper left diagonal(i--,j--)
        for(int i=row,j=col;
        i>=0 && j>=0;
        i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //check3:lower left diagonal(i++,j++)
        for(int i=row,j=col;
        i<n && j>=0;
        i++,j--){
            if(board[i][j]=='Q'){
                return false;
            
        }

    }
    return true;

    

}
}