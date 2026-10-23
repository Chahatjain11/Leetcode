class Solution {
    public long subArrayRanges(int[] nums) {
        long sumMax=sumOfMax(nums);
        long sumMin=sumOfMin(nums);
        return sumMax-sumMin;
    }
    private long sumOfMin(int[] nums){
        int n=nums.length;
        int[] nse= new int[n];
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
    }
    long sum=0;
    for(int i=0;i<n;i++){
        long left=i-pse[i];
        long right=nse[i]-i;
        sum+=left*right*nums[i];
        }return sum;
    }
    private long sumOfMax(int[] nums){
        int n=nums.length;
        int[] pge=new int[n];
        int[] nge=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            sum+=left*right*nums[i];
        }return sum;
    }
}
