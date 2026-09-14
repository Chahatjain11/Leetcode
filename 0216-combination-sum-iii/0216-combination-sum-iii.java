class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        generate(1,k,n,new ArrayList<>(),ans);
        return ans;
        
    }
    private void generate(int i,int k,int n,List<Integer>current,List<List<Integer>> ans){
        if(n==0 && k==0){
            ans.add(current);
            return;
        }
        if(i>9) return;
        if(n<0 || k<0) return;

        List<Integer>temp=new ArrayList<>(current);
        temp.add(i);
        generate(i+1,k-1,n-i,temp,ans);
        generate(i+1,k,n,current,ans);
    }
}