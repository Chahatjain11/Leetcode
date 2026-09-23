class Solution {
    public int minOperations(int[] nums, int x) {
        int total_sum=0;
        for(int i:nums){
            total_sum+=i;
        }
        int target=total_sum - x;
        //base case
        if(target<0){
            return -1;
        }
        if(target==0){
            return nums.length;
        }
        int left=0;
        int sum=0;
        int max_length=-1;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                max_length=Math.max(max_length,right-left+1);
            }

        }if(max_length==-1){
            return -1;
        }
        return nums.length-max_length;

        
    }
}