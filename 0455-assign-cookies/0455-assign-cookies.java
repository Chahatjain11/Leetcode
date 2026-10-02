class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;

        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;//greed array ka pointer
        int r=0;//size ka pointer
        while(r<m){//jab tak cookies availble h
        if(g[l]<=s[r]){
            l++;//cookie mil gayi
            if(l==n){//saare child satisfied the condn edge case
            break;
        }
        }
        r++;//nex cookie check
        }return l;//index return l ka
    }
}