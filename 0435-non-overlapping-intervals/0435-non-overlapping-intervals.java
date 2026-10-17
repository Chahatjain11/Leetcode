class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int removeCount=0;
        int lastEndTime =intervals[0][1];//first row ka dusra elemnt ie endtime
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<lastEndTime){
                removeCount++;
            }else{
                lastEndTime=intervals[i][1];
            }
        }return removeCount;

        
    }
}