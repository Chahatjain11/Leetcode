import java.util.Arrays;
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] best=new int[n];//valid subarrays k length ko store
        Arrays.fill(best,Integer.MAX_VALUE);
        int left=0;
        int sum=0;
        int answer=Integer.MAX_VALUE;

        for(int right=0;right< n;right++){
            sum += arr[right];
            while(sum>target){
                sum-=arr[left++];//shrink from left whem window size is more
            }
            //we found a subarray
            if(sum==target){
                int currentLength=(right-left)+1;

                //check if there is previous non overlap subarray
                if(left>0 && best[left-1]!=Integer.MAX_VALUE){
                    answer=Math.min(answer,currentLength + best[left-1]);
                }
                //store the shortest valid subarray best mei abhi tak jo mila
                if(right==0){
                    best[right]=currentLength;
                }else{
                    best[right]=Math.min(best[right-1],currentLength);
                    }
                }else{
                    if(right>0){
                        best[right]=best[right-1];
                    }
                }

            }
            if (answer==Integer.MAX_VALUE){
                return -1;
            }else{
                return answer;
            }
        }
}