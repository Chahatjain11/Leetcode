class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();//multiple subset store 
        List<Integer> current=new ArrayList<>();
        generate(0,nums,current,ans);
        return ans;
        }
        private void generate(int index,int[] nums,List<Integer> current,List<List<Integer>> ans){
            if(index==nums.length){
                ans.add(new ArrayList<>(current));//current list ki copy bnakr save
                return;
            }
            current.add(nums[index]);
            generate(index+1,nums,current,ans);
            current.remove(current.size()-1);
            generate(index+1,nums,current,ans);
        }
}