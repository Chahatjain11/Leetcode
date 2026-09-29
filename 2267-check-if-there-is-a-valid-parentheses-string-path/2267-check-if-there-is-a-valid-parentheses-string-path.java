class Solution {
    public boolean hasValidPath(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;

        if(grid[0][0]==')'){
            return false;
        }
        if(grid[r-1][c-1]=='('){
            return false;
        }
        if((r+c-1)%2!=0){//even lengthh ni h toh false
            return false;
        }
        dp=new Boolean[r][c][r+c];
        return isValid(0,0,r-1,c-1,grid,0);
    }
    Boolean[][][] dp;
    public boolean isValid(int startR,int startC,int endR, int endC, char[][] grid,int count){
        if(grid[startR][startC]=='('){
            count++;
        }
        else{
            count--;
        }
        if(count<0){
            return false;
        }
        if(startR == endR && startC == endC){
            return count==0;
        }
        if(dp[startR][startC][count] != null){
            return dp[startR][startC][count];
        }
        Boolean ans =false;
        //down
        if(startR+1<=endR){
            ans=isValid(startR+1,startC,endR,endC,grid,count);
        }
        if(!ans && startC+1<=endC){
            ans=isValid(startR,startC+1,endR,endC,grid,count);
        }
        dp[startR][startC][count]=ans;
        return ans;
    }
}