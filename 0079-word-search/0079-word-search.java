class Solution {
    public boolean exist(char[][] board, String word) {
        //base case
        if(board==null || board.length==0 || word==null || word.length()==0){
        return false;
        }
        int m=board.length;//rows
        int n=board[0].length;//col
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,word,i,j,0,visited)){
                return true;
                }
        }
        }return false;
        }
        private boolean dfs(char[][] board,String word,int i,int j,int index,boolean[][] visited){
            //base case
            if(index==word.length()){
                return true;
            }
            if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(index)){
                return false;
            }
            visited[i][j]=true;
            if(dfs(board,word,i+1,j,index+1,visited) || 
            dfs(board,word,i-1,j,index+1,visited) ||
            dfs(board,word,i,j+1,index+1,visited) ||
            dfs(board,word,i,j-1,index+1,visited)){
                return true;
            }
            visited[i][j]=false;

            return false;
        }
    }
