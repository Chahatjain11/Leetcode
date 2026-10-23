class Solution {
    public int sumSubarrayMins(int[] arr) {
      int n=arr.length;
      int[] nse=findNSE(arr);
      int[] pse= findPSE(arr);
      long total=0;
      int mod=(int) (1e9 + 7);
      for(int i=0;i<n;i++){
        long left=i-pse[i];
        long right=nse[i]-i;
        long contribution=left*right*arr[i]%mod;
        total=(total+contribution)%mod;
      }return (int) total;
    }
    private int[] findNSE(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }return nse;
    }
    private int[] findPSE(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }return pse;
    }
}