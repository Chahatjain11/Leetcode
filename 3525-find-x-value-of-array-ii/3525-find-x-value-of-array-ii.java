class SegmentTree{
    private static final int MAXK=6;//given 1<=k<=5
    private int k;
    private int n;
    private int[][] tree;

    public SegmentTree(int[] nums,int k){//constructor
        this.k=k;//k ko obj k andr store
        this.n=nums.length;//n ki length store
        int size=4*n+5;//segment tree k liye safe size
        tree= new int[size][MAXK];//har node ka [remainder count][whole prod remainder]
        build(nums,1,0,n-1);//(nums,root node,array start index,array end index)
    }
    private void makeLeaf(int node,int value){//jabb segment mei srf 1 elemnt ho
       Arrays.fill(tree[node],0);//node ki purani info clear 
       int r=value%k;//current elem ka remainder
       tree[node][r]=1;//single element segemnt ka 1 hi prefix h
       tree[node][k]=r;//poore segment ka prod remiander, single elemnt k case mei whole prudct=value
    }
    private void mergePre(int[] left,int[] right,int[] result){
        //left ka whole prod remainder
        int mulL=left[k];//left[k] mei poore left segment ka remainder
        int mulR=right[k];//right ka whole prodc remainder
        result[k]=(mulL*mulR)%k;

        for(int x=0;x<k;x++){
            result[x]=left[x];
        }
        for(int x=0;x<k;x++){
            result[(mulL * x) % k] += right[x];
        }
    }

    private void maintain(int o) {
        mergePre(tree[o * 2], tree[o * 2 + 1], tree[o]);
    }

    private void build(int[] nums, int o, int l, int r) {
        if (l == r) {
            makeLeaf(o, nums[l]);
            return;
        }
        int m = (l + r) / 2;
        build(nums, o * 2, l, m);
        build(nums, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    public void update(int o, int l, int r, int index, int value) {
        if (l == r) {
            makeLeaf(o, value);
            return;
        }
        int m = (l + r) / 2;
        if (index <= m) {
            update(o * 2, l, m, index, value);
        } else {
            update(o * 2 + 1, m + 1, r, index, value);
        }
        maintain(o);
    }

    public int[] query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[o];
        }

        int m = (l + r) / 2;
        if (R <= m) {
            return query(o * 2, l, m, L, R);
        }
        if (L > m) {
            return query(o * 2 + 1, m + 1, r, L, R);
        }

        int[] left = query(o * 2, l, m, L, R);
        int[] right = query(o * 2 + 1, m + 1, r, L, R);
        int[] result = new int[MAXK];
        mergePre(left, right, result);
        return result;
    }
}

class Solution {

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int index = q[0];
            int value = q[1];
            int start = q[2];
            int x = q[3];

            seg.update(1, 0, n - 1, index, value);
            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
            ans[i] = pre[x];
        }

        return ans;
    }
}