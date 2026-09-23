class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int bitIndex=0;bitIndex<=31;bitIndex++){
            int count=0;//bit 1 kha h
            for(int i=0;i<nums.length;i++){
                if((nums[i] & (1<<bitIndex))!=0){
                    count++;
                }
            }if(count%3==1){//three times diya h q mei
            ans=ans | (1<<bitIndex);

            }

        }return ans;
        
    }
}