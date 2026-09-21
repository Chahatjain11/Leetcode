class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] dp=new long[k];//no of subarrays ending at prev element having this prod remaiinder
        long[] ans= new long[k];
        for(int num:nums){
            long[] newDp=new long[k];//subarrays ending at current elemnt
            int numMod=num%k;
            newDp[numMod]++;
            for(int i=0;i<k;i++){
                int newRem=(int)((long) i*numMod%k);
                newDp[newRem]+=dp[i];//oldsubaray + current no=new subarray
            }
            for(int i=0;i<k;i++){
                ans[i]+=newDp[i];
            }
            dp=newDp;
        }
        return ans;
    }
}

