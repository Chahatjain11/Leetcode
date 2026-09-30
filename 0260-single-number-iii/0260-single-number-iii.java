class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int[] ans=new int[2];
        int index=0;//ans array mein kis position par next unique number rakhna hai, ye track karne ke liye hai
        for(int num:nums){
            if(mp.get(num)==1){
                ans[index]=num;
                index++;
            }
        }return ans;
        
    }
}