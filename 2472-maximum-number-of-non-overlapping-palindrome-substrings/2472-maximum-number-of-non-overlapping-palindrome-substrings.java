class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[][] palindrome=new boolean[n][n];

        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){//i substring ka starting index hai idhr
            int j=i+len-1;
            if (s.charAt(i)==s.charAt(j) && (len<=2 || palindrome[i+1][j-1])){

                palindrome[i][j]=true;//substring palindrome hai ya nhi
            }
        }
        }
        int dp[]=new int[n+1];//yaha dp count of palindrome store krrha h 
        for(int i=1;i<=n;i++){//i yaha pe kitne character tak ans niklre 
            //current character ko skip krrhe h
            dp[i]=dp[i-1];//current ko ignre krke prevois wala store krliya
            for(int j=0;j<i;j++){//j substring ka index h
            int length=i-j;
            if(length>=k && palindrome[j][i-1]){//yaha substring ki length h
            dp[i]=Math.max(dp[i],dp[j]+1);
            }
            }
        }
    return dp[n];
    }
}