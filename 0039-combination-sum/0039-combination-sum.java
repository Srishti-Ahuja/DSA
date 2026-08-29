class Solution {
    List<List<Integer>> res;

    void build(int[] candidates, ArrayList<Integer> ans, int target, int sum, int idx){
        
        if(target==sum){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx==candidates.length){
            return;
        }

        //dont include
        build(candidates, ans, target, sum, idx+1);
        //include
        if(sum+candidates[idx]<=target){
            ans.add(candidates[idx]);
            build(candidates, ans, target, sum+candidates[idx], idx);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();

        build(candidates, new ArrayList<Integer>(), target, 0, 0);
        return res;
    }
}