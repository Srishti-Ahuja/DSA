class Solution {
    List<List<Integer>> res;

    void build(int k, int n, int idx, ArrayList<Integer> ans){
        if(k==0 && n==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(k==0 ^ n==0){
            return;
        }
        if(idx>9)
            return;

        //dont include
        build(k,n,idx+1,ans);
        //include
        if(n>=idx){
            ans.add(idx);
            build(k-1,n-idx,idx+1,ans);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();

        build(k,n,1,new ArrayList<>());

        return res;
    }
}