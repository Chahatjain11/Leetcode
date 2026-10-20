class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int[] arr=new int[n];//arrival
        int[] dep=new int[n];//departure
        for(int k=0;k<n;k++){
            arr[k]=intervals[k][0];
            dep[k]=intervals[k][1];
         }
         Arrays.sort(arr);
         Arrays.sort(dep);
         int i=0;
         int j=0;
         int count=0;
         int maxCount=0;
         while(i<n){
            if(arr[i]<=dep[j]){
                count++;
                maxCount=Math.max(maxCount,count);
                i++;
            }else{
                count--;
                j++;
            }
         }return maxCount;
        
    }
}